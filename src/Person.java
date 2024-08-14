import java.util.Calendar;
import java.util.Date;

public class Person {
    private String ID;
    private String firstName;
    private String lastName;
    private String title;
    private int yob;


    public Person (String ID, String firstName, String lastName, String title, int yob){
        this.setID(ID);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setTitle(title);
        this.setYOB(yob);
    }
    //Getter and Setter Methods for ID
    public String getID(){
        return ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    //Getter and Setter Methods for firstName
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    //Getter and Setter Methods for lastName
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    //Getter and Setter Methods for title
    public String getTitle(){
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    //Getter and Setter Methods for yob
    public int getYOB(){
        return yob;
    }
    public void setYOB(int yob){
        this.yob = yob;
    }
    // Additional Methods
    public String fullName(){ // METHOD TO GET FULL NAME
        return firstName + " " + lastName;
    }
    public String getFormalName(){ // METHOD TO GET FORMAL NAME
        return title + " " + fullName();
    }
    public String getAge(){ // not sure if this method is what is needed...
        int age = 2024 - yob;
        String value = Integer.toString(age);

        return value;
    }
    // public String getAge(int year) uses YOB to calculate age for a specified year
    //use the Calendar object to do these. Requires a bit of a web search.
    public String getAge(int year){ //This method finds the age of the person at any given
                                    // "year" using their yob.
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);

        int specifiedYear = cal.get(Calendar.YEAR);

        int age = specifiedYear - this.yob;

        if (age < 0) {
            return "Not born yet";
        } else {
        return String.valueOf(age);
        }
    }

    public String toCSVDataRecord(){ //METHOD TO WRITE A STRING THAT CAN BE USED TO WRITE INTO A CSV FILE
        String personRecord = "";

        personRecord = getID() + "," + getFirstName() + "," + getLastName() + "," + getTitle() + "," + getYOB();
        //When you concat an integer type,(getYOB) it converts it into a String.

        return personRecord;
    }



} //This is the end of the Person Class.
