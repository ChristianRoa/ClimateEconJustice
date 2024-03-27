package climate;

import java.util.ArrayList;

/**
 * This class contains methods which perform various operations on a layered 
 * linked list structure that contains USA communitie's Climate and Economic information.
 * 
 * @author Navya Sharma
 */

public class ClimateEconJustice {

    private StateNode firstState;
    
    /*
    * Constructor
    * 
    * **** DO NOT EDIT *****
    */
    public ClimateEconJustice() {
        firstState = null;
    }

    /*
    * Get method to retrieve instance variable firstState
    * 
    * @return firstState
    * 
    * **** DO NOT EDIT *****
    */ 
    public StateNode getFirstState () {
        // DO NOT EDIT THIS CODE
        return firstState;
    }

    /**
     * Creates 3-layered linked structure consisting of state, county, 
     * and community objects by reading in CSV file provided.
     * 
     * @param inputFile, the file read from the Driver to be used for
     * @return void
     * 
     * **** DO NOT EDIT *****
     */
    public void createLinkedStructure ( String inputFile ) {
        
        // DO NOT EDIT THIS CODE
        StdIn.setFile(inputFile);
        StdIn.readLine();
        
        // Reads the file one line at a time
        while ( StdIn.hasNextLine() ) {
            // Reads a single line from input file
            String line = StdIn.readLine();
            // IMPLEMENT these methods
            addToStateLevel(line);
            addToCountyLevel(line);
            addToCommunityLevel(line);
        }
    }

    /*
    * Adds a state to the first level of the linked structure.
    * Do nothing if the state is already present in the structure.
    * 
    * @param inputLine a line from the input file
    */
    public void addToStateLevel ( String inputLine ) {
        String[] info = inputLine.split(",");
        String stateName = info[2];
        StateNode newNode = new StateNode();
        newNode.setName(stateName);
        if (firstState == null){
            firstState = newNode;
        }
        else{
            boolean check = false;
            StateNode ptr = firstState;
            StateNode prev = null;
            while( ptr!= null){
                if(ptr.getName().equals(stateName)){
                    check = true;
                }
                prev = ptr;
                ptr = ptr.getNext();
            }
            if (!check){
                prev.setNext(newNode);
            }
        }

        // WRITE YOUR CODE HERE
    }

    /*
    * Adds a county to a state's list of counties.
    * 
    * Access the state's list of counties' using the down pointer from the State class.
    * Do nothing if the county is already present in the structure.
    * 
    * @param inputFile a line from the input file
    */
    public void addToCountyLevel ( String inputLine ) {
        String[] info = inputLine.split(",");
        String stateName = info[2];
        String countyName = info[1];
        StateNode ptr = firstState;
        while(ptr != null){
            if(ptr.getName().equals(stateName)){
                break;
            }
            ptr = ptr.getNext();
        }
        CountyNode newNode = new CountyNode();
        newNode.setName(countyName);
        CountyNode ptr2 = ptr.getDown();
        CountyNode prev = null;
        boolean check = false;
        if(ptr2 == null){
            ptr2 = newNode;
            ptr.setDown(newNode); //(might need to change this to newNode instead of ptr2)
        }
        else{
            while (ptr2!=null){
                if(ptr2.getName().equals(countyName)){
                    check = true;
                }
                prev = ptr2;
                ptr2 = ptr2.getNext();
            }
            if(!check){
                newNode.setName(countyName);
                if(prev == null){
                    ptr.setDown(newNode);
                }
                else{
                    prev.setNext(newNode);
                }
            }
        }
        // WRITE YOUR CODE HERE
    }

    /*
    * Adds a community to a county's list of communities.
    * 
    * Access the county through its state
    *      - search for the state first, 
    *      - then search for the county.
    * Use the state name and the county name from the inputLine to search.
    * 
    * Access the state's list of counties using the down pointer from the StateNode class.
    * Access the county's list of communities using the down pointer from the CountyNode class.
    * Do nothing if the community is already present in the structure.
    * 
    * @param inputFile a line from the input file
    */
    public void addToCommunityLevel ( String inputLine ) {
        String[] info = inputLine.split(",");
        String state = info[2];
        String county = info[1];
        String comm = info[0];
        Data infoData = new Data();
        infoData.prcntAfricanAmerican = Double.parseDouble(info[3]);;
        infoData.prcntNative = Double.parseDouble(info[4]);
        infoData.prcntAsian = Double.parseDouble(info[5]);
        infoData.prcntWhite = Double.parseDouble(info[8]);
        infoData.prcntHispanic = Double.parseDouble(info[9]);
        infoData.disadvantaged = info[19];
        infoData.PMlevel = Double.parseDouble(info[49]);
        infoData.chanceOfFlood = Double.parseDouble(info[37]);
        infoData.prcntPovertyLine = Double.parseDouble(info[121]);
        StateNode currentState = firstState;
        CommunityNode prevComm = null;
        CommunityNode freeComm = new CommunityNode();

        while(currentState != null){
            if(currentState.getName().equals(state)){
                break;
            }
            currentState = currentState.getNext();
        }
        CountyNode curCounty = currentState.getDown();
                while(curCounty != null){
                    if(curCounty.getName().equals(county)){
                        break;
                    }
                    curCounty = curCounty.getNext();
                }
                CommunityNode currComm = curCounty.getDown();
                        while(currComm != null){
                            if(currComm.getName().equals(comm)){
                                break;
                            }

                            prevComm = currComm;
                            currComm = currComm.next;
                        }

                        freeComm.setName(comm);
                        freeComm.setInfo(infoData);

                        if(prevComm == null){
                            curCounty.setDown(freeComm);
                        }
                        else{
                            prevComm.setNext(freeComm);
                        }

                        freeComm.setNext(null);
                    }
        // String[] info = inputLine.split(",");
        // String stateName = info[2];
        // String countyName = info[1];
        // String communityIndex = info[0];
        // Data input = new Data();
        // StateNode ptr = firstState;
        // input.prcntAfricanAmerican = Double.parseDouble(info[3]);;
        // input.prcntNative = Double.parseDouble(info[4]);
        // input.prcntAsian = Double.parseDouble(info[5]);
        // input.prcntWhite = Double.parseDouble(info[8]);
        // input.prcntHispanic = Double.parseDouble(info[9]);
        // input.disadvantaged = info[19];
        // input.PMlevel = Double.parseDouble(info[49]);
        // input.chanceOfFlood = Double.parseDouble(info[37]);
        // input.prcntPovertyLine = Double.parseDouble(info[121]);
        // CommunityNode newNode = new CommunityNode();
    //     while(ptr != null){
    //         if(ptr.getName().equals(stateName)){
    //             break;
    //         } 
    //         ptr = ptr.getNext();
    //     }
    //     CountyNode ptr2 = ptr.getDown();
    //     while(ptr2 != null){
    //         if(ptr2.getName().equals(countyName)){
    //             break;
    //         }
    //         ptr2 = ptr2.getNext();
    //     }

    //     CommunityNode ptr3 = ptr2.getDown();
    //     newNode.setName(communityIndex);
    //     newNode.setInfo(input);
    //     boolean check = false;
    //     CommunityNode prev = null;
    //     if(ptr3 == null){
    //         ptr3 = newNode;
    //         ptr2.setDown(newNode);
    //     }
    //     else{
    //         while (ptr3!=null){
    //             if(ptr3.getName().equals(communityIndex)){
    //                 check = true;
    //             }
    //             prev = ptr3;
    //             ptr3 = ptr3.getNext();
    //         }
    //         if(!check){
    //             newNode.setName(communityIndex);
    //             if(prev == null){
    //                 ptr2.setDown(newNode);
    //             }
    //             else{
    //                 prev.setNext(newNode);
    //             }
    //         }
    //     }
    //     // WRITE YOUR CODE HERE
    //     // WRITE YOUR CODE HERE

    // }


    /**
     * Given a certain percentage and racial group inputted by user, returns
     * the number of communities that have that said percentage or more of racial group  
     * and are identified as disadvantaged
     * 
     * Percentages should be passed in as integers for this method.
     * 
     * @param userPrcntage the percentage which will be compared with the racial groups
     * @param race the race which will be returned
     * @return the amount of communities that contain the same or higher percentage of the given race
     */
    public int disadvantagedCommunities ( double userPrcntage, String race ) {
        int count = 0;
        StateNode ptr = firstState;
        while(ptr != null){
            CountyNode ptr2 = ptr.getDown();
            while(ptr2 != null){
                CommunityNode ptr3 = ptr2.getDown();
                while(ptr3 != null){
                    Data info = ptr3.getInfo();
                    if(race.equalsIgnoreCase("African American") && (info.getPrcntAfricanAmerican()*100 >= userPrcntage)||
                    race.equalsIgnoreCase("Native American") && (info.getPrcntNative()*100 >= userPrcntage)||
                    race.equalsIgnoreCase("Asian American") && (info.getPrcntAsian()*100 >= userPrcntage)||
                    race.equalsIgnoreCase("White American") && (info.getPrcntWhite()*100 >= userPrcntage)||
                    race.equalsIgnoreCase("Hispanic American") && (info.getPrcntHispanic()*100 >= userPrcntage)){
                        if(info.getAdvantageStatus().equals("True")){
                            count++;
                        }
                    }
                    ptr3 = ptr3.getNext();
                }
                ptr2 = ptr2.getNext();
            }
            ptr = ptr.getNext();

        }
        return count;
        // WRITE YOUR CODE HERE
     // replace this line
    }

    /**
     * Given a certain percentage and racial group inputted by user, returns
     * the number of communities that have that said percentage or more of racial group  
     * and are identified as non disadvantaged
     * 
     * Percentages should be passed in as integers for this method.
     * 
     * @param userPrcntage the percentage which will be compared with the racial groups
     * @param race the race which will be returned
     * @return the amount of communities that contain the same or higher percentage of the given race
     */
    public int nonDisadvantagedCommunities ( double userPrcntage, String race ) {
        int count = 0;
        StateNode ptr = firstState;
        while(ptr != null){
            CountyNode ptr2 = ptr.getDown();
            while(ptr2 != null){
                CommunityNode ptr3 = ptr2.getDown();
                while(ptr3 != null){
                    Data info = ptr3.getInfo();
                    if(race.equalsIgnoreCase("African American") && (info.getPrcntAfricanAmerican()*100 >= userPrcntage)||
                    race.equalsIgnoreCase("Native American") && (info.getPrcntNative()*100 >= userPrcntage)||
                    race.equalsIgnoreCase("Asian American") && (info.getPrcntAsian()*100 >= userPrcntage)||
                    race.equalsIgnoreCase("White American") && (info.getPrcntWhite()*100 >= userPrcntage)||
                    race.equalsIgnoreCase("Hispanic American") && (info.getPrcntHispanic()*100 >= userPrcntage)){
                        if(info.getAdvantageStatus().equals("False")){
                            count++;
                        }
                    }
                    ptr3 = ptr3.getNext();
                }
                ptr2 = ptr2.getNext();
            }
            ptr = ptr.getNext();

        }
        return count;

        //WRITE YOUR CODE HERE
    }
    
    /** 
     * Returns a list of states that have a PM (particulate matter) level
     * equal to or higher than value inputted by user.
     * 
     * @param PMlevel the level of particulate matter
     * @return the States which have or exceed that level
     */ 
    public ArrayList<StateNode> statesPMLevels ( double PMlevel ) {
        ArrayList<StateNode> pmStates = new ArrayList<>();
        StateNode ptr = firstState;
        while(ptr != null){
            CountyNode ptr2 = ptr.getDown();
            while(ptr2 != null){
                CommunityNode ptr3 = ptr2.getDown();
                while(ptr3 != null){
                    Data info = ptr3.getInfo();
                    if(info.getPMlevel() >= PMlevel && !pmStates.contains(ptr)){
                        pmStates.add(ptr);
                    }
                    ptr3 = ptr3.getNext();
                }
                ptr2 = ptr2.getNext();
            }
            ptr = ptr.getNext();

        }
        //WRITE YOUR CODE HERE
        // WRITE YOUR METHOD HERE
        return pmStates; // replace this line
    }

    /**
     * Given a percentage inputted by user, returns the number of communities 
     * that have a chance equal to or higher than said percentage of
     * experiencing a flood in the next 30 years.
     * 
     * @param userPercntage the percentage of interest/comparison
     * @return the amount of communities at risk of flooding
     */
    public int chanceOfFlood ( double userPercntage ) {
        int count = 0;
        StateNode ptr = firstState;
        while(ptr != null){
            CountyNode ptr2 = ptr.getDown();
            while(ptr2 != null){
                CommunityNode ptr3 = ptr2.getDown();
                while(ptr3 != null){
                    Data info = ptr3.getInfo();
                    if(info.getChanceOfFlood() >= userPercntage){
                        count++;
                    }
                    ptr3 = ptr3.getNext();
                }
                ptr2 = ptr2.getNext();
            }
            ptr = ptr.getNext();

        }
        return count;
    }
        // WRITE YOUR CODE HERE
     // replace this line

    /** 
     * Given a state inputted by user, returns the communities with 
     * the 10 lowest incomes within said state.
     * 
     *  @param stateName the State to be analyzed
     *  @return the top 10 lowest income communities in the State, with no particular order
    */
    public ArrayList<CommunityNode> lowestIncomeCommunities ( String stateName ) {
        StateNode ptr = firstState;
        ArrayList<CommunityNode> list = new ArrayList<>();
        while(ptr != null){
            if (ptr.getName().equals(stateName)){
                break;
            }
            ptr = ptr.getNext();
        }
        CountyNode ptr2 = ptr.getDown();
        while(ptr2 != null){
            CommunityNode ptr3 = ptr2.getDown();
            while(ptr3 != null){
                if(list.size() < 10 ){
                    list.add(ptr3);
                }
                if(list.size() == 10){
                    int n = 0;
                    int i = 0;
                    while (n < list.size()){
                        if (list.get(n).getInfo().getPercentPovertyLine() < list.get(i).getInfo().getPercentPovertyLine()){
                            i = n;
                        }
                        n++;
                    }
                    if(ptr3.getInfo().getPercentPovertyLine() > list.get(i).getInfo().getPercentPovertyLine()){
                        list.set(i, ptr3);
                    }
                }
                ptr3 = ptr3.getNext();
            }
            ptr2 = ptr2.getNext();
        }
        return list; // replace this line
    }
}
    
