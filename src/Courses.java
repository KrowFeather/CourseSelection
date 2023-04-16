public class Courses {
    public String name;
    public String teacher;
    public int stuNumber;

    public static void overview(){
        System.out.println("----------------------------");
        int i=0;
        while(i<Main.coursesArrayList.size()){
            System.out.println("名称\t\t教师\t\t已选人数");
            System.out.println(Main.coursesArrayList.get(i).name+"\t\t"+Main.coursesArrayList.get(i).teacher+"\t\t"+Main.coursesArrayList.get(i).stuNumber);
            i++;
        }
        System.out.println("----------------------------");
    }
}
