package lab03;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GestorDeVoos {
	
	public static HashMap<String,Voo> voos = new HashMap<String,Voo>();
	
	
	public static void readAndAddVoo(String fileName) {
		
		Scanner file = null;
		System.out.println(fileName);
		// Try to read the file
		try {
			file = new Scanner(new File(fileName)); 
			file.useDelimiter("\r\n|\n");
		}
		catch(FileNotFoundException e) {
			System.err.println("ERROR: Coundn't open file");
			System.out.println(e);
			return;
		}
		
		String[] line =  file.nextLine().split(" ");
		// Validate the header
		if(line[0].charAt(0) != '>') {
			System.err.println("ERROR: Invalid file");
			file.close();
			return;
		}
		else if (line.length < 2 || line.length > 3) {
			System.err.println("ERROR: Invalid file");
			file.close();
			return;
		}
		
		// Add the flight by calling the right factory
		Voo v;
		String codigo = line[0].substring(1);
		if(line.length > 2) {
			v = Voo.criarVoo(codigo, line[1],line[2]);
		}
		else {
			v = Voo.criarVoo(codigo, line[1]);
		}
		if(v == null) {
			file.close();
			return;
		}
		// Save flight
		voos.put(v.getCodigo(), v);
		
		// Try to reservate seats
		do {
			line =  file.nextLine().split(" ");
			// Validate the reservation
			if(line.length != 2) {
				System.err.println("ERROR: Invalid Reservation");
			}
			else if(!line[0].matches("E|T")) {
				System.err.println("ERROR: Invalid CLASS");
			}
			else if(!line[1].matches("\\d")) {
				System.err.println("ERROR: Invalid number_seats");
			}
			else {
				int numero = Integer.parseInt(line[1]);
				char classe = line[0].charAt(0);
				reservarLugares(codigo,classe,numero);
			}
			
		}while(file.hasNext());
		
		file.close();
	}
	
    public static void addVoo(String codigo, String dims_exec, String dims_turista) {
        if (voos.containsKey(codigo)) {
            System.out.println("Flight already exists!");
            return;
        }

        voos.put(codigo, Voo.criarVoo(codigo, dims_exec, dims_turista));
    }

	
	public static void showReservation(String codigo) {
		// See if flight exists
		if(!voos.containsKey(codigo)) {
			System.out.println("Sorry Flight not found :(");
			return;
		}
		else {
			System.out.println(voos.get(codigo));
		}
	}
	
	public static void reservarLugares(String codigo, char classe, int numero) {
		// See if flight exists
		if(!voos.containsKey(codigo)) {
			System.out.println("Sorry Flight not found :(");
			return;
		}
		else {
			// Warn if coundn't reservate a seat
			if(!voos.get(codigo).reservarLugares(numero, classe == 'E')) {
				System.out.printf("Não foi possível obter lugares para a reserva: %s %d\n",classe,numero);
			}
		}
	}
	
	public static void cancelarReserva(String codigo) {
		// Validate the reservation_code
		if(!codigo.matches("\\w+:\\d")) {
			System.err.println("ERROR: Invalid Reservation Code");
			return;
		}

		String flight_code = codigo.split(":")[0];
		int res_numb = Integer.parseInt(codigo.split(":")[1]);
		
		if(!voos.containsKey(flight_code)) {
			System.out.println("Sorry Flight not found :(");
			return;
		}
		voos.get(flight_code).anularReserva(res_numb);
		
	}
	
	
	
	public static void main(String args[]) {
        try {
            Scanner in;
			boolean fromFile = false;

            if (args.length == 0)
				// interactive mode
                in = new Scanner(System.in);
            else {
				// read commands from file
				fromFile = true;
                in = new Scanner(new File(args[0]));
            }

            
            String[] command;
                
            while(true) {
                System.out.println("Escolha uma opção:   (H para ajuda)");
				// Detect end of file
				if (fromFile && !in.hasNextLine()) break;
                // Read input
				String line = in.nextLine();
                command = line.split(" ");
				// Print line if reading from file
				if (fromFile) System.out.println(line);
                
                switch(command[0]) {
                    case "H":
                        System.out.println("Options:");
						System.out.println("Read file:\n   I filename");
						System.out.println("Show flight:\n   M flight_code");
						System.out.println("Add flight:\n   F flight_code [num_seats_executive] num_seats_tourist");
						System.out.println("Make reservation:\n   R flight_code class('E' | 'T') number_seats");
						System.out.println("Cancel reservation:\n   C reservation_code");
						System.out.println("Quit:\n   Q");
                        break;
                    case "I":
                        if(command.length != 2) {
                            System.err.println("ERROR: Invalid Number of Argumments");
                            System.out.println("Usage: I filename");
                        }
                        else {
                            readAndAddVoo(command[1]);
                        }
                        break;
                    case "M":
                        if(command.length != 2) {
                            System.err.println("ERROR: Invalid Number of Argumments");
                            System.out.println("Usage: M flight_code");
                        }
                        else {
                            showReservation(command[1]);
                        }
                        break;
                    case "F":
                        if (command.length == 4)
                            addVoo(command[1], command[2], command[3]);
                        else if (command.length == 3)
                            addVoo(command[1], "0x0", command[2]);
                        else {
                            System.err.println("ERROR: Invalid Number of Argumments");
                            System.out.println("Usage: F flight_code [num_seats_executive] num_seats_tourist");
                        }
                        break;
                    case "R":
                        if(command.length != 4) {
                            System.err.println("ERROR: Invalid Number of Argumments");
                            System.out.println("Usage: R flight_code class('E' | 'T') number_seats");
                        }
                        else if(!command[2].matches("E|T")) {
                            System.err.println("ERROR: Invalid CLASS");
                            System.out.println("Usage: R flight_code class('E' | 'T') number_seats");
                        }
                        else if(!command[3].matches("\\d")) {
                            System.err.println("ERROR: Invalid number_seats");
                            System.out.println("Usage: R flight_code class('E' | 'T') number_seats");
                        }
                        else {
                            int numero = Integer.parseInt(command[3]);
                            char classe = command[2].charAt(0);
                            reservarLugares(command[1],classe,numero);
                        }
                        break;
                    case "C":
                        if(command.length != 2) {
                            System.err.println("ERROR: Invalid Number of Argumments");
                            System.out.println("Usage: C reservation_code");
                        }
                        else {
                            cancelarReserva(command[1]);
                        }
                        break;
                    case "Q":
                        in.close();
                        return;
					// For debugging
					/*
                    case "D":
                        readAndAddVoo("lab03/flight1.txt");
                        showReservation("TP1920");
                        break;
					*/
                    default:
                        System.out.println("Invalid Command :(");
                        break;
                }
            }
			in.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("ERROR: file not found");
            System.exit(1);
        }
	}
}
