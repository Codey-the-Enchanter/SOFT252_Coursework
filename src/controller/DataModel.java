/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Matthew
 */
public class DataModel implements java.io.Serializable{
    //Data model is a singleton
    
    private static DataModel instance;
    
    private ArrayList<User> users = new ArrayList<User>();
    
    /**
     * Account Requests are stored as PatientBuilder objects.
     * When the request is approved, all we have to do is build
     * the object.
     */
    private ArrayList<PatientBuilder> requests = new ArrayList<PatientBuilder>();
    
    /**
    * Data is mirrored into this class to be serialized
    */
    private class DataPackage implements java.io.Serializable{
        public ArrayList<User> users = new ArrayList<User>();
        private ArrayList<PatientBuilder> requests = new ArrayList<PatientBuilder>();
    }
    
    /**
     * Pack all data into a DataPackage object for serialization
     * 
     * @return : A DataPackage object containing all of the data from the DataModel instance
     */
    private DataPackage packData()
    {
        DataPackage data = new DataPackage();
        data.users = this.users;
        data.requests = this.requests;
        return data;
    }
    
    private void unpackData(DataPackage data)
    {
        this.users = data.users;
        this.requests = data.requests;
    }
    
    public PatientBuilder getRequest()
    {
        try{
            return requests.get(0);
        }catch(IndexOutOfBoundsException e)
        {
            return null;
        }
    }
    
    public PatientBuilder popRequest()
    {
        try{
            return requests.remove(0);
        }catch(IndexOutOfBoundsException e)
        {
            return null;
        }
    }
    
    /**
     * Singleton method for this class
     * 
     * @return the current active instance of DataModel
     */
    public static DataModel getInstance()
    {
        if (instance == null)
        {
            instance = new DataModel();
        }
        return instance;
    }
    
    /**
     * preforms login check for given details
     * 
     * @param userid id of targeted user account
     * @param password password to be tested against target user
     * @return User object for the account matching the credentials.
     *  Will return null if login check fails.
     */
    public User processLogin(String userid, String password)
    {
        //search for given userid
        for (User user : users) {
            if (user.getId().equals(userid)) {
                //if we get this far, test the password
                if (user.getPassword().equals(password))
                {
                    return user;//password was correct. return current user
                }
                else
                {
                    return null;//return null if login fails.
                }
            }
        }
        //we might find ourselves here if no users exsist. better return null just to be safe.
        return null;
    }
    
    
    /**
     * <p>Adds a User object to the list of users
     * but only if it's UserId is unique among
     * all other users</p>
     * 
     * @param user the user object to be added
     * @return False if adding the user failed. True if it succeeds
     */
    public boolean addUser(User user)
    {
        for(User u : users) {
            if (u.getId().equals(user.getId())) {
                return false;
            }
        }
        users.add(user);
        return true;
    }
    
    public void addAccountRequest(PatientBuilder request)
    {
        requests.add(request);
    }
    
    /**
     * Get all users for a given type
     * 
     * @param type type identifier character
     * @return ArrayList of Users that match the given type.
     */
    public ArrayList<User> getTypedUsers(char type)
    {
        ArrayList<User> output = new ArrayList<User>();
        
        for(User u: users) {
            if (u.getType() == type) {
                output.add(u);
            }
        }
        
        return output;
    }
    
    /**
     * <p>check all User objects in the Users list of a given type 
     * and find the hightest usernum value from among them.</p>
     * <p>This is used to determine what the next available usernum
     * value is </p>
     * 
     * @param type Letter corresponding to the user type to be checked
     * @return the highest usernum value found among checked users
     */
    public Integer getHighestUserNum(char type)
    {
        Integer maxnum = 0;
        
        for (User u: users)
        {
            if (u.getNum() > maxnum & u.getType() == type)
                maxnum = u.getNum();
        }
        
        return maxnum;
    }
    
    /**
     * Save all data managed by the DataModel to an external 
     * file ("Data.dat")
     */
    public void saveData()
    {
        try{
            FileOutputStream fileout = new FileOutputStream("Data.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            DataPackage data = packData();
            out.writeObject(data);
            out.close();
            fileout.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Destroy all currently managed data and restore it
     * from an external file ("Data.dat")
     */
    public void loadData()
    {
        try {
            FileInputStream filein = new FileInputStream("Data.dat");
            ObjectInputStream in = new ObjectInputStream(filein);
            DataPackage data = (DataPackage)in.readObject();
            unpackData(data);
            in.close();
            filein.close();
        } catch (ClassNotFoundException | FileNotFoundException e)
        {
            //We couldn't read any data. But it dosen't matter because
            //the file was ether empty or missing
            return;
        } catch (IOException e)
        {
            //Something important went wrong
            e.printStackTrace();
            return;
        }
    }
}
