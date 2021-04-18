public class Student{
    int grade;
    String name;
    
    public Student(String stdntName, int stdntGrade){
        this.name = stdntName;
        this.grade = stdntGrade;
    }

    public void introduce(){
        System.out.println("Introduce your teacher by saying this: \"my name is " + this.name + " and I am currently studying in grade " + this.grade + "\"");
    }
}
