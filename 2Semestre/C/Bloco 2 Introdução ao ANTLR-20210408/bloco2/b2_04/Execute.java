public class Execute extends PrefixCalculatorBaseVisitor<Object> {
   @Override public Object visitStat(PrefixCalculatorParser.StatContext ctx) {
      Double res = null;
      res = (Double)visit(ctx.expr());
      if(res!= null){
         System.out.println("RESULTADO -> " + res);
      }
      return res;
   }

   @Override public Object visitOperators(PrefixCalculatorParser.OperatorsContext ctx) {
      Double res = null;
      Double num1 = (Double)visit(ctx.expr(0));
      Double num2 = (Double)visit(ctx.expr(1));
      if(num1 != null && num2 != null){
         switch(ctx.op.getText()){
            case "+":
               res = num1 + num2;
               break;
            case "-":
               res = num1 - num2;
               break;
            case "*":
               res = num1 * num2;
               break;
            case "/":
               if(num2 != 0){
                  res = num1/num2;
                  break;
               }
               else{
                  System.err.println("ERROR: Divide by zero");
               }
         }
      }
      return res;
   }

   @Override public Object visitNumbers(PrefixCalculatorParser.NumbersContext ctx) {
      return Double.parseDouble(ctx.Number().getText());
   }
}
