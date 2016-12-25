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
import Da.PackageDa;
import Domain.Package;

public class MaintainPackageControl {

    private PackageDa packageDa;

    public MaintainPackageControl() {
        packageDa = new PackageDa();
    }

    public Package selectRecord(String PACKAGE_ID) {
        return packageDa.getPackageRecordWithId(PACKAGE_ID);
    }

    public void addRecord(Package _package) {
        packageDa.addOnNewPackageRecord(_package);
    }

    public void UpdateRecord(Package _package) {
        packageDa.updatePackageRecord(_package);
    }

    public void DeleteRecord(Package _package) {
        packageDa.deletePackageRecordWithId(_package);
    }

    public String GetNewPackageCode() {
        String tmpCode = "";
        for (int i = 0; i >= 0; i++) {
            tmpCode = "P" + (i + 1);
            Package _package = packageDa.getPackageRecordWithId(tmpCode);
            if (_package == null) {
                break;
            }
        }
        return tmpCode;
    }
}
