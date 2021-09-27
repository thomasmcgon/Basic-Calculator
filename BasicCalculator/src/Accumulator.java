// COMP 2100 Lab 1, Fall 2020

/**
 *  The {@code Accumulator} keeps track of the state of an adding
 *  machine.  It accumulates digits to form entire numbers and
 *  either adds or subtracts those numbers to a cumulative sum.
 *  It also has a reset option.
 *
 *  @author <Thomas>
 */
public class Accumulator
{
	int runningTotal;
	int currentNumber;
	public Accumulator() {
		runningTotal = 0;
		currentNumber = 0;
		
	}
   /**
    * Resets the current number entered and the running total to 0.
    */
   public void clear()
   {
	   currentNumber = 0;
	   runningTotal = 0;
	   
   }

   /**
    * Updates current number entered with additional digit that should appear
    * as the a new digit in the lowest order position. For example, if
    * the current number was 34 and the digit is 8, the new current number
    * should be 348.
    *
    * @param  a single digit positive integer
    */
   public void addDigit(int digit)
   {
	   this.currentNumber = this.currentNumber * 10 + digit;
	   //currentNumber = currentNumber * 10 + input;
	   
   }

   /**
    * Adds the current number entered to running total
    */
   public void plus() 
   {
	   this.runningTotal += this.currentNumber;
	   this.currentNumber = 0;
   }

   /**
    * Subtracts the current number entered from running total
    */
   public void minus() 
   {
	   this.runningTotal -= this.currentNumber;
	   this.currentNumber = 0;
   }

   /**
    * Provides either current number entered or running total
    *
    * @return value to be displayed
    */
   public int getDisplay() 
   {
	   if(runningTotal == 0 && runningTotal != currentNumber) {
		   return this.currentNumber;
	   }
	   else {
		   return this.runningTotal;
	   }
   }
}
