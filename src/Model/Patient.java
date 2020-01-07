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
public class Patient extends User{
    private String gender = "UNDEFINED";
    private Integer age = 0;
    
    public Patient(Integer usernum ,String firstname ,String surname, String address, String password, String gender, Integer age)
    {
        super(usernum ,firstname ,surname, address, password);
        this.gender = gender;
        this.age = age;
    }
    
    @Override
    public char getType()
    {
        return 'P';
    }
    
    public String getGender()
    {
        return this.gender;
    }
    
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    
    public Integer getAge()
    {
        return this.age;
    }
    
    public void setAge(Integer age)
    {
        this.age = age;
    }
}
