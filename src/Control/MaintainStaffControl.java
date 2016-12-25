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
import Da.StaffDa;
import Da.BusDa;
import Domain.Bus;
import Domain.Staff;

public class MaintainStaffControl {

    private StaffDa staffDa;

    public MaintainStaffControl() {
        staffDa = new StaffDa();
    }

    public Staff selectRecord(String STAFFID) {
        return staffDa.getStaffRecordWithId(STAFFID);
    }

    public void addRecord(Staff staff) {
        staffDa.addOnNewStaffRecord(staff);
    }

    public void UpdateRecord(Staff staff) {
        staffDa.updateStaffRecord(staff);
    }

    public void DeleteRecord(Staff staff) {
        staffDa.deleteStaffRecordWithId(staff);
    }

    public String RetrieveDriver(String BUS_NO) {
        return staffDa.RetrieveDriverName(BUS_NO);
    }

    public void UpdatePassword(Staff staff) {
        staffDa.updateStaffRecord(staff);
    }

    public String GetNewStaffCode() {
        String tmpCode = "";
        for (int i = 0; i >= 0; i++) {
            tmpCode = "S" + (i + 1);
            Staff staff = staffDa.getStaffRecordWithId(tmpCode);
            if (staff == null) {
                break;
            }
        }
        return tmpCode;
    }
}
