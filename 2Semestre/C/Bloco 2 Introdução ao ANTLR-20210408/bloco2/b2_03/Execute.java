public class Execute extends CalculatorBaseVisitor<Object> {

   //FALTA FAZER A ALINEA C)

   @Override
   public Object visitStat(CalculatorParser.StatContext ctx) {
      Double result = null;
      result = (Double) visit(ctx.expr());
      if (result != null) {
         System.out.println("Resultado - " + result);
      }
      return result;
   }

   @Override
   public Object visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Double res = null;
      Double num1 = (Double) visit(ctx.expr(0));
      Double num2 = (Double) visit(ctx.expr(1));

      if (num1 != null && num2 != null) {
         switch (ctx.op.getText()) {
         case "+":
            res = num1 + num2;
            break;
         case "-":
            res = num1 - num2;
            break;
         }
      }
      return res;
   }

   @Override
   public Object visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override
   public Object visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Double.parseDouble(ctx.Integer().getText());
   }

   @Override
   public Object visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      Double res = null;
      Double num1 = (Double) visit(ctx.expr(0));
      Double num2 = (Double) visit(ctx.expr(1));

      if (num1 != null && num2 != null) {
         switch (ctx.op.getText()) {
         case "*":
            res = num1 * num2;
            break;
         case "/":
            if (num2 != 0) {
               res = num1 / num2;
            }
            else{
               System.err.println("ERRO: Divide by zero");
            }
            break;
         case "%":
            res = num1 % num2;
            break;
         }
      }
      return res;
   }
}
