/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Chan Guan Hao & Lim Zhen Kai
 */
public class Bus {

    private String BUS_ID;
    private String BUS_NO;
    private int SEAT;
    private String BUS_MODEL;
    private String STAFF_ID;
    public static int Count_Bus = 0;

    public Bus() {
    }

    public Bus(String BUS_ID) {
        this.BUS_ID = BUS_ID;
    }

    public Bus(String BUS_ID, String BUS_NO, int SEAT, String BUS_MODEL, String STAFF_ID) {
        this.BUS_ID = BUS_ID;
        this.BUS_NO = BUS_NO;
        this.SEAT = SEAT;
        this.BUS_MODEL = BUS_MODEL;
        this.STAFF_ID = STAFF_ID;
        Count_Bus++;
    }

//get
    public String getBUS_ID() {
        return BUS_ID;
    }

    public String getBUS_NO() {
        return BUS_NO;
    }

    public int getSEAT() {
        return SEAT;
    }

    public String getBUS_MODEL() {
        return BUS_MODEL;
    }

    public String getSTAFF_ID() {
        return STAFF_ID;
    }

//set
    public void setBUS_ID(String BUS_ID) {
        this.BUS_ID = BUS_ID;
    }

    public void setBUS_NO(String BUS_NO) {
        this.BUS_NO = BUS_NO;
    }

    public void setSEAT(int SEAT) {
        this.SEAT = SEAT;
    }

    public void setBUS_MODEL(String BUS_MODEL) {
        this.BUS_MODEL = BUS_MODEL;
    }

    public void setSTAFF_ID(String STAFF_ID) {
        this.STAFF_ID = STAFF_ID;
    }
}
