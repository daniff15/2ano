import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Execute extends StrLangBaseVisitor<String> {

   Map<String, String> mapinha = new HashMap<>();
   private Scanner sc = new Scanner(System.in);

   @Override public String visitStat(StrLangParser.StatContext ctx) {
      if (ctx.print() != null) {
         visit(ctx.print());
      }
      else if (ctx.assign() != null) {
         visit(ctx.assign());
      }

      return null;
   }

   @Override public String visitPrintText(StrLangParser.PrintTextContext ctx) {
      System.out.println("PRINT -> " + visit(ctx.expr()));
      return null;
   }

   @Override public String visitAssign(StrLangParser.AssignContext ctx) {
      if (ctx.expr() != null) {
         if (!mapinha.containsKey(ctx.ID().getText())) {
            mapinha.put(ctx.ID().getText(), ctx.expr().getText());
         }
      }
      else{
         //System.out.println(visit(ctx.input()));
         String userInput = visit(ctx.input());
         if (!mapinha.containsKey(ctx.ID().getText())) {
            mapinha.put(ctx.ID().getText(), userInput);
         }
      }

      return null;
   }

   @Override public String visitInput(StrLangParser.InputContext ctx) {
      System.out.print(ctx.TEXT().getText() + " ");
      String userInput = sc.nextLine();
      return userInput;
   }

   @Override public String visitVisitText(StrLangParser.VisitTextContext ctx) {
      return ctx.TEXT().getText();
   }

   @Override public String visitVisitAdd(StrLangParser.VisitAddContext ctx) {
      String tmp1 = ctx.expr(0).getText();
      tmp1 = tmp1.substring(1, tmp1.length() - 1);
      String tmp2 = ctx.expr(1).getText();
      tmp2 = tmp2.substring(1, tmp2.length() - 1);
      String result = tmp1 + tmp2;
      result = "\"" + result + "\"";
      return result;
   }

   @Override public String visitVisitSub(StrLangParser.VisitSubContext ctx) {
      String tmp1 = ctx.expr(0).getText();
      tmp1 = tmp1.substring(1, tmp1.length() - 1);
      String tmp2 = ctx.expr(1).getText();
      tmp2 = tmp2.substring(1, tmp2.length() - 1);

      String result ="";
      if (tmp2.length() >= tmp1.length() ) {
         if (tmp1.equals(tmp2)) {
            result = "";
         }
         else{
            System.out.println("String 2 is bigger than string 1");
         }
      }

      return result;
      
   }

   @Override public String visitVisitTrim(StrLangParser.VisitTrimContext ctx) {
      String str = ctx.expr().getText();
      str = str.substring(1, str.length()-1);
      str = str.trim();
      str = "\"" + str + "\"";
      return str;
   }

   @Override public String visitVisitSubstitution(StrLangParser.VisitSubstitutionContext ctx) {
      String word = ctx.expr(0).getText();
      word = word.substring(1, word.length() - 1);
      String findWord = ctx.expr(1).getText();
      findWord = findWord.substring(1, findWord.length() - 1);
      String substitute = ctx.expr(2).getText();
      substitute = substitute.substring(1, substitute.length() - 1);

      if (word.contains(findWord)) {
         word = word.replaceAll(findWord, substitute);
      }

      word = "\"" + word + "\"";

      return word;
   }

   @Override public String visitID(StrLangParser.IDContext ctx) {
      return mapinha.get(ctx.ID().getText());
   }
}
