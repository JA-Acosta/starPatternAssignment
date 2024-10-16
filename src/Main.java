/* Programmer: JAAR
*  Assignment Chapter 5: Question 7
*  Date modified: 10/15/2024
*  IDE/Tool used: IntelliJ
*/

// Generates a program that creates a star pattern.
import java.io.*;
import java.util.Scanner;

public class Main {
    // Size parameters for the star shape:
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 15;

    public static void main(String[] args) {
        // TODO: Ask about why I needed the try catch and it won't let me just
        // TODO: use the PrintWriter without the error catching
        int star;
        try {
            PrintWriter outputFile = new PrintWriter("stars.txt");

            star = starSize();
            // Prints the stars:
            printCopy(outputFile, star);
            outputFile.close(); // Close the file to prevent memory leak.
        } catch (FileNotFoundException  e) {
            e.printStackTrace();
        }

        System.out.println("Your art was saved! (stars.txt)");
    }

    // Asks the user to enter a size for the star pattern.
    // Return:
    //  int star: the size for the pattern.
    public static int starSize() {
        Scanner input = new Scanner(System.in);
        int star = 0;
        do {
            System.out.printf("Enter the number between %d and %d and I'll " +
                    "draw a star pattern based on it: ", MINIMUM, MAXIMUM );
            star = input.nextInt();
            input.nextLine(); // Clears the input stream.
            if ((star <= MINIMUM || MAXIMUM < star)) {
                System.out.println("Your input was invalid!");
            } // Error Message if input wasn't valid
        } while (star <= MINIMUM || MAXIMUM < star);
        return star;
    }

    // Prints out and saves a copy of the star pattern
    public static void printCopy(PrintWriter outputFile, int star) {
        for (int i = 0; i < star; i++){
            System.out.println();
            outputFile.println();
            for (int j = star; i < j; j--){
                System.out.print("*");
                outputFile.print("*");
            }
        }
    }
}