import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;

public class WSSolver {

	public static void main(String[] args) {
		int res = validation();
		if (res == 0){
			System.out.println("Validation of parameters not succeded.");
		}
		else{
			
		}
	}

	public static int validation(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"./sdl_01.txt"));
			String line = reader.readLine();
			int sizeLine = line.length();
			if (sizeLine>40){
				reader.close();
				return 0;
			}
			int val=0;
			while (line != null) {		
				System.out.println(line);
				// read next line
				if(line.isEmpty())
					return 0;
				if(val<sizeLine){									// Checking only for the puzzle lines
					if (!line.matches("[A-Z]*")){
						reader.close();
						return 0;
					}
					for (int i=0; i<sizeLine; i++){
						if(!Character.isUpperCase(line.charAt(i))){
							return 0;
						}
					}
				}
				else if(val>=sizeLine){													// Checking the list of words
					String[] splitStr = line.split("\\s+|\\;|\\.");
					for (int i=0; i<splitStr.length; i++){
						System.out.println(splitStr[i]);
						if (splitStr[i].matches("[A-Z]*")){
							reader.close();
							return 0;
						}
						else if(!splitStr[i].matches("[A-Za-z]*")){
							return 0;
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
		return 1;
	}
}