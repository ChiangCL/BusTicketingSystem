//This class is use for get and set variables
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
public class Staff {

    private String STAFF_ID;
    private String STAFF_NAME;
    private String STAFF_IC;
    private String ADDRESS;
    private String CONTACT_NO;
    private String POSITION;
    private String PASSWORD;
    public static int Count_Staff = 0;

    public Staff() {

    }

    public Staff(String STAFF_ID) {
        this.STAFF_ID = STAFF_ID;
    }

    public Staff(String STAFF_ID, String STAFF_NAME, String STAFF_IC) {
        this.STAFF_ID = STAFF_ID;
        this.STAFF_NAME = STAFF_NAME;
        this.STAFF_IC = STAFF_IC;
    }

    public Staff(String STAFF_ID, String STAFF_NAME, String STAFF_IC, String ADDRESS, String CONTACT_NO, String POSITION, String PASSWORD) {
        this.STAFF_ID = STAFF_ID;
        this.STAFF_NAME = STAFF_NAME;
        this.STAFF_IC = STAFF_IC;
        this.ADDRESS = ADDRESS;
        this.CONTACT_NO = CONTACT_NO;
        this.POSITION = POSITION;
        this.PASSWORD = PASSWORD;
        Count_Staff++;
    }

//get
    public String getSTAFF_ID() {
        return STAFF_ID;
    }

    public String getSTAFF_NAME() {
        return STAFF_NAME;
    }

    public String getSTAFF_IC() {
        return STAFF_IC;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public String getCONTACT_NO() {
        return CONTACT_NO;
    }

    public String getPOSITION() {
        return POSITION;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

//set
    public void setSTAFF_ID(String STAFF_ID) {
        this.STAFF_ID = STAFF_ID;
    }

    public void setSTAFF_NAME(String STAFF_NAME) {
        this.STAFF_NAME = STAFF_NAME;
    }

    public void setSTAFF_IC(String STAFF_IC) {
        this.STAFF_IC = STAFF_IC;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public void setCONTACT_NO(String CONTACT_NO) {
        this.CONTACT_NO = CONTACT_NO;
    }

    public void setPOSITION(String POSITION) {
        this.POSITION = POSITION;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String toString() {
        return String.format("%-4s, %-40s, %-14s, %-120s, %-11s, %-15s, %-12s",
                STAFF_ID, STAFF_NAME, STAFF_IC, ADDRESS, CONTACT_NO, POSITION, PASSWORD);
    }
}
