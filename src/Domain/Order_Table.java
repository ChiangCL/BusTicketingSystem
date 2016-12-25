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
public class Order_Table {

    private String ORDER_ID;
    private String ORDER_DATE;

    public Order_Table() {
    }

    public Order_Table(String ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }

    public Order_Table(String ORDER_ID, String ORDER_DATE) {
        this.ORDER_ID = ORDER_ID;
        this.ORDER_DATE = ORDER_DATE;

    }

//get
    public String getORDER_ID() {
        return ORDER_ID;
    }

    public String getORDER_DATE() {
        return ORDER_DATE;
    }

//set
    public void setORDER_ID(String ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }

    public void setORDER_DATE(String ORDER_DATE) {
        this.ORDER_DATE = ORDER_DATE;
    }

}
