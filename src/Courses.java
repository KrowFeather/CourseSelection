import java.util.ArrayList;
public class Courses{
    public String name;
    public String teacher;
    public int stuNumber;

    public void overview(ArrayList<Courses> coursesArrayList){
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
