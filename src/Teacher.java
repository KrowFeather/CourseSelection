import java.util.ArrayList;
import java.util.Scanner;
@SuppressWarnings("Duplicates")
public class Teacher extends ObjectList{
    public String userName;
    public String name;
    protected String password;
    public ArrayList<SchoolClass> ownSchoolClasses = new ArrayList<>();
    public ArrayList<Courses> ownCourses = new ArrayList<>();
    public Teacher(){
        this.password="123456";
    }

    public void changePwd(){
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

    public void selfBio() {
        System.out.println("----------------------------");
        System.out.println("用户名："+thisTeacher.userName);
        System.out.println("姓名："+thisTeacher.name);
        System.out.println("----------------------------");
    }

    public void ownCoursesInfo() {
        System.out.println("----------------------------");
        int i=0;
        System.out.println("课程名\t\t已选学生数");
        while(i<thisTeacher.ownCourses.size()){
            System.out.println(thisTeacher.ownCourses.get(i).name+"\t\t"+thisTeacher.ownCourses.get(i).stuNumber);
            i++;
        }
        System.out.println("----------------------------");
    }

    public void ownClassInfo() {
        System.out.println("----------------------------");
        int i=0;
        System.out.println("班级名\t\t学生总数");
        while(i<thisTeacher.ownSchoolClasses.size()){
            System.out.println(thisTeacher.ownSchoolClasses.get(i).name);
            i++;
        }
        System.out.println("----------------------------");
    }
}
