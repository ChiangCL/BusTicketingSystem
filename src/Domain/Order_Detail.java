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
public class Order_Detail {

    private String ORDER_ID;
    private String PACKAGE_ID;
    private String DEPARTURE_DATE;
    private String DEPARTURE_TIME;
    private double SUBTOTAL;
    private String SEAT_ID;
    private int TICKET_NO;

    public Order_Detail() {

    }

    public Order_Detail(String ORDER_ID, String PACKAGE_ID, String DEPARTURE_DATE, String DEPARTURE_TIME, double SUBTOTAL, String SEAT_ID, int TICKET_NO) {
        this.ORDER_ID = ORDER_ID;
        this.PACKAGE_ID = PACKAGE_ID;
        this.DEPARTURE_DATE = DEPARTURE_DATE;
        this.DEPARTURE_TIME = DEPARTURE_TIME;
        this.SUBTOTAL = SUBTOTAL;
        this.SEAT_ID = SEAT_ID;
        this.TICKET_NO = TICKET_NO;
    }

//get
    public String getORDER_ID() {
        return ORDER_ID;
    }

    public String getPACKAGE_ID() {
        return PACKAGE_ID;
    }

    public String getDEPARTURE_DATE() {
        return DEPARTURE_DATE;
    }

    public String getDEPARTURE_TIME() {
        return DEPARTURE_TIME;
    }

    public double getSUBTOTAL() {
        return SUBTOTAL;
    }

    public String getSEAT_ID() {
        return SEAT_ID;
    }

    public int getTICKET_NO() {
        return TICKET_NO;
    }

//set
    public void setORDER_ID(String ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }

    public void setPACKAGE_ID(String PACKAGE_ID) {
        this.PACKAGE_ID = PACKAGE_ID;
    }

    public void setDEPARTURE_DATE(String DEPARTURE_DATE) {
        this.DEPARTURE_DATE = DEPARTURE_DATE;
    }

    public void setDEPARTURE_TIME(String DEPARTURE_TIME) {
        this.DEPARTURE_TIME = DEPARTURE_TIME;
    }

    public void setSUBTOTAL(double SUBTOTAL) {
        this.SUBTOTAL = SUBTOTAL;
    }

    public void setSEAT_ID(String SEAT_ID) {
        this.SEAT_ID = SEAT_ID;
    }

    public void setTICKET_NO(int TICKET_NO) {
        this.TICKET_NO = TICKET_NO;
    }

    public String toString() {
        return String.format("%-4s, %-4s, %-10s, %-10s, %-.2f, %-4s, %-2d",
                ORDER_ID, PACKAGE_ID, DEPARTURE_DATE, DEPARTURE_TIME, SUBTOTAL, SEAT_ID, TICKET_NO);
    }
}
