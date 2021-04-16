import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class NumbersMain {
   public static void main(String[] args) {
      try {
         // create a CharStream that reads from standard input:
         // CharStream input = CharStreams.fromStream(System.in);
         // TOS WAY
         InputStream in_stream = null;
         try {
            in_stream = new FileInputStream(new File("numbers.txt"));
         } catch (FileNotFoundException e) {
            System.err.println("Error: File Not Found");
            System.exit(1);
         }

         // wtf?
         // create a CharStream that reads from in_stream:
         ANTLRInputStream input = new ANTLRInputStream(in_stream);

         // create a lexer that feeds off of input CharStream:
         NumbersLexer lexer = new NumbersLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         NumbersParser parser = new NumbersParser(tokens);
         // replace error listener:
         // parser.removeErrorListeners(); // remove ConsoleErrorListener
         // parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at file rule:
         ParseTree tree = parser.file();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            ParseTreeWalker walker = new ParseTreeWalker();
            ConstructNumberMappings mappings = new ConstructNumberMappings();
            walker.walk(mappings, tree);
            String traducao = "";
            Scanner in = new Scanner(System.in);
            while(in.hasNextLine()){
               String line = in.nextLine();
               String[] words = line.toLowerCase().split(" - ");
               
               for (int i = 0; i < words.length; i++) {
                  if(mappings.exists(words[i])){
                     traducao += mappings.value(words[i]).toString() + " ";
                  }
                  else{
                     traducao += words[i].toString() + " ";
                  }
               }
            }

            System.out.println(traducao);
         }

      } catch (IOException e) {
         e.printStackTrace();
         System.exit(1);
      } catch (RecognitionException e) {
         e.printStackTrace();
         System.exit(1);
      }
   }
}
