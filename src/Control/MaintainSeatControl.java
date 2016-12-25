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
import Da.SeatDa;
import Domain.Seat;

public class MaintainSeatControl {

    private SeatDa seatDa;

    public MaintainSeatControl() {
        seatDa = new SeatDa();
    }

    public Seat selectRecord(String SEAT_ID) {
        return seatDa.getSeatRecordWithId(SEAT_ID);
    }

    public String[] selectSeatNoRecord(String SEAT_ID) {
        return seatDa.getSeatRecordSeatNo(SEAT_ID);
    }
    
    public String selectSeatRecord(String SEAT_ID) {
        return seatDa.getSeatRecord(SEAT_ID);
    }

    public void addRecord(Seat seat) {
        seatDa.addOnNewSeatRecord(seat);
    }

    public void UpdateRecord(Seat seat, String seatno) {
        seatDa.updateSeatRecord(seat, seatno);
    }

    /*public void DeleteRecord(Bus bus) {
     busDa.deleteBusRecordWithId(bus);
     }*/
    /*public boolean ConfirmTicketNo(String ticketno) {
     Seat seat = seatDa.getSeatRecordWithSeatNo(ticketno);
     if(seat == null){
     return true;
     }else{
     return false;
     }

     }*/
    public String GetNewSeatCode() {
        String tmpCode = "";
        for (int i = 0; i >= 0; i++) {
            tmpCode = "ST" + (i + 1);
            Seat seat = seatDa.getSeatRecordWithId(tmpCode);
            if (seat == null) {
                break;
            }
        }
        return tmpCode;
    }
}
