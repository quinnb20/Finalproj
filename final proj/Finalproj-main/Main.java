
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    //Reads in Senator text file + makes it into arraylist
    
    /**Reads in a file and assigns each line to be an object of the Senator class. 
    * Populates an ArrayList with each Senator object read from file.  
    */
    public static ArrayList<Senator> readFile() throws Exception{
        ArrayList<Senator> senators = new ArrayList<>();
        File sen = new File("/Users/harpercrews/Downloads/Senators1.txt");
        Scanner reader = new Scanner(sen);
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            String[] token = line.split(", ");
            Senator newSenator = new Senator(token[0], token[1], token[2], Integer.valueOf(token[3]), Boolean.valueOf(token[4]), Boolean.valueOf(token[5]));
            senators.add(newSenator);
        }reader.close();
        return senators;

    /**Reads in a file and assigns each line to be an object of the Leadership class. 
    * Populates an ArrayList with each Leadership object read from file. 
    */
    }public static ArrayList<Leadership> read_file() throws Exception{
        ArrayList<Leadership> leaders = new ArrayList<>();
        File lead = new File("/Users/harpercrews/Downloads/Leadership.txt");
        Scanner read = new Scanner(lead);
        while(read.hasNextLine()){
            String lin = read.nextLine();
            String[] toke = lin.split(", ");
            Leadership newLeader = new Leadership(toke[0], toke[1]);
            leaders.add(newLeader);
            //System.out.println(leaders);

        }read.close();
        return leaders;

    /**Reads in a file and assigns each line to be an object of the Chairperson class. 
    * Populates an ArrayList with each Chairperson object read from file. 
    */
    }public static ArrayList<Chairperson> fileRead() throws Exception{
        ArrayList<Chairperson> chairs = new ArrayList<>();
        File chair1 = new File("/Users/harpercrews/Downloads/Chairmen.txt");
        Scanner red1 = new Scanner(chair1);
        while(red1.hasNext()){
            String li = red1.nextLine();
            String[] tok = li.split(": ");
            Chairperson newChair = new Chairperson(tok[0], tok[1]);
            chairs.add(newChair);
            
        }red1.close();
        return chairs;
        
    /**Method to print an ArrayList line by line with a corresponding line number. 
    */
    }public static void printMenu(ArrayList<String> menu_object){
        String m[] = menu_object.toArray(new String[menu_object.size()]);
        int counter = 0;
        for(String menu_string : m){
            String str = String.valueOf(counter);
            System.out.println("\n" + str + ". " + menu_string);
            counter += 1;
        }System.out.println();
        
        

    /**Method to re-populate the main menu ArrayList.
    */
    }public static void resetMenu(ArrayList<String> menu_object){
        menu_object.clear();
        menu_object.add("Name");
        menu_object.add("Party");
        menu_object.add("State");
        menu_object.add("Class");
        menu_object.add("Senate Leadership");
        menu_object.add("Committee Chairpeople");
    }
    
    /**Method to print any String ArrayList line by line.
    */
    public static void printArray(ArrayList<String> array){
        String new_arr [] = array.toArray(new String[array.size()]);
        for(String array_string : new_arr){
            System.out.println(array_string);

        }

    /**Write's the users information into a new text file. 
    * Takes a Senator ArrayList, Leadership ArrayList, and Chairperson ArrayList as parameters to write into the file
    */
    }public static void writeInfo(ArrayList<Senator> sen_list, ArrayList<Leadership> lead_list, ArrayList<Chairperson> chair_list){
        try{
            FileWriter f_writer = new FileWriter("senator_info.txt");
            for(Senator sen1 : sen_list){
                System.out.println();
                String final_string = sen1.nonBooltoString();
                if(sen1.get_is_leader()){
                    for(Leadership sen2 : lead_list){
                        if(sen1.getName().equals(sen2.getName())){
                            final_string = (final_string + sen2.posToString());

                        }
                    }
                }if(sen1.get_is_leader()){
                    for(Chairperson sen3 : chair_list){
                        if(sen1.getName().equals(sen3.getName())){
                            final_string = (final_string + sen3.chairString());
                        }
                    }
                //output to inform the user is they have recieved a saved document of their desired info
                }System.out.println(final_string);
                f_writer.write(final_string + "\n");
                System.out.println("Your information has been written to the file 'senator_info.txt'");
            }f_writer.close();
        }catch(Exception e){
            System.out.println("Could not create file");
        }
    }
    
    //main program starts
    public static void main(String[] args){

        //reading all files: senators, leadership, and chairperson

        Scanner keyboard = new Scanner(System.in);
        ArrayList<Senator> mysenators = new ArrayList<>();
        try{
            mysenators = readFile();
        }catch (Exception e){
            System.out.println("Could not read input file");
            keyboard.close();
            return;

        }ArrayList<Leadership> myLeaders = new ArrayList<>();
        try{
            myLeaders = read_file();
        }catch (Exception e){
            System.out.println("Could not read");
            keyboard.close();
            return;
        }ArrayList<Chairperson> myChairs = new ArrayList<>();
        try{
            myChairs = fileRead();
            System.out.println("Hello");
            
        }catch (Exception e){
            System.out.println("Could not read file");
            System.out.println(e.getClass().getName());
            keyboard.close();
            return;

        
        //prints welcome message + populates the main menu
        }System.out.println("Hello! Welcome to the U.S. Senate Directory.\n");
        System.out.println("");
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Name");
        menu.add("Party");
        menu.add("State");
        menu.add("Class");
        menu.add("Senate Leadership");
        menu.add("Committee Chairpeople");
        
        //user has choice to search for singular senator or multiple
        String main_loop = "Yes";
        while(main_loop.equalsIgnoreCase("Yes")){
            System.out.println("Press 'S' to search for a single senator or 'M' to search for multiple.");
            String s_or_m;
            s_or_m = keyboard.nextLine();

            //if they choose single, asks user to input the name of the senator they wish to look up
            if(s_or_m.equalsIgnoreCase("s")){
                String sen_name;
                System.out.println("What is the name of the senator you are searching for? ");
                sen_name = keyboard.nextLine();
                
                //input of senator, go through the array to find the matching name
                //return name for further questions for the user
                for(Senator member : mysenators){
                    if(sen_name.equals(member.getName())){
                        int mem_indx = mysenators.indexOf(member);
                        Senator current_senator = mysenators.get(mem_indx);
                        menu.remove("Name");
                        ArrayList<String> users_choices = new ArrayList<String>();

                        //outputs choice menu, user must choose what they would like to know
                        //about their desired senator
                        String single_on = "Yes";
                        while(single_on.equalsIgnoreCase("Yes")){
                            System.out.printf("What would you like to know about Senator %s?\n", sen_name);
                            printMenu(menu);

                            //user enters the number corresponding to their choice,
                            //code then shifts the number into the string it represents for the 
                            //if/else functions
                            System.out.println("Enter the number corresponding to your choice: ");
                            int men_choice = keyboard.nextInt();

                            String str_choice = menu.get(men_choice);
    

                            //whatever the user chooses, the information they will recieve is put
                            //in an arraylist which will be printed at the end of the code

                            //party is chosen, the senator's party will be added to output
                            if(str_choice.equals("Party")){
                                String party = current_senator.partyString();
                                users_choices.add(party);
   
                            //state is chosen, the senator's state will be added to output
                            }else if(str_choice.equals("State")){
                                String state = current_senator.stateString();
                                users_choices.add(state);

                            //class is chosen, the senator's class will be added to output
                            }else if(str_choice.equals("Class")){
                                String cls = current_senator.classToString();
                                users_choices.add(cls);

                            //leadership is chosen
                            }else if(str_choice.equals("Senate Leadership")){
                                boolean is_a_leader = current_senator.get_is_leader();
                                //if the senator has a leadership position, it will be sent to the output
                                if(is_a_leader){
                                    for(Leadership leader : myLeaders){
                                        if(sen_name.equals(leader.getName())){
                                            String position = leader.posToString();
                                            users_choices.add(position);
                                        }
                                    }

                                //if the senator does not have a leadership position, an automatic response
                                //will be printed
                                }else{
                                    System.out.println("The Senator does not hold a leadership position.");
                                    users_choices.add(current_senator.is_leader_toString());
                                }
                            //committee is chosen
                            }else if(str_choice.equals("Committee Chairpeople")){
                                boolean is_a_chair = current_senator.get_is_chair();
                                //if the senator is a chair of a committee, the title of that committee
                                //will be printed
                                if(is_a_chair){
                                    for(Chairperson c : myChairs){
                                        if(sen_name.equals(c.getName())){
                                            String chairPos = c.chairString();
                                            users_choices.add(chairPos);
                                        }
                                    }
                                //if they do not chair a committee, an automatic response will be printed
                                }else{
                                    System.out.println("The Senator is not the chair of a committee. ");
                                    users_choices.add(current_senator.is_chair_toString());
                                }
                            // if the user does not choose any of the correct number of choices, an error message
                            //will be printed
                            }else{
                                System.out.println("Please choose a valid option.");
                            
                            //at the end of the user's choice, that choice will be removed from the menu
                            }menu.remove(men_choice);

                            //beginning of output

                            System.out.printf("Here is what we have gathered so far on Senator %s: \n", sen_name);
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            //printing out user's senator's name
                            System.out.println("\n"+sen_name+ "\n");

                            //the information they requested will now print to the terminal
                            String info[] = users_choices.toArray(new String[users_choices.size()]);
                            for(String choices_string : info){
                                System.out.println(choices_string);
                            }if(menu.size()!= 0){
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                                //the program will now ask the user whether they would like to leave, or continue
                                //to gather info on this certain senator.
                                System.out.printf("\nWould you like to add more information on Senator %s?", sen_name);
                                System.out.println("\nEnter 'Yes' to add more or 'No' to exit");

                                //when entered yes, the menu will reset for the user to continue
                                //researching their desired senator
                                single_on = keyboard.next();
                                
                                

                            //upon leaving the program, the user's information they gathered
                            //will be put in a new text file for them to access
                            }else{
                                try{
                                    FileWriter fWriter = new FileWriter("senator_info.txt");
                                    for(String choices_string : info){
                                        fWriter.write(choices_string);
                                    }fWriter.close();

                                }catch(Exception e){
                                    System.out.println("Could not create file");
                                }
                                System.out.println("Your information has been written to the file 'senator_info.txt'");
                                main_loop = "No";
                                single_on = "No";
                            }
                            
                            


                        }


                    //if the name cannot be matched to a senator, an error message will be printed
                    }else{
                        System.out.println("That Senator does not exist. Please check your spelling according to the list on Senate.gov");
                        break;
                    }
                }break;    
            }
            
            //if the user requests a multiple senator search
            if(s_or_m.equalsIgnoreCase("m")){
                System.out.println("This program sorts Senators by your desired parameters in two phases.\n");
                System.out.println("The first phase creates a list of Senators \n");
                System.out.println("The second phase sorts your created list. \n ");

                // two phases are run, the first pritning a full list of the senators.
                //after that has finished, the user can then narrow down this list with the parameters
                //available such as party, state, etc through a comparator
                System.out.println("Beginning phase one...\n");

                ArrayList<String> choiceList = new ArrayList<>();
                ArrayList<Senator> runningSenList = new ArrayList<>();
                ArrayList<String> partyMenu = new ArrayList<>();
                partyMenu.add("Democrat");
                partyMenu.add("Republican");
                partyMenu.add("Independent");

                System.out.println("The system will prompt you to choose fields until you have reached your desired list\n");
                String continue_adding = "Yes";
                
                //prints the choice menu, changes the number input into the string it represents
                while(continue_adding.equalsIgnoreCase("Yes")){
                    System.out.println("Please enter the number corresponding to your desired field");
                    menu.remove("Name");
                    printMenu(menu);
                    int choiceFromMenu = keyboard.nextInt();
                    String menu_Choice = menu.get(choiceFromMenu);
                    choiceList.add(menu_Choice);
                    menu.remove("Name");

                    //if user chooses party to sort, they have to pick what party to narrow down with
                    if(menu_Choice.equals("Party")){
                        while(partyMenu.size()!=0){
                            String cont_party = "Yes";
                            while(cont_party.equalsIgnoreCase("Yes")){
                                System.out.println("Please enter the number corresponding to your desired party: ");
                                printMenu(partyMenu);
                                int partyChoice = keyboard.nextInt();
                                String partyString = partyMenu.get(partyChoice);
                                partyMenu.remove(partyChoice);
                                
                                //prints out a list of senators that are a member of the party user inputs
                                System.out.println("The " + partyString + "s in the Senate are: ");
                                for(Senator s : mysenators){
                                    //checks if the senator is already in the user's list
                                    if(s.getParty().equals(partyString)){
                                        if(runningSenList.contains(s)==false){

                                            //adds the senator to the list if they are not already present
                                            runningSenList.add(s);
                                            
                                        }System.out.println(s.getName() + "\n" + "Party: " + s.getParty()); 


                                    }
                                //program asks user if they would like to add senators from another party
                                
                                }System.out.println("Would you like to add Senators from another party? ");
                                System.out.println("Enter 'Yes' or 'No'");
                                cont_party = keyboard.next();
                                //if not, user is asked to choose another field
                            }break; 
                            //"Party" is removed from main menu
                        }menu.remove("Party");
                        

                    //user chooses state
                    }else if(menu_Choice.equalsIgnoreCase("State")){
                        String cont_state = "Yes";

                        //user must enter the state they want to see the representative senators
                        while(cont_state.equalsIgnoreCase("Yes")){
                            System.out.println("Enter the name of the state you would like to see the Senators from: ");
                            String state_choice = keyboard.next();

                          //prints out a list of senators representing desired state
                            System.out.println("The Senators from " + state_choice + " are: ");
                            for(Senator x : mysenators){
                                
                                //checks if senator is already in the user's list to avoid duplicates
                                if(state_choice.equalsIgnoreCase(x.getState())){
                                    if(runningSenList.contains(x)==false){

                                        //adds senator to list if not already present
                                        runningSenList.add(x);
                                    
                                    }System.out.println(x.getName() + "\n" + "State: " + x.getState());
                                    
                                }

                            //asks user if they would like to continue sorting through the senators
                            }System.out.println("Would you like to add Senators from another state?");
                            System.out.println("Enter 'Yes' or 'No'");

                            //if yes, they will return to the state menu to add senators form other states
                            cont_state = keyboard.next();

                        }menu.remove("State");
                        

                    //user chooses class
                    }else if(menu_Choice.equals("Class")){
                        String cont_class = "Yes";
                        
                        //this sorts the senators into their election classes, each class coming up for 
                        //reelection on a different date
                        while(cont_class.equalsIgnoreCase("Yes")){
                            System.out.println("Senators are split into class 1, class 2, or class 3 based on when they were elected.");
                            System.out.println("Please enter the number corresponding to the class of Senators you would like to see: ");
                            int e_class = keyboard.nextInt();

                            //user picks a specific class num (1-3), and will have a list of those senators printed
                            System.out.println("The Senators from election class " + e_class + " are: ");

                            for(Senator y : mysenators){
                                
                                //checks if senator is already in the user's list
                                if(e_class == y.get_elect_class()){
                                    if(runningSenList.contains(y)==false){

                                        //adds the current senator to the personal user list if not alrady present
                                        runningSenList.add(y);
                                    }System.out.println(y.getName() + "\n" + "Class: " + y.get_elect_class());


                                }
                            //program asks user if they would like to add more classes to the list, if yes
                            //the user will return to class menu
                            }System.out.println("Would you like to add Senators from another class?");
                            System.out.println("Enter 'Yes' or 'No'");
                            cont_class = keyboard.next();
                        }menu.remove("Class");
                

                    //user chooses sorting via senate leadership
                    }else if(menu_Choice.equals("Senate Leadership")){
                        System.out.println("The Senators who have leaderhsip positions are: ");

                        //this list will be added to the user-personal list
                        for(Senator l : mysenators){
                            if(l.get_is_leader()){
                                
                                //checks if senator is already in user's list
                                if(runningSenList.contains(l)==false){

                                    //adds them if they are not already present
                                    runningSenList.add(l);
                                }

                            }
                        //iterates through the Leadership class array to access the senator's position title
                        }for(Leadership leader_1 : myLeaders){
                            //prints each senator and their position
                            System.out.println(leader_1.getName() + "\n" + "Position: " + leader_1.getPosition());
                        }menu.remove("Senate Leadership");
                      
                    //user chooses committee
                    }else if(menu_Choice.equals("Committee Chairpeople")){
                        System.out.println("The Senators who are committee chairs are: ");
                        
                        //senators that are committee leaders will be added to the user-personal list
                        for(Senator c : mysenators){
                            if(c.get_is_chair()){
                                
                                //checks if senator is alreayd in user's list
                                if(runningSenList.contains(c)==false){

                                    //adds them if they are not already present
                                    runningSenList.add(c);
                                }
                            }
                        //the list will be printed along with the committee leadership title for user
                        }for(Chairperson chair_1 : myChairs){
                            System.out.println(chair_1.getName() + "\n" + "Chair: " + chair_1.get_chairTitle());
                        }menu.remove("Committee Chairpeople");
                       

                    //program will ask user after finishing their previous choice if they would like to 
                    //narrow down their list using other choices. 
                    //will only prompt for a response if there are still options in the main menu
                    }if(menu.size()!=0){                    
                        System.out.println("Would you like to add another field? Enter 'Yes' or 'No'");

                        //if yes, they will return to the choice menu
                        continue_adding = keyboard.next();
                    }    

                // the user's personal list can now be sorted in different ways for best understanding
                //either alphabetically, grouped by party, alphabetically by state, or alphabetically
                //with senate leadership or committee chair
                }System.out.println("Now that you have populated your list, you may choose how it is organized");
                System.out.println("Choose 'name' to sort Senators alphabetically by first name.\n");
                System.out.println("Choose 'Party' to sort Senators by their party affiliations.\n");
                System.out.println("Choose 'State' to sort Senators alphabetically by State.\n");
                System.out.println("Choose 'Senate Leadership' to sort Senators based on if they hold leadership positions.\n");
                System.out.println("Choose 'Commitee Chairpeople' to sort Senators based on if they are a Chairperson.\n");


                //user inputs their desired sorting option using the choice menu
                System.out.println("Enter the number corresponding to the field you would like to sort by: ");
                resetMenu(menu);
                printMenu(menu);

                // when user decides on sorting choice, their new sorted list will rewrite their
                //personal list

                int sorting = keyboard.nextInt();
                String sortingString = menu.get(sorting);
                
                //sorts list alphabetically by name then writes into text file
                if(sortingString.equals("Name")){
                    Collections.sort(runningSenList, new sortByName());
                    writeInfo(runningSenList, myLeaders, myChairs);
                 
                //sorts list alphabetically by party then writes into text file
                }else if(sortingString.equals("Party")){
                    Collections.sort(runningSenList, new sortByParty());
                    writeInfo(runningSenList, myLeaders, myChairs);
                
                //sorts alphabetically by state then writes into text file
                }else if(sortingString.equals("State")){
                    Collections.sort(runningSenList, new sortByState());
                    writeInfo(runningSenList, myLeaders, myChairs);
                    
                //sorts numerically by class then writes into text file
                }else if(sortingString.equals("Class")){
                    Collections.sort(runningSenList, new sortByClass());
                    writeInfo(runningSenList, myLeaders, myChairs);
                    
                //sorts by boolean leadership status
                }else if(sortingString.equals("Senate Leadership")){
                    Collections.sort(runningSenList, new sortByLeader());
                    writeInfo(runningSenList, myLeaders, myChairs);
                   
                //sorts by boolean chair status
                }else if(sortingString.equals("Commitee Chairpeople")){
                    Collections.sort(runningSenList, new sortByChair());
                    writeInfo(runningSenList, myLeaders, myChairs);
                }




                    

            }break;
            

                    
        }keyboard.close();


    }
}
        
        

        
        

 
    
        
        


        

      
    


