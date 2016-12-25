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
public class Package {

    private String PACKAGE_ID;
    private String DESTINATION;
    private double PRICE;
    private String DAY;
    private String TIME;
    private String BUS_ID;
    public static int Count_Package = 0;

    public Package() {

    }

    public Package(String PACKAGE_ID, String DESTINATION, double PRICE, String DAY, String TIME, String BUS_ID) {
        this.PACKAGE_ID = PACKAGE_ID;
        this.DESTINATION = DESTINATION;
        this.PRICE = PRICE;
        this.DAY = DAY;
        this.TIME = TIME;
        this.BUS_ID = BUS_ID;
        Count_Package++;
    }

//get
    public String getPACKAGE_ID() {
        return PACKAGE_ID;
    }

    public String getDESTINATION() {
        return DESTINATION;
    }

    public double getPRICE() {
        return PRICE;
    }

    public String getDAY() {
        return DAY;
    }

    public String getTIME() {
        return TIME;
    }

    public String getBUS_ID() {
        return BUS_ID;
    }

//set
    public void setPACKAGE_ID(String PACKAGE_ID) {
        this.PACKAGE_ID = PACKAGE_ID;
    }

    public void setDESTINATION(String DESTINATION) {
        this.DESTINATION = DESTINATION;
    }

    public void setPRICE(double PRICE) {
        this.PRICE = PRICE;
    }

    public void setDAY(String DAY) {
        this.DAY = DAY;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    public void setBUS_ID(String BUS_ID) {
        this.BUS_ID = BUS_ID;
    }
}
