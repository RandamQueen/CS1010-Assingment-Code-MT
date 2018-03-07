
/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5: 5 
		Comment: I feel that I used variable names that were easy to understand and formatted correctly.
		.
 2. Did I indent the code appropriately?
        Mark out of 5:5 
		Comment: I believe that the code was correctly indented. 

 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20: 20  
	   Comment: 	For my createCipher function, i didn't have an parameters being passed over, as the constant 
	   ALPHABET_LIST was used as the fountain on this function. The return type was a char array as the function
	   was creating a new list of low case letter in a different order to the normal alphabet. The function body was
	   a rewritten version of the randomiseOrder function given to us in the notes, that would work with a char array. 

 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20:20  
	   Comment: The purpose of this function was encrypt the user input text. The parameter that we passed into the 
	   function was the user's inputed text array and the cipher array. The user inputed text was converted from a
	   string to a char array before we ran the function. The return type of this array was an char array as we converted 
	   this array to a string in the main. The body of this  function was quite simple. We tested to see where each element
	   of our input array was located in our ALPHABET_LIST. We then loaded in the correspond element of the cipher array and 
	   added that to an encrypt array. This encrypt array was placed to the main at the end of the function and became our 
	   encrypt text.     

 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20:  20
	   Comment: The purpose of this function was decrypt the encrypt text, back in plain text as before. The parameter 
	   that we passed into the function was the encrypt array and the cipher array. Again, the array was converted from a
	   string to a char array before we ran the function. The return type of this array was an char array as we converted 
	   this array to a string in the main. The body of this function was similar to the encrypt. The made change was that we 
	   tested to see where the encrypt element was the same as the cipher's elements and would load in the corresponding ALPHABET_LIST
	   elements. We returned a decryptArray, which became our decrypted text. 

 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?
       Mark out of 25: 20 
	   Comment: We started off the main body by creating the cipher array and the textScanner. Then we ran a while loop that tested to see if we where
	   still inputting text. Inside this loop, we didn't some error testing to make sure the user didn't put in a number by accident. Unfortunately, we weren't
	   sure how to test if the user entered a Capital Letter, so we told them to only use lower-case. if they entered the / symbol, we terminated the program. 
	   
	   Once we where sure we the user input was correct, we converted it from a String to a char Array. This char Array was then converted 
	   to the encrypt text using the encrypt function. This encrypt was then converted back to lain text using decrypt function. Both of this array
	   were converted back into a string and printed to the console. 

 7. How well did I complete this self-assessment?
   		Mark out of 5:5
		Comment:I think I was fair in this self assessment. 

 Total Mark out of 100 (Add all the previous marks):95 

 */ 

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

