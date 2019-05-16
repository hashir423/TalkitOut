
/**
 * This sub class represents student and has relevant attributes
 *
 * @author Mohammad Hashir,Kripa Makhija,Neil
 * @version 26-03-2019
 */

import java.util.ArrayList;
import java.io.*;
public class student extends registerable
{
    
   
    private String preferredGender;
    private String preferredLocation;
    private String personalityType;
    public student()
    {
        super();
    }
    /**
     * Constructor class student
     */

    public student(String studentID,String name,String email,String gender)
    {
        super(studentID,name,email,gender);  
        this.preferredGender = "";
        this.preferredLocation = "";
          
    }
    public student(String studentID,String name,String email,String gender,String birthYear,String birthMonth,String birthDay,String course,String phoneNumber,String preferredGender,String preferredLocation,String personalityType,String dayAvailable)
    {
        
        super(studentID,name,email,gender,birthYear,birthMonth,birthDay,course,phoneNumber);
        this.preferredGender = preferredGender;
        this.preferredLocation = preferredLocation;
        this.personalityType = personalityType; 
        this.dayAvailable =dayAvailable;
    }
    public void setPreferredGender(String preferredGender)
    {
        this.preferredGender = preferredGender;
    }
    public String getPreferredGender()
    {
        return(preferredGender);
    }
    public void setPreferredLocation(String preferredLocation)
    {
        this.preferredLocation = preferredLocation;
    }
    public String getPreferredLocation()
    {
        return(preferredLocation);
    }
    public void setPersonalityType(String personalityType)
    {
        this.personalityType = personalityType;
    }
    public String getPersonalityType()
    {
        return(personalityType);
    }
    
    public String displayDetails()
    {
        String details = "Your are matched with \n" + getName();
        return details;
    }
    

}
