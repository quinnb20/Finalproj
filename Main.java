
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class FinalDraft{
    //Reads in Senator text file
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
        

    }public static void printMenu(ArrayList<String> menu_object){
        String m[] = menu_object.toArray(new String[menu_object.size()]);
        int counter = 0;
        for(String menu_string : m){
            String str = String.valueOf(counter);
            System.out.println("\n" + str + ". " + menu_string);
            counter += 1;
        }System.out.println();
        
        


    }public static void resetMenu(ArrayList<String> menu_object){
        menu_object.clear();
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
                }System.out.println(final_string);
                f_writer.write(final_string + "\n");
                System.out.println("Your information has been written to the file 'senator_info.txt'");
            }f_writer.close();
        }catch(Exception e){
            System.out.println("Could not create file");
        }
    }
    
    public static void main(String[] args){
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
        }System.out.println("Hello! Welcome to the U.S. Senate Directory.\n");
        System.out.println("");
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Name");
        menu.add("Party");
        menu.add("State");
        menu.add("Class");
        menu.add("Senate Leadership");
        menu.add("Committee Chairpeople");
        
        String main_loop = "Yes";
        while(main_loop.equalsIgnoreCase("Yes")){
            System.out.println("Press 'S' to search for a single senator or 'M' to search for multiple.");
            String s_or_m;
            s_or_m = keyboard.nextLine();

            if(s_or_m.equalsIgnoreCase("s")){
                String sen_name;
                System.out.println("What is the name of the senator you are searching for? ");
                sen_name = keyboard.nextLine();
                
                for(Senator member : mysenators){
                    if(sen_name.equals(member.getName())){
                        int mem_indx = mysenators.indexOf(member);
                        Senator current_senator = mysenators.get(mem_indx);
                        menu.remove("Name");
                        ArrayList<String> users_choices = new ArrayList<String>();

                        String single_on = "Yes";
                        while(single_on.equalsIgnoreCase("Yes")){
                            System.out.printf("What would you like to know about Senator %s?\n", sen_name);
                            printMenu(menu);

                            System.out.println("Enter the number corresponding to your choice: ");
                            int men_choice = keyboard.nextInt();

                            String str_choice = menu.get(men_choice);
    

                            if(str_choice.equals("Party")){
                                String party = current_senator.partyString();
                                users_choices.add(party);
   
                            }else if(str_choice.equals("State")){
                                String state = current_senator.stateString();
                                users_choices.add(state);


                            }else if(str_choice.equals("Class")){
                                String cls = current_senator.classToString();
                                users_choices.add(cls);

                            }else if(str_choice.equals("Senate Leadership")){
                                boolean is_a_leader = current_senator.get_is_leader();
                                if(is_a_leader){
                                    for(Leadership leader : myLeaders){
                                        if(sen_name.equals(leader.getName())){
                                            String position = leader.posToString();
                                            users_choices.add(position);
                                        }
                                    }

                                }else{
                                    System.out.println("The Senator does not hold a leadership position.");
                                    users_choices.add(current_senator.is_leader_toString());
                                }
                            }else if(str_choice.equals("Committee Chairpeople")){
                                boolean is_a_chair = current_senator.get_is_chair();
                                if(is_a_chair){
                                    for(Chairperson c : myChairs){
                                        if(sen_name.equals(c.getName())){
                                            String chairPos = c.chairString();
                                            users_choices.add(chairPos);
                                        }
                                    }
                                }else{
                                    System.out.println("The Senator is not the chair of a committee. ");
                                    users_choices.add(current_senator.is_chair_toString());
                                }
                            }else{
                                System.out.println("Please choose a valid option.");
                            }menu.remove(men_choice);
                            System.out.printf("Here is what we have gathered so far on Senator %s: \n", sen_name);
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("\n"+sen_name+ "\n");
                            String info[] = users_choices.toArray(new String[users_choices.size()]);
                            for(String choices_string : info){
                                System.out.println(choices_string);
                            }if(menu.size()!= 0){
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.printf("\nWould you like to add more information on Senator %s?", sen_name);
                                System.out.println("\nEnter 'Yes' to add more or 'No' to exit");

                                single_on = keyboard.next();
                                
                                

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


                    }else{
                        System.out.println("That Senator does not exist. Please check your spelling according to the list on Senate.gov");
                        break;
                    }
                }break;    
            }
                
            if(s_or_m.equalsIgnoreCase("m")){
                System.out.println("This program sorts Senators by your desired parameters in two phases.\n");
                System.out.println("The first phase creates a list of Senators \n");
                System.out.println("The second phase sorts your created list. \n ");

                System.out.println("Beginning phase one...\n");

                ArrayList<String> choiceList = new ArrayList<>();
                ArrayList<Senator> runningSenList = new ArrayList<>();
                ArrayList<String> partyMenu = new ArrayList<>();
                partyMenu.add("Democrat");
                partyMenu.add("Republican");
                partyMenu.add("Independent");

                System.out.println("The system will prompt you to choose fields until you have reached your desired list\n");
                String continue_adding = "Yes";
                
                while(continue_adding.equalsIgnoreCase("Yes")){
                    System.out.println("Please enter the number corresponding to your desired field");
                    menu.remove("Name");
                    printMenu(menu);
                    int choiceFromMenu = keyboard.nextInt();
                    String menu_Choice = menu.get(choiceFromMenu);
                    choiceList.add(menu_Choice);
                    menu.remove("Name");
                    if(menu_Choice.equals("Party")){
                        while(partyMenu.size()!=0){

                        
                            String cont_party = "Yes";
                            while(cont_party.equalsIgnoreCase("Yes")){
                                System.out.println("Please enter the number corresponding to your desired party: ");
                                printMenu(partyMenu);
                                int partyChoice = keyboard.nextInt();
                                String partyString = partyMenu.get(partyChoice);
                                partyMenu.remove(partyChoice);
                        
                                System.out.println("The " + partyString + "s in the Senate are: ");
                                for(Senator s : mysenators){
                                    if(s.getParty().equals(partyString)){
                                        if(runningSenList.contains(s)==false){

                                        
                                            runningSenList.add(s);
                                            
                                        }System.out.println(s.getName() + "\n" + "Party: " + s.getParty()); 


                                    }
                                }System.out.println("Would you like to add Senators from another party? ");
                                System.out.println("Enter 'Yes' or 'No'");
                                cont_party = keyboard.next();
                            }break;    
                        }menu.remove("Party");
                        

                        
                    }else if(menu_Choice.equalsIgnoreCase("State")){
                        String cont_state = "Yes";
                        while(cont_state.equalsIgnoreCase("Yes")){
                            System.out.println("Enter the name of the state you would like to see the Senators from: ");
                            String state_choice = keyboard.next();

                          
                            System.out.println("The Senators from " + state_choice + " are: ");
                            for(Senator x : mysenators){
                                if(state_choice.equalsIgnoreCase(x.getState())){
                                    if(runningSenList.contains(x)==false){

                                    
                                        runningSenList.add(x);
                                    
                                    }System.out.println(x.getName() + "\n" + "State: " + x.getState());
                                    
                                }
                            }System.out.println("Would you like to add Senators from another state?");
                            System.out.println("Enter 'Yes' or 'No'");
                            cont_state = keyboard.next();

                        }menu.remove("State");
                        

                    }else if(menu_Choice.equals("Class")){
                        String cont_class = "Yes";
                        
                        while(cont_class.equalsIgnoreCase("Yes")){
                            System.out.println("Senators are split into class 1, class 2, or class 3 based on when they were elected.");
                            System.out.println("Please enter the number corresponding to the class of Senators you would like to see: ");
                            int e_class = keyboard.nextInt();
                            System.out.println("The Senators from election class " + e_class + " are: ");

                            for(Senator y : mysenators){
                                if(e_class == y.get_elect_class()){
                                    if(runningSenList.contains(y)==false){

                                    
                                        runningSenList.add(y);
                                    }System.out.println(y.getName() + "\n" + "Class: " + y.get_elect_class());


                                }
                            }System.out.println("Would you like to add Senators from another class?");
                            System.out.println("Enter 'Yes' or 'No'");
                            cont_class = keyboard.next();
                        }menu.remove("Class");
                


                    }else if(menu_Choice.equals("Senate Leadership")){
                        System.out.println("The Senators who have leaderhsip positions are: ");

                  
                        for(Senator l : mysenators){
                            if(l.get_is_leader()){
                                if(runningSenList.contains(l)==false){

                                
                                    runningSenList.add(l);
                                }

                            }
                        }for(Leadership leader_1 : myLeaders){
                            System.out.println(leader_1.getName() + "\n" + "Position: " + leader_1.getPosition());
                        }menu.remove("Senate Leadership");
                      

                    }else if(menu_Choice.equals("Committee Chairpeople")){
                        System.out.println("The Senators who are committee chairs are: ");
                        
                   
                        for(Senator c : mysenators){
                            if(c.get_is_chair()){
                                if(runningSenList.contains(c)==false){

                                
                                    runningSenList.add(c);
                                }
                            }
                        }for(Chairperson chair_1 : myChairs){
                            System.out.println(chair_1.getName() + "\n" + "Chair: " + chair_1.get_chairTitle());
                        }menu.remove("Committee Chairpeople");
                       


                    }if(menu.size()!=0){                    
                        System.out.println("Would you like to add another field? Enter 'Yes' or 'No'");
                        continue_adding = keyboard.next();
                    }    
                }System.out.println("Now that you have populated your list, you may choose how it is organized");
                System.out.println("Choose 'name' to sort Senators alphabetically by first name.\n");
                System.out.println("Choose 'Party' to sort Senators by their party affiliations.\n");
                System.out.println("Choose 'State' to sort Senators alphabetically by State.\n");
                System.out.println("Choose 'Senate Leadership' to sort Senators based on if they hold leadership positions.\n");
                System.out.println("Choose 'Commitee Chairpeople' to sort Senators based on if they are a Chairperson.\n");



                System.out.println("Enter the number corresponding to the field you would like to sort by: ");
                resetMenu(menu);
                printMenu(menu);

                int sorting = keyboard.nextInt();
                String sortingString = menu.get(sorting);
                if(sortingString.equals("Name")){
                    Collections.sort(runningSenList, new sortByName());
                    writeInfo(runningSenList, myLeaders, myChairs);
                    
                }else if(sortingString.equals("Party")){
                    Collections.sort(runningSenList, new sortByParty());
                    writeInfo(runningSenList, myLeaders, myChairs);
                    
                }else if(sortingString.equals("State")){
                    Collections.sort(runningSenList, new sortByState());
                    writeInfo(runningSenList, myLeaders, myChairs);

                }else if(sortingString.equals("Class")){
                    Collections.sort(runningSenList, new sortByClass());
                    writeInfo(runningSenList, myLeaders, myChairs);
                }else if(sortingString.equals("Senate Leadership")){
                    Collections.sort(runningSenList, new sortByLeader());
                    writeInfo(runningSenList, myLeaders, myChairs);

                }else if(sortingString.equals("Commitee Chairpeople")){
                    Collections.sort(runningSenList, new sortByChair());
                    writeInfo(runningSenList, myLeaders, myChairs);
                }




                    

            }break;
            

                    
        }keyboard.close();


    }
}
        
        

        
        

 
    
        
        


        

      
    


