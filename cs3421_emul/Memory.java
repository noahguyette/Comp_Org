/*
 * Name: Noah Guyette
 * Class: Memory 
 * Program: CS3421, Program 1 
 * Creation Date: 22 SEP 2019
 * Last Edited: 22 SEP 2019
 * Current Issue: 
 */
package cs3421_emul;

public class Memory {
	
	//Needed variables
	int MemArray[];
	
	
	
	
	/*
	 * This is the method that is called when we want to create new memory
	 * The user should call "create" and then also specifiy a size of the memory they will be using. 
	 * This size will be in hexadecimal. 
	 */
	public void create(int sizeinbytes) {
	
		//Since this is the size in bytes, I will want to convert to decimal, which means that I will need to multiply by four to create the properly sized array. 
		
		int MemArraySize = (sizeinbytes * 4)+1; 
		
		MemArray = new int [MemArraySize];	//Array is now the specified size. Its values are still uninitialized
		
	}
	
	
	
	/*
	 * This method will take all of the memory in the MemArray array, and set each piece of it equal to zero 
	 * This can be used to initialize all values, or it can be used to clear the array out for new incoming values. 
	 */
	public void reset() {
		
		int tempi = MemArray.length; 			//Get the length of the mem array so that I can use it in my for loop 
		
		for(int k = 0; k < tempi; k++) {
			
			MemArray[k] = 0; 					//This will set each position of MemArray to be equal to zero. 
		}		
	}
	
	
	
	
	
	
	
	
	
	
	/*
	 * This method will take in a Hexadecimal address, as well as a count value. 
	 * With these two values, I will start at the given address, and then count forward however
	 * many bytes was specified, printing each byte out to show the user what was at the given location. 
	 */
	public StringBuilder dump(String HexAddress, String Count) {
		 	
		String ClearHexAddy = HexAddress.substring(2);			//Now it is just the hex value, no "0x"
		
		String ClearCount = Count.substring(2);					//Now it is just the hex value, no "0x"
		
		int HexAddy = Integer.parseInt(ClearHexAddy,16);		//Both of these are now decimal ints, rather than hexadecimal values. 
		
		int NewCount = Integer.parseInt(ClearCount, 16); 
		
		int LoopLimit = HexAddy + NewCount; 					//This is the limit that I will loop to when extracting from the MemArray
		//TODO
		//return a string, using string builder, keep concatenating to one string (with line breaks) and then return that.
		
		StringBuilder OutputString = new StringBuilder("Addr   00 01 02 03 04 05 06 07 08 09 0A 0B 0C 0D 0E 0F\n")	;	//Create a string builder with the required top line of the output. 
		
		int beginning = (int) (16* (Math.floor(HexAddy/16))); 	//This will help me figure out how many white spaces I will need to output before I can begin to print the actual values. 
		
		int NumOfBlanks = HexAddy - beginning; 					//This is how many whitespaces I will need to fill before outputting my actual code. 
		
		int linefeedcounter = 0;  
		
		OutputString.append("0x"+Integer.toHexString(beginning));		//This will add the first needed
		
		linefeedcounter++; 									//Since we added something to a new line I need to increment my linefeedcounter. 
		
		//This will be a for loop that will add the whitespace needed to the beginning of the program. 
		for(int aa = 0; aa < NumOfBlanks; aa++) {
			OutputString.append("   ");				//Add three spaces for each blank thing we do not want to print. 
			linefeedcounter++; 						//If we add one thing, then we need to increment the linefeedcounter by one for each thing that is added. 
		}
		
		OutputString.append(" "); 					//Add one space so that I can print my next value in the following for loop. 
		/*
		 * Alright this is an explanation for myself and whoever is reading this. This method got more complicated than what I wanted it to be
		 * but I think that the logic behind all of it is solid. 
		 * When I get to the following for loop. I have already added the required top line of the output, and I have also added the first hex address, as well as the 
		 * necesarry whitespace before the first needed output. 
		 * This loop will start at the necesarry hexadecimal address. I will first check to see if I am at the end of a line and in need of a line feed. 
		 * If I am at the end, I will add a line feed, which puts me on a new line. I will then print the next lines beginning hex address. 
		 *  If I am not at the end of a line I will hit the "else" portion of my if statement which will first add the needed hex value. Once I have added that next hex
		 *  value, I will increase the linefeed by one (since I added one thing to it), and also add a white space  so that I can add another hex value if needed. 
		 */
		for(int a = HexAddy; a < LoopLimit; a++) {		
			
			if(linefeedcounter == 17) {
			OutputString.append("\n");			//If we are at the end of the line then we need to add a new line feed to my string so that I can start on the next one.  
			OutputString.append("0x"+Integer.toHexString(a));
			linefeedcounter = 1;				//Reset the linefeedcounter to one since there is one thing in the line. 
			}
			
			else {
				OutputString.append(Integer.toHexString(MemArray[a]));	//Add the given hex value to the string builder, and give it a space afterwards s
				linefeedcounter++; 				//Increment the line feed counter by one since we added one thing to the line.
				OutputString.append(" ");		//If we are not at the end of the line, then we need to add a space after the given character. 
			}
			 					 
		}
		return OutputString; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//Should be good to go. 
	 public void set (int address, int addedByte) {
		 
		 
		MemArray[address] = addedByte; 							//The given hex address is now equal to the given byte. 
		 
	 }
}
