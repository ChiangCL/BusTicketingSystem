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
public class Payment {

    private String PAYMENT_ID;
    private String PAYMENT_METHOD;
    private double DISCOUNT;
    private double TOTAL_AMOUNT;
    private String PAYMENT_DATE;
    private String STAFF_ID;
    private String MEMBER_ID;
    private String ORDER_ID;

    public Payment() {

    }

    public Payment(String PAYMENT_ID, String PAYMENT_METHOD, double DISCOUNT,
            double TOTAL_AMOUNT, String PAYMENT_DATE, String STAFF_ID, String MEMBER_ID, String ORDER_ID) {
        this.PAYMENT_ID = PAYMENT_ID;
        this.PAYMENT_METHOD = PAYMENT_METHOD;
        this.DISCOUNT = DISCOUNT;
        this.TOTAL_AMOUNT = TOTAL_AMOUNT;
        this.PAYMENT_DATE = PAYMENT_DATE;
        this.STAFF_ID = STAFF_ID;
        this.MEMBER_ID = MEMBER_ID;
        this.ORDER_ID = ORDER_ID;
    }

//get
    public String getPAYMENT_ID() {
        return PAYMENT_ID;
    }

    public String getPAYMENT_METHOD() {
        return PAYMENT_METHOD;
    }

    public double getDISCOUNT() {
        return DISCOUNT;
    }

    public double getTOTAL_AMOUNT() {
        return TOTAL_AMOUNT;
    }

    public String getPAYMENT_DATE() {
        return PAYMENT_DATE;
    }

    public String getSTAFF_ID() {
        return STAFF_ID;
    }

    public String getMEMBER_ID() {
        return MEMBER_ID;
    }

    public String getORDER_ID() {
        return ORDER_ID;
    }

//set
    public void setPAYMENT_ID(String PAYMENT_ID) {
        this.PAYMENT_ID = PAYMENT_ID;
    }

    public void setPAYMENT_METHOD(String PAYMENT_METHOD) {
        this.PAYMENT_METHOD = PAYMENT_METHOD;
    }

    public void setDISCOUNT(double DISCOUNT) {
        this.DISCOUNT = DISCOUNT;
    }

    public void setTOTAL_AMOUNT(double TOTAL_AMOUNT) {
        this.TOTAL_AMOUNT = TOTAL_AMOUNT;
    }

    public void setPAYMENT_DATE(String PAYMENT_DATE) {
        this.PAYMENT_DATE = PAYMENT_DATE;
    }

    public void setSTAFF_ID(String STAFF_ID) {
        this.STAFF_ID = STAFF_ID;
    }

    public void setMEMBER_ID(String MEMBER_ID) {
        this.MEMBER_ID = MEMBER_ID;
    }

    public void setORDER_ID(String ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }
}
