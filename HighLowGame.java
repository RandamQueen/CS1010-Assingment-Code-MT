import java.util.Scanner; 
import java.util.Random;
public class HighLowGame {
	public static final int DIFFERENT_NUMBER_OF_POSSIBLE_CARDS = 13;  
	public static final int RANDOM_NUMBER_ERROR_CORRECTION = 2; 
	public static final int ACE_CARD = 14;
	public static final int KING_CARD = 13;
	public static final int QUEEN_CARD = 12;
	public static final int JACK_CARD = 11;
	public static final int 	GUESSES_TO_WIN = 4; 

	public static void main(String[] args) {
		Scanner cardScanner = new Scanner ( System.in);
		Random cardGenerator = new Random (); 
		int correctGuesses = 0; 
		int currentCard = cardGenerator.nextInt( DIFFERENT_NUMBER_OF_POSSIBLE_CARDS ) + RANDOM_NUMBER_ERROR_CORRECTION;
		boolean finished = false; 
		if (currentCard == ACE_CARD )
		{ 
			System.out.println("The card is an Ace");		
		}
		else if (currentCard == KING_CARD )
		{ 
			System.out.println("The card is a King");		
		}
		else if (currentCard == QUEEN_CARD )
		{ 
			System.out.println("The card is a Queen");		
		}
		else if (currentCard == JACK_CARD )
		{ 
			System.out.println("The card is a Jack");		
		}
		else 
		{	
		System.out.println("The card is a " + currentCard);	
		}

		while( !finished)
		{
			int nextCard = cardGenerator.nextInt( DIFFERENT_NUMBER_OF_POSSIBLE_CARDS ) + RANDOM_NUMBER_ERROR_CORRECTION;
			System.out.print("Do you think the next card will be higher, lower or equal? ");
			
			if( (cardScanner.hasNext("higher")))
			{	
				if ( nextCard > currentCard  )
				{
					correctGuesses = correctGuesses + 1; 
					currentCard = nextCard; 
					if (currentCard == ACE_CARD )
					{ 
						System.out.println("The card is an Ace");		
					}
					else if (currentCard == KING_CARD )
					{ 
						System.out.println("The card is a King");		
					}
					else if (currentCard == QUEEN_CARD )
					{ 
						System.out.println("The card is a Queen");		
					}
					else if (currentCard == JACK_CARD )
					{ 
						System.out.println("The card is a Jack");		
					}
					else 
					{	
					System.out.println("The card is a " + currentCard);	
					}
					cardScanner = new Scanner ( System.in);	
				}
				else 
				{
					finished = true; 		
				}
			}
			
			else if( (cardScanner.hasNext("lower")))
			{
				if ( nextCard < currentCard  )
				{
					correctGuesses = correctGuesses + 1; 
					currentCard = nextCard; 
					if (currentCard == ACE_CARD )
					{ 
						System.out.println("The card is an Ace");		
					}
					else if (currentCard == KING_CARD )
					{ 
						System.out.println("The card is a King");		
					}
					else if (currentCard == QUEEN_CARD )
					{ 
						System.out.println("The card is a Queen");		
					}
					else if (currentCard == JACK_CARD )
					{ 
						System.out.println("The card is a Jack");		
					}
					else 
					{	
					System.out.println("The card is a " + currentCard);	
					}
					cardScanner = new Scanner ( System.in);	
				}
				else 
				{
					finished = true; 		
				}
			}
			
			else if( (cardScanner.hasNext("equal")))
			{
				if ( nextCard == currentCard  )
				{
					correctGuesses = correctGuesses + 1; 
					currentCard = nextCard; 
					if (currentCard == ACE_CARD )
					{ 
						System.out.println("The card is an Ace");		
					}
					else if (currentCard == KING_CARD )
					{ 
						System.out.println("The card is a King");		
					}
					else if (currentCard == QUEEN_CARD )
					{ 
						System.out.println("The card is a Queen");		
					}
					else if (currentCard == JACK_CARD )
					{ 
						System.out.println("The card is a Jack");		
					}
					else 
					{	
					System.out.println("The card is a " + currentCard);	
					}
					cardScanner = new Scanner ( System.in);	
				}
				else 
				{
					finished = true; 
				}
			}
			
			else 
			{
				System.out.println("Sorry this is not a valid input."
						+ " Make sure not to capitalize your answer! "); 
				cardScanner = new Scanner ( System.in);
				if (currentCard == ACE_CARD )
				{ 
					System.out.println("The card is an Ace");		
				}
				else if (currentCard == KING_CARD )
				{ 
					System.out.println("The card is a King");		
				}
				else if (currentCard == QUEEN_CARD )
				{ 
					System.out.println("The card is a Queen");		
				}
				else if (currentCard == JACK_CARD )
				{ 
					System.out.println("The card is a Jack");		
				}
				else 
				{	
				System.out.println("The card is a " + currentCard);	
				}
			}
			
			if( correctGuesses == GUESSES_TO_WIN )
			{ 
				finished = true;
			}
		}
		cardScanner.close();
		if( correctGuesses < GUESSES_TO_WIN   )
		{
			System.out.println("I'm sorry, your guess was incorrect. Please play again!"); 
		
		}
		else 
		{
			System.out.println("Congratulations.You got them all correct.");
		}
	}
}
