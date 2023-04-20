import java.util.ArrayList;

public class CourseSelectionSystem {
    public ArrayList<Student> studentArrayList = new ArrayList<>();
    public ArrayList<Teacher> teacherArrayList = new ArrayList<>();
    public ArrayList<Courses> coursesArrayList = new ArrayList<>();
    public ArrayList<SchoolClass> schoolClassArrayList = new ArrayList<>();
    public Student thisStudent;
    public Teacher thisTeacher;
    Administrator admin = new Administrator();

    public void startProg(){
        Menu menu = new Menu();
        menu.initial();
    }
}
