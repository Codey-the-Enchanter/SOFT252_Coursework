/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;

/**
 *
 * @author Matthew
 */
public class DataModel {
    //Data model is a singleton
    
    private static DataModel instance;
    
    private User[] users;
    
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
}
