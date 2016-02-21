/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Travel;
import entities.User;
import javax.ejb.Local;

/**
 *
 * @author Yannis
 */
@Local
public interface UserI {
    public void createTravel(User user, Travel travel);
    public void createUser(User user);

    public void registerPassengerTravel(Travel travel);
    public void pay(Travel travel);
}
