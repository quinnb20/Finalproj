public class Chairperson {
    String name;
    String chairTitle;

    public Chairperson(String name, String chairTitle){
        this.name = name;
        this.chairTitle = chairTitle;
    }public String getName(){
        return name;
    }public String get_chairTitle(){
        return chairTitle;
    }
    public void setName(String name){
        this.name = name;
    
    }public void set_chairTitle(String chairTitle){
        this.chairTitle = chairTitle;
    }
    @Override public String toString(){
        return(this.getName()+"\nTitle: " + this.get_chairTitle());
    }public String chairString(){
        return("  Chair Title: " + this.get_chairTitle());
    }
}
