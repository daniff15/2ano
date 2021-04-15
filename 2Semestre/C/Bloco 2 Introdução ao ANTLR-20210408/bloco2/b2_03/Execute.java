public class Execute extends CalculatorBaseVisitor<Object> {

   //FALTA FAZER A ALINEA C)

   @Override
   public Object visitStat(CalculatorParser.StatContext ctx) {
      Integer result = null;
      result = (Integer) visit(ctx.expr());
      if (result != null) {
         System.out.println("Resultado - " + Math.round(result));
      }
      return Math.round(result);
   }

   @Override
   public Object visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Integer res = null;
      Integer num1 = (Integer) visit(ctx.expr(0));
      Integer num2 = (Integer) visit(ctx.expr(1));

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
      return Math.round(res);
   }

   @Override
   public Object visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override
   public Object visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Integer.parseInt(ctx.Integer().getText());
   }

   @Override
   public Object visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      Integer res = null;
      Integer num1 = (Integer) visit(ctx.expr(0));
      Integer num2 = (Integer) visit(ctx.expr(1));

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
      return Math.round(res);
   }
}
