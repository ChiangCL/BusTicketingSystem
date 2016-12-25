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
import Da.PaymentDa;
import Domain.Payment;

public class MaintainPaymentControl {

    private PaymentDa paymentDa;

    public MaintainPaymentControl() {
        paymentDa = new PaymentDa();
    }

    public Payment selectRecord(String PAYMENT_ID) {
        return paymentDa.getPaymentRecordWithId(PAYMENT_ID);
    }

    public void addRecord(Payment payment) {
        paymentDa.addOnNewPaymentRecord(payment);
    }

    public void UpdateRecord(Payment payment) {
        paymentDa.updatePaymentRecord(payment);
    }

    /*public void DeleteRecord(Bus bus) {
     busDa.deleteBusRecordWithId(bus);
     }
     */
    public String GetNewPaymentCode() {
        String tmpCode = "";
        for (int i = 0; i >= 0; i++) {
            tmpCode = "PY" + (i + 1);
            Payment payment = paymentDa.getPaymentRecordWithId(tmpCode);
            if (payment == null) {
                break;
            }
        }
        return tmpCode;
    }
}
