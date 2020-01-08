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
public class Appointment implements java.io.Serializable{
    private Doctor doctor;
    private String dateTime;
    private boolean accepted = false;
    
    public Appointment(Doctor doctor, String datetime)
    {
        this.doctor = doctor;
        this.dateTime = datetime;
    }
    
    public Doctor getDoctor()
    {
        return this.doctor;
    }
    
    public void setDoctor(Doctor doc)
    {
        this.doctor = doc;
    }
    
    public String getDateTime()
    {
        return this.dateTime;
    }
    
    public void setDateTime(String datetime)
    {
        this.dateTime = datetime;
    }
    
    public boolean getAccepted()
    {
        return this.accepted;
    }
    
    public void setAccepted(boolean accepted)
    {
        this.accepted = accepted;
    }
}
