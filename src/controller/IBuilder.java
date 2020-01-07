/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.User;

/**
 *
 * @author Matthew
 */
public interface IBuilder {
    public void setUserNum(Integer num);
    public void setFirstName(String name);
    public void setSurname(String name);
    public void setAddress(String address);
    public void setPassword(String password);
    public char getType();
    public User build();
}
