package StudentManagement.mainapp;

import StudentManagement.models.Course;
import StudentManagement.models.Student;
import java.util.Scanner;

public class Main {

    private static Student[] students = new Student[100];
    private static int studentCount = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice = 0;

        while(choice != 5){

            System.out.println("Student Management System");
            System.out.println("1. Enroll Student");
            System.out.println("2. List Students");
            System.out.println("3. Search Student");
            System.out.println("4. Sort Students");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    String ID = sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String Name = sc.nextLine();

                    students[studentCount] = new Student(ID, Name);
                    studentCount++;

                    System.out.println("Student enrolled successfully");

                    break;

                case 2:

                    if (studentCount == 0) {
                        System.out.println("No students enrolled");
                    } 
                    else {
                        System.out.println("Student List: ");

                        for (int i = 0; i < studentCount; i++) {
                            System.out.println(students[i]);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    String STID = sc.nextLine();

                    Student result = searchStudents(STID);

                    if(result != null){
                        System.out.println("Student found:");
                        System.out.println(result);
                    }
                    else{
                        System.out.println("Student not found");
                    }
                    break;

                case 4:

                    sortStudentsByName(students, studentCount);

                    System.out.println("Students sorted successfully");

                break;


                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        }

    }

    /**
    * Searches for a student using the student ID.
    *
    * @param id the student ID to search for
    * @return the matching student object, or null if not found
    */
    public static Student searchStudents(String id) {

    for (int i = 0; i < studentCount; i++) {

        if (id.equals(students[i].getId())) {
            return students[i];
        }

    }

    return null;
}

    /**
    * Sorts students alphabetically by name using bubble sort.
    *
    * @param list the array of students
    * @param count the number of students in the array
    */
    public static void sortStudentsByName(Student[] list, int count) {

        for (int i = 0; i < count - 1; i++) {

         for (int j = 0; j < count - i - 1; j++) {

                if (list[j].getName().compareToIgnoreCase(list[j + 1].getName()) > 0) {

                    Student temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;

             }
            }
        }
    }

}