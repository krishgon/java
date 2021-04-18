public class Car {
    private String name; // private attribute

    public String getName(){ // a method for getting the value of so called 'private' name attribute
        return name;
    }

    public void setName(String newName){ // a method for setting the name of car 
        this.name = newName;
    }
}
