/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entities.Car;
import entities.Travel;
import entities.User;
import hibernate.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Yannis
 */
public class Main {
    
    public static void main (String[] args) {
        
        User yannis = new User("yannis","password","Yannis","RICHARD");
        User toto = new User("toto","password","Toto","lasticot");
        //List<User> lstPassengers = new List<User>();
        //lstPassengers.add(toto);
        Travel travel = new Travel("Chauriat", "Clermont-Ferrand", new Date(2016, 02, 21, 12, 00), 3, 10);
        travel.setUser_driver(yannis);
        //travel.setUsers_passenger(lstPassengers);
        Car car = new Car("Citroen", "C3", yannis);
        
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(yannis);
        session.save(toto);

        session.save(car);
        session.save(travel);
        tx.commit();
        session.close();
        
    }
}
