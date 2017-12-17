/*  SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 10: 10. There isn't any magic numbers or undefined numbers in the program.   
        
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5: 5 
       
    3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5: 5 
       
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10: 8. They are quite similar, so someone could possible get confused. 
       
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 10:  10
       
   6. Did I indent the code appropriately?
       Mark out of 10:  9
       
   7. Did I read the input correctly from the user using (an) appropriate question(s)?
       Mark out of 10:  9
       
   8. Did I compute the answer correctly for all cases?
       Mark out of 20:  20
       
   9. Did I output the correct answer in the correct format (as shown in the examples)?
       Mark out of 10:  10
       
   10. How well did I complete this self-assessment?
       Mark out of 10: 10. I was honest with my indenting, 
       	as i feel like it could be better.  
       	
   Total Mark out of 100 (Add all the previous marks):  96 / 100
*/

import java.util.Scanner; 

import javax.swing.JOptionPane;

public class CurrencyConverter {
	public static final int  AMOUNT_OF_OLD_PENNIES_IN_OLD_SHILLING = 12;  
 	public static final int  AMOUNT_OF_OLD_SHILLINGS_IN_OLD_POUND = 20; 
	public static final int INFLATION_RATE = 67; 
	public static final int AMOUNT_OF_NEW_PENNIES_IN_NEW_POUND = 100;  
	
	
	public static void main(String[] args) {
			String input = JOptionPane.showInputDialog( "Enter currency to be converted in the following format "
					+ "(Pounds: Shillings: Pennies )"); 
			Scanner inputScanner = new Scanner (input); 
			inputScanner.useDelimiter(":"); 
			int inputPounds = inputScanner. nextInt(); 
			int inputShillings  = inputScanner. nextInt();   
			int inputPennies = inputScanner. nextInt(); 
			inputScanner.close();

			int shillingsToPennies = inputShillings * AMOUNT_OF_OLD_PENNIES_IN_OLD_SHILLING; 
			int poundsToPennies = inputPounds * AMOUNT_OF_OLD_SHILLINGS_IN_OLD_POUND 
					* AMOUNT_OF_OLD_PENNIES_IN_OLD_SHILLING; 
			int totalOldPennies =  shillingsToPennies  + poundsToPennies + inputPennies;
			int totalNewPennies = totalOldPennies * INFLATION_RATE ; 
			double totalNewPounds = ((double)  totalNewPennies /
					AMOUNT_OF_NEW_PENNIES_IN_NEW_POUND); 

			JOptionPane.showMessageDialog(null, inputPounds + " old pound, " +  inputShillings + 
				" old shilling and " + inputPennies + " old pence " +  " = £"  + totalNewPounds); 
	}
}




