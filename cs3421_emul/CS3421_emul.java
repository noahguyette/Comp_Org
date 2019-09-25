package cs3421_emul;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CS3421_emul {
	
	/*
	 * Creation of instance variables so that I can access methods that are in other classes. 
	 */
	
	private Clock Inst_Clock; 
	
	private Memory Inst_Memory; 
	
	private CPU Inst_CPU; 
	
	
	
	
	/*
	 * Method: InstructionParser
	 * Purpose: To get the instructions that Professor Dal Santa gives me, and break them up into words in an array
	 * Use: Strings stored in an array will be able to be used to use necesarry methods for this program. 
	 */
	public static String[]  Parser(String CurrentCommand) {
		
		String [] ParsedContent = CurrentCommand.split(" ");
		
		 return ParsedContent;
	}
	
	
	
	
	
	
	
	
	
	public static void main (String[] args) throws FileNotFoundException {
		
		//First things first I need to create an instance of the CS3421 class, so that I can bypass the static part of this main method. 
		
		CS3421_emul CompOrg = new CS3421_emul(); 		//New instance of the CS3421 method, which will grant access to the other classes like Clock, Memory, and CPU. 
		
		//Now create a scanner so that I can read in the different commands that I might be getting from the data file/command line arguments. 
		File file = new File(args[0]);
		
		Scanner scanny = new Scanner(file);		//Now I have the input that Professor Dal Santo is passing to me 
		
		
		
		//Noah Guyette
		
		
		
		
		//While loop that will keep going through each line of what professor Dal Santo provides for input. 
		while(scanny.hasNextLine()) {
			
			String CurrentCommand = scanny.nextLine();		//CurrentCommand is a string that hold the next given command. It needs to be parsed into something that has whitespace, and can be stored.... putting into an array would be best. 
			
			//If statements that will determine which class is going to be called. 
			
			
			
			
			
			
			
			
			
			//IF statement that handles all clock commands.  
			if(CurrentCommand.contains("clock")) {
				
				String [] ArrayOfClockCommands = Parser(CurrentCommand);		//This gives me a parsed array of the different commands that are held inside of the command.  
				
				
				if(ArrayOfClockCommands[1].contains("reset")) {					//This if statement looks to see if the command is asking for us to reset the clock. 
					CompOrg.Inst_Clock.reset(); 								//This calls the reset command. The number of ticks is now back to zero. 
				}
				
				if(ArrayOfClockCommands[1].contains("tick")) {
					//Create a shift method for CPU, and then call that here, will probably need to incorporate a loop depending on how many shifts are needed. 
					int number = Integer.parseInt(ArrayOfClockCommands[2]);		//If we hit this then we know that the last command in this line will be the number of ticks that the instructions wants to send, so convert it to a number
					
					CompOrg.Inst_Clock.tick(number);							//Once it is a number, I will call "tick(number)" to increase the clock with the given number of ticks. 
				}
				
				if(ArrayOfClockCommands[1].contains("dump")) {
					
					CompOrg.Inst_Clock.dump();
					
				}
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			//Now going to do my if statements for Memory
			if (CurrentCommand.contains("memory")) {
				
				String [] ArrayOfMemoryCommands = Parser(CurrentCommand);		//This will give me a parsed array of the commands that are turned to Memory
				
				if(ArrayOfMemoryCommands[1].contains("create")) {
					int MemNum = Integer.parseInt(ArrayOfMemoryCommands[2]);	//Set the size in bytes to an int, from a string
					CompOrg.Inst_Memory.create(MemNum);							//Call this to create a memory array of the given size, in bytes of course
				}
				
				if(ArrayOfMemoryCommands[1].contains("reset")) {
					CompOrg.Inst_Memory.reset();								//If it contains reset, then reset the memory array. 
				}
				
				if(ArrayOfMemoryCommands[1].contains("dump")) {
					System.out.println(CompOrg.Inst_Memory.dump(ArrayOfMemoryCommands[2], ArrayOfMemoryCommands[3]));
				}
				
				if(ArrayOfMemoryCommands[1].contains("set")) {
					
					String ClearCountt = ArrayOfMemoryCommands[3].substring(2);					//Now it is just the hex value, no "0x"
					
					int DecCountt = Integer.parseInt(ClearCountt,16);		//Both of these are now decimal ints, rather than hexadecimal values. 
					
					String ClearHexAddy = ArrayOfMemoryCommands[2].substring(2);		//removes the "0x" in front of the hex address
					
					int DecAddress = Integer.parseInt(ClearHexAddy,16);
					 
					int looplimit = DecCountt + 4; 
					for(int aaa = 4; aaa < looplimit; aaa++) {
						
					 String ClearHexByte = ArrayOfMemoryCommands[aaa].substring(2);		//removes the "0x" in front of the added byte
					 
					 int DecByte = Integer.parseInt(ClearHexByte,16);		//This should convert the hex to a decimal. I am worried that it might not work with the "0x" in front of it? 
					
					 CompOrg.Inst_Memory.set(DecAddress, DecByte); //Uses the 3rd index of the array and the fifth index of the array to call my set command. 
					 
					 DecAddress++; 
					}	
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
			//If statement that will scan for commands utilizing the cpu. 
			if(CurrentCommand.contains("cpu")) {
				
				String [] ArrayOfCPUCommands = Parser(CurrentCommand);			//This puts the cpu command into an array, each command being a different index of said array. 
				
				if(ArrayOfCPUCommands[1].contains("reset")) {					//Nest if checks to see which CPU Command the directive is asking for. 
					CompOrg.Inst_CPU.reset();
				}
				
				if(ArrayOfCPUCommands[1].contains("set")) {
					String ClearHexBytee = ArrayOfCPUCommands[4].substring(2);	//Get rid of the 0x in front of the hex byte
					
					int CPUHexByte = Integer.parseInt(ClearHexBytee,16);		//Now we have the hex byte in decimal. 
					
					CompOrg.Inst_CPU.setreg(ArrayOfCPUCommands[3], CPUHexByte);	//Set the given register equal to the given hex byte. 
				}
			}
			
			
			
		}
		scanny.close();			//Do not forget to close the scanner for mem leaks. 
		
		
		
	}

}
