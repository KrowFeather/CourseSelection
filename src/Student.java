import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    public String userName;
    public String name;
    public String id;
    private String password;
    private static Student thisStudent;
    public Student(){
        this.password="123456";
    }
    public  ArrayList<Courses> studentCourse = new ArrayList<>();
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
            while (i < Main.studentArrayList.size()) {
                if (userName.equals(Main.studentArrayList.get(i).userName) && password.equals(Main.studentArrayList.get(i).password)) {
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
                thisStudent=Main.studentArrayList.get(i);
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
            if (password.equals(thisStudent.password)) {
                System.out.println("请输入新密码");
                password = sc.next();
                thisStudent.password = password;
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
        System.out.println("用户名："+thisStudent.userName);
        System.out.println("姓名："+thisStudent.name);
        System.out.println("----------------------------");
    }

    public static void addCourses() {
        System.out.println("----------------------------");
        Scanner sc = new Scanner(System.in);
        int i=0;
        String name,teacher;
        System.out.println("请输入课程名:");
        name=sc.next();
        System.out.println("请输入教师名:");
        teacher=sc.next();
        boolean flag=false;
        while(i<Main.coursesArrayList.size()){
            if(name.equals(Main.coursesArrayList.get(i).name)&&teacher.equals(Main.coursesArrayList.get(i).teacher)){
                System.out.println("添加成功");
                thisStudent.studentCourse.add(Main.coursesArrayList.get(i));
                Main.coursesArrayList.get(i).stuNumber++;
                flag=true;
                break;
            }
            i++;
        }
        if(!flag){
            System.out.println("添加失败，未找到课程");
        }
        System.out.println("----------------------------");
    }

    public static void deleteCourses() {
        System.out.println("----------------------------");
        Scanner sc = new Scanner(System.in);
        int i=0;
        String name,teacher;
        System.out.println("请输入课程名:");
        name=sc.next();
        System.out.println("请输入教师名:");
        teacher=sc.next();
        boolean flag=false;
        while(i<thisStudent.studentCourse.size()){
            if(name.equals(thisStudent.studentCourse.get(i).name)&&teacher.equals(thisStudent.studentCourse.get(i).teacher)){
                System.out.println("删除成功");
                thisStudent.studentCourse.get(i).stuNumber--;
                thisStudent.studentCourse.remove(i);
                flag=true;
                break;
            }
            i++;
        }
        if(!flag){
            System.out.println("删除失败，未找到课程");
        }
        System.out.println("----------------------------");
    }

    public static void checkCourses() {
        Courses.overview();
    }

    public static void overview(){
        System.out.println("----------------------------");
        int i=0;
        while(i<Main.studentArrayList.size()){
            System.out.println("用户名\t\t姓名\t\tid");
            System.out.println(Main.studentArrayList.get(i).userName+"\t\t"+Main.studentArrayList.get(i).name+"\t\t"+Main.studentArrayList.get(i).id);
            i++;
        }
        System.out.println("----------------------------");
    }
}
