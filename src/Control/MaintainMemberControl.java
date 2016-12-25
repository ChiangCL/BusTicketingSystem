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
import Da.MemberDa;
import Domain.Member;

public class MaintainMemberControl {

    private MemberDa memberDa;

    public MaintainMemberControl() {
        memberDa = new MemberDa();
    }

    public Member selectRecord(String MEMBER_ID) {
        return memberDa.getMemberRecordWithId(MEMBER_ID);
    }

    public void addRecord(Member member) {
        memberDa.addOnNewMemberRecord(member);
    }

    public void UpdateRecord(Member member) {
        memberDa.updateMemberRecord(member);
    }

    public void DeleteRecord(Member member) {
        memberDa.deleteMemberRecordWithId(member);
    }

    public String GetNewMemberCode() {
        String tmpCode = "";
        for (int i = 0; i >= 0; i++) {
            tmpCode = "M" + (i + 1);
            Member member = memberDa.getMemberRecordWithId(tmpCode);
            if (member == null) {
                break;
            }
        }
        return tmpCode;
    }
}
