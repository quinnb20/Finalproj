
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class FinalDraft{
    //Reads in Senator text file
    public static ArrayList<Senator> readFile() throws Exception{
        ArrayList<Senator> senators = new ArrayList<>();
        File sen = new File("Senators1.txt");
        Scanner reader = new Scanner(sen);

        // takes the senators file and creates an arraylist for each senator
        // and their information
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            String[] token = line.split(", ");
            Senator newSenator = new Senator(token[0], token[1], token[2], Integer.valueOf(token[3]), Boolean.valueOf(token[4]), Boolean.valueOf(token[5]));
            senators.add(newSenator);
        }reader.close();
        return senators;

    //Takes the leadership.txt (contaiing senators that hold committee roles)
    //and creates another arraylist for user to look at
    }public static ArrayList<Leadership> read_file() throws Exception{
        ArrayList<Leadership> leaders = new ArrayList<>();
        File lead = new File("Leadership.txt");
        Scanner read = new Scanner(lead);
        while(read.hasNextLine()){
            String lin = read.nextLine();
            String[] toke = lin.split(", ");
            Leadership newLeader = new Leadership(toke[0], toke[1]);
            leaders.add(newLeader);

        }read.close();
        return leaders;

    //Reads the text file indicating senators that hold leadership roles 
    //within the senate, and creates an arraylist for user interaction
    }public static ArrayList<Chairperson> Read_File() throws Exception{
        ArrayList<Chairperson> chairs = new ArrayList<>();
        File chair = new File("Chairmen.txt");
        Scanner red = new Scanner(chair);
        while(red.hasNextLine()){
            String li = red.nextLine();
            String[] tok = li.split(": ");
            Chairperson newChair = new Chairperson(tok[0], tok[1]);
            chairs.add(newChair);
        }red.close();
        return chairs;

    //esablishes the menu to be used for the user: an arraylist so the 
    //choices can be easily removed to avoid repetition
    }public static void printMenu(ArrayList<String> menu_object){
        String m[] = menu_object.toArray(new String[menu_object.size()]);
        int counter = 0;
        for(String menu_string : m){
            String str = String.valueOf(counter);
            System.out.println("\n" + str + ". " + menu_string);
            counter += 1;
        }System.out.println();
        
        

    // creating the choices for user to choose from when searching for 
    //a senator, this part is o help in looping the menu
    }public static void resetMenu(ArrayList<String> menu_object){
        menu_object.add("Name");
        menu_object.add("Party");
        menu_object.add("State");
        menu_object.add("Class");
        menu_object.add("Senate Leadership");
        menu_object.add("Committee Chairpeople");
    }

    public static void printArray(ArrayList<String> array){
        String new_arr [] = array.toArray(new String[array.size()]);
        for(String array_string : new_arr){
            System.out.println(array_string);

        }
    }
    
    // Here is the beginning of the main program!

    public static void main(String[] args){
        // setting up the keyboard for user interaction
        Scanner keyboard = new Scanner(System.in);

         // readng the main senators text file and establishing the arraylist
        ArrayList<Senator> mysenators = new ArrayList<>();
        try{
            mysenators = readFile();
        }catch (Exception e){
            System.out.println("Could not read input file");
            keyboard.close();
            return;

        }/*while(true){
            for(Senator s : mysenators) {
                System.out.println(s.toString());
            }break;
        }*/
        
        // reading the leadership text file and establishing the arraylist
        ArrayList<Leadership> myLeaders = new ArrayList<>();
        try{
            myLeaders = read_file();
        }catch (Exception e){
            System.out.println("Could not read");
            keyboard.close();
            return;
        }/*while(true){
            for(Leadership l : myLeaders){
                System.out.println(l.toString());
            }break;
        }*/
        
        // reading the committee text file and making it an arraylist
        ArrayList<Chairperson> myChairs = new ArrayList<>();
        try{
            myLeaders = read_file();
        }catch (Exception e){
            System.out.println("Could not read");
            keyboard.close();
            return;
        }/*while(true){
            for(Chairperson c : myChairs){
                System.out.println(c.toString());
            }break;
        }*/

        //start of the outputted menu
        System.out.println("Hello! Welcome to the U.S. Senate Directory.\n");
        System.out.println("");

        //sets up the menu's arraylist of options for the user to choose from
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Name");
        menu.add("Party");
        menu.add("State");
        menu.add("Class");
        menu.add("Senate Leadership");
        menu.add("Committee Chairpeople");
        
        // begins asking user for what they would like to do: either serach for 
        //one singular senator, or sift through many
        int main_loop = 1;
        while(main_loop == 1){
            System.out.println("Press 's' to search for a single senator or 'm' to search for multiple.");
            
            // creates a variable from the user's choice of a multiple or
            //singular search
            String s_or_m;
            s_or_m = keyboard.nextLine();

            //if the user decided to search for one singular senator
            if(s_or_m.equals("s")){
                String sen_name;
                System.out.println("What is the name of the senator you are searching for? ");
                sen_name = keyboard.nextLine();
                
                //user must provide the name of their desired senator
                for(Senator member : mysenators){

                    //for loop goes through all the names within the senator array list,
                    //to find the matching name the user gave
                    if(sen_name.equals(member.getName())){
                        int mem_indx = mysenators.indexOf(member);
                        Senator current_senator = mysenators.get(mem_indx);

                        // removing the choice of "name" from the arraylist, since the user
                        //has now used it
                        menu.remove("Name");
                        ArrayList<String> users_choices = new ArrayList<String>();
                        
                        //now that the user provided the name and it was matched, they can now
                        //choose what they would like to know about them
                        //(from menu arraylist established in the beginning)
                        int single_on = 1;
                        while(single_on == 1){
                            System.out.printf("What would you like to know about Senator %s?\n", sen_name);
                            printMenu(menu);

                            System.out.println("Enter the number corresponding to your choice: ");
                            int men_choice = keyboard.nextInt();

                            //corresponds the user's number answer to the menu choices
                            String str_choice = menu.get(men_choice);
                            //menu.remove(men_choice);
                            //System.out.println(str_choice);
                            //ArrayList<String> users_choices = new ArrayList<String>();

                            //provides the user with the party of their desired senator
                            if(str_choice.equals("Party")){
                                String party = current_senator.partyString();
                                //System.out.println(sen_name);
                                //System.out.println("\n"+ party);
                                users_choices.add(party);
   
                             //provides the user with the state of their desired senator
                            }else if(str_choice.equals("State")){
                                String state = current_senator.stateString();
                               //System.out.println(sen_name);
                                //System.out.println("\n" + state);
                                users_choices.add(state);

                             //provides the user with the class of their desired senator
                             // (class being what cycled group they are in for reelection)
                            }else if(str_choice.equals("Class")){
                                String cls = current_senator.classToString();
                                //System.out.println(sen_name);
                                //System.out.println("\n" + cls);
                                users_choices.add(cls);

                             //provides the user with a boolean (T/F) of if their desired
                             //senator has a leadership position
                            }else if(str_choice.equals("Senate Leadership")){
                                boolean is_a_leader = current_senator.get_is_leader();

                                // if the senator does have a position, it is printed out
                                if(is_a_leader){
                                    for(Leadership leader : myLeaders){
                                        if(sen_name.equals(leader.getName())){
                                            String position = leader.posToString();
                                            //System.out.println(sen_name);
                                            //System.out.println("\n" + position);
                                            users_choices.add(position);
                                        }
                                    }

                                //informs the user that their desired senator does not hold a
                                //leadership position
                                }else{
                                    System.out.println("The Senator does not hold a leadership position.");
                                    users_choices.add(current_senator.is_leader_toString());
                                }
                            
                            //If user chose this, their desired senator's committee info with be printed
                            }else if(str_choice.equals("Committee Chairpeople")){
                                boolean is_a_chair = current_senator.get_is_chair();
                                if(is_a_chair){
                                    for(Chairperson c : myChairs){
                                        if(sen_name.equals(c.getName())){
                                            String chairPos = c.chairString();
                                            //System.out.println(sen_name);
                                            //System.out.println("\n" + chairPos);
                                            users_choices.add(chairPos);
                                        }
                                    }

                                // prints that the user's desired senator does not lead a committee
                                }else{
                                    System.out.println("The Senator is not the chair of a committee. ");
                                    users_choices.add(current_senator.is_chair_toString());
                                }
                            
                            //output if the number the user provides does not belong to a menu choice
                            }else{
                                System.out.println("Please choose a valid option.");
                            }menu.remove(men_choice);

                            //outputs the information asks for
                            System.out.printf("Here is what we have gathered so far on Senator %s: \n", sen_name);
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("\n"+sen_name+ "\n");
                            String info[] = users_choices.toArray(new String[users_choices.size()]);
                            for(String choices_string : info){
                                System.out.println(choices_string);
                            }if(menu.size()!= 0){

                                //allows the user to ask for other information on their senator
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.printf("\nWould you like to add more information on Senator %s?", sen_name);
                                System.out.println("\nEnter '1' for Yes or '2' for No");

                                // if user picks 1, the menu asking about information regarding their
                                //specific senator will reset
                                int more = keyboard.nextInt();
                                if(more == 1){
                                    single_on = 1;
                                //if they choose 2, they will first be asked if they would like to search for
                                //another senator
                                }else{
                                    System.out.println("\nWould you like to add information on any other senators?");
                                    System.out.println("Enter '1' for Yes or '2' for No:");
                                    int add_another = keyboard.nextInt();

                                    //if user chooses to searcch for another senator, their menu will be reset in order
                                    //for them to search for another singular senator
                                    if(add_another == 1){
                                        menu.clear();
                                        resetMenu(menu);
                                        single_on = 0;

                                    // if the user says no searching for additional information, they will be 
                                    //given a "farewell", and the entire program will be reset
                                    }else{
                                        System.out.println("Your information has been written to the file 'senator_info.txt'");
                                        main_loop = 0;
                                        single_on = 0;
                                        // the information the searched for will be added to a new file, for them to
                                        // save for easier access
                                    }
                                }
                                
                            //this user is finished with searching, and the program resents
                            }else{
                                System.out.println("Your information has been written to the file 'senator_info.txt'");
                                main_loop = 0;
                                single_on = 0;
                            }
                            
                            


                        }


                    }
                }
            
            //the code in which the user can search through multiple senators at a time
            }else{
                System.out.println("This program sorts Senators by your desired parameters in two phases.");
                System.out.println("This first phase will narrow down Senators, only showing those belonging to whatever criteria you select. ");
                System.out.println("The second phase will sort your list of Senators by whatever criteria you desire. ");

                System.out.println("Beginning phase one...");

                ArrayList<String> runningList = new ArrayList<>();

                //using the choices menu, the user can sort through different senators
                //according to the variables they are categorized in through the class
                int first_choice = 1;
                while(first_choice == 1){
                    System.out.println("Please enter the number corresponding to the filter your would like to apply to your search: \n");
                    menu.remove("Name");
                    printMenu(menu);

                    int phase1_choice = keyboard.nextInt();
                    String p1_string = menu.get(phase1_choice);

                    //if the user chooses to sift through parties, a party menu is
                    //established, and the user must now pick what type of political
                    //party to search through
                    if(p1_string.equals("Party")){
                        ArrayList<String> partyMenu = new ArrayList<>();
                        partyMenu.add("Democrat");
                        partyMenu.add("Republican");
                        partyMenu.add("Independent");
                        partyMenu.add("All");

                        printMenu(partyMenu);
                        System.out.println("Please enter the number corresponding to your desired party: ");

                        int party_choice = keyboard.nextInt();

                        String party_str = partyMenu.get(party_choice);
                        partyMenu.remove(party_choice);

                        // the user submits the number regarding the party, and the program
                        //sifts through the senator class, finding the senators with th esame political party

                        //then outputting the list of that party's senators
                        for(Senator p : mysenators){
                            //if democrat
                            if(party_str.equals("Democrat")){
                                String senator_name = p.getName();
                                runningList.add(senator_name + "\n" + "Party: Democrat");
                            //if republican
                            }else if(party_str.equals("Republican")){
                                String sen_nm = p.getName();
                                runningList.add(sen_nm + "\n" + "Party: Republican");
                            //if independent
                            }else if(party_str.equals("Independent")){
                                String sn_name = p.getName();
                                runningList.add(sn_name + "\n" + "Party: Independent");
                            //if the user does not discolse a party, the program will output all senators
                            //along with their party
                            }else{
                                String senate_name = p.getName();
                                runningList.add(senate_name + "\n" + "Party: " + p.getParty());
                            }
                            
                        //program will continute to sort down and down tthorugh the provided menu choices
                        //and keep the user informed in what senators are still matching their filters 
                        }System.out.println("Here is your current list of Senators: ");
                        printArray(runningList);

                    }

                    
                }


            }
        }   
        keyboard.close();
    }
}  
    
        
        


        

      
    


