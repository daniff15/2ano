public class Execute extends convertSuffixBaseVisitor<String> {

   @Override public String visitStat(convertSuffixParser.StatContext ctx) {
      String result = "";
      result = visit(ctx.expr());
      if (result != "") {
         System.out.println("SuffixCalc - " + result);
      }
      return result;
   }

   @Override public String visitAssignment(convertSuffixParser.AssignmentContext ctx) {
      System.out.println(ctx.ID().getText() + " = " + visit(ctx.expr()));
      return null;
   }

   @Override public String visitExprAddSub(convertSuffixParser.ExprAddSubContext ctx) {
      String num1 = visit(ctx.expr(0));
      String num2 = visit(ctx.expr(1));
      String str = "" + num1 + " " + num2 + " " + ctx.op.getText() + " ";
      return str;
   }

   @Override public String visitExprParent(convertSuffixParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public String visitExprInteger(convertSuffixParser.ExprIntegerContext ctx) {
      return ctx.Integer().getText();
   }

   @Override public String visitExprUnitario(convertSuffixParser.ExprUnitarioContext ctx) {
      String res = null;
      String num = visit(ctx.expr());

      if (num != null) {
         res = num + " " + "!" + ctx.op.getText();
      }
      return res;
   }

   @Override public String visitExprID(convertSuffixParser.ExprIDContext ctx) {
      return ctx.ID().getText();
   }

   @Override public String visitExprMultDivMod(convertSuffixParser.ExprMultDivModContext ctx) {
      String num1 = visit(ctx.expr(0));
      String num2 = visit(ctx.expr(1));
      String str = "" + num1 + " " + num2 + " " + ctx.op.getText() + " ";
      return str;
   }
}
