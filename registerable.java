
/**
 * Abstract class registerable - write a description of the class here
 *
 * @author 
 * @version (version number or date here)
 */
import java.util.Calendar;
import java.time.*;
import java.util.ArrayList;

public abstract class registerable
{
    //Defining instance variables of type String, int
    protected String studentID;
    protected String name;
    protected String email;
    protected String birthYear;
    protected String birthMonth;
    protected String birthDay;
    protected String course;
    protected String phoneNumber;
    protected String gender; 
    protected String dayAvailable;
    protected int age;
    protected ArrayList<String> selectedLanguage;
    protected ArrayList<String> selectedInterest ;
    
    /**
     * Constructor class registerable
     */
    public registerable()
    {
       selectedLanguage = new ArrayList<String>();
       selectedInterest = new ArrayList<String>(); 
    }
    /**
     * Abstract class that displays all fields
     */
    abstract String displayDetails();
    /**
     * Constructor for objects of class BankAccount
     * @param studentID The unique Student Identification number
     * @param name  The name of person registering to the application
     * @param email The email of person registering to the application
     * @param gender The gender of person registering to the application
     */
    public registerable(String studentID,String name,String email,String gender)
    {
        this.studentID = studentID;
        this.name = name;
        this.email = email;
        this.gender = gender;
        birthYear= "NA";
        birthMonth= "NA";
        birthDay= "NA";
        course= "NA";
        phoneNumber= "NA";
        selectedLanguage = new ArrayList<String>();
        selectedInterest = new ArrayList<String>();
        
    }
    
     /**
     * Constructor for objects of class BankAccount
     * @param studentID The unique Student Identification number
     * @param name  The name of person registering to the application
     * @param email The email of person registering to the application
     * @param gender The gender of person registering to the application
     * @param birthYear The birth year of person registering to the application
     * @param birthMonth The birth month of person registering to the application
     * @param birthDay  The birth day of person registering to the application
     * @param course    The course of person registering to the application
     * @param phoneNumber   The Phone number of person registering to the application
     */
    public registerable(String studentID,String name,String email,String gender,String birthYear,String birthMonth,String birthDay, String course,String phoneNumber)
    {
        this.studentID = studentID;
        this.name = name;
        this.email=email;
        this.gender = gender;
        this.birthYear= birthYear;
        this.birthMonth= birthMonth;
        this.birthDay= birthDay;
        this.course= course;
        this.phoneNumber= phoneNumber;
        selectedLanguage = new ArrayList<String>();
        selectedInterest = new ArrayList<String>();
    }
    
    /**
     * Gets the StudentID 
     * @return a string type representing StudentID
     */
    public String getStudentID()
    {
        return studentID;
    }
    public void setStudentID(String studentID)
    {
        this.studentID = studentID;
    }
    
     /**
     * Gets the name 
     * @return a string type representing name
     */
    public String getName()
    {
        
        return name;
    }
    
     /**
     * Gets the gender 
     * @return a string type representing gender
     */
    public String getGender()
    {
        return gender;
    }
    
    /**
     * Sets the name
     * @param name The name of person registering of type String
     */    
    public void setName(String name)
    {
         this.name= name;
    }
    
    /**
     * Sets the gender
     * @param gender The gender of person registering of type String
     */    

    public void setGender(String gender)
    {
         this.gender = gender;
    }
    
    /**
     * Gets the email 
     * @return a email of person registering of type String
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Sets the email
     * @param email The email of person registering of type String
     */    
    public void setEmail(String email)
    {
         this.email= email;
    }
    
    /**
     * Gets the Date of birth of registering person
     * @return a string type representing DateOfBirth
     */
    public String getDateOfBirth()
    {
        return (birthDay + "-" + birthMonth + "-" + birthYear);
    }
    
    /**
     * Sets the Date of birth
     * @param birthYear The birth year of a person
     * @param birthMonth The birth month of a person
     * @param birthDay The birth day of a person
     */
    public void setdateOfBirth(String birthYear,String birthMonth,String birthDay)
    {
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }
    
    /**
     * Gets the course 
     * @return a string type representing course
     */
    public String getCourse()
    {
        return course;
    }
    
     /**
     * Gets the dayAvailable 
     * @return a string type representing dayAvailable
     */
    public String getdayAvailable()
    {
        return dayAvailable;
    }
    
    /**
     * Sets the Account Status
     * @param dayAvailable The day on which person is available of type String
     */
     public void setdayAvailable(String dayAvailable)
    {
        
        this.dayAvailable = dayAvailable;
    }
    
    /**
     * Sets the course
     * @param course The course person tookm of type String
     */
    public void setCourse(String course)
    {
         this.course= course;
    }
    
    /**
     * Gets the phoneNumber 
     * @return a string type representing phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    /**
     * Sets the Account Status
     * @param phoneNumber the phoneNumber value of type String
     */
    public void setPhoneNumber(String phoneNumber)
    {
         this.phoneNumber= phoneNumber;
    }
    
    /**
     * Calculates the age of a person 
     * 
     */
    private void calculateAge()
    {
          LocalDate birthDate = LocalDate.of(Integer.parseInt(birthYear),Integer.parseInt(birthMonth),Integer.parseInt(birthDay));
          LocalDate today = LocalDate.now();
          age = Period.between(birthDate, today).getYears();
          System.out.println("\n"+age);

    }
    
    /**
     * Gets the age 
     * @return a string type representing age
     */
    public int getAge()
    {
        calculateAge();
        return age;
    }
    
    /**
     * Gets the selectedLanguage 
     * @return a ArrayList of string type representing selectedLanguage
     */
    public ArrayList<String> getselectedLanguage()
    {
        return selectedLanguage;
    }
    /**
     * Sets the selectedLanguage
     * @param language The language known to a person 
     */
    public void setSelectedLanguage(String language)
    {
        selectedLanguage.add(language);
        
    }
    
    /**
     * Gets the selectedInterest 
     * @return a ArrayList of string type representing selectedInterest
     */    
    public ArrayList<String> getselectedInterest()
    {
        return selectedInterest;
    }
    
    /**
     * Sets the selectedInterest arraylist
     * @param interest The things in which person is interested 
     */
    public void setselectedInterest(String interest)
    {
        selectedInterest.add(interest);        
    }
         
    
}
