import java.util.Scanner; 
import java.lang.Math;	
public class DayOfWeek {
	public static final int STARTING_VALUE=0;
	public static final int MAXIMUM_INPUTS = 3;
	public static final int ADD_TO_MONTH = 9;
	public static final int FLOOR_MOD_DIVIDER = 12;
	public static final int FLOOR_DIVIDER = 4;
	public static final int FINAL_MOD_DIVIDER = 7;
	public static final int FIRST_DIGIT_MULTIPLIER =2;  
	public static final int ADD_BEFORE_FLOOR_MONTH =1;  
	public static final double MONTH_MULTIPLIER = 2.6;  
	public static final double SUB_AFTER_FLOOR_MONTH = 0.2;  
	
	// The following constant are taken from the ValidDate. java file 
	//that was provided to use in the Week 9. Functions file. 
	public static final int DAYS_IN_APRIL_JUNE_SEPT_NOV = 30;
	public static final int DAYS_IN_FEBRUARY_NORMALLY = 28;
	public static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
	public static final int DAYS_IN_MOST_MONTHS = 31;
	public static final int NUMBER_OF_MONTHS = 12;
	
	public static void main(String[] args) {
		int inputDay = STARTING_VALUE;
		int inputMonth  = STARTING_VALUE;
		int inputYear = STARTING_VALUE;
		int numInputted = STARTING_VALUE; 
		Scanner dateScanner = new Scanner (System.in);
		System.out.print("Please enter a date in the following formate (DD/MM/YYYY/): ");
		while(numInputted < MAXIMUM_INPUTS) {
			dateScanner.useDelimiter("/");
			//dateScanner.useDelimiter("/" || "\n");
			if(dateScanner.hasNextInt() )
			{
				switch( numInputted) { 
				case 0: 
					inputDay = dateScanner. nextInt(); 
					break; 
				case 1: 
					inputMonth = dateScanner. nextInt(); 
					break; 
				case 2: 
					
					inputYear = dateScanner. nextInt();
					break; 	
				default: 	
				}
				numInputted++;  	
			}
			else if (dateScanner.hasNext()  )
			{
				System.out.println("Sorry this is not a valid input") ;
				dateScanner = new Scanner (System.in);
				System.out.print("Please enter a date in the following formate (DD/MM/YYYY/): ") ;
				numInputted = STARTING_VALUE;	
			}
		}
		dateScanner.close();
		if(validDate(inputDay,inputMonth,inputYear))
		{
			dayOfTheWeek( inputDay, inputMonth,inputYear);
			numberEnding(inputDay);
			monthName(inputMonth);
			System.out.print(inputYear);
		}
		else
		{
			System.out.println("Sorry, this is not a valid date.");
		}
	}
	
	public static void numberEnding(int day) 
	{
		switch(day)
		{ 
		case 1:
		case 21:	
		case 31:
			System.out.print("th");
			break;
		case 2: 
		case 22:	
			System.out.print("nd");
			break;
		case 3: 
		case 23:
			System.out.print("rd");
			break;
		default: 
			System.out.print("th");
			break;
		}
	}
	
	public static void monthName(int month) 
	{
		switch(month) { 
		case 1: 
			System.out.print(" January ");
			break;
		case 2: 
			System.out.print(" February ");
			break;
		case 3: 
			System.out.print(" March ");
			break;	
		case 4: 
			System.out.print(" April ");
			break;	
		case 5: 
			System.out.print(" May ");
			break;
		case 6: 
			System.out.print(" June ");
			break;
		case 7: 
			System.out.print(" July ");
			break;
		case 8: 
			System.out.print(" August ");
			break;	
		case 9: 
			System.out.print(" September ");
			break;	
		case 11: 
			System.out.print(" November ");
			break;
		case 12: 
			System.out.print(" December ");
			break;
		default:
		}
	}
	
	public static void dayOfTheWeek(int day, int month, int year) 
	{
		int enteredDay = day; 
		int enteredMonth = month; 
		int enteredyear = year; 
		if ( enteredMonth <= 2)
		{
			enteredyear--;
		}
		int firstTwoDigitsOfYear = enteredyear/100;
		int lastTwoDigitsOfYear = enteredyear % 100; 
	
		int nameOfDay =((enteredDay + (int)Math.floor(MONTH_MULTIPLIER*(((enteredMonth + ADD_TO_MONTH)  % FLOOR_MOD_DIVIDER)
				+ ADD_BEFORE_FLOOR_MONTH) - SUB_AFTER_FLOOR_MONTH ) + lastTwoDigitsOfYear 
				+ (int)Math.floor( lastTwoDigitsOfYear / FLOOR_DIVIDER) 
				+  (int)Math.floor( firstTwoDigitsOfYear / FLOOR_DIVIDER) 
				- FIRST_DIGIT_MULTIPLIER * firstTwoDigitsOfYear) % FINAL_MOD_DIVIDER) ;
		switch( nameOfDay)
		{ 
		case 0: 
			System.out.print("Sunday, " + enteredDay);
			break;
		case 1: 
			System.out.print("Monday, " + enteredDay);
			break;
		case 2: 
			System.out.print("Tuesday, " + enteredDay);
			break;
		case 3: 
			System.out.print("Wednesday, " + enteredDay);
			break;	
		case 4: 
			System.out.print("Thursday, " + enteredDay);
			break;	
		case 5: 
			System.out.print("Friday, " + enteredDay);
			break;
		case 6: 
			System.out.print("Saturday, " + enteredDay);
			break;
		default:
		}
	}
	
	// The following function are taken from the ValidDate. java file 
	//that was provided to use in the Week 9. Functions file. 
	public static boolean validDate( int day, int month, int year)
	{
		return ((year >= 0) && (month >= 1) && (month <= NUMBER_OF_MONTHS) &&
				(day >= 1) && (day <= daysInMonth( month, year )));
	}
	
	public static int daysInMonth( int month, int year )
	{
		int numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
		switch (month)
		{
		case 2:
			numberOfDaysInMonth = isLeapYear( year ) ? DAYS_IN_FEBRUARY_IN_LEAP_YEAR :
				                                       DAYS_IN_FEBRUARY_NORMALLY;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numberOfDaysInMonth = DAYS_IN_APRIL_JUNE_SEPT_NOV;
			break;
		default:
			numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
			break;
		}
		return numberOfDaysInMonth;
	}
	
	public static boolean isLeapYear( int year )
	{
		return (((year%4 == 0) && (year%100 != 0)) || (year%400 == 0));
	}
}
