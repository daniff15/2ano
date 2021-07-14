import java.util.*;
import types.*;
import SecondaryGrammar.*;
import java.io.*;

public class Output {

   public static void main(String[] args) {

      String intro = "Caso a pergunta seja do tipo multiple-choice, insira o ID da resposta que acha que está correta, depois clique em enter e repita o processo. \nSe a pergunta for do tipo matching, insira os pares que acha correto no seguinte formato \"<par da esquerda> -> <par da direita>\", separando os pares por enter. \nEm ambas as situaçoes, quando nao quiser adicionar mais respostas, insira \":\".";
      Scanner sc = new Scanner(System.in);
      String input;
      String s;
      String[] splt;

      SecondaryGrammarMain secMain = new SecondaryGrammarMain();
      List<Question> questionToReport = new ArrayList<>();
      Map<String, List<String>> userAnswersMap = new HashMap<>();
      List<String> edits = new ArrayList<>();

      List<question> v1 = new ArrayList<>();

      v1 = SecondaryGrammarMain.load("bancoPerguntas.txt");
   }
}



