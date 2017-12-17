public class DaysOfChirstmas {
	public static final int FIRST_DAY = 1; 
	public static final int LAST_DAY = 12; 
	public static void main(String[] args) {
		int currentDay = FIRST_DAY ; 
		while (currentDay<= LAST_DAY)
		{	
			switch(currentDay)
			{
			case 1: 
				System.out.println("On the first day of Chirstmas"); 
				break; 
			case 2: 
				System.out.println("On the second day of Chirstmas"); 
				break;
			case 3: 
				System.out.println("On the third day of Chirstmas"); 
				break;	
			case 4: 
				System.out.println("On the fourth day of Chirstmas"); 
				break;		
			case 5: 
				System.out.println("On the fifth day of Chirstmas"); 
				break;	
			case 6: 
				System.out.println("On the sixth day of Chirstmas"); 
				break;		
			case 7: 
				System.out.println("On the seventh day of Chirstmas"); 
				break;		
			case 8: 
				System.out.println("On the eighth day of Chirstmas"); 
				break;
			case 9: 
				System.out.println("On the ninth day of Chirstmas"); 
				break;		
			case 10: 
				System.out.println("On the tenth day of Chirstmas"); 
				break;		
			case 11: 
				System.out.println("On the eleven day of Chirstmas"); 
				break;	
			case 12: 
				System.out.println("On the twelfth day of Chirstmas"); 
				break;	
			default :
			}
			System.out.println("my true love sent to me:");
			switch(currentDay)
			{
			case 12:
				System.out.println("12 Drummers Drumming," );
			case 11: 
				System.out.println("11 Pipers Piping,");
			case 10: 
				System.out.println("10 Lords a- Leaping, ");	
			case 9: 	
				System.out.println("9 Ladies Dancing,");
			case 8:	
				System.out.println("8 Maids a- Milking, ");
			case 7:
				System.out.println("7 Swans a-Swimming, ");
			case 6: 
				System.out.println("6 Geese a-Laying, ");
			case 5:
				System.out.println("5 Gold Rings, ");
			case 4: 
				System.out.println("4 Calling Birds,");
			case 3:	
				System.out.println("3 French Hens,");
			case 2: 
				System.out.println("2 Turtle Doves ");
				System.out.print("and ");
			case 1: 
				System.out.println("a Partridge in a Pear Tree. ");
			break; 
			default : 	
			}
			System.out.println(" ");
			currentDay++;
		}
	}
}
