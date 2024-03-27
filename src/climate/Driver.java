package climate;

import java.util.ArrayList;

/**
 * Contains the CLI used by students to iterate through
 * ClimateEconJustice.java and work on the assignment
 * the program is executed by first compiling via:
 *      javac -d bin src/climate/*.java
 * and executing via:
 *      java -cp bin climate.Driver 
 *      
 * @author Navya Sharma
 */

public class Driver {

    private static ClimateEconJustice climEconJust;
    
    public static void main(String[] args) {
        String[] methods = {"createLinkedStructure", "disadvantagedCommunities", "nonDisadvantagedCommunities", "statesPMLevels", "chanceOfFlood", "lowestIncomeCommunities"};
		String[] options = {"Test a new input file", "Test another method on the same file", "Quit"};
		int controlChoice = 0;
		
		do {
			StdOut.print("Enter input file => ");
			String inputFile = StdIn.readLine();
            climEconJust = new ClimateEconJustice();
			do {
				StdOut.println("\nWhat method would you like to test?");
				for (int i = 0; i < 6; i++) {
					StdOut.printf("%d. %s\n", i+1, methods[i]);
				}
				StdOut.print("Enter a number => ");
				int choice = Integer.parseInt(StdIn.readLine());
                
				switch (choice) {
					case 1:
                        testCreateLinkedList(inputFile);
						break;
					case 2:
                        System.out.print("Enter percentage => ");
                        double userPercntage =  Double.parseDouble(StdIn.readLine());
                        System.out.print("Enter racial group (African American, Native American, Asian American, White American, Hispanic American) => ");
                        String race = StdIn.readLine();
						testDisadvantagedCommunities(userPercntage, race);
						break;
					case 3:
                        System.out.print("Enter percentage => ");
                        double userPercentage = Double.parseDouble(StdIn.readLine());
                        System.out.print("Enter racial group (African American, Native American, Asian American, White American, Hispanic American) => ");
                        String raceND = StdIn.readLine();
                        testNonDisadvantagedCommunities(userPercentage, raceND);
						break;
					case 4:
                        System.out.print("Enter PM level (Double) => ");
                        double PMLevel = Double.parseDouble(StdIn.readLine());
                        testStatesPMLevels(PMLevel);
						break;
					case 5:
                        System.out.print("Enter percentage (Double) => ");
                        double userPrcntage = Double.parseDouble(StdIn.readLine());
						testChanceOfFlood(userPrcntage);
						break;
					case 6:
                        System.out.print("Enter state => ");
                        String stateName = StdIn.readLine();
                        testLowestIncomeCommunities(stateName);
						break;
					default:
						StdOut.println("Not a valid option!");
				}

                StdIn.resetFile();
                System.out.println();
				StdOut.println("What would you like to do now?");
				for (int i = 0; i < 3; i++) {
					StdOut.printf("%d. %s\n", i+1, options[i]);
				}
				StdOut.print("Enter a number => ");
				controlChoice = Integer.parseInt(StdIn.readLine());
			} while (controlChoice == 2);
		} while (controlChoice == 1);
    }

    // create initial 3-layered linked list by reading in CommunityData.java file  
    private static void testCreateLinkedList(String filename) {
        StdIn.setFile(filename);
        climEconJust.createLinkedStructure(filename);
        StdIn.resetFile();

        System.out.print("Would you like the list to be printed? [Y/N]: ");
        String readInput = StdIn.readLine();
        if (readInput.equals("Y")){
            System.out.println("Here are the number of communities, listed by state, then county:");
            for (StateNode statePointer = climEconJust.getFirstState(); statePointer != null; statePointer = statePointer.getNext()) {
                StdOut.println("+ " + statePointer.getName());
                for (CountyNode countyPointer = statePointer.getDown(); countyPointer != null; countyPointer = countyPointer.getNext()) {
                    StdOut.print(" -> " + countyPointer.getName());
                    int counter = 0;
                    for (CommunityNode communityPointer = countyPointer.getDown(); communityPointer != null; communityPointer = communityPointer.getNext()) {
                        counter++;
                    }
                    StdOut.print(" [" + counter + " communities]");
                }
                StdOut.println();
                StdOut.println();
            }
        }

        return;
    }

    // return the # of communities that have a certain percentage or more of a given race that are identified
    // as disadvantaged by calling method disadvantagedCommunities  
    private static void testDisadvantagedCommunities(double percentage, String race) {
        int numberOfComms = climEconJust.disadvantagedCommunities(percentage, race);
        System.out.println(numberOfComms + " of the total communities that have " + percentage + "% or more of "
        + race + "s are identified as disadvantaged."); 
    }

    // return the # of communities that have a certain percentage or more of a given race that are identified
    // as non disadvantaged by calling method nonDisadvantagedCommunities
    private static void testNonDisadvantagedCommunities(double percentage, String race) {
        int numberOfComms = climEconJust.nonDisadvantagedCommunities(percentage, race);
        System.out.println(numberOfComms + " of the total communities whose populations are " + percentage + "% or more "
        + race + "s are identified as advantaged.");
    }

    // return a list of states that have a given PM level or higher by calling method statesPMLevels
    private static void testStatesPMLevels(double PMLevel) {
        ArrayList<StateNode> statesPMLevels = climEconJust.statesPMLevels(PMLevel);
        System.out.println("The states that have a PM level of " + PMLevel + " or higher are: ");
        for (int i=0;i<statesPMLevels.size();i++){
            System.out.println(i+1 + ". " + statesPMLevels.get(i).getName());
        }
    }

    // return the # of communities that have a given percentage chance or higher of experiencing flooding
    // in the next 30 years by calling method chanceOfFlood
    private static void testChanceOfFlood(double percentage) {
        int numberOfComms = climEconJust.chanceOfFlood(percentage);
        System.out.println(numberOfComms + " communities have a " + percentage 
        + "% chance or higher of experiencing a flood in the next 30 years.");
    }

    // return the communities with the 10 lowest avg. incomes in a given state by calling
    // method lowestIncomeCommunities
    private static void testLowestIncomeCommunities(String stateName) {
        ArrayList<CommunityNode> commsLowestIncome = climEconJust.lowestIncomeCommunities(stateName);
        System.out.println("The communities that have the 10 lowest average incomes in " 
        + stateName + " are (order does not matter):");

        for (int i=0; i<commsLowestIncome.size();i++){
            System.out.println(i+1 +". " + commsLowestIncome.get(i).getName());
        }
    }
}