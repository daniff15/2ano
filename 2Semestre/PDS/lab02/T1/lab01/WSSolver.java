import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class WSSolver {

	private static int soup_size;
	private static int wordList_size;
	private static String[] res;

	public static void main(String[] args) throws IOException{
		res = validation();
		solve();
	}

	public static void solve()throws IOException{
		soup_size = Integer.parseInt(res[2]);			// soup size
		wordList_size = Integer.parseInt(res[3]);		// wordlist size
		Scanner soupScanner = new Scanner(res[0]);
		Scanner wordScanner = new Scanner(res[1]);
		String[] wordList = new String[wordList_size];
		Character[][] soup = new Character[soup_size][soup_size];
		for(int i = 0 ; i < soup_size ; i++) {
            String line = soupScanner.nextLine();
            for (int j = 0; j < soup_size; j++)
                soup[i][j] = line.charAt(j);				// transfers the soup puzzle from string to Character[][]
        }

        for(int i=0; i<wordList_size; i++){
        	String line = wordScanner.nextLine();
        	wordList[i] = line;								// has all words from wordlist
        }
        wordScanner.close();
        soupScanner.close();

        //Table with dots that after will be replaced by the words in the soup letters
        Character[][] soupBoard = new Character[soup_size][soup_size];
        for(int i=0; i<soup_size; i++){
        	for(int j=0; j<soup_size; j++){
        		soupBoard[i][j] = '.';
        	}
        }

        // Getting the results and printing on the console and in the txt file
        int file = 1;
        while (true){
	        	File output = new File("out"+Integer.toString(file)+".txt");
	        	if(!output.createNewFile())
	        		file++;
	        	else
	        		break;
		}	

    	PrintWriter writer = new PrintWriter("out"+Integer.toString(file)+".txt", "UTF-8");

        for (String word: wordList){
        	String[] results = find(soup,word);
        	int word_len=word.length();
        	System.out.printf("%-10s %-5d %-4s %s\n", word, word_len, results[0],results[1]);
        	writer.printf("%-10s %-5d %-5s %-8s\n", word, word_len, results[0],results[1]);
        	String[] splitStr = results[0].split("\\,");
        	int y=Integer.parseInt(splitStr[0]);
        	int x=Integer.parseInt(splitStr[1]);
        	x--;
        	y--;
        	for (int i=0; i<word_len; i++){
        		char c=word.charAt(i);
        		soupBoard[y][x]=Character.toUpperCase(c);
	        	switch(results[1]){
	        		case("UP"):
	        			y--;
	        			break;
	        		case("DOWN"):
	        			y++;
	        			break;
	        		case("LEFT"):
	        			x--;
	        			break;
	        		case("RIGHT"):
	        			x++;
	        			break;
	        		case("UPLEFT"):
	        			y--;
	        			x--;
	        			break;
	        		case("UPRIGHT"):
	        			x++;
	        			y--;
	        			break;
	        		case("DOWNLEFT"):
	        			y++;
	        			x--;
	        			break;
	        		case("DOWNRIGHT"):
	        			y++;
	        			x++;
	        			break;
	        		default:
	        			continue;
	        	}
	        }
        }  
        for(int i=0; i<soup_size; i++){
        	System.out.println();
        	writer.println();
    		for(int j=0; j<soup_size; j++){
    			System.out.print(soupBoard[i][j]);
    			writer.print(soupBoard[i][j]);
    		}
        }
        writer.close();
	}

	public static String[] find (Character[][] sopa, String word){
		word = word.toUpperCase();
		int size = sopa.length;

		int direction = -1;

		for (int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				if(sopa[i][j]==word.charAt(0)){
					direction = allDirections(sopa, word, i, j);							// Verify all directions
                    switch(direction){
                    	case(0):
                        	return new String[]{++i + "," + ++j, "LEFT"};
                        case(1):
                        	return new String[]{++i + "," + ++j, "RIGHT"};
                        case(2):
                        	return new String[]{++i + "," + ++j, "UP"};
                        case(3):
                        	return new String[]{++i + "," + ++j, "DOWN"};
                       	case(4):
                       		return new String[]{++i + "," + ++j, "UPLEFT"};
                        case(5):
                        	return new String[]{++i + "," + ++j, "UPRIGHT"};
                        case(6):
                        	return new String[]{++i + "," + ++j, "DOWNLEFT"};
                        case(7):
                        	return new String[]{++i + "," + ++j, "DOWNRIGHT"};
                        default:
                        	continue;
                    }
				}
			}
		}
		System.out.printf("ERROR: Word %s not found\n",word);
        System.exit(1);
        return null;
	}

	private static int allDirections(Character[][] soup,String word,  int x, int y)
    {
        int[] abcissas = {  0,  0,-1, 1, -1, -1,  1, 1}; //UP DOWN LEFT RIGHT UPLEFT DOWNLEFT UPRIGHT DOWNRIGHT
        int[] ordenadas = { -1,  1, 0, 0, -1,  1, -1, 1}; //UP DOWN LEFT RIGHT UPLEFT DOWNLEFT UPRIGHT DOWNRIGHT


        for (int direction = 0; direction < 8; direction++) //8 cardinal directions
        {

            int i, nextX = x + abcissas[direction], nextY = y + ordenadas[direction];

            for (i = 1; i < word.length(); i++) 
            {
                if (nextX >= soup.length || nextX < 0 || nextY >= soup.length || nextY < 0)			// break if is out of bounds
                    break;

                if (soup[nextX][nextY] != word.charAt(i)){						// break if char in soup is not equal to the respective word char
                    break;
                }

                nextX += abcissas[direction];
                nextY += ordenadas[direction];
            }

            if (i == word.length()){							// if all the word could be placed in the puzzle, then we got the right direction 
                return direction;								// if not, we try other direction
            }
        }
        return -1;												// if all directions have been tested, then we need to get other start for index x and y
    }


	public static String[] validation(){
		String[] res = new String[4];
		String sopa = "";
		String words = "";
		int sizeLine = 0;
		int sizeWords = 0;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(			// opnes the wordslist file to get the wordds
					"./sdl_02.txt"));
			String line = reader.readLine();
			sizeLine = line.length();
			if (sizeLine>40){
				reader.close();
				System.err.println("Line size is over 40!");
				System.exit(0);
			}
			int val=0;
			while (line != null) {		
				// read next line
				if(line.isEmpty()){
					System.err.println("Validation not succeded");
					System.exit(0);
				}
				if(val<sizeLine){									// Checking only for the puzzle lines
					if (!line.matches("[A-Z]*")){
						reader.close();
						System.err.println("Validation not succeded");
						System.exit(0);
					}
					for (int i=0; i<sizeLine; i++){
						if(!Character.isUpperCase(line.charAt(i))){
							System.err.println("Validation not succeded");
							System.exit(0);
						}
					}
					sopa += line + "\n";
				}
				else if(val>=sizeLine){													// Checking the list of words
					String[] splitStr = line.split("\\s+|\\;|\\.|\\,");
					for (int i=0; i<splitStr.length; i++){
						words += splitStr[i] + "\n";
						sizeWords++;
						if (splitStr[i].matches("[A-Z]*")){
							reader.close();
							System.err.println("Validation not succeded");
							System.exit(0);
						}
						else if(!splitStr[i].matches("[A-Za-z]*")){
							System.err.println("Validation not succeded");
							System.exit(0);
						}
					}
				}
				line = reader.readLine();
				val++;
			}
			reader.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		String lineSize = Integer.toString(sizeLine);
		String wordsSize = Integer.toString(sizeWords);
		res[0]=sopa;
		res[1]=words;
		res[2]=lineSize;
		res[3]=wordsSize;
		return res;
	}

	// True if word is in the row
	

}