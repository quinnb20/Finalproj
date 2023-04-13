public class Chairperson {

    // establishment of the class if a senator is a chair of a 
    // specific committee

    String name;
    // the Senator's name
    String chairTitle;
    // the title of their committee they lead

    //establishing the categories into the class
    public Chairperson(String name, String chairTitle){
        this.name = name;
        this.chairTitle = chairTitle;
    // creating a way for the user to provide a name
    }public String getName(){
        return name;
    //a way for the class to recieve a committee title
    }public String get_chairTitle(){
        return chairTitle;
    }
    //setting the name in the class to a specific individual
    public void setName(String name){
        this.name = name;
    //setting the committee title in the class to a specific variable
    }public void set_chairTitle(String chairTitle){
        this.chairTitle = chairTitle;
    }
    //establishing the string for the output for a senator's info on commitees
    @Override public String toString(){
        return(this.getName()+"\nTitle: " + this.get_chairTitle());
    }public String chairString(){
        return("  Chair Title: " + this.get_chairTitle());
    }
}
