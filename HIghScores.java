import java.util.Scanner;
public class HIghScores {
	public static final int BEGINNING_VALUE = 0; 
	public static final int MINIMUM_AMOUNT_OF_SCORES =1; 
	public static final int INDEX_CORRECTION = -1; 

	public static void main(String[] args) {
		int[] highScoreList = null;
		int scoresEntered = BEGINNING_VALUE; 
		boolean gettingListSize = true;
		Scanner inputScanner = new Scanner (System.in); 
		System.out.print("Please input the maximum amount of highscores."
				+ "(It must be postive and greather than 0): ");
		while(gettingListSize)
		{
			if( inputScanner.hasNextInt())
			{
				int maxAmountOfScores = inputScanner.nextInt();
				if (maxAmountOfScores >= MINIMUM_AMOUNT_OF_SCORES  )
				{
					highScoreList = new int[maxAmountOfScores ];
					initliasiseHighScores( highScoreList); 
					printHighScore( highScoreList); 
					gettingListSize = false;
				}

				else 
				{
					inputScanner = new Scanner (System.in); 
					errorMessage(); 
				}
			}
			else if(inputScanner.hasNext() )
			{
				inputScanner = new Scanner (System.in); 
				errorMessage(); 
			}
		}
		while( scoresEntered < highScoreList.length  )
		{
			System.out.print( "Enter next Highscore: ");
			if( inputScanner.hasNextInt())
			{
				int enteredScore= inputScanner.nextInt();
				insertScore( highScoreList, enteredScore);
				printHighScore(highScoreList);
				scoresEntered++;
			}
			else if(  inputScanner.hasNext())
			{
				System.out.println( "please make sure to input a number in digit formation.Thank you");
				inputScanner = new Scanner (System.in); 
			}
		}

		inputScanner.close();
	}

	public static void initliasiseHighScores( int[] zeroArray )
	{
		for( int index =BEGINNING_VALUE; index < zeroArray.length; index++ )
		{
			zeroArray[index] =BEGINNING_VALUE;

		}
	}

	public static void printHighScore( int[] printArray )
	{
		for( int index =BEGINNING_VALUE; index < printArray.length; index++ )
		{
			System.out.println(printArray [index]);		
		}
	}

	public static void insertScore( int[] storeArray, int newScore)
	{
		boolean findPosition = true; 
		int testIndex = storeArray.length + INDEX_CORRECTION; 
		int shiftIndex = testIndex; 
		while( findPosition && testIndex != INDEX_CORRECTION )
		{
			if( higherThan(newScore, storeArray[ testIndex]))
			{
				testIndex--; 
			}
			else 
			{
				findPosition = false;
			}
		}
		if( newScore !=BEGINNING_VALUE)
		{
			testIndex++;
		}
		int [] tempArray = storeArray ; 
		while( shiftIndex > testIndex  )
		{
			tempArray[shiftIndex] = tempArray[shiftIndex + INDEX_CORRECTION]; 
			shiftIndex--;
		}
		storeArray[testIndex] = newScore; 
	}

	public static boolean higherThan(int newScore, int currentScore )
	{
		if( newScore > currentScore)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	public static void  errorMessage() 
	{
		System.out.println("Sorry, this inputted amount is not acceptable. "
				+ "Make sure your number is postive"); 
		System.out.print( "Please input the maximum amount of highscores."
				+ "(It must be postive and greather than 0): ");	
	}
}

