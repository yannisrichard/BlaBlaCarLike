/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBean;

import entities.Travel;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.TravelI;
import model.UserI;
import ws.TravelWS;

/**
 *
 * @author Yannis
 */
@ManagedBean(name="TravelManageBean")
@SessionScoped
public class TravelManageBean {
    
    @EJB
    public TravelI travelWS;
    
    @EJB
    public UserI userWS;
    
    private Travel travel;
    
    private List<Travel> lst;
    
    public void findTravelByParameters() throws IOException {
        this.travelWS = new TravelWS();
        lst = this.travelWS.getTravelByParameters(this.travel);
        System.out.println("nb en base : " + lst.size());
        for(Travel t : lst){
            System.out.println(t.getStart() + " -- " + t.getPlaceEnd());
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("searchResult.faces");
    }
    
    public void findAllTravel() {
        this.travelWS = new TravelWS();
        System.out.println(this.travelWS.getAllTravel().get(0));
    }

    public TravelI getTravelWS() {
        return travelWS;
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

    public List<Travel> getLst() {
        return lst;
    }

    public void setLst(List<Travel> lst) {
        this.lst = lst;
    }
    
    
}
