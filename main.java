import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{
  public static ArrayList<Senator> readFile() throws Exception{
    ArrayList<Senator> senators = new ArrayList<>();
    File sen = new File("Senators1.txt");
    Scanner reader = new Scanner(sen);
    while(reader.hasNextLine()){
      String line = reader.nextLine();
      String[] token = line.split(", ");
      Senator newSenator = new Senator(token[0], token[1], token[2], Integer.valueOf(token[3]), Boolean.valueOf(token[4]), Boolean.valueOf(token[5]));
      senators.add(newSenator);
    }
    return senators;
  }public static ArrayList<Leadership> readFile() throws Exception{
    ArrayList<Leadership> leaders = new ArrayList<>();
    File lead = new File("Leadership.txt");
    Scanner reader = Scanner(lead);
    while(reader.hasNextLine()){
      String lin = reader.nextLine();
      String[] toke = lin.split(", ");
      Leadership newLeader = new Leadership(toke[0], toke[1]);
      leaders.add(newLeader);
    }
    return leaders;
  }public static ArrayList<Chairperson> realFile() throws Exception{
    ArrayList<Chairperson> chairs = new ArrayList<>();
    File chair = new File("Chairmen.txt");
    Scanner reader = Scanner(chair);
    while(reader.hasNextLine()){
      String li = reader.nextLine();
      String[] tok = li.split(": ");
      Chairperson newChair = new Chairperson(tok[0], tok[1]);
      chairs.add(newChair);
    }
    return chairs;
  }System.out.println("Hello! Welcome to the U.S. Senate Directory!!\n");
  System.out.println("What can we help you find today?\n");
  
  int continue = 1;
  while(continue == 1){
    System.out.println("Press 'S' to search for a single Senator or 'M' to search for multiple.\n");
    Scanner reader = Scanner(System.in);
    char s_or_m;
    s_or_m = reader.nextChar();
  
    if(s_or_m=="s"){
      String sen_name;
      System.out.println("What is the name of the senator you are searching for? ");
      sen_name = reader.nextLine();
      boolean ans = senators.contains(sen_name);
      if(ans){
        System.out.println("What would you like to know about Senator %s", sen_name);
        
        menu.remove(0);
        
        printMenu(menu);
        
        System.out.println("Enter the number corresponding to your choice: ");
        men_choice = reader.nextInt();
        menu.remove(men_choice);
        
        for(Senator member : senators){
          ///Set each menu choice to specific number (hard code it) and use it w senator.get to retrive inf from for loop
          ///use this setup for basically everytbibg 
          
   
ArrayList<String> menu = new ArrayList<String>;
menu.add("Name");
menu.add("Party");
menu.add("State");
menu.add("Class");
menu.add("Senate Leadership");
menu.add("Committee Chairpeople");
menu.add("Committee Assignments");




//Prints menu and attaches numbers starting at 0 to use indexing to prompt response

static String printMenu(ArrayList<String> menu_object){
  String m[] = menu_object.toArray(new String[menu_object.size()]);
  int counter = 0;
  for(String menu_string : m){
    String str = String.valueOf(counter);
    System.out.println(str + ".  " + menu_string);
    counter += 1;
  }System.out.println();
        
      

    

      
      
  
