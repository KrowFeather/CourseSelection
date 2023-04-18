import java.util.Scanner;

public class Menu {
    Administrator admin = new Administrator();
    Scanner sc = new Scanner(System.in);
    //initialize main menu
    public void initial(){
        int choice;
        preLoad();
        System.out.println("-------欢迎进入选课系统-------");
        System.out.println("1.管理员登录");
        System.out.println("2.学生登录");
        System.out.println("3.教师登录");
        System.out.println("0.退出");
        System.out.println("----------------------------");
        System.out.print("请选择：");
        choice=sc.nextInt();
        checkChoice(choice);
    }

    private void preLoad() {
        int i=0;
        while(i<Main.teacherArrayList.size()){
            int j=0;
            while(j<Main.coursesArrayList.size()) {
                if (Main.coursesArrayList.get(j).teacher.equals(Main.teacherArrayList.get(i).name)&&Teacher.isCourseFound(Main.coursesArrayList.get(j))) {
                    Main.teacherArrayList.get(i).ownCourses.add(Main.coursesArrayList.get(j));
                    break;
                }
                j++;
            }
            j=0;
            while(j<Main.classArrayList.size()) {
                if (Main.classArrayList.get(j).teacher.equals(Main.teacherArrayList.get(i).name)&&Teacher.isClassFound(Main.classArrayList.get(j))) {
                    Main.teacherArrayList.get(i).ownClasses.add(Main.classArrayList.get(j));
                    break;
                }
                j++;
            }
            i++;
        }
    }

    private void checkChoice(int choice){
        boolean check;
        boolean flag=false;
        do {
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    check=admin.login();
                    if(check) {
                        adminMenu();
                    }
                    flag = true;
                    break;
                case 2:
                    check=Student.login();
                    if(check) {
                        studentMenu();
                    }
                    flag = true;
                    break;
                case 3:
                    check=Teacher.login();
                    if(check) {
                        teacherMenu();
                    }
                    flag = true;
                    break;
                default:
                    System.out.println("invalid choice!");
                    choice = sc.nextInt();
            }
        }while(!flag);
        returnMenu();
    }
    private void returnMenu(){
        initial();
    }

    /*
        top menu
     */
    private void adminMenu(){
        int choice;
        System.out.println("----------管理员菜单----------");
        System.out.println("1.学生管理");
        System.out.println("2.教师管理");
        System.out.println("3.班级管理");
        System.out.println("4.课程管理");
        System.out.println("0.退回主菜单");
        System.out.println("----------------------------");
        System.out.print("请选择：");
        choice=sc.nextInt();
        checkAdminChoice(choice);
    }
    private void teacherMenu() {
        int choice;
        System.out.println("-----------教师菜单----------");
        System.out.println("1.选课管理");
        System.out.println("2.查看学生信息");
        System.out.println("3.查看班级信息");
        System.out.println("4.查看个人档案");
        System.out.println("5.修改密码");
        System.out.println("0.退回主菜单");
        System.out.println("----------------------------");
        System.out.print("请选择：");
        choice=sc.nextInt();
        checkTeacherChoice(choice);
    }
    private void studentMenu() {
        int choice;
        System.out.println("-----------学生菜单----------");
        System.out.println("1.选课管理");
        System.out.println("2.查看个人档案");
        System.out.println("3.修改密码");
        System.out.println("0.退回主菜单");
        System.out.println("----------------------------");
        System.out.print("请选择：");
        choice=sc.nextInt();
        checkStudentChoice(choice);
    }

    private void checkStudentChoice(int choice) {
        boolean flag=false;
        do{
            switch (choice){
                case 0:
                    returnMenu();
                    flag=true;
                    break;
                case 1:
                    courseManagerForStudentMenu();
                    flag=true;
                    break;
                case 2:
                    studentSelfBio();
                    flag=true;
                    break;
                case 3:
                    studentChangePwd();
                    flag=true;
                    break;
                default:
                    System.out.println("invalid choice!");
                    choice = sc.nextInt();
                    break;
            }
        }while(!flag);
        System.out.println("输入0返回");
        flag=false;
        do {
            choice = sc.nextInt();
            if (choice == 0) {
                studentMenu();
                flag=true;
            }
            else{
                System.out.println("invalid choice!");
            }
        }while(!flag);
    }

    /*
        student secondary menu
     */
    private void courseManagerForStudentMenu() {
        int choice;
        boolean flag=false;
        Scanner sc =new Scanner(System.in);
        System.out.println("-----------选课管理----------");
        System.out.println("1.新增选课");
        System.out.println("2.删除已选");
        System.out.println("3.查看课程");
        System.out.println("0.退回主菜单");
        System.out.println("----------------------------");
        System.out.println("请选择：");
        choice=sc.nextInt();
        do {
            switch (choice) {
                case 1:
                    Student.addCourses();
                    flag = true;
                    break;
                case 2:
                    Student.deleteCourses();
                    flag = true;
                    break;
                case 3:
                    Student.checkCourses();
                    flag = true;
                    break;
                default:
                    System.out.println("invalid choice!");
                    choice=sc.nextInt();
                    break;
            }
        }while(!flag);
    }

    private void studentSelfBio() {
        Student.selfBio();
    }

    private void studentChangePwd() {
        Student.changePwd();
    }

    /*
        teacher utils
     */
    private void checkTeacherChoice(int choice) {
        boolean flag=false;
        do{
            switch (choice){
                case 0:
                    returnMenu();
                    flag=true;
                    break;
                case 1:
                    courseManagerForTeacherMenu();
                    flag=true;
                    break;
                case 2:
                    studentInfoForTeacher();
                    flag=true;
                    break;
                case 3:
                    classInfoForTeacher();
                    flag=true;
                    break;
                case 4:
                    teacherSelfBio();
                    flag=true;
                    break;
                case 5:
                    teacherChangePwd();
                    flag=true;
                    break;
                default:
                    System.out.println("invalid choice!");
                    choice = sc.nextInt();
                    break;
            }
        }while(!flag);
        System.out.println("输入0返回");
        flag=false;
        do {
            choice = sc.nextInt();
            if (choice == 0) {
                teacherMenu();
                flag=true;
            }
            else{
                System.out.println("invalid choice!");
            }
        }while(!flag);
    }

    /*
        teacher secondary menu
     */
    private void courseManagerForTeacherMenu() {
        Teacher.ownCoursesInfo();
    }
    private void studentInfoForTeacher() {
    }
    private void teacherChangePwd() {
        Teacher.changePwd();
    }

    private void teacherSelfBio() {
        Teacher.selfBio();
    }

    private void classInfoForTeacher() {
        Teacher.ownClassInfo();
    }

    /*
        admin utils
     */
    private void checkAdminChoice(int choice){
        boolean flag=false;
        do{
            switch (choice){
                case 0:
                    returnMenu();
                    flag=true;
                    break;
                case 1:
                    studentManagerMenu();
                    flag=true;
                    break;
                case 2:
                    teacherManagerMenu();
                    flag=true;
                    break;
                case 3:
                    classManagerMenu();
                    flag=true;
                    break;
                case 4:
                    courseManagerMenu();
                    flag=true;
                    break;
                default:
                    System.out.println("invalid choice!");
                    choice = sc.nextInt();
                    break;
            }
        }while(!flag);
        System.out.println("输入0返回");
        flag=false;
        do {
            choice = sc.nextInt();
            if (choice == 0) {
                adminMenu();
                flag=true;
            }
            else{
                System.out.println("invalid choice!");
            }
        }while(!flag);
    }
    private void checkStudentMgrChoice(int choice){
        boolean flag=false;
        do{
            switch (choice){
                case 0:
                    returnAdminMenu();
                    flag=true;
                    break;
                case 1:
                    admin.addStudent();
                    flag=true;
                    break;
                case 2:
                    admin.deleteStudent();
                    flag=true;
                    break;
                case 3:
                    admin.modifyStudent();
                    flag=true;
                    break;
                case 4:
                    admin.searchStudent();
                    flag=true;
                    break;
                case 5:
                    admin.studentInfo();
                default:
                    System.out.println("invalid choice!");
                    choice = sc.nextInt();
                    break;
            }
        }while(!flag);
    }
    private void checkTeacherMgrChoice(int choice) {
        boolean flag=false;
        do{
            switch (choice){
                case 0:
                    returnAdminMenu();
                    flag=true;
                    break;
                case 1:
                    admin.addTeacher();
                    flag=true;
                    break;
                case 2:
                    admin.deleteTeacher();
                    flag=true;
                    break;
                case 3:
                    admin.modifyTeacher();
                    flag=true;
                    break;
                case 4:
                    admin.searchTeacher();
                    flag=true;
                    break;
                case 5:
                    admin.teacherInfo();
                default:
                    System.out.println("invalid choice!");
                    choice = sc.nextInt();
                    break;
            }
        }while(!flag);
    }
    private void checkCourseMgrChoice(int choice) {
        boolean flag=false;
        do{
            switch (choice){
                case 0:
                    returnAdminMenu();
                    flag=true;
                    break;
                case 1:
                    admin.addCourse();
                    flag=true;
                    break;
                case 2:
                    admin.deleteCourse();
                    flag=true;
                    break;
                case 3:
                    admin.modifyCourse();
                    flag=true;
                    break;
                case 4:
                    admin.searchCourse();
                    flag=true;
                    break;
                case 5:
                    admin.courseInfo();
                default:
                    System.out.println("invalid choice!");
                    choice = sc.nextInt();
                    break;
            }
        }while(!flag);
    }
    private void checkClassMgrChoice(int choice) {
        boolean flag=false;
        do{
            switch (choice){
                case 0:
                    returnAdminMenu();
                    flag=true;
                    break;
                case 1:
                    admin.addClass();
                    flag=true;
                    break;
                case 2:
                    admin.deleteClass();
                    flag=true;
                    break;
                case 3:
                    admin.modifyClass();
                    flag=true;
                    break;
                case 4:
                    admin.searchClass();
                    flag=true;
                    break;
                case 5:
                    admin.classInfo();
                default:
                    System.out.println("invalid choice!");
                    choice = sc.nextInt();
                    break;
            }
        }while(!flag);
    }
    private void returnAdminMenu(){
        adminMenu();
    }

    /*
        admin secondary menu
     */
    private void classManagerMenu() {
        int choice;
        System.out.println("-----------班级管理-----------");
        System.out.println("1.新增");
        System.out.println("2.删除");
        System.out.println("3.修改");
        System.out.println("4.查询");
        System.out.println("5.查看");
        System.out.println("0.返回");
        System.out.println("----------------------------");
        System.out.println("请选择：");
        choice = sc.nextInt();
        checkClassMgrChoice(choice);
    }
    private void courseManagerMenu() {
        int choice;
        System.out.println("-----------课程管理-----------");
        System.out.println("1.新增");
        System.out.println("2.删除");
        System.out.println("3.修改");
        System.out.println("4.查询");
        System.out.println("5.查看");
        System.out.println("0.返回");
        System.out.println("----------------------------");
        System.out.println("请选择：");
        choice = sc.nextInt();
        checkCourseMgrChoice(choice);
    }
    private void teacherManagerMenu() {
        int choice;
        System.out.println("-----------教师管理-----------");
        System.out.println("1.新增");
        System.out.println("2.删除");
        System.out.println("3.修改");
        System.out.println("4.查询");
        System.out.println("5.查看");
        System.out.println("0.返回");
        System.out.println("----------------------------");
        System.out.println("请选择：");
        choice = sc.nextInt();
        checkTeacherMgrChoice(choice);
    }
    private void studentManagerMenu() {
        int choice;
        System.out.println("-----------学生管理-----------");
        System.out.println("1.新增");
        System.out.println("2.删除");
        System.out.println("3.修改");
        System.out.println("4.查询");
        System.out.println("5.查看");
        System.out.println("0.返回");
        System.out.println("----------------------------");
        System.out.println("请选择：");
        choice = sc.nextInt();
        checkStudentMgrChoice(choice);
    }
}
