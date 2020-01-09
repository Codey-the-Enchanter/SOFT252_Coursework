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
public class Prescription implements java.io.Serializable{
    private Medicine medicine;
    private Float dosage;
    
    public Prescription(Medicine medicine, Float dosage)
    {
        this.medicine = medicine;
        this.dosage = dosage;
    }
    
    public Medicine getMedicine()
    {
        return this.medicine;
    }
    
    public void setMedicine(Medicine medicine)
    {
        this.medicine = medicine;
    }
    
    public Float getDosage()
    {
        return this.dosage;
    }
    
    public void setDosage(Float dosage)
    {
        this.dosage = dosage;
    }
}
