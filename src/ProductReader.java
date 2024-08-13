import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir"));
        File selectedFile;
        String records = "";
        String ID = "";
        String name = "";
        String description = "";
        double cost = 0.0;
        final int FIELDS_LENGTH = 4;
        ArrayList<String> lines = new ArrayList<>();

        chooser.setCurrentDirectory(workingDirectory);

        try{
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                while(reader.ready()){
                    records = reader.readLine(); // Records is what is inside the file being opened.
                                                // reader.readline() does the reading of the file.
                    lines.add(records); // the records that are being read are also being added to an ArrayList we made called "lines".
                                        // Once all the lines are read, the while loop will stop.
                }
                reader.close(); // Have to make sure we close the reader this way.
                System.out.println("\nData file has been read!"); // Little message stating that the reading process is done.

                // Now process the lines in the arrayList
                // Split the line into the fields by using split with a comma
                // use trim to remove leading and trailing spaces
                // Numbers need to be converted back to numeric values. Here only
                // the last field year of birth yob is an int the rest are strings.

                // Placed columns outside for loop, so it doesn't get printed multiple times.
                System.out.printf("\n%-8s%-25s%-25s%2s", "ID#", "Name", "Description", "Cost"); // Formated Columns
                System.out.printf("\n==================================================================");

                //Create a new Array. This Array will get rid of the commas and trailing/leading spaces

                String[] fields;

                for (String l : lines){
                    fields = l.split(","); // Splits the record into the fields

                    if(fields.length == FIELDS_LENGTH){
                        ID = fields[0].trim();
                        name = fields[1].trim();
                        description = fields[2].trim();
                        cost = Double.parseDouble(fields[3].trim());

                        System.out.printf("\n%-8s%-25s%-25s%.2f", ID, name, description, cost); //%.2f (rounded to the nearest tenth) f is used for floats or doubles to format.
                    } else {
                        System.out.println("Found a record that may be corrupted: ");
                        System.out.println(l);
                    }
                }




            }else {  // user closed the file dialog without choosing
                System.out.println("Failed to choose a file to process");
                System.out.println("Run the program again!");
                System.exit(0);
            }

        }catch (FileNotFoundException e){
            System.out.println("File not found!");
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }



    }
}
