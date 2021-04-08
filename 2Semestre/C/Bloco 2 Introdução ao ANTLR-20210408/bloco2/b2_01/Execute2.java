public class Execute2 extends HelloBaseVisitor<String> {

   @Override public String visitGreetings(HelloParser.GreetingsContext ctx) {
      System.out.println("Ola " + ctx.ID());
      return null;
   }

   @Override public String visitBye(HelloParser.ByeContext ctx) {
      System.out.println("Adeus " + ctx.ID());
      return null;
   }
}
