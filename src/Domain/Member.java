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
public class Member {

    private String MEMBER_ID;
    private String MEMBER_NAME;
    private String MEMBER_IC;
    private String ADDRESS;
    private String CONTACT_NO;
    public static int Count_Member = 0;

    public Member() {
    }

    public Member(String MEMBER_ID) {
        this.MEMBER_ID = MEMBER_ID;
    }

    public Member(String MEMBER_ID, String MEMBER_NAME, String MEMBER_IC, String ADDRESS, String CONTACT_NO) {
        this.MEMBER_ID = MEMBER_ID;
        this.MEMBER_NAME = MEMBER_NAME;
        this.MEMBER_IC = MEMBER_IC;
        this.ADDRESS = ADDRESS;
        this.CONTACT_NO = CONTACT_NO;
        Count_Member++;
    }

//get
    public String getMEMBER_ID() {
        return MEMBER_ID;
    }

    public String getMEMBER_NAME() {
        return MEMBER_NAME;
    }

    public String getMEMBER_IC() {
        return MEMBER_IC;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public String getCONTACT_NO() {
        return CONTACT_NO;
    }

//set
    public void setMEMBER_ID(String MEMBER_ID) {
        this.MEMBER_ID = MEMBER_ID;
    }

    public void setMEMBER_NAME(String MEMBER_NAME) {
        this.MEMBER_NAME = MEMBER_NAME;
    }

    public void setMEMBER_IC(String MEMBER_IC) {
        this.MEMBER_IC = MEMBER_IC;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public void setCONTACT_NO(String CONTACT_NO) {
        this.CONTACT_NO = CONTACT_NO;
    }
}
