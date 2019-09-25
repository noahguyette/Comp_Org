/*
 * Name: Noah Guyette
 * Class: CS3421
 * Program: Program One 
 * Date Created: 22 SEP 2019
 * Last Edited: 22 SEP 2019
 */
package cs3421_emul;

public class CPU {
	
	private Memory Ins_Mem; 
	
	//Create the Registers Needed to hold values, and also the program counter 
	int [] regs = new int [9];		//The way this is created, it is two tall and 9 wide, the first slot is for the program counter. 
	
	
	//Assign each of the "registers" to the given index of the registers array. 
	
	int PC = regs[0];
    int RA = regs[1];
	int RB = regs[2];
	int RC = regs[3];
	int RD = regs[4];
	int RE = regs[5];
	int RF = regs[6];
	int RG = regs[7];
	int RH = regs[8];
	 
	//Set all the register values back to zero. 
	 public void reset() {
		 
		 for ( int i = 0; i < regs.length; i++) {
			 regs[i] = 0; 
		 }
		 
	 }
	 
	 
	 public void setreg(String reg, int byteadded) {
		 
		    if( reg.contains("PC")) {
		    	
		    	PC = byteadded; 
		    }
		    else if(reg.contains("RA")){
		    	RA = byteadded; 
		    }
		    else if(reg.contains("RB")){
		    	RB = byteadded; 
		    }
		    else if(reg.contains("RC")){
		    	RC = byteadded;
		    }
		    else if(reg.contains("RD")){
		    	RD = byteadded; 
		    }
		    else if(reg.contains("RE")){
		    	RE = byteadded;
		    }
		    else if(reg.contains("RF")){
		    	RF = byteadded; 
		    }
		    else if(reg.contains("RG")){
		    	RG = byteadded; 
		    }
		    else if(reg.contains("RH")){
		    	RH = byteadded; 
		    }
		 
	 }
	 
	 
	 public StringBuilder dump() {
		 
		 StringBuilder CPUDump = new StringBuilder();		//Create a new string builder, and add in each of the registers with the correct name and line feeds. 
		 
		 CPUDump.append("PC: 0x"+PC+"\n");
		 CPUDump.append("RA: 0x"+RA+"\n");
		 CPUDump.append("RB: 0x"+RB+"\n");
		 CPUDump.append("RC: 0x"+RC+"\n");
		 CPUDump.append("RD: 0x"+RD+"\n");
		 CPUDump.append("RE: 0x"+RE+"\n");
		 CPUDump.append("RF: 0x"+RF+"\n");
		 CPUDump.append("RG: 0x"+RG+"\n");
		 CPUDump.append("RH: 0x"+RH+"\n");
		 
		 return CPUDump;  
	 }
	 
	 
	 public void shift() {
		 
		 
		 //This for loop now needs to shift each register. 
		 for( int b = 2; b < 8; b++) {
			  
			 regs[b] = regs[b-1];			//This should set each register equal to the register that was before it. 
			 
		 }
		 regs[1] = Ins_Mem.MemArray[PC];	//Set RA to be equal to whatever the program counter points to in memory. 
		 PC++; 
		 
	 }
	
}

