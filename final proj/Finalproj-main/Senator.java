import java.util.Comparator;

//creating the variables the senators will have
public class Senator {
    String name;
    String state;
    String party;
    int election_class;
    boolean is_leader;
    boolean is_chair;

    // creating an area in the class for these variables
    public Senator(String name, String state, String party, int election_class, boolean is_leader, boolean is_chair){
        this.name = name;
        this.state = state;
        this.party = party;
        this.election_class = election_class;
        this.is_leader = is_leader;
        this.is_chair = is_chair; }

// establishing a way for the class to be given these variables
    public String getName(){
        return name;
    }public String getState(){
        return state;
    }public String getParty(){
        return party;
    }public int get_elect_class(){
        return election_class;
    }public boolean get_is_leader(){
        return is_leader;
    }public boolean get_is_chair(){
        return is_chair;
    }
    
    //setting the variables to their specific areas
    public void setName(String name){
        this.name = name;
    }public void setState(String state){
        this.state = state;
    }public void setParty(String party){
        this.party = party;
    }public void setElect_class(int election_class){
        this.election_class = election_class;
    }public void set_is_leader(boolean is_leader){
        this.is_leader = is_leader;
    }public void set_is_chair(boolean is_chair){
        this.is_chair = is_chair;
    }

    //creating the putput strings for each specific answer regarding a variable
    @Override public String toString(){
        return(this.getName() + "\nParty: " +this.getParty() + "  State: " +this.getState()+"  Class: " + this.get_elect_class()+"  Leader: " + this.get_is_leader()+ "  Chairperson: " +this.get_is_chair());
    }public String partyString(){
        return("Party: " + this.getParty());
    }public String stateString(){
        return("State: " + this.getState());
    }public String classToString(){
        return("Election Class: " + this.get_elect_class());
    }public String is_leader_toString(){
        return("Leadership Status: "+ this.get_is_leader());
    }public String is_chair_toString(){
        return("Chair Status: " + this.get_is_chair());
    }public String nonBooltoString(){
        return(this.getName() + "\nParty: " + this.getParty() + "  State: " + this.getState() + "  Class: " + this.get_elect_class());
    }

//creation of comparators to compare and sort senators according to how the user
//wishes to search for multiple senators

}class sortByName implements Comparator<Senator>{
    public int compare(Senator a, Senator b){
        return a.name.compareTo(b.name);
    }
}class sortByParty implements Comparator<Senator>{
    public int compare(Senator a, Senator b){
        return a.party.compareTo(b.party);
    }
}class sortByState implements Comparator <Senator>{
    public int compare(Senator a, Senator b){
        return a.state.compareTo(b.state);
    }
}
class sortByClass implements Comparator<Senator>{
    public int compare(Senator a, Senator b){
        return a.election_class - b.election_class;
    }
}class sortByLeader implements Comparator<Senator>{
    public int compare(Senator a, Senator b){
        return Boolean.compare(a.is_leader, b.is_leader);
    }
}class sortByChair implements Comparator<Senator>{
    public int compare(Senator a, Senator b){
        return Boolean.compare(a.is_chair, b.is_chair);
    }
}
