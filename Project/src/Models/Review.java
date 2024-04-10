/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author jilssa
 */
public class Review {

    private String date_resena;
    private String review_reservation;

    public Review(String date_resena, String review_reservation) {
        this.date_resena = date_resena;
        this.review_reservation = review_reservation;
    }

    public String getDate_resena() {
        return date_resena;
    }

    public void setDate_resena(String date_resena) {
        this.date_resena = date_resena;
    }

    public String getReview_reservation() {
        return review_reservation;
    }

    public void setReview_reservation(String review_reservation) {
        this.review_reservation = review_reservation;
    }
}
