/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBean;

import entities.Travel;
import entities.User;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.TravelI;
import model.UserI;
import ws.UserWS;

/**
 *
 * @author Yannis
 */
@ManagedBean(name="UserManageBean")
@SessionScoped
public class UserManageBean {
    
    @EJB
    public UserI userWS;
    
    private User user;
    
    @EJB 
    public TravelI travelWS;
     
    private Travel travel;
    
    public void createTravel(){
        //Instancie UserWS sinon erreur
        this.userWS = new UserWS();
        this.userWS.createTravel(this.getUser(), this.getTravel());
    }
    
    public String createUser(){
        final User user = new User("toto", "toto", "Toto", "Titi"); 
        //Instancie UserWS sinon erreur
        this.userWS = new UserWS();
        userWS.createUser(user); 
        
        return "User créé";
    }

    public User getUser() {
        if(user == null){
            user = new User();
        }
        
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Travel getTravel() {
        if(travel == null){
            travel = new Travel();
        }
        
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }
    
    
}

