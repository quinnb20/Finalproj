//making the class for the Senators with leadership positions
public class Leadership {
    String name;
    String position;

    //establishment of these categories in the class
    public Leadership(String name, String position){
        this.name = name;
        this.position = position;

    //making the actions of getting the variables running the code
    }public String getName(){
        return name;
    }public String getPosition(){
        return position;
    }
    //setting the specific varaibles to the specific objects in a class
    public void setName(String name){
        this.name = name;
    }public void setPosition(String position){
        this.position = position;
    }
    //creating the outputs for the leadership class
    @Override public String toString(){
        return(this.getName()+ "\nPosition: " +this.getPosition());
    }public String posToString(){
        return("  Position: " + this.getPosition());
    }
}
