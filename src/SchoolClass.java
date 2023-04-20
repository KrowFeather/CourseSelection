import java.util.ArrayList;

public class SchoolClass{
    public String name;
    public String teacher;
    public void overview(ArrayList<SchoolClass> schoolClassArrayList){
        System.out.println("----------------------------");
        int i=0;
        while(i<schoolClassArrayList.size()){
            System.out.println("名称\t\t教师");
            System.out.println(schoolClassArrayList.get(i).name+"\t\t"+schoolClassArrayList.get(i).teacher);
            i++;
        }
        System.out.println("----------------------------");
    }
}
