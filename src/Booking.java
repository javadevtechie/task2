
public class Booking {

	private int memberId;

	private int instructorId;

	private int lessonId;

	private String slot;

	private int motorBoatId;

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(int memberId, int instructorId, int lessonId, String slot, int motorBoatId) {
		super();
		this.memberId = memberId;
		this.instructorId = instructorId;
		this.lessonId = lessonId;
		this.slot = slot;
		this.motorBoatId = motorBoatId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public int getMotorBoatId() {
		return motorBoatId;
	}

	public void setMotorBoatId(int motorBoatId) {
		this.motorBoatId = motorBoatId;
	}

}
