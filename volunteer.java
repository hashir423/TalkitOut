
/**
 * This sub class represents student and has relevant attributes
 *
 * @author Mohammad Hashir,Kripa Makhija,Neil
 * @version 26-03-2019
 */
import java.util.ArrayList;
public class volunteer extends registerable
{    
    private String aboutMe = "";
    public volunteer()
    {
        super();
    }
     public volunteer(String studentID,String name,String email,String gender,String birthYear,String birthMonth,String birthDay, String course,String phoneNumber,String dayAvailable,String aboutMe)
    {
        super(studentID,name,email,gender,birthYear,birthMonth,birthDay,course,phoneNumber);
        this.dayAvailable=dayAvailable;
        this.aboutMe = aboutMe;
    }
    
    public volunteer(String studentID,String name,String email,String gender)
    {
        super(studentID,name,email,gender);  
        this.aboutMe = "";
          
    }
    public void setAboutMe(String aboutMe)
    {
        this.aboutMe = aboutMe;
    }
    public String getAboutMe()
    {
        return aboutMe;
    }
    public String displayDetails()
    {   String details = "Your matched volunteer is  \n" +"Name :"+getName()
        +"\n Email : " + getEmail()
        +"\n Phone number : " + getPhoneNumber()
        +"\n About Me : " + getAboutMe();
        
        System.out.println(details);
        return details;

    }

}
