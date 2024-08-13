import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    private static ArrayList<String> products = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Scanner is necessary to get input from user
        String ID = "";
        String name = "";
        String description = "";
        double cost = 0.0;
        String productRec = ""; // Needed to put the person's info in CSV format, which then we add to the ArrayLists
        String nameOfFile = "";
        boolean done = false; // Needed to repeat or end loop.

        while(!done){
            ID = SafeInput.getNonZeroLenString(in, "Enter an ID [6 digits] ");
            name = SafeInput.getNonZeroLenString(in, "Enter a name ");
            description = SafeInput.getNonZeroLenString(in, "Enter a description of the item ");
            cost = SafeInput.getDouble(in, "Enter the cost of the item ");

            productRec = ID + "," + name + "," + description + "," + cost ;
            products.add(productRec);
            done = SafeInput.getYNConfirm(in, "Are you done? ");
        }

        for (String i : products){
            System.out.println(i);
        }
        nameOfFile = SafeInput.getNonZeroLenString(in, "Enter the name of your file ");

        try
        {

            createFile(nameOfFile);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }







    } // End of main Method
    private static void createFile(String filename) throws IOException {
        FileWriter myWriter = new FileWriter(filename + ".txt");

        for(String line : products){
            myWriter.write(line + "\n");
        }
        myWriter.close();
        System.out.println("Created and wrote to the file!");
    }
}
