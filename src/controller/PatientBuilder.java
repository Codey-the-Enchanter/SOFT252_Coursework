/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Patient;

/**
 *
 * @author Matthew
 */
public class PatientBuilder implements IBuilder, java.io.Serializable{
    protected Integer userNum;
    protected String firstName;
    protected String surname;
    protected String address;
    protected String password;
    protected String gender;
    protected Integer age;
    
    @Override
    public void setUserNum(Integer num)
    {
        this.userNum = num;
    }
    
    @Override
    public void setFirstName(String name)
    {
        this.firstName = name;
    }
    
    @Override
    public void setSurname(String name)
    {
        this.surname = name;
    }
    
    @Override
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    @Override
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    @Override
    public char getType()
    {
        return 'P';
    }
    
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    
    public void setAge(Integer age)
    {
        this.age = age;
    }
    
    public String GetName()
    {
        return this.firstName + " " + this.surname;
    }
    
    @Override
    public Patient build()
    {
        return new Patient(userNum, firstName, surname, address, password, gender, age);
    }
}
