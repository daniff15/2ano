import java.util.HashMap;
import java.util.Map;

public class Interpreter extends vectorBaseVisitor<Vector> {

   Map<String, Vector> mapinha = new HashMap<>();

   @Override
   public Vector visitShow(vectorParser.ShowContext ctx) {
      Vector result = visit(ctx.expr());

      if (result != null) {
         System.out.println(result);
      }
      return null;
   }

   @Override
   public Vector visitAssign(vectorParser.AssignContext ctx) {
      mapinha.put(ctx.ID().getText(), visit(ctx.expr()));
      return null;
   }

   @Override
   public Vector visitId(vectorParser.IdContext ctx) {
      if (!mapinha.containsKey(ctx.ID().getText())) {
         System.err.println("ERROR: Nao contem id passado!");
         System.exit(1);
      }

      return mapinha.get(ctx.ID().getText());
   }

   @Override
   public Vector visitNumber(vectorParser.NumberContext ctx) {
      return new Vector(Double.parseDouble(ctx.NUMBER().getText()));
   }

   @Override
   public Vector visitVector(vectorParser.VectorContext ctx) {
      Vector result = null;
      int i = 0;

      for (vectorParser.ExprContext vetorinho : ctx.expr()) {
         if (i == 0) {
            result = new Vector(Double.parseDouble(vetorinho.getText()));
            i++;
         } else {
            result.addToArray(Double.parseDouble(vetorinho.getText()));
         }
      }

      return result;
   }

   @Override
   public Vector visitParent(vectorParser.ParentContext ctx) {
      if (visit(ctx.expr()) == null) {
         System.err.println("ERROR: Not Possible");
         System.exit(1);
      }

      return visit(ctx.expr());
   }

   @Override
   public Vector visitUnario(vectorParser.UnarioContext ctx) {

      if (ctx.op.getText().equals("+")) {
         return visit(ctx.expr());
      }

      else {
         Vector result = visit(ctx.expr()).unario();
         return result;
      }
   }

   @Override
   public Vector visitInternProduct(vectorParser.InternProductContext ctx) {
      Vector v1 = visit(ctx.expr(0));
      Vector v2 = visit(ctx.expr(1));
      Vector result = null;

      if (v1 != null && v2 != null) {
         result = v1.internProdut(v2);
      }

      return result;
   }

   @Override
   public Vector visitSomaSub(vectorParser.SomaSubContext ctx) {

      Vector v1 = visit(ctx.expr(0));
      Vector v2 = visit(ctx.expr(1));
      Vector result = null;

      if (v1 != null && v2 != null) {
         switch (ctx.op.getText()) {
            case "+":
               result = v1.sum(v2);
               break;

            case "-":
               result = v1.sub(v2);
               break;

            default:
               break;
         }

      }

      else {
         System.err.println("Some vectors aint right!!");
         System.exit(1);
      }

      return result;
   }

   @Override
   public Vector visitMulti(vectorParser.MultiContext ctx) {
      Vector v1 = visit(ctx.expr(0));
      Vector v2 = visit(ctx.expr(1));
      Vector result = null;

      if (v1 != null && v2 != null) {
         result = v1.multi(v2);
      }

      return result;
   }
}
