/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Chan Guan Hao
 */
import Da.Order_TableDa;
import Domain.Order_Table;

public class MaintainOrderControl {

    private Order_TableDa order_tableDa;

    public MaintainOrderControl() {
        order_tableDa = new Order_TableDa();
    }

    public Order_Table selectRecord(String ORDER_ID) {
        return order_tableDa.getOrderRecordWithId(ORDER_ID);
    }

    public void addRecord(Order_Table order_table) {
        order_tableDa.addOnNewOrderRecord(order_table);
    }

    public void UpdateRecord(Order_Table order_table) {
        order_tableDa.updateOrderRecord(order_table);
    }

    /*public void DeleteRecord(Bus bus) {
     busDa.deleteBusRecordWithId(bus);
     }*/
    public String GetNewOrderCode() {
        String tmpCode = "";
        for (int i = 0; i >= 0; i++) {
            tmpCode = "O" + (i + 1);
            Order_Table order_table = order_tableDa.getOrderRecordWithId(tmpCode);
            if (order_table == null) {
                break;
            }
        }
        return tmpCode;
    }
}
