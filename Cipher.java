import java.util.Random;
import java.util.Scanner;

public class Cipher {
	public static final int BEGINNING_VALUE =0; 
	public static final char[] 	ALPHABET_LIST = {'a', 'b', 'c', 'd', 'e', 'f','g','h', 'i', 'j', 'k', 
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '}; 
	
	public static void main(String[] args) 
	{
		boolean inputtingText = true; 
		char [] cipherArray=  createCipher(); 
		Scanner textScanner = new Scanner( System.in);
		while(inputtingText)
		{
			System.out.println("This program allows you to encrapted low case letters.");
			System.out.println("If you wish to end the program, please enter the / symbol.");
			System.out.print("Please enter the text you want to encrapted: ");
			if (textScanner.hasNextLine())
			{
				if(textScanner.hasNextInt() )
				{
					System.out.println("Sorry, this is not a valid input."); 
					textScanner = new Scanner( System.in);
				}
				if(textScanner.hasNext("/"))
				{
					inputtingText = false; 
				}
				else 
				{	
					String inputtText = textScanner.nextLine();	
					char[] inputArray = inputtText.toCharArray();

					char[] encryptArray = encrypt(inputArray,cipherArray ) ;
					String encryptString =  new String( encryptArray );

					char[] decryptArray = decrypt(encryptArray,cipherArray ) ;
					String decryptString =  new String( decryptArray );
					System.out.println("The encrypt text is: " + encryptString);
					System.out.println("The decrypt text is: " + decryptString);

				}
				System.out.println();
			}	
		}
		textScanner. close(); 
	}

	// the body of this function was based of the randomiseOrder function given to us 
	// in the Week 12. 1D and 2D Arrays notes. 
	public static char[] createCipher()    
	{
		char[] tempArray = new char[ALPHABET_LIST.length];
		for (int index=BEGINNING_VALUE; index<tempArray.length; index++ )
		{
			tempArray[index] = ALPHABET_LIST[index];
		}
		Random generator = new Random();
		for (int index=BEGINNING_VALUE; index<tempArray.length; index++ )
		{
			int otherIndex = generator.nextInt(tempArray.length);
			char temp = tempArray[index];
			tempArray[index] = tempArray[otherIndex];
			tempArray[otherIndex] = temp;
		}
		return tempArray;
	}

	public static char [] encrypt(char [] inputArray, char [] cipherArray) 
	{
		char [] encryptArray = new char[inputArray.length]; 
		for( int inputIndex = BEGINNING_VALUE; inputIndex <inputArray.length; inputIndex++ )
		{
			char inputElement = inputArray[inputIndex];
			int cipherIndex = BEGINNING_VALUE;
			boolean findingPosition = true; 
			while (findingPosition )
			{
				if( inputElement == ALPHABET_LIST[cipherIndex])
				{
					findingPosition = false;
				}
				else 
				{
					cipherIndex++;
				}
			}
			char encryptChar = cipherArray[cipherIndex];		
			encryptArray[inputIndex] = encryptChar ;
		}
		return encryptArray; 
	}

	public static char [] decrypt(char [] encryptArray, char [] cipherArray) 
	{
		char [] decryptArray = new char[encryptArray.length]; 
		for( int decryptIndex = BEGINNING_VALUE; decryptIndex <decryptArray.length; decryptIndex++ )
		{
			char encryptChar = encryptArray[decryptIndex];
			int cipherIndex = BEGINNING_VALUE;
			boolean findingPosition = true; 
			while (findingPosition)
			{
				if( encryptChar == cipherArray[cipherIndex])
				{
					findingPosition = false;
				}
				else 
				{
					cipherIndex++;
				}
			}
			char decryptChar = ALPHABET_LIST[cipherIndex];
			decryptArray[decryptIndex] = decryptChar ;
		}
		return decryptArray; 
	}
}

