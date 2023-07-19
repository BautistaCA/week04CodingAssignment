package w04CP;

import java.util.Arrays;

public class ThirteenPrompts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Prompt 1");  		// I do this to make it clear what prompts I'm working on/completed
			int[] ages = {3, 9, 23, 64, 2, 8, 28, 93};	
		
			System.out.println((ages[ages.length - 1] - ages[0]));	// [0] is start, [.length - 1] is the end
		
			int[] agesNew = {21, 54, 4, 89, 12, 37, 95, 7, 16};		// chose random numbers
		System.out.println((agesNew[agesNew.length - 1] - agesNew[0]));
		
		double averageAge = 0;					// Decided on using double for precision.
		for (int i = 0; i < agesNew.length; i++) { // I tend to lean towards using this loop 1st
			averageAge+= agesNew[i];
		}
		System.out.println(averageAge / agesNew.length); // The result would've left out the decimal as an int
	
		System.out.println("Prompt 2");
		
		String[] names = {"Sam", "Tommy", "Tim", "Sally", "Buck","Bob"};
		StringBuilder singleString = new StringBuilder(); // Answered 3 and 4 at the same time, wanted to optimize
		double averageWords = 0;					
		for (int i2 = 0; i2 < names.length; i2++) {
				averageWords+= names[i2].length();	//almost made a brand new int just for the name length
				singleString.append(names[i2]);
				singleString.append(" ");
		}
		singleString.deleteCharAt(singleString.length() - 1);	//There's probably a better way to remove the last space, but I don't remember
			System.out.println(averageWords / names.length);
				System.out.println(singleString);
		
		System.out.println("Prompt 4");
			System.out.println("Last element of an array: array[array.length - 1]");
				System.out.println("First element of an array: array[0]");
		
				//Decided to answer 5 and 6 in the same loop, wasn't sure if I needed to print nameLengths
	
		int namesAdd = 0;						// I felt it unnecessary to rewrite the same loop over for related results/inputs.
		int nameLengths[] = new int[names.length];					
		for (int i3 = 0; i3 < names.length; i3++) { //The nickname for this kind of loop I thought of was "the counter"
			nameLengths[i3] = names[i3].length();
			namesAdd+= nameLengths[i3];
		}
		
			System.out.println("Prompt 6");
				System.out.println(namesAdd);
		
		System.out.println("Prompt 7");
			System.out.println(concatWord(names[0], ages[0])); // I used the arrays to write less new strings
	
				System.out.println("Prompt 8");
					System.out.println(oneWord(names[0], "Jackson"));
	
		System.out.println("Prompt 9");
			System.out.println(moreThan100(ages));
				System.out.println(moreThan100(nameLengths));
	
		System.out.println("Prompt 10");
		double[] doubles = Arrays.stream(ages).asDoubleStream().toArray(); // Had to import for this, wanted to try it out
			System.out.println(dblAverage(doubles));
	
		System.out.println("Prompt 11");
		double[] doublestwo = Arrays.stream(agesNew).asDoubleStream().toArray();
		System.out.println(dblTrueFalse(doubles, doublestwo));
		System.out.println(dblTrueFalse(doublestwo, doubles));
			
			System.out.println("Prompt 12");
		System.out.println(willBuyDrink(moreThan100(ages), namesAdd));
		//lessThan100 is a boolean method, having it reflect isHotOutside made sense to me lol
	
		System.out.println("Prompt 13");
		System.out.println(whichGarage(5.8, 3000));
		System.out.println(whichGarage(7, 4000));
		System.out.println(whichGarage(8, 5000));
	}
		// This is where Methods go so they work
		//Method 7
	static StringBuilder concatWord(String word, int num){ // made the method a stringbuilder for better optimization
			StringBuilder concat = new StringBuilder();	// Need to get into the habit of using words as identifiers for clarity
			for (int i = 1; i <= num; i++){
				concat.append(word);
			}
			return concat;
			}
	 	//Method 8
	static StringBuilder oneWord(String firstName, String lastName){ // Feels like the most optimal way I know to do this
		StringBuilder word = new StringBuilder(); 
		word.append(firstName);
			word.append(" ");
				word.append(lastName);
		return word;
		}
		//Method 9
	static boolean moreThan100(int[] numbers){
		int arrayTotal = 0;
		for (int i = 0; i < numbers.length; i++){
			arrayTotal+= numbers[i];
		}
		return (arrayTotal > 100);
	}
	//Method 10
	static double dblAverage(double[] x){
		double average = 0;
		for (int i = 0; i < x.length; i++){
			average+= x[i];
		}
	return (average / x.length);
	}
	//Method 11
	static boolean dblTrueFalse(double[] first, double[] second){
		double averageOne = dblAverage(first);
		double averageTwo = dblAverage(second);
		return (averageOne > averageTwo);
	}
	//Method 12
	static boolean willBuyDrink(boolean isHotOutside, double moneyInPocket){
		return (isHotOutside && (moneyInPocket >= 10.50));
	}
	//Method 13
	//A height clearance check needs to be made to guide vehicles to specific parking garages, or to deny access to vehicles that are too tall or above the weight limit
	static StringBuilder whichGarage(double height, int weight) {
		StringBuilder garage = new StringBuilder();
		garage.append("This vehicle can");
		if ((height < 8.9) && (weight < 5000)) {
			if (height > 7.8) {
				garage.append(" park in Garage A");
				return garage;
			} else if (height > 6.7) {
				garage.append(" park in Garage B");
				return garage;
			} else if (height < 5.9) {
				garage.append(" park in Garage C");
				return garage;
			}
		}		
		garage.append("not be designated a Parking Garage");
		return garage; // I based the heights off of parking garages in Vegas: https://fa4d458be4.nxcli.net/wp-content/uploads/2019/03/Las-Vegas-Parking-Garage-Heights.pdf
	}
}
