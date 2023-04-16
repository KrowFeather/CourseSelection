public class Class {
    public String name;
    public String teacher;
    public static void overview(){
        System.out.println("----------------------------");
        int i=0;
        while(i<Main.classArrayList.size()){
            System.out.println("名称\t\t教师");
            System.out.println(Main.classArrayList.get(i).name+"\t\t"+Main.classArrayList.get(i).teacher);
            i++;
        }
        System.out.println("----------------------------");
    }
}
