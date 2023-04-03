import java.util.Scanner;

public class Senator{
  String name;
  String party;
  String state;
  int election_class;
  boolean is_leader;
  String leadership;
  boolean is_chair;
  String chairperson;
  String comm_assignments;
  
  public Senator(String name, String party, String state, int election_class, boolean is_leader, String leadership, boolean is_chair, String chairperson, String comm_assignments){
    this.name = name;
    this.party = party;
    this.state = state;
    this.election_class = election_class;
    this.is_leader = is_leader;
    this.leadership = leadership;
    this.is_chair = is_chair;
    this.chairperson = chairperson;
    this.comm_assignments = comm_assignments;
  }
  
  public String getName(){
    return name;
  }public String getParty(){
    return party;
  }public String getState(){
    return state;
  }public int getClass(){
    return election_class;
  }public boolean get_is_leader(){
    return is_leader;
  }public String getLeadership(){
    return leadership;
  }public boolean get_is_chair(){
    return is_chair;
  }public String getChairperson(){
    return chairperson;
  }public String getComm_assignments(){
    return comm_assignments;
  }
    
  
  

//read file
  //identify variables in class (party, state, if leader, etc)

}

public static void main(Strings[] args){

  //create array of the objects ti use in senator search in order to delete as the user uses program
  
  boolean menu= false
  
  while(menu==false){
  
  // gather input on whether user wants to search for a single senator or mult
    
    // input = single
      // ask for name, use for loop for senator and print out information
    
    //input = multiple
      //ask for a narrow down (using variables)
        //delete in array as user continues
  
  }


} 
