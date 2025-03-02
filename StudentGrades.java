/*teacher to enter students' grades and compute their average,
highest, and lowest scores. Using array*/
/*Code create by manoj mali */
import java.util.Scanner;

public class StudentGrades{
    public static void main(String[] args) {
        //main function start
        Scanner obj= new Scanner(System.in);/*obj is the object of the scanner class*/
         
        // Taking input for the number of students
        System.out.print("Enter the number of students: ");
        int numStudents = obj.nextInt();
        
        // Creating an array to store grades
        int[] grades = new int[numStudents];
        
        // Input grades
        System.out.println("Enter the grades of the students:");
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            grades[i] = obj.nextInt();
        }
        
        // Calculate highest, lowest, and average score
        int highest = grades[0];
        int lowest = grades[0];
        int sum = grades[0];
        
        for (int i = 1; i < numStudents; i++) {// for loop start
            if (grades[i] > highest) {
                highest = grades[i];
            }
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
            sum += grades[i];
        }//for loop end
        
        double average = (double) sum / numStudents;//using formula's
        
        // Display results
        System.out.println("\nResults:");
        System.out.println("Average Grade: " + average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        
        obj.close();
    }//end of main function
}/*End of the code */
