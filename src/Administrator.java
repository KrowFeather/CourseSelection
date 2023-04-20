import java.util.ArrayList;
import java.util.Scanner;

public class Administrator {
    private static final String userName="admin";
    private static final String password="123456";
    public boolean login(){
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

   /*
        student area
    */
    public void addStudent(ArrayList<Student> studentArrayList) {
        Student student = new Student();
        System.out.println("----------------------------");
        System.out.println("输入用户名");
        Scanner sc = new Scanner(System.in);
        String userName;
        String name;
        String id;
        userName=sc.next();
        System.out.println("输入姓名");
        name=sc.next();
        System.out.println("输入学号");
        id=sc.next();
        student.userName=userName;
        student.name=name;
        student.id=id;
        studentArrayList.add(student);
        System.out.println("添加成功！");
        System.out.println("----------------------------");
    }

    public void deleteStudent(ArrayList<Student> studentArrayList) {
        System.out.println("----------------------------");
        System.out.println("请输入要删除的用户名");
        Scanner sc = new Scanner(System.in);
        String userName;
        boolean flag=false;
        userName=sc.next();
        int i=0;
        while(i<studentArrayList.size()){
            if(userName.equals(studentArrayList.get(i).userName)){
                studentArrayList.remove(i);
                System.out.println("删除成功！");
                flag=true;
                break;
            }
            i++;
        }
        if(!flag){
            System.out.println("删除失败，未找到用户");
        }
        System.out.println("----------------------------");
    }

    public void modifyStudent(ArrayList<Student> studentArrayList) {
        System.out.println("----------------------------");
        System.out.println("请输入要修改的用户名:");
        Scanner sc = new Scanner(System.in);
        String userName;
        boolean flag=false;
        userName=sc.next();
        int i=0;
        while(i<studentArrayList.size()){
            if(userName.equals(studentArrayList.get(i).name)){
                System.out.println("----------------------------");
                String newName;
                String newId;
                System.out.println("请输入新姓名:");
                newName=sc.next();
                System.out.println("请输入新学号:");
                newId = sc.next();
                studentArrayList.get(i).name=newName;
                studentArrayList.get(i).id=newId;
                System.out.println("修改成功！");
                System.out.println("----------------------------");
                flag=true;
                break;
            }
            i++;
        }
        if(!flag){
            System.out.println("修改失败，未找到用户");
            System.out.println("----------------------------");
        }
    }

    public void searchStudent(ArrayList<Student> studentArrayList) {
        System.out.println("----------------------------");
        System.out.println("请输入要查询的用户名:");
        Scanner sc = new Scanner(System.in);
        String name;
        boolean flag=false;
        name=sc.next();
        int i=0;
        while(i<studentArrayList.size()){
            if(name.equals(studentArrayList.get(i).userName)){
                System.out.println("----------------------------");
                System.out.println("查询结果");
                System.out.println("用户名:"+studentArrayList.get(i).userName);
                System.out.println("姓名:"+studentArrayList.get(i).name);
                System.out.println("学号:"+studentArrayList.get(i).id);
                System.out.println("用户存在");
                System.out.println("----------------------------");
                flag=true;
                break;
            }
            i++;
        }
        if(!flag){
            System.out.println("查询失败，未找到用户");
            System.out.println("----------------------------");
        }
    }

    public void studentInfo(ArrayList<Student> studentArrayList) {
        Student.overview(studentArrayList);
    }

    /*
        teacher area
     */
    public void addTeacher(ArrayList<Teacher> teacherArrayList) {
        Teacher teacher = new Teacher();
        String userName;
        String name;
        System.out.println("----------------------------");
        System.out.println("输入用户名");
        Scanner sc = new Scanner(System.in);
        userName=sc.next();
        System.out.println("输入姓名");
        name=sc.next();
        teacher.userName=userName;
        teacher.name=name;
        teacherArrayList.add(teacher);
        System.out.println("添加成功！");
        System.out.println("----------------------------");
    }

    public void deleteTeacher(ArrayList<Teacher> teacherArrayList) {
        System.out.println("----------------------------");
        System.out.println("请输入要删除的用户名");
        Scanner sc = new Scanner(System.in);
        String userName;
        boolean flag=false;
        userName=sc.next();
        int i=0;
        while(i<teacherArrayList.size()){
            if(userName.equals(teacherArrayList.get(i).userName)){
                teacherArrayList.remove(i);
                System.out.println("删除成功！");
                flag=true;
                break;
            }
            i++;
        }
        if(!flag){
            System.out.println("删除失败，未找到用户");
        }
        System.out.println("----------------------------");
    }

    public void modifyTeacher(ArrayList<Teacher> teacherArrayList) {
        System.out.println("----------------------------");
        System.out.println("请输入要修改的用户名:");
        Scanner sc = new Scanner(System.in);
        String userName;
        boolean flag=false;
        userName=sc.next();
        int i=0;
        while(i<teacherArrayList.size()){
            if(userName.equals(teacherArrayList.get(i).name)){
                System.out.println("----------------------------");
                String newName;
                System.out.println("请输入新姓名:");
                newName=sc.next();
                teacherArrayList.get(i).name=newName;
                System.out.println("修改成功！");
                System.out.println("----------------------------");
                flag=true;
                break;
            }
            i++;
        }
        if(!flag){
            System.out.println("修改失败，未找到用户");
            System.out.println("----------------------------");
        }
    }

    public void searchTeacher(ArrayList<Teacher> teacherArrayList) {
        System.out.println("----------------------------");
        System.out.println("请输入要查询的用户名:");
        Scanner sc = new Scanner(System.in);
        String name;
        boolean flag=false;
        name=sc.next();
        int i=0;
        while(i<teacherArrayList.size()){
            if(name.equals(teacherArrayList.get(i).userName)){
                System.out.println("----------------------------");
                System.out.println("查询结果");
                System.out.println("用户名:"+teacherArrayList.get(i).userName);
                System.out.println("姓名:"+teacherArrayList.get(i).name);
                System.out.println("用户存在");
                System.out.println("----------------------------");
                flag=true;
                break;
            }
            i++;
        }
        if(!flag){
            System.out.println("查询失败，未找到用户");
            System.out.println("----------------------------");
        }
    }

    public void teacherInfo(ArrayList<Teacher> teacherArrayList) {
        teacherArrayList.get(0).overview(teacherArrayList);
    }

    /*
        course area
     */
    public void addCourse(ArrayList<Courses> coursesArrayList) {
        Courses courses = new Courses();
        Scanner sc = new Scanner(System.in);
        String name;
        String teacher;
        System.out.println("----------------------------");
        System.out.println("请输入新课程的名称:");
        name=sc.next();
        System.out.println("请输入课程教师:");
        teacher=sc.next();
        courses.name=name;
        courses.teacher=teacher;
        coursesArrayList.add(courses);
        System.out.println("添加成功！");
        System.out.println("----------------------------");
    }

    public void deleteCourse(ArrayList<Courses> coursesArrayList) {
        System.out.println("----------------------------");
        System.out.println("请输入要删除的课程名:");
        Scanner sc = new Scanner(System.in);
        String name;
        String teacher;
        boolean flag=false;
        name=sc.next();
        System.out.println("请输入课程教师名:");
        teacher=sc.next();
        int i=0;
        while(i<coursesArrayList.size()){
            if(name.equals(coursesArrayList.get(i).name)&&teacher.equals(coursesArrayList.get(i).teacher)){
                coursesArrayList.remove(i);
                System.out.println("删除成功！");
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

    public void modifyCourse(ArrayList<Courses> coursesArrayList) {
        System.out.println("----------------------------");
        System.out.println("请输入要修改的课程名:");
        Scanner sc = new Scanner(System.in);
        String name;
        String teacher;
        boolean flag=false;
        name=sc.next();
        System.out.println("请输入课程教师名:");
        teacher=sc.next();
        int i=0;
        while(i<coursesArrayList.size()){
            if(name.equals(coursesArrayList.get(i).name)&&teacher.equals(coursesArrayList.get(i).teacher)){
                System.out.println("----------------------------");
                String newName;
                String newTeacher;
                System.out.println("请输入新课程名:");
                newName=sc.next();
                System.out.println("请输入新教师名:");
                newTeacher=sc.next();
                coursesArrayList.get(i).name=newName;
                coursesArrayList.get(i).teacher=newTeacher;
                System.out.println("修改成功！");
                System.out.println("----------------------------");
                flag=true;
                break;
            }
            i++;
        }
        if(!flag){
            System.out.println("修改失败，未找到课程");
            System.out.println("----------------------------");
        }
    }

    public void searchCourse(ArrayList<Courses> coursesArrayList) {
        System.out.println("----------------------------");
        System.out.println("请输入要查询的课程名:");
        Scanner sc = new Scanner(System.in);
        String name;
        boolean flag=false;
        name=sc.next();
        int i=0;
        while(i<coursesArrayList.size()){
            if(name.equals(coursesArrayList.get(i).name)){
                System.out.println("----------------------------");
                System.out.println("查询结果");
                System.out.println("课程名:"+coursesArrayList.get(i).name);
                System.out.println("课程存在");
                System.out.println("----------------------------");
                flag=true;
                break;
            }
            i++;
        }
        if(!flag){
            System.out.println("查询失败，未找到课程");
            System.out.println("----------------------------");
        }
    }

    public void courseInfo(ArrayList<Courses> coursesArrayList) {
        coursesArrayList.get(0).overview(coursesArrayList);
    }

    /*
        class area
     */
    public void addClass(ArrayList<Teacher> teacherArrayList,ArrayList<SchoolClass> schoolClassArrayList) {
        System.out.println("----------------------------");
        SchoolClass newSchoolClass = new SchoolClass();
        String name;
        String teacher;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入班级名");
        name=sc.next();
        System.out.println("请输入班主任名");
        teacher=sc.next();
        newSchoolClass.name=name;
        newSchoolClass.teacher=teacher;
        schoolClassArrayList.add(newSchoolClass);
        System.out.println("----------------------------");
        int i=0;
        while(i<teacherArrayList.size()){
            if(newSchoolClass.teacher.equals(teacherArrayList.get(i).name)){
                teacherArrayList.get(i).ownSchoolClasses.add(newSchoolClass);
                break;
            }
            i++;
        }
    }

    public void deleteClass(ArrayList<SchoolClass> schoolClassArrayList) {
        System.out.println("----------------------------");
        System.out.println("请输入要删除的班级名");
        Scanner sc = new Scanner(System.in);
        String name;
        boolean flag=false;
        name=sc.next();
        int i=0;
        while(i< schoolClassArrayList.size()){
            if(name.equals(schoolClassArrayList.get(i).name)){
                schoolClassArrayList.remove(i);
                System.out.println("删除成功！");
                flag=true;
                break;
            }
            i++;
        }
        if(!flag){
            System.out.println("删除失败，未找到班级");
        }
        System.out.println("----------------------------");
    }

    public void modifyClass(ArrayList<SchoolClass> schoolClassArrayList) {
        System.out.println("----------------------------");
        System.out.println("请输入要修改的班级名:");
        Scanner sc = new Scanner(System.in);
        String name;
        boolean flag=false;
        name=sc.next();
        int i=0;
        while(i<schoolClassArrayList.size()){
            if(name.equals(schoolClassArrayList.get(i).name)){
                System.out.println("----------------------------");
                String newName;
                String newTeacher;
                System.out.println("请输入新班级名:");
                newName=sc.next();
                System.out.println("请输入新教师名:");
                newTeacher=sc.next();
                schoolClassArrayList.get(i).name=newName;
                schoolClassArrayList.get(i).teacher=newTeacher;
                System.out.println("修改成功！");
                System.out.println("----------------------------");
                flag=true;
                break;
            }
            i++;
        }
        if(!flag){
            System.out.println("修改失败，未找到班级");
            System.out.println("----------------------------");
        }
    }

    public void searchClass(ArrayList<SchoolClass> schoolClassArrayList) {
        System.out.println("----------------------------");
        System.out.println("请输入要查询的班级名:");
        Scanner sc = new Scanner(System.in);
        String name;
        boolean flag=false;
        name=sc.next();
        int i=0;
        while(i<schoolClassArrayList.size()){
            if(name.equals(schoolClassArrayList.get(i).name)){
                System.out.println("----------------------------");
                System.out.println("查询结果");
                System.out.println("班级名:"+schoolClassArrayList.get(i).name);
                System.out.println("所属教师:"+schoolClassArrayList.get(i).teacher);
                System.out.println("班级存在");
                System.out.println("----------------------------");
                flag=true;
                break;
            }
            i++;
        }
        if(!flag){
            System.out.println("查询失败，未找到班级");
            System.out.println("----------------------------");
        }
    }

    public void classInfo(ArrayList<SchoolClass> schoolClassArrayList) {
        schoolClassArrayList.get(0).overview(schoolClassArrayList);
    }
}
