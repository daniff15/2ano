import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Interpreter extends BigIntCalcBaseVisitor<BigInteger> {

   Map<String, BigInteger> mapinha = new HashMap<>();

   @Override
   public BigInteger visitShow(BigIntCalcParser.ShowContext ctx) {
      BigInteger result = visit(ctx.expr());

      if (result == null) {
         System.err.println("ERROR: Expr null!");
         System.exit(1);
      } else {
         System.out.println(result);
      }

      return result;
   }

   @Override
   public BigInteger visitAssign(BigIntCalcParser.AssignContext ctx) {
      BigInteger result = visit(ctx.expr());

      if (result == null) {
         System.err.println("ERROR: Expr null!");
         System.exit(1);
      } else {
         mapinha.put(ctx.ID().getText(), result);
      }

      return result;
   }

   @Override
   public BigInteger visitExprInt(BigIntCalcParser.ExprIntContext ctx) {
      BigInteger result = new BigInteger(ctx.INTEGER().getText());

      return result;
   }

   @Override
   public BigInteger visitExprID(BigIntCalcParser.ExprIDContext ctx) {

      if (!mapinha.containsKey(ctx.ID().getText())) {
         System.err.println("ERROR: No var in store!");
         System.exit(1);
      }

      return mapinha.get(ctx.ID().getText());
   }

   @Override
   public BigInteger visitExprSumSub(BigIntCalcParser.ExprSumSubContext ctx) {
      BigInteger bg1 = visit(ctx.expr(0));
      BigInteger bg2 = visit(ctx.expr(1));
      BigInteger result = null;

      if (bg1 != null && bg2 != null) {
         switch (ctx.op.getText()) {
            case "+":
               result = bg1.add(bg2);
               break;

            case "-":
               result = bg1.subtract(bg2);
               break;

            default:
               break;
         }
      } else {
         System.err.println("ERROR: Expr null!");
         System.exit(1);
      }

      return result;

   };

   @Override
   public BigInteger visitExprParent(BigIntCalcParser.ExprParentContext ctx) {
      if (visit(ctx.expr()) == null) {
         System.err.println("ERROR: Expr null!");
         System.exit(1);
      }

      return visit(ctx.expr());
   };

   @Override
   public BigInteger visitExprMultiDivMod(BigIntCalcParser.ExprMultiDivModContext ctx) {
      BigInteger bg1 = visit(ctx.expr(0));
      BigInteger bg2 = visit(ctx.expr(1));
      BigInteger result = null;

      if (bg1 != null && bg2 != null) {
         switch (ctx.op.getText()) {
            case "*":
               result = bg1.multiply(bg2);
               break;

            case "div":
               if ((BigInteger.valueOf(0).compareTo(bg2)) != 0) {
                  result = bg1.divide(bg2);
               } else {
                  System.err.println("ERROR: Divide by zero!");
                  System.exit(1);
               }
               break;

            case "mod":
               if ((BigInteger.valueOf(0).compareTo(bg2)) <= 0 ) {
                  result = bg1.mod(bg2);
               } else {
                  System.err.println("ERROR: Divide by zero or lower!");
                  System.exit(1);
               }
               break;

            default:
               break;
         }
      } else {
         System.err.println("ERROR: Expr null!");
         System.exit(1);
      }

      return result;
   };

   @Override
   public BigInteger visitExprUnario(BigIntCalcParser.ExprUnarioContext ctx) {
      BigInteger bg1 = visit(ctx.expr());
      BigInteger result = null;

      if (ctx.op.getText().equals("-")) {
         result = bg1.multiply(new BigInteger("-1"));
      }
      else if(ctx.op.getText().equals("+")){
         result = bg1;
      }

      return result;
   };

}
