
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

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

        }read.close();
        return leaders;
    }public static ArrayList<Chairperson> Read_File() throws Exception{
        ArrayList<Chairperson> chairs = new ArrayList<>();
        File chair = new File("/Users/harpercrews/Downloads/Chairmen.txt");
        Scanner red = new Scanner(chair);
        while(red.hasNextLine()){
            String li = red.nextLine();
            String[] tok = li.split(": ");
            Chairperson newChair = new Chairperson(tok[0], tok[1]);
            chairs.add(newChair);
        }red.close();
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
    
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
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
        }*/ArrayList<Chairperson> myChairs = new ArrayList<>();
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
        System.out.println("Hello! Welcome to the U.S. Senate Directory.\n");
        System.out.println("");
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Name");
        menu.add("Party");
        menu.add("State");
        menu.add("Class");
        menu.add("Senate Leadership");
        menu.add("Committee Chairpeople");
        
        int main_loop = 1;
        while(main_loop == 1){
            System.out.println("Press 's' to search for a single senator or 'm' to search for multiple.");
            String s_or_m;
            s_or_m = keyboard.nextLine();

            if(s_or_m.equals("s")){
                String sen_name;
                System.out.println("What is the name of the senator you are searching for? ");
                sen_name = keyboard.nextLine();
                
                for(Senator member : mysenators){
                    if(sen_name.equals(member.getName())){
                        int mem_indx = mysenators.indexOf(member);
                        Senator current_senator = mysenators.get(mem_indx);
                        menu.remove("Name");
                        ArrayList<String> users_choices = new ArrayList<String>();

                        int single_on = 1;
                        while(single_on == 1){
                            System.out.printf("What would you like to know about Senator %s?\n", sen_name);
                            printMenu(menu);

                            System.out.println("Enter the number corresponding to your choice: ");
                            int men_choice = keyboard.nextInt();

                            String str_choice = menu.get(men_choice);
                            //menu.remove(men_choice);
                            //System.out.println(str_choice);
                            //ArrayList<String> users_choices = new ArrayList<String>();

                            if(str_choice.equals("Party")){
                                String party = current_senator.partyString();
                                //System.out.println(sen_name);
                                //System.out.println("\n"+ party);
                                users_choices.add(party);
   
                            }else if(str_choice.equals("State")){
                                String state = current_senator.stateString();
                               //System.out.println(sen_name);
                                //System.out.println("\n" + state);
                                users_choices.add(state);


                            }else if(str_choice.equals("Class")){
                                String cls = current_senator.classToString();
                                //System.out.println(sen_name);
                                //System.out.println("\n" + cls);
                                users_choices.add(cls);

                            }else if(str_choice.equals("Senate Leadership")){
                                boolean is_a_leader = current_senator.get_is_leader();
                                if(is_a_leader){
                                    for(Leadership leader : myLeaders){
                                        if(sen_name.equals(leader.getName())){
                                            String position = leader.posToString();
                                            //System.out.println(sen_name);
                                            //System.out.println("\n" + position);
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
                                            //System.out.println(sen_name);
                                            //System.out.println("\n" + chairPos);
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
                                System.out.println("\nEnter '1' for Yes or '2' for No");

                                int more = keyboard.nextInt();
                                if(more == 1){
                                    single_on = 1;
                                }else{
                                    System.out.println("\nWould you like to add information on any other senators?");
                                    System.out.println("Enter '1' for Yes or '2' for No:");
                                    int add_another = keyboard.nextInt();
                                    if(add_another == 1){
                                        menu.clear();
                                        resetMenu(menu);
                                        single_on = 0;

                                    }else{
                                        System.out.println("Your information has been written to the file 'senator_info.txt'");
                                        main_loop = 0;
                                        single_on = 0;
                                    }
                                }
                                

                            }else{
                                System.out.println("Your information has been written to the file 'senator_info.txt'");
                                main_loop = 0;
                                single_on = 0;
                            }
                            
                            


                        }


                    }
                }
                
            }else{
                System.out.println("This program sorts Senators by your desired parameters in two phases.");
                System.out.println("This first phase will narrow down Senators, only showing those belonging to whatever criteria you select. ");
                System.out.println("The second phase will sort your list of Senators by whatever criteria you desire. ");

                System.out.println("Beginning phase one...");

                ArrayList<String> runningList = new ArrayList<>();

                int first_choice = 1;
                while(first_choice == 1){
                    System.out.println("Please enter the number corresponding to the filter your would like to apply to your search: \n");
                    menu.remove("Name");
                    printMenu(menu);

                    int phase1_choice = keyboard.nextInt();
                    String p1_string = menu.get(phase1_choice);

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

                        for(Senator p : mysenators){
                            if(party_str.equals("Democrat")){
                                String senator_name = p.getName();
                                runningList.add(senator_name + "\n" + "Party: Democrat");
                                    
                                
                            }else if(party_str.equals("Republican")){
                                String sen_nm = p.getName();
                                runningList.add(sen_nm + "\n" + "Party: Republican");
                            }else if(party_str.equals("Independent")){
                                String sn_name = p.getName();
                                runningList.add(sn_name + "\n" + "Party: Independent");
                            }else{
                                String senate_name = p.getName();
                                runningList.add(senate_name + "\n" + "Party: " + p.getParty());
                            }
                            
                        }System.out.println("Here is your current list of Senators: ");
                        printArray(runningList);

                    }

                    
                }


            }
        }   
        
        
        
        
        
        
        
        keyboard.close();
    }
}  
    
        
        


        

      
    


