/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import entities.Travel;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import model.TravelI;

/**
 *
 * @author Yannis
 */
@Stateless
@Local(TravelI.class)
public class TravelWS implements TravelI {
    
    @PersistenceUnit(unitName = "BlaBlaCar-ejbPU")
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BlaBlaCar-ejbPU");

    public TravelWS() {
    }

    @Override
    public List<Travel> getTravelByParameters(Travel trajet) {
        EntityManager em = this.emf.createEntityManager();
        Query query = em.createQuery("FROM TRAVEL WHERE place_start=:placeStart AND place_end=:placeEnd AND start=:date");
        query.setParameter("placeStart", trajet.getPlaceStart());
        query.setParameter("placeEnd", trajet.getPlaceEnd());
        query.setParameter("date", trajet.getStartString());
        
        return query.getResultList();
    }

    @Override
    public List getAllTravel() {
        EntityManager em = this.emf.createEntityManager();
        Query query = em.createQuery("from Travel");
        return query.getResultList();
    }

}
