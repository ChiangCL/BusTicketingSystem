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
import Da.BusDa;
import Da.StaffDa;
import Domain.Bus;
import Domain.Staff;

public class MaintainBusControl {

    private StaffDa staffDa;
    private BusDa busDa;

    public MaintainBusControl() {
        busDa = new BusDa();
        staffDa = new StaffDa();
    }

    public Bus selectRecord(String BUS_ID) {
        return busDa.getBusRecordWithId(BUS_ID);
    }

    public void addRecord(Bus bus) {
        busDa.addOnNewBusRecord(bus);
    }

    public void UpdateRecord(Bus bus) {
        busDa.updateBusRecord(bus);
    }

    public void DeleteRecord(Bus bus) {
        busDa.deleteBusRecordWithId(bus);
    }

    public String RetrieveBus(String PACKAGE_ID) {
        return busDa.RetrieveBusNo(PACKAGE_ID);
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
    }

}
