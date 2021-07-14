import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;


public class wordsearch{

  private static int wordCount;
  private static  String words = "";
  private static String file;
  private static int size;
  private static String output;
  private static String[] wordList;
  private static Character [][] sopa; 
  private  static String input;
  
  public static void  main(String [] args) throws IOException{
    int verification=0;
    for (int i=0; i<args.length; i++){
      if(args[i].equals("-i")){
        file=args[i+1];
        verification++;
      }
      else if(args[i].equals("-s")){
        size=Integer.parseInt(args[i+1]);
        verification++;
      }
      else if(args[i].equals("-o")){
        output = args[i+1];
        verification++;
      }
    }
    if(verification!=3){
      System.err.println("Invalid Arguments!");                 // if we dont get 3 of the essencial arguments, the program closes
      System.exit(0);
    }
    else{
      run(size, file);                                          // will run the other functions
      printSoup();
    }
  }
  
  public static void printSoup() throws IOException{            // prints the soup puzzle in the command line and in a local file 
    PrintWriter writer = new PrintWriter(output, "UTF-8");      // output has the name of the file
    for(int i =0; i<size; i++){
      for(int j =0; j<size; j ++){
        System.out.print(sopa[i][j]);
        writer.print(sopa[i][j]);
      }
      System.out.println();
      writer.println();
    }      
    BufferedReader reader;
    reader = new BufferedReader(new FileReader(file));
    String line = reader.readLine();
    while(line!=null){
      writer.print(line+"\n");
      System.out.println(line);
      line = reader.readLine();
    }
    reader.close();
    writer.close();             
  }

  public static void run(int size,String file) throws IOException{
    input(file);
    soupFiller(size);
    add();
  }

  public static void add(){                                // this function will add the words from wordlist, and random words to fill the gaps, to the soup puzzle
    int x, y, strlen, direction=-1;
    for (int i=0; i<wordCount; i++){
      strlen = wordList[i].length();
      while (true){
        x = randInt(0,size-1);
        y = randInt(0,size-1);
        direction = allDirections(sopa,wordList[i],x,y);
        if(!(direction== -1)){
          break;
        }
      }
      for(int j =0; j <strlen; j++){                                       // for each letter in the word, 
        char c = wordList[i].charAt(j);
        sopa[y][x] = Character.toUpperCase(c);
        switch (direction){
          case(0):               
            y--;        // case UP
            break;
          case(1):
            y++;        // case DOWN
            break;
          case(2):
            x--;        // case LEFT
            break;
          case(3):
            x++;        // case RIGHT ...
            break;
          case(4):
            y--;
            x--;
            break;
          case(5):
            y++;
            x--;
            break;
          case(6):
            y--;
            x++;
            break;
          case(7):
            y++;
            x++;
            break;
          default:
            continue;
        }
      } 
    }
    for (int i =0; i <size; i ++){
      for (int j =0; j< size; j++){
        if(sopa[j][i] == '.'){
          char t = (char) randInt(97, 122);                               // number 97 and 122 are respectively a and z in chars
          sopa[j][i] = Character.toUpperCase(Character.valueOf(t));     // so we are generating a random letter to put into the soup empty spots
        }
      }
    }
  }
  
  public static int allDirections(Character[][] soup,String word,  int startX, int startY){
    word = word.toUpperCase();
    char c;
    Character charword;
    Character charsoup;
    int[] abcissas = {  0,  0,-1, 1, -1, -1,  1, 1}; //UP DOWN LEFT RIGHT UPLEFT DOWNLEFT UPRIGHT DOWNRIGHT
    int[] ordenadas = { -1,  1, 0, 0, -1,  1, -1, 1}; //UP DOWN LEFT RIGHT UPLEFT DOWNLEFT UPRIGHT DOWNRIGHT

    int[] directions = new int[]{-1,-1,-1,-1,-1,-1,-1,-1};
    int val=0;
    while (val<=7){
      int direction = randInt(0,7);
      for(int i=0; i<directions.length; i++){
        if(directions[i]==direction){                 // this will generate a random numbers to fill the integer array so that,
          break;                                      // we can choose a direction randomly
        }
        if(directions[i]==-1){
          directions[i]=direction;
          val++;
          break;
        }
      }
    }

    for (int direction: directions) //8 cardinal directions
    {
        int i, nextX = startX , nextY = startY ;

        for (i = 0; i < word.length(); i++) 
        {
            if (nextX >= soup.length-1 || nextX < 0 || nextY >= soup.length-1 || nextY < 0)     
              break;                                                                              // break if is out of bounds

            c = word.charAt(i);
            charword = Character.toUpperCase(c);
            charsoup = soup[nextY][nextX];
            if (!(charsoup.equals('.'))){
              if(!(charsoup.equals(charword)))
                break;                                          // break if charsoup is not equal to either '.' or charword
            }

            nextX += abcissas[direction];                       
            nextY += ordenadas[direction];                      
        }

        if (i == word.length()){                                // if the word could be placed in the puzzle then we got the right direction
            return direction;                                   // if not, we try other direction
        }
    } 
    return -1;                                                  // if all directions have been tested, then we need to get other coordinates 
  }
  
  public static void input(String file) throws IOException{
    BufferedReader reader;
    wordCount =0;
    reader = new BufferedReader(new FileReader(file));
    String line = reader.readLine();
    while (line!=null){
      String[] splitStr = line.split("\\s+|\\;|\\.|\\,");             // opens the file to remove the words from wordslist
      for (int i=0; i<splitStr.length; i++){
        words += splitStr[i] + "\n";
        wordCount++;
      }
      line = reader.readLine();
    }
    wordList = new String[wordCount];
    Scanner wordScanner = new Scanner(words);
    for(int i=0; i<wordCount; i++){
      String wrd = wordScanner.nextLine();
      wordList[i] = wrd;               // contains all words from words list
    }
    wordScanner.close();

  }

  public static int randInt(int min,int max){                     // returns random number btw a minimum and maximum numbers
    int randNumber = (int)(Math.random() * (max-min+1)+min);
    return randNumber;
  }

  public static void soupFiller(int size){                        // creates a matrix to the puzzle and add '.' to all coordinates of the soup
    sopa = new Character [size][size];                            // later, they will be exchanged for the respective letters of the wordList
    for (int j=0; j<size; j++){
      for(int ind=0; ind<size; ind++){
        sopa[j][ind]='.';
      }
    }
  }
}