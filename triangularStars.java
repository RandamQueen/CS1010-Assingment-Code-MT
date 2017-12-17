public class triangularStars { 
	public static final int BEGINNING_VALUE=1;
	public static final int STARTING_DIGIT_OF_TRI_NUM =0; 	
	public static final int 	STAR_MULIPLIER = 6; 	
	public static final int 	STAR_INDEX_SUB = 1; 	
	public static final int 	STAR_INDEX_CONSTANT = 1; 
	public static final int  MAXIMUM_VALUE_OF_INDEX =Integer.MAX_VALUE ;
	public static final int  MAX_ACCEPTABLE_TRINUMBER =2147463020 ;
	public static void main(String[] args) {
		System.out.println("The following are Triangular Star Numbers:");
		int triNumber = STARTING_DIGIT_OF_TRI_NUM;
		int index = BEGINNING_VALUE; 
		boolean isAtMax = false;
		while (index <= MAXIMUM_VALUE_OF_INDEX && !isAtMax)
		{
			triNumber = triNumber +index; 	
			if( triNumber >= MAX_ACCEPTABLE_TRINUMBER )
			{
				isAtMax = true;
			}
			if(isStarNumber(triNumber))
			{
				System.out.println(triNumber);
			}
			index++;
		}	
		System.out.println("That's all of them!");
	}	

	public static boolean isStarNumber(int inputNum)
	{
		int indexCount =BEGINNING_VALUE; 
		int testNum =BEGINNING_VALUE;
		boolean testingStars = true;
		while(testingStars)
		{
			testNum =determineStarNumber( indexCount);
			indexCount++;
			if(testNum >= inputNum)  
			{
				testingStars = false;
			}		
		}
		if(testNum == inputNum )
		{
			return true; 
		}
		else   
		{
			return false;
		}
	}

	public static int determineStarNumber(int index)
	{
		int starNumber = ((STAR_MULIPLIER*(index)*(index -STAR_INDEX_SUB)) +STAR_INDEX_CONSTANT);
		return starNumber;
	}
}
