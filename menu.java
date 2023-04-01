ArrayList<String> menu = new ArrayList<String>;
menu.add("Name");
menu.add("Party");
menu.add("State");
menu.add("Class");
menu.add("Senate Leadership");
menu.add("Committee Chairpeople");
menu.add("Committee Assignments");




//Prints menu and attaches numbers starting at 0 to use indexing to prompt response
String m[] = menu.toArray(new String[menu.size()]);
int counter = 0;
for(String menu_string : m){
  String str = String.valueOf(counter);
  System.out.println(str + ".  " + menu_string);
  counter += 1;
}System.out.println();
  
