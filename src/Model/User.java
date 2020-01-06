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
    protected String userid = "N9999";
    protected String firstName = "UNDEFINED";
    protected String surname = "UNDEFINED";
    protected String address = "UNDEFINED";
    protected String username = "user";
    protected String password = "password";
    
    public User(String userid ,String firstname ,String surname, String address)
    {
        this.userid = userid;
        this.firstName = firstname;
        this.surname = surname;
        this.address = address;
    }
    
    public String getId()
    {
        return this.userid;
    }
    
    public void setId(String userid)
    {
        if(userid != null && !userid.isEmpty()){
            this.userid = userid;
        }
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
}
