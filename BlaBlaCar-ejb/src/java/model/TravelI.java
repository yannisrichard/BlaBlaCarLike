/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.ejb.Local;
import entities.Travel;

/**
 *
 * @author Yannis
 */
@Local
public interface TravelI {

    /**
     *
     * @param travel
     * @return
     */
    public List getTravelByParameters(Travel travel);
    public List getAllTravel();

}
