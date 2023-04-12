public class Leadership {
    String name;
    String position;

    public Leadership(String name, String position){
        this.name = name;
        this.position = position;
    }public String getName(){
        return name;
    }public String getPosition(){
        return position;
    }
    public void setName(String name){
        this.name = name;
    }public void setPosition(String position){
        this.position = position;
    }
    @Override public String toString(){
        return(this.getName()+ "\nPosition: " +this.getPosition());
    }public String posToString(){
        return("  Position: " + this.getPosition());
    }
}
