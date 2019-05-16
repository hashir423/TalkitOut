
/**
 * 
 * This is a controller class that consists of the user interface and handles object creation of student and volunteer. 
 * It also consists of the matching algorithm that matches students and volunteer.
 * It creates objects, reads and writes to file all registered details
 * It has a user interface with welcome, registeration, login and booking
 *
 * @Hashir,Kripa,Neil
 * @version 26/03/2019
 */
import java.util.ArrayList;
import java.lang.Math.*;
import javax.swing.*;
import java.util.Collections;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TalkItOut
{
    // Defining variables and ArrayList of objects and filenames
    private double languageScore;
    private double interestScore;
    private double matchScore;
    private double ageScore;
    private ArrayList<student> studentList;
    private ArrayList<volunteer> volunteerList;
    private ArrayList<Double> matchScoreList;
    public static final String studentFNAME = "studentlist.txt";
    public static final String volunteerFNAME = "volunteerlist.txt";

    /**
     * Constructor for objects of class TalkItOut. 
     * Reads from file and loads objects and displays userinterface
     */
    public TalkItOut()
    {
        studentList = new ArrayList<student>();
        volunteerList = new ArrayList<volunteer>();
        matchScoreList = new ArrayList<Double>();
        enterReadFromFile();
        userInterface();
    }

    /**
     * Method to create a student by invoking the constructor of student class and storing the student object into an arraylist
     *
     * @param userNameField     Name of the student of type JTextField
     * @param userStudentIDField    ID of the student of type JTextField
     * @param userEmailField    Email id of the student of type JTextField
     * @param userBirthYearField    Student Birthyear of type JTextField
     * @param userBirthMonthField   Student Birthmonth of type JTextField
     * @param userBirthDayField     Student day of birth of type JTextField
     * @param userCourseField   Student course of type JTextField
     * @param userPhoneNumberField  Student phone number of type JTextField
     * @param genderComboBox    Student gender of type JComboBox
     * @param preferredGenderComboBox   Selected Preferred gender of type JComboBox
     * @param PreferredLocationComboBox     Selected Preferred location of type JComboBox
     * @param personalityComboBox   Selected Preferred personality of type JComboBox
     * @param dayAvailableComboBox  Selected Preferred day of type JComboBox
     */

    private void createAccount(JTextField userNameField,JTextField userStudentIDField,JTextField userEmailField,JTextField userBirthYearField,
    JTextField userBirthMonthField,JTextField userBirthDayField,JTextField userCourseField,JTextField userPhoneNumberField,JComboBox genderComboBox,JComboBox preferredGenderComboBox,
    JComboBox PreferredLocationComboBox,JComboBox personalityComboBox,JComboBox dayAvailableComboBox)
    {
        String username = userNameField.getText();
        String studentID = userStudentIDField.getText();
        String email = userEmailField.getText();
        String birthyear = userBirthYearField.getText();
        String birthmonth = userBirthMonthField.getText();
        String birthday = userBirthDayField.getText();
        String course = userCourseField.getText();
        String phoneNumber = userPhoneNumberField.getText();
        String gender = genderComboBox.getSelectedItem().toString();
        String preferredGender = preferredGenderComboBox.getSelectedItem().toString();
        String preferredLocation = PreferredLocationComboBox.getSelectedItem().toString();
        String personality = personalityComboBox.getSelectedItem().toString();
        String dayAvailable = dayAvailableComboBox.getSelectedItem().toString();

        studentList.add(new student(studentID,username,email,gender,birthyear,birthmonth,birthday,course,phoneNumber,preferredGender,preferredLocation,personality,dayAvailable));
    }

    /**
     * Method to create a student by invoking the constructor of student class and storing the student object into an arraylist
     *
     * @param userNameField     Name of the Volunteer of type JTextField
     * @param userStudentIDField    ID of the Volunteer of type JTextField
     * @param userEmailField    Email id of the Volunteer of type JTextField
     * @param userBirthYearField    Volunteer Birthyear of type JTextField
     * @param userBirthMonthField   Volunteer Birthmonth of type JTextField
     * @param userBirthDayField     Volunteer day of birth of type JTextField
     * @param userCourseField   Volunteer course of type JTextField
     * @param userPhoneNumberField  Volunteer phone number of type JTextField
     * @param genderComboBox    Volunteer gender of type JComboBox
     * @param dayAvailableComboBox  Selected Preferred day of type JComboBox
     * @param userAboutMeField    About me description of Volunteer day of type JTextField
     */
    private void createAccount(JTextField userNameField,JTextField userStudentIDField,JTextField userEmailField,JTextField userBirthYearField,
    JTextField userBirthMonthField,JTextField userBirthDayField,JTextField userCourseField,JTextField userPhoneNumberField,JComboBox genderComboBox,
    JComboBox dayAvailableComboBox,JTextField userAboutMeField)
    {
        String username = userNameField.getText();
        String studentID = userStudentIDField.getText();
        String email = userEmailField.getText();
        String birthyear = userBirthYearField.getText();
        String birthmonth = userBirthMonthField.getText();
        String birthday = userBirthDayField.getText();
        String course = userCourseField.getText();
        String phoneNumber = userPhoneNumberField.getText();
        String gender = genderComboBox.getSelectedItem().toString();
        String dayAvailable = dayAvailableComboBox.getSelectedItem().toString();
        String aboutMe = userAboutMeField.getText();

        volunteerList.add(new volunteer(studentID,username,email,gender,birthyear,birthmonth,birthday,course,phoneNumber,dayAvailable,aboutMe));
    }

    /**
     * Method to display user interface for both student and volunteer. The entire application is controlled from here. This method is the entry and exit point for the application
     */
    public void userInterface()   
    {   
        String choice;
        //display welcome interface
        choice = JOptionPane.showInputDialog(null,
        "Please select an option below:\n\n"
        +"[1]Volunteer\n\n[2]Student\n\n[3]Exit\n", "MyBuddy",JOptionPane.PLAIN_MESSAGE);
        //display volunteer interface to login or register
        if (choice.equals("1")) {
            String loginOption;
            loginOption = JOptionPane.showInputDialog(null,"Please select an option below:\n\n"
            +"[1]Register\n\n[2]Login\n\n\n","MyBuddy",JOptionPane.PLAIN_MESSAGE);
            //Display agreement
            if(loginOption.equals("1")) {
                int dialogResult;
                dialogResult = JOptionPane.showConfirmDialog(null,"Do you accept the below given agreement:\n\nI agree to maintain the confidentiality of student information"
                    +"and follow all the laws needed to maintain  decorum",
                    "Terms of Agreement",JOptionPane.YES_NO_OPTION);
                    //display registration form 
                if(dialogResult == JOptionPane.YES_OPTION){
                    JTextField userNameField = new JTextField();
                    JLabel userName = new JLabel("Name:"); 

                    JTextField userStudentIDField = new JTextField();
                    JLabel userStudentID = new JLabel("StudentID:"); 

                    JTextField userEmailField = new JTextField();
                    JLabel userEmail = new JLabel("Email:");

                        
                    JTextField userBirthYearField = new JTextField();
                    JLabel userBirthYear = new JLabel("BirthYear:");

                    JTextField userBirthMonthField = new JTextField();
                    JLabel userBirthMonth = new JLabel("BirthMonth:");

                    JTextField userBirthDayField = new JTextField();
                    JLabel userBirthDay = new JLabel("BirthDay:");

                    JTextField userCourseField = new JTextField();
                    JLabel userCourse = new JLabel("Course:");

                    JTextField userPhoneNumberField = new JTextField();
                    JLabel userPhoneNumber = new JLabel("Phone Number:");

                    String[] genderOptions = { "Male","Female" };
                    JComboBox genderComboBox = new JComboBox(genderOptions);
                    JLabel userGender = new JLabel("Gender:");

                    String[] dayAvailableOptions = { "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
                    JComboBox dayAvailableComboBox = new JComboBox(dayAvailableOptions);
                    JLabel userdayAvailable = new JLabel("Select Available Day:");

                    JTextField userAboutMeField = new JTextField();
                    JLabel userAboutMe = new JLabel("About Me:");

                    Object[] loginElements = {userName,
                                              userNameField,
                                              userStudentID,
                                              userStudentIDField,
                                              userEmail,
                                              userEmailField, 
                                              userBirthYear,
                                              userBirthYearField, 
                                              userBirthMonth, 
                                              userBirthMonthField,
                                              userBirthDay,
                                              userBirthDayField,
                                              userCourse, 
                                              userCourseField, 
                                              userPhoneNumber, 
                                              userPhoneNumberField , 
                                              userGender, 
                                              genderComboBox,
                                              userdayAvailable,
                                              dayAvailableComboBox,
                                              userAboutMe,
                                              userAboutMeField};
                    JOptionPane.showConfirmDialog(null, loginElements, "Registration Window",
                                                 JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);

                    createAccount(userNameField,userStudentIDField,userEmailField,userBirthYearField,userBirthMonthField,userBirthDayField,userCourseField,userPhoneNumberField,genderComboBox,dayAvailableComboBox,userAboutMeField);

                    //language dialog box
                    JTextField lang1Field = new JTextField();
                    JLabel lang1 = new JLabel("English"); 

                    JTextField lang2Field = new JTextField();
                    JLabel lang2 = new JLabel("Chinese"); 

                    JTextField lang3Field = new JTextField();
                    JLabel lang3 = new JLabel("Hindi");

                    JTextField lang4Field = new JTextField();
                    JLabel lang4 = new JLabel("Irish");

                    JTextField lang5Field = new JTextField();
                    JLabel lang5 = new JLabel("German");

                    Object[] language = {lang1,lang1Field,lang2,lang2Field,lang3,lang3Field,lang4,lang4Field,lang5,lang5Field};

                    JOptionPane.showConfirmDialog(null, language, "Language TYPE 1 IF YES",
                                                 JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);

                    //temporary variables to display language    
                    String [] langValue ={lang1Field.getText(),lang2Field.getText(),lang3Field.getText(),lang4Field.getText(),lang5Field.getText()};
                    String [] langList = {lang1.getText(),lang2.getText(),lang3.getText(),lang4.getText(),lang5.getText()};

                    for(int i=0;i<langValue.length;i++)
                    {
                        if(langValue[i].equals("1"))
                        {
                            volunteerList.get(getVolunteerIndex(userStudentIDField.getText())).selectedLanguage.add(langList[i]);
                        }
                    }

                    //Interest dialog box
                    JTextField interest1Field = new JTextField();
                    JLabel interest1 = new JLabel("Sports"); 

                    JTextField interest2Field = new JTextField();
                    JLabel interest2 = new JLabel("Art"); 

                    JTextField interest3Field = new JTextField();
                    JLabel interest3 = new JLabel("Reading");

                    JTextField interest4Field = new JTextField();
                    JLabel interest4 = new JLabel("Music"); 

                    JTextField interest5Field = new JTextField();
                    JLabel interest5 = new JLabel("Dancing");

                    Object[] interest = {interest1,interest1Field,interest2,interest2Field,interest3,interest3Field,interest4,interest4Field,interest5,interest5Field};

                    JOptionPane.showConfirmDialog(null, interest, "Choose Interest TYPE 1 IF YES",
                                                 JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);

                        
                    String [] interestValue ={interest1Field.getText(),interest2Field.getText(),interest3Field.getText(),interest4Field.getText(),interest5Field.getText()};
                    String [] interestList = {interest1.getText(),interest2.getText(),interest3.getText(),interest4.getText(),interest5.getText()};

                    for(int i=0;i<interestValue.length;i++)
                    {
                        if(interestValue[i].equals("1"))
                        {
                            volunteerList.get(getVolunteerIndex(userStudentIDField.getText())).selectedInterest.add(interestList[i]);
                        }
                    }

                    JOptionPane.showMessageDialog(null,"Registration is successfull","Confirmation",JOptionPane.INFORMATION_MESSAGE);

                    loginOption="2";
                }
            }
            //student Login
            if(loginOption.equals("2")) {
                JTextField userStudentIDField = new JTextField();
                JLabel userStudentID = new JLabel("Enter StudentID:"); 
      
                Object[] loginElements = {userStudentID, userStudentIDField};
                int input = JOptionPane.showConfirmDialog(null, loginElements, "Login Window",
                        JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
                        //Match volunteer for student
                if(input== JOptionPane.YES_OPTION )
                {
                    Object[] options = {"Book"};
                    int result = JOptionPane.showOptionDialog(null, "Do you want to Book?", "Booking",
                            JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[0]);

                    findBestmatchVolunteer(userStudentIDField.getText());
                        
                }

            }
        }
        //Volunteer interface
        if (choice.equals("2")) {
            String loginOption;
            loginOption = JOptionPane.showInputDialog(null,"Please select an option below:\n\n"+
                                                     "[1]Register\n\n[2]Login\n\n\n", "MyBuddy",JOptionPane.PLAIN_MESSAGE);
            //volunteer registration                                        
            if(loginOption.equals("1")) {
                int dialogResult;
                dialogResult = JOptionPane.showConfirmDialog(null,"Do you accept the below given agreement:\n\nI agree to "+
                    "not exploit this platform in any way",
                    "Terms of Agreement- Student",JOptionPane.YES_NO_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION){
                    JTextField userNameField = new JTextField();
                    JLabel userName = new JLabel("Name:"); 

                    JTextField userStudentIDField = new JTextField();
                    JLabel userStudentID = new JLabel("StudentID:"); 

                    JTextField userEmailField = new JTextField();
                    JLabel userEmail = new JLabel("Email:");

                    JTextField userBirthYearField = new JTextField();
                    JLabel userBirthYear = new JLabel("BirthYear:");

                    JTextField userBirthMonthField = new JTextField();
                    JLabel userBirthMonth = new JLabel("BirthMonth:");

                    JTextField userBirthDayField = new JTextField();
                    JLabel userBirthDay = new JLabel("BirthDay:");

                    JTextField userCourseField = new JTextField();
                    JLabel userCourse = new JLabel("Course:");

                    JTextField userPhoneNumberField = new JTextField();
                    JLabel userPhoneNumber = new JLabel("Phone Number:");

                    String[] genderOptions = { "Male","Female","No Preference" };
                    JComboBox genderComboBox = new JComboBox(genderOptions);
                    JLabel userGender = new JLabel("Gender:");

                    String[] preferredGenderOptions = { "Male","Female","No Preference" };
                    JComboBox preferredGenderComboBox = new JComboBox(preferredGenderOptions);
                    JLabel userPreferredGender = new JLabel("Preferred Gender:");

                    String[] PreferredLocationOptions = { "Sult","Chapel","Hub","No Preference" };
                    JComboBox PreferredLocationComboBox = new JComboBox(PreferredLocationOptions);
                    JLabel userPreferredLocation = new JLabel("Preferred Location:");

                    String[] personalityOptions = { "Introvert","Extrovert","Ambivert" };
                    JComboBox personalityComboBox = new JComboBox(personalityOptions);
                    JLabel userPersonality = new JLabel("Personality type:");

                    String[] dayAvailableOptions = { "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
                    JComboBox dayAvailableComboBox = new JComboBox(dayAvailableOptions);
                    JLabel userdayAvailable = new JLabel("Select Available Day:");

                    Object[] loginElements = {userName,
                                              userNameField,
                                              userStudentID,
                                              userStudentIDField,
                                              userEmail, 
                                              userEmailField, 
                                              userBirthYear,
                                              userBirthYearField, 
                                              userBirthMonth, 
                                              userBirthMonthField,
                                              userBirthDay,
                                              userBirthDayField,
                                              userCourse, 
                                              userCourseField, 
                                              userPhoneNumber, 
                                              userPhoneNumberField , 
                                              userGender, 
                                              genderComboBox,
                                              userPreferredGender,
                                              preferredGenderComboBox,
                                              userPreferredLocation,
                                              PreferredLocationComboBox,
                                              userdayAvailable,
                                              dayAvailableComboBox};
                    int input = JOptionPane.showConfirmDialog(null, loginElements, "Registration Window",
                            JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);

                    createAccount(userNameField,userStudentIDField,userEmailField,userBirthYearField,
                        userBirthMonthField,userBirthDayField,userCourseField,userPhoneNumberField,genderComboBox,preferredGenderComboBox,
                        PreferredLocationComboBox,personalityComboBox,dayAvailableComboBox);

                    //language dialog box
                    JTextField lang1Field = new JTextField();
                    JLabel lang1 = new JLabel("English"); 

                    JTextField lang2Field = new JTextField();
                    JLabel lang2 = new JLabel("Chinese"); 

                    JTextField lang3Field = new JTextField();
                    JLabel lang3 = new JLabel("Hindi");

                    JTextField lang4Field = new JTextField();
                    JLabel lang4 = new JLabel("Irish");

                    JTextField lang5Field = new JTextField();
                    JLabel lang5 = new JLabel("German");

                    Object[] language = {lang1,lang1Field,lang2,lang2Field,lang3,lang3Field,lang4,lang4Field,lang5,lang5Field};

                    JOptionPane.showConfirmDialog(null, language, "Language TYPE 1 for YES",
                        JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);

                    String [] langValue ={lang1Field.getText(),lang2Field.getText(),lang3Field.getText(),lang4Field.getText(),lang5Field.getText()};
                    String [] langList = {lang1.getText(),lang2.getText(),lang3.getText(),lang4.getText(),lang5.getText()};

                    for(int i=0;i<langValue.length;i++)
                    {
                        if(langValue[i].equals("1"))
                        {
                            studentList.get(getStudentIndex(userStudentIDField.getText())).selectedLanguage.add(langList[i]);
                        }
                    }

                    //Interest dialog box
                    JTextField interest1Field = new JTextField();
                    JLabel interest1 = new JLabel("Sports"); 

                    JTextField interest2Field = new JTextField();
                    JLabel interest2 = new JLabel("Painting"); 

                    JTextField interest3Field = new JTextField();
                    JLabel interest3 = new JLabel("Reading");

                    JTextField interest4Field = new JTextField();
                    JLabel interest4 = new JLabel("Music"); 

                    JTextField interest5Field = new JTextField();
                    JLabel interest5 = new JLabel("Dancing");

                    Object[] interest = {interest1,interest1Field,interest2,interest2Field,interest3,interest3Field,interest4,interest4Field,interest5,interest5Field};

                    JOptionPane.showConfirmDialog(null, interest, "Interest TYPE 1 for YES",
                        JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);

                    String [] interestValue ={interest1Field.getText(),interest2Field.getText(),interest3Field.getText(),interest4Field.getText(),interest5Field.getText()};
                    String [] interestList = {interest1.getText(),interest2.getText(),interest3.getText(),interest4.getText(),interest5.getText()};
                    for(int i=0;i<interestValue.length;i++)
                    {
                        if(interestValue[i].equals("1"))
                        {
                            studentList.get(getStudentIndex(userStudentIDField.getText())).selectedInterest.add(interestList[i]);
                        }
                    }

                    JOptionPane.showMessageDialog(null,"Registration is successfull","Confirmation",JOptionPane.INFORMATION_MESSAGE);
                    loginOption="2";
                }
            }
            //Student login
            if(loginOption.equals("2")) {
                JTextField userStudentIDField = new JTextField();
                JLabel userStudentID = new JLabel("Enter StudentID:"); 

                Object[] loginElements = {userStudentID, userStudentIDField};
                int input = JOptionPane.showConfirmDialog(null, loginElements, "Login Window",
                        JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);
                if(input== JOptionPane.YES_OPTION )
                {
                    Object[] options = {"Book"};
                    int result = JOptionPane.showOptionDialog(null, "Do you want to Book?", "Booking",
                            JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[0]);

                    if(result==JOptionPane.YES_OPTION) {
                        findBestmatchStudent(userStudentIDField.getText());
                    }
                    else {
                        choice = "3";
                    }

                }
            }
        }
        if(choice.equals("3")) 
        {
            exitWriteToFile();
        }
    }
    /**
     * Method to read saved volunteer and student details from file line by line and create array list of objects 
     */
    private void enterReadFromFile()
    {
        //STUDENT
        //Temporary variable to store file lines
        String read = "";
        // Try catch block for exception handling
        try(BufferedReader reader = new BufferedReader(new FileReader(studentFNAME))) {
            //Read file till last line
            int lineCount = 0;
            String studentID ="";
            while((read = reader.readLine()) != null) {
                 //Object fields for contsructor call
                if(lineCount%3 == 0)
                {
                    String[] studentDetail = read.split(",");
                    studentID=studentDetail[0];
                    studentList.add(new student(studentDetail[0],studentDetail[1],studentDetail[2],studentDetail[3],studentDetail[4],studentDetail[5],studentDetail[6],studentDetail[7],studentDetail[8],studentDetail[9],studentDetail[10],studentDetail[11],studentDetail[12]));
                    lineCount++;
                }
                //Read language
                else if (lineCount%3 == 1)
                {
                    String[] languageList = read.split(","); 
                    for(int i=0;i< languageList.length ;i++)
                    {
                        studentList.get(getStudentIndex(studentID)).selectedLanguage.add(languageList[i]);
                    }

                }
                //Read interest
                else if (lineCount%3 == 2)
                {
                    String[] interestList = read.split(",");  
                    for(int i=0;i< interestList.length ;i++)
                    {
                        studentList.get(getStudentIndex(studentID)).selectedInterest.add(interestList[i]);
                    }

                }

            }
            reader.close();
            JOptionPane.showMessageDialog(null,"Student details read from file successfully","Student Details read from file",JOptionPane.INFORMATION_MESSAGE);
        }
        //Exception handling if file is not created 

        catch (FileNotFoundException fe) {
            JOptionPane.showMessageDialog(null,"File not found \n " + fe,"File Read Error",JOptionPane.ERROR_MESSAGE);
        }
        //Exception handling for any file reading errors. 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Unable to read from file \n" + e,"File Read Error",JOptionPane.ERROR_MESSAGE);
        }

        //VOLUNTEER
        
        //Temporary variable to store file lines
   
        read = "";
     
        //Try catch block for exception handling
        try(BufferedReader reader = new BufferedReader(new FileReader(volunteerFNAME))) {
             //Read file till last line
            int lineCount = 0;
            String studentID ="";
            while((read = reader.readLine()) != null) {
                //Object fields for contsructor call
                if(lineCount%3 == 0)
                {
                    String[] volunteerDetail = read.split(",");
                    studentID=volunteerDetail[0];
                    volunteerList.add(new volunteer(volunteerDetail[0],volunteerDetail[1],volunteerDetail[2],volunteerDetail[3],volunteerDetail[4],volunteerDetail[5],volunteerDetail[6],volunteerDetail[7],volunteerDetail[8],volunteerDetail[9],volunteerDetail[10]));
                    lineCount++;
                }
                //Read language
                else if (lineCount%3 == 1)
                {
                    String[] languageList = read.split(","); 
                    for(int i=0;i< languageList.length ;i++)
                    {
                        volunteerList.get(getVolunteerIndex(studentID)).selectedLanguage.add(languageList[i]);
                    }

                }
                //Read interest
                else if (lineCount%3 == 2)
                {
                    String[] interestList = read.split(",");  
                    for(int i=0;i< interestList.length ;i++)
                    {
                        volunteerList.get(getVolunteerIndex(studentID)).selectedInterest.add(interestList[i]);
                    }

                }

            }
            reader.close();
            JOptionPane.showMessageDialog(null,"Volunteer details read from file successfully","Volunteer Details read from file",JOptionPane.INFORMATION_MESSAGE);
        }
        //Exception handling if file is not created 
        catch (FileNotFoundException fe) {
            JOptionPane.showMessageDialog(null,"File not found \n " + fe,"File Read Error",JOptionPane.ERROR_MESSAGE);
        }
        //Exception handling for any file reading errors. 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Unable to read from file \n" + e,"File Read Error",JOptionPane.ERROR_MESSAGE);
        }

        
    }
    /**
     * Method to write all created objects of students and volunteers into a file. 
     */
    private void exitWriteToFile()
    {
        //STUDENT
        /**
         * Temporary String to write to file
         */
        String write = "";
        /**
         * Using try catch block for writing into file using filewriter class
         */
        try(FileWriter writer = new FileWriter(studentFNAME, true)) {
            /**
             *Iterate through Array List to write into file 
             */
            for(student s:studentList) {
                /**
                 * write account details to file line by line for each account
                 */
                String studentLanguageList = "";
                for(String studentLanguage : s.selectedLanguage)
                {
                    studentLanguageList  += studentLanguage +",";
                }
                String studentInterestList = "";
                for(String studentInterest : s.selectedInterest)
                {
                    studentInterestList  += studentInterest +",";
                }
                String dateOfBirth[] = s.getDateOfBirth().split("-");

                writer.write(""
                    +s.getStudentID()
                    +","+s.getName() 
                    +","+ s.getEmail()
                    +","+s.getGender()
                    +","+ dateOfBirth[2]
                    +","+ dateOfBirth[1]
                    +","+ dateOfBirth[0]
                    +","+ s.getCourse()
                    +","+ s.getPhoneNumber()
                    +","+s.getPreferredGender()
                    +","+s.getPreferredLocation()
                    +","+s.getPersonalityType()
                    +","+s.getdayAvailable()
                    +"\n"+studentLanguageList
                    +"\n"+studentInterestList
                    +"\n"); 

            }
            /**
             * Close file after writing
             */
            writer.close();
            JOptionPane.showMessageDialog(null,"Student details written to file successfully","Student Details written to file",JOptionPane.INFORMATION_MESSAGE);
        }
        //Exception handling for and File Wrting errors 
        catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Unable to write to file" + e,"File Write Error",JOptionPane.ERROR_MESSAGE);
        }

        //Volunteer write to file

        //Temporary String to write to file
         
        write = "";
        //Using try catch block for writing into file using filewriter class
         
        try(FileWriter writer = new FileWriter(volunteerFNAME, true)) {
            //Iterate through Array List to write into file  
            for(volunteer v:volunteerList) {
                //write volunteer details to file line by line for each account
                String volunteerLanguageList = "";
                for(String volunteerLanguage : v.selectedLanguage)
                {
                    volunteerLanguageList  += volunteerLanguage +",";
                }
                String volunteerInterestList = "";
                for(String volunteerInterest : v.selectedInterest)
                {
                    volunteerInterestList  += volunteerInterest +",";
                }
                String dateOfBirth[] = v.getDateOfBirth().split("-");
                writer.write(""
                    +v.getStudentID()
                    +","+ v.getName()
                    +","+ v.getEmail()
                    +","+ v.getGender()
                    +","+ dateOfBirth[2]
                    +","+ dateOfBirth[1]
                    +","+ dateOfBirth[0]
                    +","+ v.getCourse()
                    +","+ v.getPhoneNumber()
                    +","+v.getdayAvailable()
                    +","+ v.getAboutMe()               
                    +"\n"+volunteerLanguageList
                    +"\n"+volunteerInterestList
                    +"\n"); 
            }            
            //Close file after writing             
            writer.close();
            JOptionPane.showMessageDialog(null,"volunteer details written to file successfully","volunteer Details written to file",JOptionPane.INFORMATION_MESSAGE);
        }
        //Exception handling for and File Wrting errors
        catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Unable to write to file" + e,"File Write Error",JOptionPane.ERROR_MESSAGE);
        }

    }
    /**
     * Method to create test objects of student
     */
    private void createTestStudent()
    {

        studentList.add(new student("18230442","kripa","kk","female","1991","10","10","BA","123","any","sult","introvert","Monday"));
        studentList.get(getStudentIndex("18230442")).selectedLanguage.add("English");
        studentList.get(getStudentIndex("18230442")).selectedLanguage.add("Spanish");
        studentList.get(getStudentIndex("18230442")).selectedInterest.add("Sports");
        studentList.get(getStudentIndex("18230442")).selectedInterest.add("Painting");
        studentList.get(getStudentIndex("18230442")).selectedInterest.add("TableTenis");
        studentList.get(getStudentIndex("18230442")).setdayAvailable("Monday");

        studentList.add(new student("18230445","hema","hems","female","1992","09","10","MBA","786","male","chapel","extrovert","Sunday"));
        studentList.get(getStudentIndex("18230445")).selectedLanguage.add("English");
        studentList.get(getStudentIndex("18230445")).selectedLanguage.add("Tamil");
        studentList.get(getStudentIndex("18230445")).selectedInterest.add("Sports");
        studentList.get(getStudentIndex("18230445")).selectedInterest.add("Doodling");
        studentList.get(getStudentIndex("18230445")).selectedInterest.add("TableTenis");
        studentList.get(getStudentIndex("18230445")).setdayAvailable("Tuesday");

    }
    
     /**
     * Method to get student index from volunteer list 
     * @param Student id from volunteer class
     * @return Index in array list of student objects.
     */
    private int getStudentIndex(String id)
    {
        int studentIndex = -1;
        //Iterating through every object of arrayList to search for BankAccount using accountNumber and saving index in accountIndex         
        for(student student : studentList) {
            if(student.getStudentID().equals(id)) {
                studentIndex = studentList.indexOf(student);
            }
        }
        //Dialog box to display if  not found
        if(studentIndex == -1) {
            JOptionPane.showMessageDialog(null,"Invalid number entered","Not found",JOptionPane.ERROR_MESSAGE);
        }
        return studentIndex;
    }
    /**
     * Method to get volunteer index from volunteer list 
     * @param Student id from volunteer class
     * @return Index in array list of volunteer objects.
     */
    private int getVolunteerIndex(String id)
    {
        int volunteerIndex = -1;
        //Iterating through every object of arrayList to search for BankAccount using accountNumber and saving index in accountIndex
        for(volunteer volunteer : volunteerList) {
            if(volunteer.getStudentID().equals(id)) {
                volunteerIndex = volunteerList.indexOf(volunteer);
            }
        }
        //Dialog box to display if  not found
        if(volunteerIndex == -1) {
            JOptionPane.showMessageDialog(null,"Invalid number entered","Not found",JOptionPane.ERROR_MESSAGE);
        }
        return volunteerIndex;
    }
    /**
     * Method to match student with volunteer. This uses a matching algorithm to give a score for every volunteer
     * @param student Object of class student
     */
    private void match(student s)
    {   

        for(volunteer v : volunteerList)
        {
            if(s.getdayAvailable().equals(v.getdayAvailable()))
            {
                s.getselectedLanguage().retainAll(v.getselectedLanguage());
                languageScore = s.getselectedLanguage().size();
                s.getselectedInterest().retainAll(v.getselectedInterest());
                interestScore = s.getselectedInterest().size();  
                ageScore = Math.abs((s.getAge() - v.getAge()));
                matchScore = (0.3*languageScore)+(0.5*interestScore)+(0.2*ageScore);
                matchScoreList.add(matchScore);
            }
            else 
                JOptionPane.showMessageDialog(null,"Sorry no matches on the same day as you","No matches",JOptionPane.ERROR_MESSAGE);
        }

    }
    /**
     * Method that does the matching of a volunteer with student using matching algorithm 
     * @param volunteer Object of volunteer class
     */
    private void matchVolunteer(volunteer v)
    {   

        for(student s : studentList)
        {
            if(s.getdayAvailable().equals(v.getdayAvailable()))
            {
                v.getselectedLanguage().retainAll(s.getselectedLanguage());
                languageScore = v.getselectedLanguage().size();
                v.getselectedInterest().retainAll(s.getselectedInterest());
                interestScore = v.getselectedInterest().size();  
                ageScore = Math.abs((v.getAge() - s.getAge()));
                matchScore = (0.3*languageScore)+(0.5*interestScore)+(0.2*ageScore);
                matchScoreList.add(matchScore);
            }
            else 
                JOptionPane.showMessageDialog(null,"Sorry no matches on the same day as you","No matches",JOptionPane.ERROR_MESSAGE);
        }

    }
    /**
     * Method displays the number of matches for a volunteer
     * It displays the name of the most suitable volunteer with contact details.
     * @param studentID StudentID of a student. 
     */
    private void findBestmatchVolunteer(String studentID)
    {

        volunteer s = volunteerList.get(getVolunteerIndex(studentID));
        int count = -1;
        matchScoreList.clear();
        matchVolunteer(s);
        count = matchScoreList.size();
        if(count >0) {
            JOptionPane.showMessageDialog(null,"\n You are matched with  " + count + " students \n Please wait to be contacted","Match found",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null,"\n Sorry you have no match currently.  \n Please wait for a match","No matches",JOptionPane.ERROR_MESSAGE);
        }

        
    }
    /**
     * Method that finds best match for a student. It calls the matching algorithm to create a score and selects the maximum score for a given student
     * It displays the name of the most suitable volunteer with contact details.
     * @param studentID StudentID of a student registered. 
     */
    private void findBestmatchStudent(String studentID)
    {

        student s = studentList.get(getStudentIndex(studentID));
        int bestMatchIndex = -1;
        matchScoreList.clear();
        match(s);
        if(matchScoreList.size() > 0) {
            bestMatchIndex = matchScoreList.indexOf(Collections.max(matchScoreList));
            JOptionPane.showMessageDialog(null,volunteerList.get(bestMatchIndex).displayDetails(),"Match found",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null,"\n Sorry you have no match currently.  \n Please wait for a match","No matches",JOptionPane.ERROR_MESSAGE);
        }

    }

}
