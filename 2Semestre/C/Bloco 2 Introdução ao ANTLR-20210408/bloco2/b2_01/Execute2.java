import java.util.Iterator;
import org.antlr.v4.runtime.tree.*;

public class Execute2 extends HelloBaseVisitor<String> {

   @Override public String visitGreetings(HelloParser.GreetingsContext ctx) {
      String word = "";
      for (TerminalNode tmp : ctx.ID()) {
         word += tmp + " ";
      }
      System.out.println("Ola " + word);
      return null;
   }

   @Override public String visitBye(HelloParser.ByeContext ctx) {
      String word = "";
      for (TerminalNode tmp : ctx.ID()) {
         word += tmp + " ";
      }
      System.out.println("Adeus " + word);
      return null;
   }
}
