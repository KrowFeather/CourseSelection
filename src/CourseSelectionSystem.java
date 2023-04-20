import java.util.ArrayList;
import java.util.Scanner;
@SuppressWarnings("Duplicates")
public class CourseSelectionSystem {
    public ArrayList<Student> studentArrayList = new ArrayList<>();
    public ArrayList<Teacher> teacherArrayList = new ArrayList<>();
    public ArrayList<Courses> coursesArrayList = new ArrayList<>();
    public ArrayList<SchoolClass> schoolClassArrayList = new ArrayList<>();
    public Student thisStudent;
    public Teacher thisTeacher;
    Administrator admin = new Administrator();

    public void startProgram(){
        Menu menu = new Menu();
        menu.initial();
    }

    public boolean adminLogin(){
        Scanner sc = new Scanner(System.in);
        String userName;
        String password;
        boolean flag=false;
        int choice;
        do {
            System.out.println("请输入用户名：");
            userName=sc.next();
            System.out.println("请输入密码：");
            password=sc.next();
            if (userName.equals(Administrator.userName) && password.equals(Administrator.password)) {
                System.out.println("登录成功");
                flag=true;
            } else {
                System.out.println("登录失败");
                System.out.println("输入0退回主菜单,输入除0外任意数字重新登录");
                choice=sc.nextInt();
                if(choice==0){
                    return false;
                }
            }
        }while(!flag);
        return true;
    }
    public boolean studentLogin(){
        Scanner sc = new Scanner(System.in);
        String userName;
        String password;
        boolean flag=false;
        int choice;
        do {
            int i=0;
            System.out.println("请输入用户名：");
            userName = sc.next();
            System.out.println("请输入密码：");
            password = sc.next();
            while (i <studentArrayList.size()) {
                if (userName.equals(studentArrayList.get(i).userName) && password.equals(studentArrayList.get(i).password)) {
                    flag = true;
                    break;
                }
                i++;
            }
            if (!flag) {
                System.out.println("登录失败，密码错误或用户名不存在");
                System.out.println("输入0退回主菜单,输入除0外任意数字重新登录");
                choice = sc.nextInt();
                if (choice == 0) {
                    return false;
                }
            } else {
                System.out.println("登录成功");
                thisStudent=studentArrayList.get(i);
            }
        }while(!flag);
        return true;
    }

    public boolean teacherLogin(){
        Scanner sc = new Scanner(System.in);
        String userName;
        String password;
        boolean flag=false;
        int choice;
        do {
            int i=0;
            System.out.println("请输入用户名：");
            userName = sc.next();
            System.out.println("请输入密码：");
            password = sc.next();
            while (i < teacherArrayList.size()) {
                if (userName.equals(teacherArrayList.get(i).userName) && password.equals(teacherArrayList.get(i).password)) {
                    flag = true;
                    break;
                }
                i++;
            }
            if (!flag) {
                System.out.println("登录失败，密码错误或用户名不存在");
                System.out.println("输入0退回主菜单,输入除0外任意数字重新登录");
                choice = sc.nextInt();
                if (choice == 0) {
                    return false;
                }
            } else {
                System.out.println("登录成功");
                thisTeacher=teacherArrayList.get(i);
            }
        }while(!flag);
        return true;
    }
}
