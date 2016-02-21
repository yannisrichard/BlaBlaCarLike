/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Yannis
 */
@Entity
public class Travel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTravel;

    //permet d'associer un travel à un driver
    @ManyToOne
    @JoinColumn(name="user_driver")
    private User user_driver;

    // permet de lister les passengers du travel
    @OneToMany(mappedBy = "travel")
    private List<User> users_passenger = new ArrayList<>();

    @Column(name = "place_start")
    private String placeStart;

    @Column(name = "place_end")
    private String placeEnd;

    @Column(name = "start")
    @Temporal(value = TemporalType.DATE)
    private Date start;

    @Column(name = "nb_seat_total")
    private int nb_seat_total;

    @Column(name = "nb_seat_available")
    private int nb_seat_available;

    @Column(name = "price")
    private float price;

    public Travel() {
    }

    public Travel(String placeS, String placeE, Date dateS, int nbPlaces, int price) {
        this.placeStart = placeS;
        this.placeEnd = placeE;
        this.start = dateS;
        this.nb_seat_total = nbPlaces;
        this.price = price;
    }

    public int getIdTravel() {
        return idTravel;
    }

    public void setIdTravel(int idTravel) {
        this.idTravel = idTravel;
    }

    public User getUser_driver() {
        return user_driver;
    }

    public void setUser_driver(User user_driver) {
        this.user_driver = user_driver;
    }

    public List<User> getUsers_passenger() {
        return users_passenger;
    }

    public void setUsers_passenger(List<User> users_passenger) {
        this.users_passenger = users_passenger;
    }

    public String getPlaceStart() {
        return placeStart;
    }
    
    public String getStartString() {
        if (start == null) {
            return null;
        }
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdfDate.format(start);
        return dateString;
    }

    public void setPlaceStart(String placeStart) {
        this.placeStart = placeStart;
    }  

    public String getPlaceEnd() {
        return placeEnd;
    }

    public void setPlaceEnd(String placeEnd) {
        this.placeEnd = placeEnd;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public int getNb_seat_total() {
        return nb_seat_total;
    }

    public void setNb_seat_total(int nb_seat_total) {
        this.nb_seat_total = nb_seat_total;
    }

    public int getNb_seat_available() {
        return nb_seat_available;
    }

    public void setNb_seat_available(int nb_seat_available) {
        this.nb_seat_available = nb_seat_available;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
