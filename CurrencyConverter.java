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




