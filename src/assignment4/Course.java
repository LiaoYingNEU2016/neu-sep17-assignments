package assignment4;

import java.util.ArrayList;
import java.util.List;

public class Course {
    String title;
    int numberOfStudent = 0;
    ArrayList<Student> students;

    Course(String title) {
        this.title = title;
    }
    ArrayList<Student> getStudents() {
        return students;
    }
    boolean isFull(){
        return numberOfStudent >= 10;
    }
    void registerStudent(Student student){
        if(!isFull()){
            numberOfStudent++;
            students.add(student);
        }
    }
}
class Student{
    String studentName;
    String studentID;

    public Student(String studentName, String studentID){
        this.studentName = studentName;
        this.studentID = studentID;

    }

} 
