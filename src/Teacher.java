import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
@SuppressWarnings("Duplicates")
public class Teacher {
    public String userName;
    public String name;
    public String password;
    public ArrayList<SchoolClass> ownSchoolClasses = new ArrayList<>();
    public ArrayList<Courses> ownCourses = new ArrayList<>();
    public Teacher(){
        this.password="123456";
    }

    public void changePwd(Teacher this){
        int choice;
        Scanner sc = new Scanner(System.in);
        String password;
        boolean flag=false;
        System.out.println("请输入旧密码");
        do {
            password = sc.next();
            if (password.equals(this.password)) {
                System.out.println("请输入新密码");
                password = sc.next();
                this.password = password;
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

    public void selfBio(Teacher this) {
        System.out.println("----------------------------");
        System.out.println("用户名："+this.userName);
        System.out.println("姓名："+this.name);
        System.out.println("----------------------------");
    }

    public void ownCoursesInfo() {
        System.out.println("----------------------------");
        int i=0;
        System.out.println("课程名\t\t已选学生数");
        while(i<this.ownCourses.size()){
            System.out.println(this.ownCourses.get(i).name+"\t\t"+this.ownCourses.get(i).stuNumber);
            i++;
        }
        System.out.println("----------------------------");
    }

    public void ownClassInfo() {
        System.out.println("----------------------------");
        int i=0;
        System.out.println("班级名\t\t学生总数");
        while(i<this.ownSchoolClasses.size()){
            System.out.println(this.ownSchoolClasses.get(i).name);
            i++;
        }
        System.out.println("----------------------------");
    }

    public void deleteStudentFromCourse(ArrayList<Student> studentArrayList) {
        System.out.println("----------------------------");
        Scanner sc = new Scanner(System.in);
        String name;
        String id;
        String course;
        System.out.println("请输入学生姓名");
        name=sc.next();
        System.out.println("请输入学生学号");
        id=sc.next();
        System.out.println("请输入要移出的课程名");
        course=sc.next();
        int i=0;
        boolean flag=false;
        while(i<studentArrayList.size()){
            if(id.equals(studentArrayList.get(i).id)&&name.equals(studentArrayList.get(i).name)){
                int j=0;
                while(j<studentArrayList.get(i).studentCourse.size()){
                    if(course.equals(studentArrayList.get(i).studentCourse.get(j).name)&&this.name.equals(studentArrayList.get(i).studentCourse.get(j).teacher)){
                        studentArrayList.get(i).studentCourse.get(j).stuNumber--;
                        studentArrayList.get(i).studentCourse.remove(studentArrayList.get(i).studentCourse.get(j));
                        flag=true;
                        break;
                    }
                    j++;
                }
            }
            i++;
        }
        if(!flag){
            System.out.println("移出失败");
        }else{
            System.out.println("移出成功");
        }
        System.out.println("----------------------------");
    }

    public void addStudentToCourse(ArrayList<Student> studentArrayList) {
        System.out.println("----------------------------");
        Scanner sc = new Scanner(System.in);
        String name;
        String id;
        String course;
        System.out.println("请输入学生姓名");
        name=sc.next();
        System.out.println("请输入学生学号");
        id=sc.next();
        System.out.println("请输入要加入的课程名");
        course=sc.next();
        int i=0;
        boolean flag=false;
        while(i<studentArrayList.size()){
            if(id.equals(studentArrayList.get(i).id)&&name.equals(studentArrayList.get(i).name)){
                int j=0;
                while(j<this.ownCourses.size()){
                    if(course.equals(this.ownCourses.get(j).name)){
                        this.ownCourses.get(j).stuNumber++;
                        studentArrayList.get(i).studentCourse.add(this.ownCourses.get(j));
                        flag=true;
                        break;
                    }
                    j++;
                }
            }
            i++;
        }
        if(!flag){
            System.out.println("添加失败");
        }else{
            System.out.println("添加成功");
        }
        System.out.println("----------------------------");
    }
    public void studentOverview(ArrayList<Student> studentArrayList){
        System.out.println("----------------------------");
        int i=0;
        while(i<studentArrayList.size()){
            System.out.println("用户名\t\t姓名\t\tid");
            System.out.println(studentArrayList.get(i).userName+"\t\t"+studentArrayList.get(i).name+"\t\t"+studentArrayList.get(i).id);
            i++;
        }
        System.out.println("----------------------------");
    }

    public void setStudentScore(ArrayList<Student> studentArrayList) {
        System.out.println("----------------------------");
        Scanner sc = new Scanner(System.in);
        String name;
        String id;
        double score;
        System.out.println("请输入学生姓名");
        name=sc.next();
        System.out.println("请输入学生学号");
        id=sc.next();
        int i=0;
        boolean flag=false;
        while(i<studentArrayList.size()){
            if(id.equals(studentArrayList.get(i).id)&&name.equals(studentArrayList.get(i).name)){
                System.out.println("请输入成绩");
                score=sc.nextDouble();
                studentArrayList.get(i).score=score;
                flag=true;
                break;
            }
            i++;
        }
        if(!flag){
            System.out.println("设置失败");
        }else{
            System.out.println("设置成功");
        }
        System.out.println("----------------------------");
    }

    public void checkStudentScore(ArrayList<Student> studentArrayList) {
        System.out.println("----------------------------");
        Scanner sc = new Scanner(System.in);
        String name;
        String id;
        System.out.println("请输入学生姓名");
        name=sc.next();
        System.out.println("请输入学生学号");
        id=sc.next();
        int i=0;
        boolean flag=false;
        while(i<studentArrayList.size()){
            if(id.equals(studentArrayList.get(i).id)&&name.equals(studentArrayList.get(i).name)){
                System.out.println("姓名\t\t成绩");
                System.out.println(studentArrayList.get(i).name+"\t\t"+studentArrayList.get(i).score);
                flag=true;
                break;
            }
            i++;
        }
        if(!flag){
            System.out.println("查找失败");
        }else{
            System.out.println("查找成功");
        }
        System.out.println("----------------------------");
    }
}
