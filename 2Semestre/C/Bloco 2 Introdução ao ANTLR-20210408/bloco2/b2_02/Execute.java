public class Execute extends SuffixCalculatorBaseVisitor<Double> {

   @Override public Double visitStat(SuffixCalculatorParser.StatContext ctx) {
      Double res = null;
      res = (Double)visit(ctx.expr());
      if(res!= null){
         System.out.println("RESULTADO -> " + res);
      }
      return res;
   }

   @Override public Double visitNumbers(SuffixCalculatorParser.NumbersContext ctx) {
      return Double.parseDouble(ctx.Number().getText());
   }

   @Override public Double visitOperators(SuffixCalculatorParser.OperatorsContext ctx) {
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
}
