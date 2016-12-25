/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Guanhaochan
 */
import Da.OrderDetailDa;
import Domain.Order_Detail;

public class MaintainOrderDetailControl {

    private OrderDetailDa orderdetailDa;

    public MaintainOrderDetailControl() {
        orderdetailDa = new OrderDetailDa();
    }

    public Order_Detail selectRecord(String ORDER_ID) {
        return orderdetailDa.getOrderDetailRecordWithId(ORDER_ID);
    }

    public void addRecord(Order_Detail orderdetail) {
        orderdetailDa.addOnNewOrderDetailRecord(orderdetail);
    }

    public Order_Detail RetrieveTicketNo(String PACKAGE_ID, String DEPARTURE_DATE, String DEPARTURE_TIME) {
        return orderdetailDa.checkingseatavail(PACKAGE_ID, DEPARTURE_DATE, DEPARTURE_TIME);
    }

    public void UpdateRecord(Order_Detail orderdetail) {
        orderdetailDa.updateOrderDetailRecord(orderdetail);
    }

    /*public void DeleteRecord(Bus bus) {
     busDa.deleteBusRecordWithId(bus);
     }

     public String GetNewBusCode() {
     String tmpCode = "";
     for (int i = 0; i >= 0; i++) {
     tmpCode = "B" + (i + 1);
     Bus bus = busDa.getBusRecordWithId(tmpCode);
     if (bus == null) {
     break;
     }
     }
     return tmpCode;
     }*/
}
