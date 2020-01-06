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
public class Administrator extends User {
    public Administrator(Integer usernum ,String firstname ,String surname, String address, String password)
    {
        super(usernum ,firstname ,surname, address, password);
    }
    
    @Override
    public char getType()
    {
        return 'A';
    }
}
