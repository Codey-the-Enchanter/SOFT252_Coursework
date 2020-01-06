/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.*;
import java.util.ArrayList;

/**
 *
 * @author Matthew
 */
public class DataModel {
    //Data model is a singleton
    
    private static DataModel instance;
    
    private ArrayList<User> users = new ArrayList<User>();
    
    private DataModel()
    {
        
    }
    
    public static DataModel getInstance()
    {
        if (instance == null)
        {
            instance = new DataModel();
        }
        return instance;
    }
    
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
}
