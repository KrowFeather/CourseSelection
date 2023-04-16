import java.util.ArrayList;
import java.util.Scanner;

public class Teacher {
    public String userName;
    public String name;
    private String password;
    public ArrayList<Class> ownClasses = new ArrayList<>();
    public ArrayList<Courses> ownCourses = new ArrayList<>();
    private static Teacher thisTeacher;
    public Teacher(){
        this.password="123456";
    }
    public static boolean login(){
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
            while (i < Main.teacherArrayList.size()) {
                if (userName.equals(Main.teacherArrayList.get(i).userName) && password.equals(Main.teacherArrayList.get(i).password)) {
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
                thisTeacher=Main.teacherArrayList.get(i);
            }
        }while(!flag);
        return true;
    }
    public static void changePwd(){
        int choice;
        Scanner sc = new Scanner(System.in);
        String password;
        boolean flag=false;
        System.out.println("请输入旧密码");
        do {
            password = sc.next();
            if (password.equals(thisTeacher.password)) {
                System.out.println("请输入新密码");
                password = sc.next();
                thisTeacher.password = password;
                flag=true;
            }else{
                System.out.println("密码错误！");
                System.out.println("输入0退回主菜单,输入除0外任意数字重新输入");
                choice = sc.nextInt();
                if (choice == 0) {
                    return;
                }
            }
        }while(!flag);
        System.out.println("修改密码成功！");
        System.out.println("----------------------------");
    }

    public static void selfBio() {
        System.out.println("----------------------------");
        System.out.println("用户名："+thisTeacher.userName);
        System.out.println("姓名："+thisTeacher.name);
        System.out.println("----------------------------");
    }

    public static void ownCoursesInfo() {
        System.out.println("----------------------------");
        int i=0;
        System.out.println("课程名\t\t已选学生数");
        while(i<thisTeacher.ownCourses.size()){
            System.out.println(thisTeacher.ownCourses.get(i).name+"\t\t"+thisTeacher.ownCourses.get(i).stuNumber);
            i++;
        }
        System.out.println("----------------------------");
    }

    public static void ownClassInfo() {
        System.out.println("----------------------------");
        int i=0;
        System.out.println("班级名\t\t学生总数");
        while(i<thisTeacher.ownClasses.size()){
            System.out.println(thisTeacher.ownClasses.get(i).name);
            i++;
        }
        System.out.println("----------------------------");
    }
}