public class Hire {
	private int memberid;
	private int motorBoatId;
	private String slot;

	public Hire() {
		// TODO Auto-generated constructor stub
	}

	public Hire(int memberid, int motorBoatId, String slot) {
		super();
		this.memberid = memberid;
		this.motorBoatId = motorBoatId;
		this.slot = slot;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public int getMotorBoatId() {
		return motorBoatId;
	}

	public void setMotorBoatId(int motorBoatId) {
		this.motorBoatId = motorBoatId;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

}
