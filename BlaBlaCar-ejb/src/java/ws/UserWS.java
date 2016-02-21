/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import entities.Travel;
import entities.User;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import model.UserI;

/**
 *
 * @author Yannis
 */
@Stateless
@Local(UserI.class)
public class UserWS implements UserI {

    @PersistenceUnit(unitName = "BlaBlaCar-ejbPU")
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BlaBlaCar-ejbPU");

    public UserWS() {
    }

    @Override
    public void createTravel(User user, Travel travel) {
        if (travel != null) {
            EntityManager em = this.emf.createEntityManager();
            String lastNameUser = user.getLastName();
            String firstNameUser = user.getFirstName();
            Query query = em.createQuery("FROM USER2 WHERE firstname=:firstName AND lastname=:lastName");
            query.setParameter("firstName", firstNameUser);
            query.setParameter("lastName", lastNameUser);

            List<User> listeUsers = query.getResultList();
            System.out.println("User found");

            //Si user n'existe pas on en crée un sinon on met l'user trouvé précédemment
            if (listeUsers.isEmpty()) { 
                travel.setUser_driver(user);
                user.getTravels().add(travel);
                System.err.println(user.getLastName());
                em.persist(user);
            } else {
                final User userTmp = listeUsers.get(0);
                travel.setUser_driver(userTmp);
                userTmp.getTravels().add(travel);
            }
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.persist(travel);
            em.getTransaction().commit();
            em.close();
        }
    }

    @Override
    public void createUser(User user) {
        EntityManager em = this.emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        System.out.println("User created");
    }

    @Override
    public void registerPassengerTravel(Travel travel) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public void pay(Travel travel) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
