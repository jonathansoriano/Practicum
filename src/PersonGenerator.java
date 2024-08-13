import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    private static ArrayList<String> folks = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Scanner is needed to get input from user
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int yearOfBirth = 0;
        String personRec = ""; // Needed to put the person's info in CSV format, which then we add to the ArrayLists
        String nameOfFile = "";
        boolean done = false; // Needed to repeat or end loop.

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits] ");
            firstName = SafeInput.getNonZeroLenString(in, "Enter the firstname ");
            lastName = SafeInput.getNonZeroLenString(in, "Enter the lastname ");
            title = SafeInput.getNonZeroLenString(in, "Enter the title ");
            yearOfBirth = SafeInput.getRangedInt(in, "Enter the year of birth ", 1000, 9999); // Need at least 4 digits for YOB

            personRec = ID + "," + firstName + "," + lastName + "," + title + "," + yearOfBirth; // yearOfBirth will convert to String since we are concatenating
                                                                                                    // the values to one String with commas.
            folks.add(personRec); // adding concat String of values to ArrayList

            done = SafeInput.getYNConfirm(in, "Are you done? "); // Asking if we are done adding people's info to ArrayList
        }while(!done);

        /* for (int i = 0; i < folks.size(); i++) // This is the regular for loop. Starts with 0 index and since it's a List
                                                 // we do ".size()" method instead of ".length()".
            System.out.println(folks.get(i)); // Printing out all the values in ArrayList
        */


        for (String p : folks) { // For Each Loop
            System.out.println(p); // p represents item in the "folks" ArrayList
        }



        try
        {
            nameOfFile = SafeInput.getNonZeroLenString(in, "Enter the name of your file ");
            createFile(nameOfFile);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    } // End of main Method

    private static void createFile(String filename) throws IOException {
        FileWriter myWriter = new FileWriter(filename + ".txt");

        for(String line : folks){
            myWriter.write(line + "\n");
        }
        myWriter.close();
        System.out.println("Created and wrote to the file!");
    }


}
