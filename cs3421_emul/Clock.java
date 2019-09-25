/*
 * Name: Noah Guyette
 * Class: CS3421
 * Program: Program One - CPU
 * Date Created: 22 SEP 2019
 * Last Edited: 22 SEP 2019 
 * Current Issue: 
 */

package cs3421_emul;



public class Clock {
	
	private CPU Instance_CPU; 
	
	//I need to establish my variables that I will be using for this class, the largest and most important of these is "Count" 
	//Would it be easier to store this as an int and convert to 16 bit unsigned, or just keep it as a 16 bit unsigned the whole time? 
	//Variables
	int unsignedcount; //This will be the variable that holds the number of ticks that I receive. 
	
	

	
/*
 * GOOD TO GO
 * Method Name: reset
 * Function: This method will take the current counter value of how many ticks have "ticked" 
 * and then set that value back to zero. 
 */
public void reset() {
	
	unsignedcount = 0; 	// this should be a 16 bit binary number, displayed in hex. As I increment this should too. 
	
}



/*
 * This will accept a positive decimal integer. This integer will determine how many clock ticks to 
 * omit to the connected devices. It should not output anything from this method, however it is possible
 * that connected devices will produce output when called to "tick. 
 */
public void  tick( int issuedticks ) {
	
	
	for(int i = 0; i < issuedticks; i++ ) {		//This should loop through the given number of times, and increase the counter that many ticks. 
		
		Instance_CPU.shift();					//I need to call this, because everytime the clock ticks, it is supposed to shift each of the registers that is in the CPU. 
		
		unsignedcount++; 						//Increase the tick number by one (per loop)
	}

}

/*
 * This seems to be one of the easier commands, as all I need to do in it
 * is return what the count value is. No arguments taken, and then a return
 * of "Clock: __Count__. 
 */
public String dump() {
	
	return "Clock: " + unsignedcount; 			//Return the number of tickets in the specified format. 
	
}
	
	

}