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
}
Scanner keyboard = new Scanner(System.in);
System.out.println("Enter the number corresponding to the information you would like to know: ");
int user_choice = keyboard.nextInt()
  
