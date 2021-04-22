public class Execute extends CalculatorBaseVisitor<Object> {

   @Override
   public Object visitStat(CalculatorParser.StatContext ctx) {
      Integer result = null;
      result = (Integer) visit(ctx.expr());
      if (result != null) {
         System.out.println("Resultado - " + result);
      }
      return result;
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
      return res;
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
            } else {
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

   @Override
   public Object visitExprUnitario(CalculatorParser.ExprUnitarioContext ctx) {
      Integer res = null;
      Integer num = (Integer) visit(ctx.expr());

      if (num != null) {
         switch (ctx.op.getText()) {
         case "+":
            res = num;
            break;
         case "-":
            res = 0 - num;
            break;
         }
      }
      return res;
   }
}
