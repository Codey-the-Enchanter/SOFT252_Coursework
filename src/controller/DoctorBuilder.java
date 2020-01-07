/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Doctor;

/**
 *
 * @author Matthew
 */
public class DoctorBuilder implements IBuilder{
    private Integer userNum;
    private String firstName;
    private String surname;
    private String address;
    private String password;
    
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
        return 'D';
    }
    
    @Override
    public Doctor build()
    {
        return new Doctor(userNum, firstName, surname, address, password);
    }
}
