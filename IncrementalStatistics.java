import java.util.Scanner; 

public class IncrementalStatistics {

	public static void main(String[] args) {
		double perviousAverage = 0;
		double currentAverage = 0; 
		double perviousVariance = 0; 
		double currentVariance = 0; 
		int inputNumber = 0; 
		int amountOfNumbersEntered = 0; 
		boolean finished = false; 
		Scanner inputNum = new Scanner(System.in );
		System.out.println("This program computes the average and variance of all numbers entered.");		
		while (!finished)	
		{
			System.out.print("Enter another number (or type 'exit'): ") ;
			if(inputNum.hasNextInt() ) 
			{
				inputNumber = inputNum.nextInt();			
				amountOfNumbersEntered++; 
				perviousAverage = currentAverage;  
				perviousVariance = currentVariance; 
				currentAverage = (perviousAverage + (inputNumber - perviousAverage)/ amountOfNumbersEntered);		
				currentVariance = ((( perviousVariance * (amountOfNumbersEntered -1 )) 
						+ (inputNumber - perviousAverage) * (inputNumber - currentAverage)) /amountOfNumbersEntered);
				System.out.println("So far the average is " + currentAverage 
						+ " and variance is " +currentVariance ); 	
			}
			else if ((inputNum.hasNext("exit")) || (inputNum.hasNext("quit")))
			{ 
				finished = true;
			} 	
			else if(inputNum.hasNext())
			{ 
				System.out.println("Sorry this input is invalid.") ;
				inputNum = new Scanner(System.in );
			}
		}
		System.out.print("Goodbye.") ;
		inputNum.close();
	}	
}



