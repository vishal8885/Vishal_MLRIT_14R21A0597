
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		//You may test that your code works find here
		//Please check that your code works and has no 
		//compilation problems before to submit
                StudentGroup sg=new StudentGroup(3);
                sg.add(new Student(501,"vishal",new Date(),58));
                sg.add(new Student(501,"yugg",new Date(),58));
                sg.addFirst(new Student(501,"hjsdf",new Date(),58));
                Student[] s=sg.getStudents();
                
            for (Student item : s) {
                System.out.println(item.getFullName()+" "+item.getBirthDate());
            }
            sg.addLast(new Student(501,"ihdfidfgudh",new Date(),58));
            sg.bubbleSort();
            s=sg.getByBirthDate(new Date());
             
            for (Student item : s) {
                System.out.println(item.getFullName());
            }
	}

}
