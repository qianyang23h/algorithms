import java.util.Arrays;
import java.util.Comparator;


public class MyComparator {
    
    public static class Student{
        public String name;
        public int age;
        public int id;

        public Student(String name, int id, int age){
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }
    
    public static class IdAscendingComparator implements Comparator<Student>{

        // 返回负数的时候，第一个参数在前面
        // 返回正数的时候，第一个参数在后面
        // 返回0的时候，谁在前面无所谓（两个数相等）
        @Override
        public int compare(Student o1, Student o2){
            return o1.id - o2.id;
        }
    }
    

    public static class IdDecendingComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2){
            return o2.id - o1.id;
        }
    }

    public static class AgeAscendingIdAscendingComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2){
            return o1.age != o2.age ? (o1.age - o2.age) : (o1.id - o2.id);
        }
    }

    public static void printStudents(Student[] students){
        for(Student student : students){
            System.out.println("Name:" + student.name + " " +"Id:" + student.id + " " + "age:" + student.age);
        }
    }

    public static void printArr(int[] arr){
        if(arr == null){
            return;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        Student student1 = new Student("A", 1, 20);
        Student student2 = new Student("B", 2, 22);
        Student student3 = new Student("C", 3, 10);

       
        Student[] students = new Student[]{student1, student2, student3};

        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);
        System.out.println("============================");

        Arrays.sort(students, new IdDecendingComparator());
        printStudents(students);
        System.out.println("============================");

        Arrays.sort(students, new AgeAscendingIdAscendingComparator());
        printStudents(students);
        System.out.println("============================");


    }

}
