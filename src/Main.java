import java.util.ArrayList;

public class Main {
    public static ArrayList<Student> studentArrayList = new ArrayList<>();
    public static ArrayList<Teacher> teacherArrayList = new ArrayList<>();
    public static ArrayList<Courses> coursesArrayList = new ArrayList<>();
    public static ArrayList<Class> classArrayList = new ArrayList<>();
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.initial();
    }
}