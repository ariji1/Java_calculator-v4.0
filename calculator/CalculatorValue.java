package calculator;

import java.util.Scanner;


/**
 * <p> Title: CalculatorValue Class. </p>
 * 
 * <p> Description: A component of a JavaFX demonstration application that performs computations </p>
 * 
 * <p> Copyright: Lynn Robert Carter © 2017 </p>
 * 
 * @author Lynn Robert Carter
 * @modified by Arijit Mukherjee
 * 
 * @version 4.00	2017-10-18 Long integer implementation of the CalculatorValue class 
 * 
 */
public class CalculatorValue {
	
	/**********************************************************************************************

	Attributes
	
	**********************************************************************************************/
	
	// These are the major values that define a calculator value
	double measuredValue = 0; // changed the data type from long to double
	String errorMessage = "";
//	String errorMessage2 = "";// new error message string for handling square root edge case.
	
	/**********************************************************************************************

	Constructors
	
	**********************************************************************************************/

	/*****
	 * This is the default constructor
	 */
	public CalculatorValue() {
	}

	/*****
	 * This constructor creates a calculator value based on a double integer. For future calculators, it
	 * is best to avoid using this constructor.
	 */
	public CalculatorValue(double v) { // changed from Long to double
		measuredValue = v;
	}

	/*****
	 * This copy constructor creates a duplicate of an already existing calculator value
	 */
	public CalculatorValue(CalculatorValue v) {
		measuredValue = v.measuredValue;
		errorMessage = v.errorMessage;
	}

	/*****
	 * This constructor creates a calculator value from a string... Due to the nature
	 * of the input, there is a high probability that the input has errors, so the 
	 * routine returns the value with the error message value set to empty or the string 
	 * of an error message.
	 */
	public CalculatorValue(String s) 
	{
		measuredValue = 0;
		if (s.length() == 0) {								// If there is nothing there,
			errorMessage = "***Error*** Input is empty";		// signal an error	
			return;												
		}
		// If the first character is a plus sign, ignore it.
		int start = 0;										// Start at character position zero
		boolean negative = false;							// Assume the value is not negative
		if (s.charAt(start) == '+')							// See if the first character is '+'
			 start++;										// If so, skip it and ignore it
		
		// If the first character is a minus sign, skip over it, but remember it
		else if (s.charAt(start) == '-'){					// See if the first character is '-'
			start++;											// if so, skip it
			negative = true;									// but do not ignore it
		}
		
		// See if the user-entered string can be converted into an integer value
		Scanner tempScanner = new Scanner(s.substring(start));// Create scanner for the digits
		if (!tempScanner.hasNextDouble()) {					// See if the next token is a valid // changed from .hasnextLong() to .hasnextDouble()
			errorMessage = "***Error*** Invalid value"; 		// integer value.  If not, signal there
			tempScanner.close();								// return a zero
			return;												
		}
		
		// Convert the user-entered string to a integer value and see if something else is following it
		measuredValue = tempScanner.nextDouble();				// Convert the value and check to see
		if (tempScanner.hasNext()) {							// that there is nothing else is 
			errorMessage = "***Error*** Excess data"; 		// following the value.  If so, it
			tempScanner.close();								// is an error.  Therefore we must
			measuredValue = 0;								// return a zero value.
			return;													
		}
		tempScanner.close();
		errorMessage = "";
		if (negative)										// Return the proper value based
			measuredValue = -measuredValue;					// on the state of the flag that
	}
	
//	public CalculatorValue(String s, int k) // constructor for square root exception
//	{
//		measuredValue = 0;
//		if (s.length() == 0) {								// If there is nothing there,
//			errorMessage2 = "***Error*** Input is empty";		// signal an error	
//			return;												
//		}
//		// If the first character is a plus sign, ignore it.
//		int start = 0;										// Start at character position zero
//		boolean negative = false;							// Assume the value is not negative
//		if (s.charAt(start) == '+')							// See if the first character is '+'
//			 start++;										// If so, skip it and ignore it
//		
//		// If the first character is a minus sign, skip over it, but remember it
//		if (s.charAt(start) == '-'){					// See if the first character is '-'
//			start++;											// commented this line because we can't compute square root for negative values
//			errorMessage2 = "Invalid operand, negative input";
//			negative = true;
//			return;
//		}
//		
//		// See if the user-entered string can be converted into an integer value
//		Scanner tempScanner = new Scanner(s.substring(start));// Create scanner for the digits
//		if (!tempScanner.hasNextDouble()) {					// See if the next token is a valid // changed from .hasnextLong() to .hasnextDouble()
//			errorMessage2 = "***Error*** Invalid value"; 		// integer value.  If not, signal there
//			tempScanner.close();								// return a zero
//			return;												
//		}
//		
//		// Convert the user-entered string to a integer value and see if something else is following it
//		measuredValue = tempScanner.nextDouble();				// Convert the value and check to see
//		if (tempScanner.hasNext()) {							// that there is nothing else is 
//			errorMessage2 = "***Error*** Excess data"; 		// following the value.  If so, it
//			tempScanner.close();								// is an error.  Therefore we must
//			measuredValue = 0;								// return a zero value.
//			return;													
//		}
//		tempScanner.close();
//		errorMessage2 = "";
//		if (negative)										// Return the proper value based
//			measuredValue = -measuredValue;					// on the state of the flag that
//	}

	/**********************************************************************************************

	Getters and Setters
	
	**********************************************************************************************/
	
	/*****
	 * This is the start of the getters and setters
	 * 
	 * Get the error message
	 */
	
	
	/*****
	 * Set the current value of a calculator error message to a specific string
	 */
//	public void setErrorMessage2(String m){
//		errorMessage2 = m;
//	}
	
//	public String getErrorMessage2() //Get the error message for sqrt
//	{
//		return errorMessage2;
//	}
	
	public String getErrorMessage()
	{
		return errorMessage;
	}
	
	/*****
	 * Set the current value of a calculator value to a specific long integer
	 */
	public void setValue(double v){ // changed from Long to Double
		measuredValue = v;
	}
	
	/*****
	 * Set the current value of a calculator error message to a specific string
	 */
	public void setErrorMessage(String m){
		errorMessage = m;
	}
	
	/*****
	 * Set the current value of a calculator value to the value of another (copy)
	 */
	public void setValue(CalculatorValue v){
		measuredValue = v.measuredValue;
		errorMessage = v.errorMessage;
	}
	
	/**********************************************************************************************

	The toString() Method
	
	**********************************************************************************************/
	
	/*****
	 * This is the default toString method
	 * 
	 * When more complex calculator values are creating this routine will need to be updated
	 */
	public String toString() {
		return measuredValue + "";
	}
	
	/*****
	 * This is the debug toString method
	 * 
	 * When more complex calculator values are creating this routine will need to be updated
	 */
	public String debugToString() {
		return "measuredValue = " + measuredValue + "\nerrorMessage = " + errorMessage + "\n";
	}

	
	/**********************************************************************************************

	The computation methods
	
	**********************************************************************************************/
	

	/*******************************************************************************************************
	 * The following methods implement computation on the calculator values.  These routines assume that the
	 * caller has verified that things are okay for the operation to take place.  These methods understand
	 * the technical details of the values and their reputations, hiding those details from the business 
	 * logic and user interface modules.
	 * 
	 * Since this is addition and we do not yet support units, we don't recognize any errors.
	 */
	public void add(CalculatorValue v) {
		System.out.print(measuredValue);
		measuredValue += v.measuredValue;
		errorMessage = "";
	}

	/*****
	 * Sub method will handle the subtraction operation for two valid operands.
	 * Object based implementation is followed, similar to addition,
	 * default error message is null.
	 * @param v
	 */
	public void sub(CalculatorValue v) 
	{
		System.out.print(measuredValue); // a test statement to check if the method works. Id doesn't affect the UI and can be commented
		measuredValue -= v.measuredValue;
		errorMessage = "";
	}
	
	/*****
	 * mpy method will handle the multiplication operation for two valid operands.
	 * Object based implementation is followed, similar to addition,
	 * default error message is null.
	 * @param v
	 */
	public void mpy(CalculatorValue v)
	{
		measuredValue *= v.measuredValue;
		errorMessage = "";
	}
	
	/*****
	 * div method will handle the division operation for two valid operands.
	 * Object based implementation is followed, similar to addition,
	 * default error message is null.
	 * @param v
	 */

	public void div(CalculatorValue v) 
	{
		if(v.measuredValue == 0)
		{
			errorMessage = "Division by zero is not allowed";		// handling the divide by zero error
		}
		else
		{
			measuredValue /= v.measuredValue;
		}
	}
	/*****
	 * sqr method will handle the division operation for a valid operand.
	 * Object based implementation is followed, similar to addition,
	 * default error message is null.
	 * @param v
	 */
	public void sqr()
	{
		if(measuredValue < 0)
		{
			errorMessage = "invalid operand, negative number"; // there is no square root for negative numbers
//			System.out.println(errorMessage);
			
		}
		else
		{
			measuredValue = Math.sqrt(measuredValue);
			errorMessage = "";
		}
		
	}
	
}
