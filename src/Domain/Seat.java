/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Guanhaochan
 */
public class Seat {

    private String SEAT_ID;
    private String SEAT_NO;

    public Seat() {
    }

    public Seat(String SEAT_NO) {
        this.SEAT_NO = SEAT_NO;
    }

    public Seat(String SEAT_ID, String SEAT_NO) {
        this.SEAT_ID = SEAT_ID;
        this.SEAT_NO = SEAT_NO;

    }

//get
    public String getSEAT_ID() {
        return SEAT_ID;
    }

    public String getSEAT_NO() {
        return SEAT_NO;
    }

//set
    public void setSEAT_ID(String SEAT_ID) {
        this.SEAT_ID = SEAT_ID;
    }

    public void setSEAT_NO(String SEAT_NO) {
        this.SEAT_NO = SEAT_NO;
    }

}
