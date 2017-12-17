public class SquareAge {
	public static final int MAXIMUM_AGE = 123; 
	public static final int CURRENT_YEAR = 2017;	 
	public static final int MINIMUM_YEAR = CURRENT_YEAR  - MAXIMUM_AGE;	 
 
	public static void main(String[] args) {
		int testAge = 0; 	
		for(testAge = 0; testAge <= MAXIMUM_AGE; testAge++){ 
			int testAgeSquared = testAge *testAge; 
			int yearOfBirth = testAgeSquared - testAge ;
				if((yearOfBirth <= CURRENT_YEAR ) && ((yearOfBirth >= MINIMUM_YEAR))){
					System.out.println( "A person born in " + yearOfBirth +" will be aged " + testAge
						 + " in the square of their age: " +testAgeSquared);
			}
		}
	}
}
