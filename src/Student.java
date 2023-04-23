import java.util.ArrayList;
import java.util.Scanner;
@SuppressWarnings("Duplicates")
public class Student extends ObjectList{
    public String userName;
    public String name;
    public String id;
    protected String password;
    public Student(){
        this.password="123456";
    }
    public ArrayList<Courses> studentCourse = new ArrayList<>();

    public void changePwd(){
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

    public void selfBio() {
        System.out.println("----------------------------");
        System.out.println("用户名："+thisStudent.userName);
        System.out.println("姓名："+thisStudent.name);
        System.out.println("----------------------------");
    }

    public void addCourses(ArrayList<Courses> coursesArrayList) {
        System.out.println("----------------------------");
        Scanner sc = new Scanner(System.in);
        int i=0;
        String name,teacher;
        System.out.println("请输入课程名:");
        name=sc.next();
        System.out.println("请输入教师名:");
        teacher=sc.next();
        boolean flag=false;
        while(i<coursesArrayList.size()){
            if(name.equals(coursesArrayList.get(i).name)&&teacher.equals(coursesArrayList.get(i).teacher)){
                System.out.println("添加成功");
                thisStudent.studentCourse.add(coursesArrayList.get(i));
                coursesArrayList.get(i).stuNumber++;
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

    public void deleteCourses() {
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

    public void checkCourses(ArrayList<Courses> coursesArrayList) {
        courseOverview(coursesArrayList);
    }
    public void courseOverview(ArrayList<Courses> coursesArrayList){
        System.out.println("----------------------------");
        int i=0;
        while(i<coursesArrayList.size()){
            System.out.println("名称\t\t教师\t\t已选人数");
            System.out.println(coursesArrayList.get(i).name+"\t\t"+coursesArrayList.get(i).teacher+"\t\t"+coursesArrayList.get(i).stuNumber);
            i++;
        }
        System.out.println("----------------------------");
    }

}
