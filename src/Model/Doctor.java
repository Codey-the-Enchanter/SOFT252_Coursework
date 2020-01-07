/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Matthew
 */
public class Doctor extends User{
    private ArrayList<Feedback> feedback = new ArrayList<Feedback>();
    
    public Doctor(Integer usernum ,String firstname ,String surname, String address, String password)
    {
        super(usernum ,firstname ,surname, address, password);
    }
    
    public ArrayList<Feedback> getFeedback()
    {
        return this.feedback;
    }
    
    public void addFeedback(Feedback feedback)
    {
        this.feedback.add(feedback);
    }
    
    @Override
    public char getType()
    {
        return 'D';
    }
}
