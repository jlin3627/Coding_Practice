// Compile Directions: javac TestStudent.java
// Run direction: java TestStudent

public class TestStudent 
{
    public static void main(String[] args)
    {
        Student stA = new Student("abc", "100 New York");
        System.out.println(stA);

        stA.setAddress("200 New York");
        System.out.println(stA);
        System.out.println(stA.getName());
        System.out.println(stA.getAddress());

        stA.addCourseGrade("mat100", 80);
        stA.addCourseGrade("mat200", 78);
        stA.addCourseGrade("psy300", 33);
        stA.printGrades();
        System.out.printf("The average grade is %.2f%n", stA.getAverageGrade());
    }
}
