/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Matthew
 */
public abstract class User implements java.io.Serializable {
    
    protected Integer userNum = 9999;
    protected String firstName = "UNDEFINED";
    protected String surname = "UNDEFINED";
    protected String address = "UNDEFINED";
    protected String password = "password";
    
    public User(Integer usernum ,String firstname ,String surname, String address, String password)
    {
        
        this.userNum = usernum;
        this.firstName = firstname;
        this.surname = surname;
        this.address = address;
        this.password = password;
    }
    
    /*
    getType is used to hardcode the user type identifer so that
    the character in the userid string and the actual
    subclass of User can never missmatch.
    i.e. You can never have an instance of Doctor that
    returns A0123 as it's userid becuase the first character
    of that string is hardcoded to "D" for all instances of Doctor
    
    This also allows us to store the last 4 characters of the id
    as an integer making arithmatic comparisons easier.
    */
    
    public abstract char getType();
    
    public Integer getNum()
    {
        return this.userNum;
    }
    
    public String getId()
    {
        String strUserNum = String.format("%04d", this.userNum);
        return this.getType()+strUserNum;
    }
    
    public void setNum(Integer usernum)
    {
        this.userNum = usernum;
    }
    
    public void setFirstName(String firstname)
    {
        this.firstName = firstname;
    }
    
    public String getFirstName()
    {
        return this.firstName;
    }
    
    public void setSurname(String surname)
    {
        this.surname = surname;
    }
    
    public String getSurname()
    {
        return this.surname;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getAddress()
    {
        return this.address;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPassword()
    {
        return this.password;
    }
}
