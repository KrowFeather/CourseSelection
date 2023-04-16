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
    public void addStudent() {
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
        Main.studentArrayList.add(student);
        System.out.println("添加成功！");
        System.out.println("----------------------------");
    }

    public void deleteStudent() {
        System.out.println("----------------------------");
        System.out.println("请输入要删除的用户名");
        Scanner sc = new Scanner(System.in);
        String userName;
        boolean flag=false;
        userName=sc.next();
        int i=0;
        while(i<Main.studentArrayList.size()){
            if(userName.equals(Main.studentArrayList.get(i).userName)){
                Main.studentArrayList.remove(i);
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

    public void modifyStudent() {
        System.out.println("----------------------------");
        System.out.println("请输入要修改的用户名:");
        Scanner sc = new Scanner(System.in);
        String userName;
        boolean flag=false;
        userName=sc.next();
        int i=0;
        while(i<Main.studentArrayList.size()){
            if(userName.equals(Main.studentArrayList.get(i).name)){
                System.out.println("----------------------------");
                String newName;
                String newId;
                System.out.println("请输入新姓名:");
                newName=sc.next();
                System.out.println("请输入新学号");
                newId = sc.next();
                Main.studentArrayList.get(i).name=newName;
                Main.studentArrayList.get(i).id=newId;
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

    public void searchStudent() {
        System.out.println("----------------------------");
        System.out.println("请输入要查询的用户名:");
        Scanner sc = new Scanner(System.in);
        String name;
        boolean flag=false;
        name=sc.next();
        int i=0;
        while(i<Main.studentArrayList.size()){
            if(name.equals(Main.studentArrayList.get(i).userName)){
                System.out.println("----------------------------");
                System.out.println("查询结果");
                System.out.println("用户名:"+Main.studentArrayList.get(i).userName);
                System.out.println("姓名:"+Main.studentArrayList.get(i).name);
                System.out.println("学号:"+Main.studentArrayList.get(i).id);
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

    public void studentInfo() {
        System.out.println("----------------------------");
        int i=0;
        while(i<Main.studentArrayList.size()){
            System.out.println("用户名\t\t姓名\t\tid");
            System.out.println(Main.studentArrayList.get(i).userName+"\t\t"+Main.studentArrayList.get(i).name+"\t\t"+Main.studentArrayList.get(i).id);
            i++;
        }
        System.out.println("----------------------------");
    }

    /*
        teacher area
     */
    public void addTeacher() {
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
        Main.teacherArrayList.add(teacher);
        System.out.println("添加成功！");
        System.out.println("----------------------------");
    }

    public void deleteTeacher() {
        System.out.println("----------------------------");
        System.out.println("请输入要删除的用户名");
        Scanner sc = new Scanner(System.in);
        String userName;
        boolean flag=false;
        userName=sc.next();
        int i=0;
        while(i<Main.teacherArrayList.size()){
            if(userName.equals(Main.teacherArrayList.get(i).userName)){
                Main.teacherArrayList.remove(i);
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

    public void modifyTeacher() {
        System.out.println("----------------------------");
        System.out.println("请输入要修改的用户名:");
        Scanner sc = new Scanner(System.in);
        String userName;
        boolean flag=false;
        userName=sc.next();
        int i=0;
        while(i<Main.teacherArrayList.size()){
            if(userName.equals(Main.teacherArrayList.get(i).name)){
                System.out.println("----------------------------");
                String newName;
                System.out.println("请输入新姓名:");
                newName=sc.next();
                Main.teacherArrayList.get(i).name=newName;
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

    public void searchTeacher() {
        System.out.println("----------------------------");
        System.out.println("请输入要查询的用户名:");
        Scanner sc = new Scanner(System.in);
        String name;
        boolean flag=false;
        name=sc.next();
        int i=0;
        while(i<Main.teacherArrayList.size()){
            if(name.equals(Main.teacherArrayList.get(i).userName)){
                System.out.println("----------------------------");
                System.out.println("查询结果");
                System.out.println("用户名:"+Main.teacherArrayList.get(i).userName);
                System.out.println("姓名:"+Main.teacherArrayList.get(i).name);
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

    public void teacherInfo() {
        System.out.println("----------------------------");
        int i=0;
        while(i<Main.teacherArrayList.size()){
            System.out.println("用户名\t\t姓名");
            System.out.println(Main.teacherArrayList.get(i).userName+"\t\t"+Main.teacherArrayList.get(i).name);
            i++;
        }
        System.out.println("----------------------------");
    }

    /*
        course area
     */
    public void addCourse() {
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
        Main.coursesArrayList.add(courses);
        System.out.println("添加成功！");
        System.out.println("----------------------------");
    }

    public void deleteCourse() {
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
        while(i<Main.coursesArrayList.size()){
            if(name.equals(Main.coursesArrayList.get(i).name)&&teacher.equals(Main.coursesArrayList.get(i).teacher)){
                Main.coursesArrayList.remove(i);
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

    public void modifyCourse() {
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
        while(i<Main.coursesArrayList.size()){
            if(name.equals(Main.coursesArrayList.get(i).name)&&teacher.equals(Main.coursesArrayList.get(i).teacher)){
                System.out.println("----------------------------");
                String newName;
                String newTeacher;
                System.out.println("请输入新课程名:");
                newName=sc.next();
                System.out.println("请输入新教师名:");
                newTeacher=sc.next();
                Main.coursesArrayList.get(i).name=newName;
                Main.coursesArrayList.get(i).teacher=newTeacher;
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

    public void searchCourse() {
        System.out.println("----------------------------");
        System.out.println("请输入要查询的课程名:");
        Scanner sc = new Scanner(System.in);
        String name;
        boolean flag=false;
        name=sc.next();
        int i=0;
        while(i<Main.coursesArrayList.size()){
            if(name.equals(Main.coursesArrayList.get(i).name)){
                System.out.println("----------------------------");
                System.out.println("查询结果");
                System.out.println("课程名:"+Main.coursesArrayList.get(i).name);
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

    public void courseInfo() {
        Courses.overview();
    }

    /*
        class area
     */
    public void addClass() {
        System.out.println("----------------------------");
        Class newClass = new Class();
        String name;
        String teacher;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入班级名");
        name=sc.next();
        System.out.println("请输入班主任名");
        teacher=sc.next();
        newClass.name=name;
        newClass.teacher=teacher;
        Main.classArrayList.add(newClass);
        System.out.println("----------------------------");
        int i=0;
        while(i<Main.teacherArrayList.size()){
            if(newClass.teacher.equals(Main.teacherArrayList.get(i).name)){
                Main.teacherArrayList.get(i).ownClasses.add(newClass);
                break;
            }
            i++;
        }
    }

    public void deleteClass() {
        System.out.println("----------------------------");
        System.out.println("请输入要删除的班级名");
        Scanner sc = new Scanner(System.in);
        String name;
        boolean flag=false;
        name=sc.next();
        int i=0;
        while(i<Main.classArrayList.size()){
            if(name.equals(Main.classArrayList.get(i).name)){
                Main.classArrayList.remove(i);
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

    public void modifyClass() {
        System.out.println("----------------------------");
        System.out.println("请输入要修改的班级名:");
        Scanner sc = new Scanner(System.in);
        String name;
        boolean flag=false;
        name=sc.next();
        int i=0;
        while(i<Main.classArrayList.size()){
            if(name.equals(Main.classArrayList.get(i).name)){
                System.out.println("----------------------------");
                String newName;
                String newTeacher;
                System.out.println("请输入新班级名:");
                newName=sc.next();
                System.out.println("请输入新教师名:");
                newTeacher=sc.next();
                Main.classArrayList.get(i).name=newName;
                Main.classArrayList.get(i).teacher=newTeacher;
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

    public void searchClass() {
        System.out.println("----------------------------");
        System.out.println("请输入要查询的班级名:");
        Scanner sc = new Scanner(System.in);
        String name;
        boolean flag=false;
        name=sc.next();
        int i=0;
        while(i<Main.classArrayList.size()){
            if(name.equals(Main.classArrayList.get(i).name)){
                System.out.println("----------------------------");
                System.out.println("查询结果");
                System.out.println("班级名:"+Main.classArrayList.get(i).name);
                System.out.println("所属教师:"+Main.classArrayList.get(i).teacher);
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

    public void classInfo() {
        Class.overview();
    }
}
