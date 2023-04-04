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
      

    

      
      
  
