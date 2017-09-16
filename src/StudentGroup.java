
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/**
 * A fix-sized array of students array length should always be equal to the
 * number of stored elements after the element was removed the size of the array
 * should be equal to the number of stored elements after the element was added
 * the size of the array should be equal to the number of stored elements null
 * elements are not allowed to be stored in the array
 *
 * You may add new methods, fields to this class, but DO NOT RENAME any given
 * class, interface or method DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

    private Student[] students;
    private static ArrayList<Student> al;
    private static ArrayList<Student> te;
    /**
     * DO NOT remove or change this constructor, it will be used during task
     * check
     *
     * @param length
     */
    public StudentGroup(int length) {
        this.students = new Student[length];
        al=new ArrayList<Student>(length);
        te=new ArrayList<Student>();
        
    }

    @Override
    public Student[] getStudents() {
        // Add your implementation here
        
        this.students=al.toArray(students);
        return students;
    }

    @Override
    public void setStudents(Student[] students) {
        // Add your implementation here
        if (students == null) {
            throw new IllegalArgumentException();
        }
        Student temp;
        for (int i = 0; i < students.length; i++) {
            temp=students[i];
            temp.setId(students[i].getId());
            temp.setFullName(students[i].getFullName());
            temp.setBirthDate(students[i].getBirthDate());
            temp.setAvgMark(students[i].getAvgMark());
            al.add(temp);
        }
       
    }

    @Override
    public Student getStudent(int index) {
        // Add your implementation here
        if (index < 0 || index >al.size()) {
            throw new IllegalArgumentException();
        }
        return al.get(index);
    }

    @Override
    public void setStudent(Student student, int index) {
        // Add your implementation here
        if (student == null) {
            throw new IllegalArgumentException();
        }
        if (index < 0 || index >al.size()) {
            throw new IllegalArgumentException();
        }
        al.set(index, student);

    }
    public void add(Student student) {
        // Add your implementation here
        al.add(student);
    }
    @Override
    public void addFirst(Student student) {
        // Add your implementation here
        if (student == null) {
            throw new IllegalArgumentException();
        }
        
        al.add(0, student);
    }

    @Override
    public void addLast(Student student) {
        // Add your implementation here
        if (student == null) {
            throw new IllegalArgumentException();
        }
        al.add(student);
    }

    @Override
    public void add(Student student, int index) {
        // Add your implementation here
        if (student == null) {
            throw new IllegalArgumentException();
        }
        if (index < 0 || index >= al.size()) {
            throw new IllegalArgumentException();
        }
        al.add(index, student);
    }

    @Override
    public void remove(int index) {
        // Add your implementation here
        if (index < 0 || index > al.size()) {
            throw new IllegalArgumentException();
        }
        al.remove(index);
    }

    @Override
    public void remove(Student student) {
        // Add your implementation here
        if (student == null) {
            throw new IllegalArgumentException("Student not exist");
        }
        al.remove(student);
    }

    @Override
    public void removeFromIndex(int index) {
        // Add your implementation here
        if (index < 0 || index >al.size()) {
            throw new IllegalArgumentException();
        }
        for(int i=index+1;i<al.size();i++){
            al.remove(i);
        }
        
    }

    @Override
    public void removeFromElement(Student student) {
        // Add your implementation here
        if (student == null) {
            throw new IllegalArgumentException("Student not exist");
        }
        for(int i=0;i<this.students.length;i++){
            if(this.students[i].compareTo(student)==0){
                for(int j=i+1;j<al.size();j++)
                    al.remove(this.students[j]);
                return;
            }
        }
        
    }

    @Override
    public void removeToIndex(int index) {
        // Add your implementation here
        if (index < 0 || index >al.size()) {
            throw new IllegalArgumentException();
        }
        for(int i=0;i<al.size();i++){
            al.remove(i);
        }
    }

    @Override
    public void removeToElement(Student student) {
        // Add your implementation here
        if (student == null) {
            throw new IllegalArgumentException();
        }
        for(int i=0;i<al.size();i++){
            if(al.get(i).compareTo(student)==0){
                break;
            }
            al.remove(i);
             
        }
        
    }

    @Override
    public void bubbleSort() {
        // Add your implementation here
        Collections.sort(al);
        
        
    }

    @Override
    public Student[] getByBirthDate(Date date) {
        // Add your implementation here
        if (date == null) {
            throw new IllegalArgumentException();
        }
        for(int i=0;i<al.size();i++){
            if(!al.get(i).getBirthDate().after(date))
                te.add(al.get(i));
             
        }
        students=(Student[])te.toArray(students);
        return students;
    }

    @Override
    public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
        // Add your implementation here
        if (firstDate == null) {
            throw new IllegalArgumentException();
        }
        if (lastDate == null) {
            throw new IllegalArgumentException();
        }
        te.clear();
        for(int i=0;i<al.size();i++){
            if(al.get(i).getBirthDate().after(lastDate) && al.get(i).getBirthDate().before(firstDate)){
                
            }
             
            else 
                te.add(al.get(i));
        }
        students=(Student[])te.toArray(students);
        return students;
    }

    @Override
    public Student[] getNearBirthDate(Date date, int days) {
        // Add your implementation here
        if (date == null) {
            throw new IllegalArgumentException();
        }
        te.clear();
        for(int i=0;i<al.size();i++){
            if(al.get(i).getBirthDate().compareTo(date)>days)
                te.add(al.get(i));
        }
        students=(Student[])te.toArray(students);
        return students;
    }

    @Override
    public int getCurrentAgeByDate(int indexOfStudent) {
        // Add your implementation here
        if(indexOfStudent==0)
            throw new IllegalArgumentException();
        return calculateAge(al.get(indexOfStudent+1).getBirthDate());
    }
    
    public static int calculateAge(Date birthdate) {
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthdate);
        Calendar today = Calendar.getInstance();

        int yearDifference = today.get(Calendar.YEAR)
                - birth.get(Calendar.YEAR);

        if (today.get(Calendar.MONTH) < birth.get(Calendar.MONTH)) {
            yearDifference--;
        } else {
            if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)
                    && today.get(Calendar.DAY_OF_MONTH) < birth
                            .get(Calendar.DAY_OF_MONTH)) {
                yearDifference--;
            }

        }

        return yearDifference;
    }

    @Override
    public Student[] getStudentsByAge(int age) {
        // Add your implementation here
        te.clear();
        for(int i=0;i<al.size();i++){
            if(calculateAge(al.get(i).getBirthDate())==age)
                te.add(al.get(i));
        }
        students=(Student[])te.toArray(students);
        return students;
    }

    @Override
    public Student[] getStudentsWithMaxAvgMark() {
        // Add your implementation here
        double max= al.get(0).getAvgMark();
        for(int i=1;i<al.size();i++){
            if(al.get(i).getAvgMark()>max){
                max= al.get(i).getAvgMark();
            }
        }
        te.clear();
        for(int i=0;i<al.size();i++){
            if(al.get(i).getAvgMark()>=max){
               te.add(al.get(i));
            }
        }
        students=(Student[])te.toArray(students);
        return students;
    }

    @Override
    public Student getNextStudent(Student student) {
        // Add your implementation here
        if(student==null)
            throw new IllegalArgumentException();
        for(int i=0;i<al.size();i++){
            if(al.get(i).compareTo(student)==0){
               return al.get(i+1);
            }
        }
        return null;
    }
}
