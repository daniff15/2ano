import java.util.HashMap;
import java.util.Map;

public class Interpreter extends FracLangBaseVisitor<Fraction> {

   Map<String, Fraction> mapinha = new HashMap<>();

   @Override
   public Fraction visitStat(FracLangParser.StatContext ctx) {
      if (ctx.display() != null) {
         visit(ctx.display());
      } else if (ctx.assign() != null) {
         visit(ctx.assign());
      }

      return null;
   }

   @Override
   public Fraction visitInteger(FracLangParser.IntegerContext ctx) {
      Integer number = Integer.parseInt(ctx.INTEGER().getText());
      Fraction fracao = new Fraction(number, 1);
      return fracao;
   }

   @Override
   public Fraction visitIdentifier(FracLangParser.IdentifierContext ctx) {
      if (mapinha.containsKey(ctx.ID().getText())) {
         return mapinha.get(ctx.ID().getText());
      } else {
         String error = "Esta variável nao se encontra coise.";
         System.err.println(error);
         System.exit(1);
      }

      return null;
   }

   @Override
   public Fraction visitParent(FracLangParser.ParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Fraction visitAddSub(FracLangParser.AddSubContext ctx) {
      Fraction frac1 = visit(ctx.expr(0));
      Fraction frac2 = visit(ctx.expr(1));
      Fraction res = null;

      if (frac1 != null && frac2 != null) {
         switch (ctx.op.getText()) {
            case "+":
               res = frac1.add(frac2);
               break;
         
            case ":":
               res = frac1.subtract(frac2);
               break;

            default:
               break;
         }
      }

      return res;
   }

   @Override
   public Fraction visitUnario(FracLangParser.UnarioContext ctx) {
      Fraction frac1 = new Fraction(0, 1);
      Fraction frac2 = null;
      if (ctx.op.getText().equals("-")) {
         frac2 = visit(ctx.expr());
         return frac1.subtract(frac2);
      }
      else{
         return frac1.add(frac2);
      }

   }

   @Override
   public Fraction visitMultiDiv(FracLangParser.MultiDivContext ctx) {
      Fraction frac1 = visit(ctx.expr(0));
      Fraction frac2 = visit(ctx.expr(1));
      Fraction res = null;

      if (frac1 != null && frac2 != null) {
         switch (ctx.op.getText()) {
            case "*":
               res = frac1.multiply(frac2);
               break;
         
            case ":":
               res = frac1.divide(frac2);
               break;

            default:
               break;
         }
      }

      return res;
   }

   @Override
   public Fraction visitFraction(FracLangParser.FractionContext ctx) {
      Integer numerador = Integer.parseInt(ctx.expr(0).getText());
      Integer denominador = Integer.parseInt(ctx.expr(1).getText());
      if (denominador == 0) {
         System.err.println("Denominador tem de ser diferente 0");
         System.exit(1);
      }
      return new Fraction(numerador, denominador);

   }

   @Override
   public Fraction visitDisplay(FracLangParser.DisplayContext ctx) {
      Object obj = visit(ctx.expr());
      System.out.println(obj);
      return null;
   }

   @Override
   public Fraction visitAssign(FracLangParser.AssignContext ctx) {
      if (!mapinha.containsKey(ctx.ID().getText())) {
         mapinha.put(ctx.ID().getText(), visit(ctx.expr()));
      }

      return null;
   }
}
