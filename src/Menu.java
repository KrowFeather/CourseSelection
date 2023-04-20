import java.util.Scanner;

public class Menu extends CourseSelectionSystem{
    //initialize main menu
    public void initial(){
        Scanner sc = new Scanner(System.in);
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
        while(i<teacherArrayList.size()){
            int j=0;
            while(j<coursesArrayList.size()) {
                if (coursesArrayList.get(j).teacher.equals(teacherArrayList.get(i).name)&&teacherArrayList.get(0).isCourseFound(coursesArrayList.get(j),teacherArrayList)) {
                    teacherArrayList.get(i).ownCourses.add(coursesArrayList.get(j));
                    break;
                }
                j++;
            }
            j=0;
            while(j< schoolClassArrayList.size()) {
                if (schoolClassArrayList.get(j).teacher.equals(teacherArrayList.get(i).name)&&teacherArrayList.get(0).isClassFound(schoolClassArrayList.get(j),teacherArrayList)) {
                    teacherArrayList.get(i).ownSchoolClasses.add(schoolClassArrayList.get(j));
                    break;
                }
                j++;
            }
            i++;
        }
    }

    private void checkChoice(int choice){
        Scanner sc = new Scanner(System.in);
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
                    check=studentArrayList.get(0).login(studentArrayList);
                    if(check) {
                        studentMenu();
                    }
                    flag = true;
                    break;
                case 3:
                    check=teacherArrayList.get(0).login(teacherArrayList);
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
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean flag=false;
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
                    thisStudent.addCourses(coursesArrayList);
                    flag = true;
                    break;
                case 2:
                    thisStudent.deleteCourses();
                    flag = true;
                    break;
                case 3:
                    thisStudent.checkCourses(coursesArrayList);
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
        thisStudent.selfBio();
    }

    private void studentChangePwd() {
        thisStudent.changePwd();
    }

    /*
        teacher utils
     */
    private void checkTeacherChoice(int choice) {
        Scanner sc = new Scanner(System.in);
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
        thisTeacher.ownCoursesInfo();
    }
    private void studentInfoForTeacher() {
    }
    private void teacherChangePwd() {
        thisTeacher.changePwd();
    }

    private void teacherSelfBio() {

    }

    private void classInfoForTeacher() {
        thisTeacher.ownClassInfo();
    }

    /*
        admin utils
     */
    private void checkAdminChoice(int choice){
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
        boolean flag=false;
        do{
            switch (choice){
                case 0:
                    returnAdminMenu();
                    flag=true;
                    break;
                case 1:
                    admin.addStudent(studentArrayList);
                    flag=true;
                    break;
                case 2:
                    admin.deleteStudent(studentArrayList);
                    flag=true;
                    break;
                case 3:
                    admin.modifyStudent(studentArrayList);
                    flag=true;
                    break;
                case 4:
                    admin.searchStudent(studentArrayList);
                    flag=true;
                    break;
                case 5:
                    admin.studentInfo(studentArrayList);
                default:
                    System.out.println("invalid choice!");
                    choice = sc.nextInt();
                    break;
            }
        }while(!flag);
    }
    private void checkTeacherMgrChoice(int choice) {
        Scanner sc = new Scanner(System.in);
        boolean flag=false;
        do{
            switch (choice){
                case 0:
                    returnAdminMenu();
                    flag=true;
                    break;
                case 1:
                    admin.addTeacher(teacherArrayList);
                    flag=true;
                    break;
                case 2:
                    admin.deleteTeacher(teacherArrayList);
                    flag=true;
                    break;
                case 3:
                    admin.modifyTeacher(teacherArrayList);
                    flag=true;
                    break;
                case 4:
                    admin.searchTeacher(teacherArrayList);
                    flag=true;
                    break;
                case 5:
                    admin.teacherInfo(teacherArrayList);
                default:
                    System.out.println("invalid choice!");
                    choice = sc.nextInt();
                    break;
            }
        }while(!flag);
    }
    private void checkCourseMgrChoice(int choice) {
        Scanner sc = new Scanner(System.in);
        boolean flag=false;
        do{
            switch (choice){
                case 0:
                    returnAdminMenu();
                    flag=true;
                    break;
                case 1:
                    admin.addCourse(coursesArrayList);
                    flag=true;
                    break;
                case 2:
                    admin.deleteCourse(coursesArrayList);
                    flag=true;
                    break;
                case 3:
                    admin.modifyCourse(coursesArrayList);
                    flag=true;
                    break;
                case 4:
                    admin.searchCourse(coursesArrayList);
                    flag=true;
                    break;
                case 5:
                    admin.courseInfo(coursesArrayList);
                default:
                    System.out.println("invalid choice!");
                    choice = sc.nextInt();
                    break;
            }
        }while(!flag);
    }
    private void checkClassMgrChoice(int choice) {
        Scanner sc = new Scanner(System.in);
        boolean flag=false;
        do{
            switch (choice){
                case 0:
                    returnAdminMenu();
                    flag=true;
                    break;
                case 1:
                    admin.addClass(teacherArrayList,schoolClassArrayList);
                    flag=true;
                    break;
                case 2:
                    admin.deleteClass(schoolClassArrayList);
                    flag=true;
                    break;
                case 3:
                    admin.modifyClass(schoolClassArrayList);
                    flag=true;
                    break;
                case 4:
                    admin.searchClass(schoolClassArrayList);
                    flag=true;
                    break;
                case 5:
                    admin.classInfo(schoolClassArrayList);
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
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
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
