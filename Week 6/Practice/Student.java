class Student {

    // Instance variables
    String name;
    double attendance;

    // Static variables
    static String collegeName =
            "SRM Institute of Science and Technology";

    static int studentCount = 0;

    // Constructor
    Student(String name, double attendance) {

        this.name = name;
        this.attendance = attendance;

        // Increase count whenever object is created
        studentCount++;
    }

    // Static method
    static void printCollegeInfo() {

        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {

        // Create two Student objects
        Student s1 = new Student("Ravi", 90);
        Student s2 = new Student("Anitha", 95);

        // Call static method using class name
        Student.printCollegeInfo();
    }
}