public class Student
{
    private String name;
    private String address;
    private String[] courses;
    private int[] grades;
    private int numCourses;
    private static final int MAX_COURSES = 30;

    public Student(String name, String address)
    {
        this.name = name;
        this.address = address;
        courses = new String[MAX_COURSES];
        grades = new int[MAX_COURSES];
        numCourses = 0;
    }

    public String getName()
    {
        return this.name;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String toString()
    {
        return name + "(" + address + ")";
    }

    public void addCourseGrade(String course, int grade)
    {
        courses[numCourses] = course;
        grades[numCourses] = grade;
        ++numCourses;
    }

    public void printGrades()
    {
        System.out.println(name);
        for (int i = 0; i<numCourses; ++i)
        {
            System.out.println(" " + courses[i] + ":" + grades[i]);
        }
        System.out.println();
    }

    public double getAverageGrade()
    {
        int sum = 0;
        for (int i = 0; i<numCourses; ++i)
        {
            sum += grades[i];
        }
        return (double) sum/numCourses;
    }
}