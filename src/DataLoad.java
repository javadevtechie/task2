import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class DataLoad {

	public static List<MotorBoat> loadMotorBoats() {
		List<MotorBoat> motorBoats = new ArrayList<MotorBoat>();

		MotorBoat motorBoat1 = new MotorBoat();
		motorBoat1.setId(1);
		motorBoat1.setName("mb-1");

		MotorBoat motorBoat2 = new MotorBoat();
		motorBoat2.setId(2);
		motorBoat2.setName("mb-2");

		MotorBoat motorBoat3 = new MotorBoat();
		motorBoat3.setId(3);
		motorBoat3.setName("mb-3");

		MotorBoat motorBoat4 = new MotorBoat();
		motorBoat4.setId(4);
		motorBoat4.setName("mb-4");

		MotorBoat motorBoat5 = new MotorBoat();
		motorBoat5.setId(5);
		motorBoat5.setName("mb-5");

		MotorBoat motorBoat6 = new MotorBoat();
		motorBoat6.setId(6);
		motorBoat6.setName("mb-6");

		MotorBoat motorBoat7 = new MotorBoat();
		motorBoat7.setId(7);
		motorBoat7.setName("mb-7");

		MotorBoat motorBoat8 = new MotorBoat();
		motorBoat8.setId(8);
		motorBoat8.setName("mb-8");

		MotorBoat motorBoat9 = new MotorBoat();
		motorBoat9.setId(9);
		motorBoat9.setName("mb-9");

		MotorBoat motorBoat10 = new MotorBoat();
		motorBoat10.setId(10);
		motorBoat10.setName("mb-10");
		motorBoats.add(motorBoat1);
		motorBoats.add(motorBoat2);
		motorBoats.add(motorBoat3);
		motorBoats.add(motorBoat4);
		motorBoats.add(motorBoat5);
		motorBoats.add(motorBoat6);
		motorBoats.add(motorBoat7);
		motorBoats.add(motorBoat8);
		motorBoats.add(motorBoat9);
		motorBoats.add(motorBoat10);

		return motorBoats;

	}

	public static List<Lesson> loadLessions() {
		Lesson lesson = new Lesson();
		lesson.setId(1);
		lesson.setName("lesson-1");

		Lesson lesson1 = new Lesson();
		lesson1.setId(2);
		lesson1.setName("lesson-2");

		Lesson lesson2 = new Lesson();
		lesson2.setId(3);
		lesson2.setName("lesson-3");

		Lesson lesson3 = new Lesson();
		lesson3.setId(4);
		lesson3.setName("lesson-4");

		List<Lesson> lessons = new ArrayList<Lesson>();
		lessons.add(lesson);
		lessons.add(lesson1);
		lessons.add(lesson2);
		lessons.add(lesson3);
		return lessons;
	}

	public static List<Instructor> loadInstructors() {

		List<Member> loadMembersData = loadMembers();

		List<Instructor> instructors = new ArrayList<>();
		Instructor instructor = new Instructor();
		instructor.setId(1);
		instructor.setName("Joys");
		instructor.setNovice(loadMembersData.get(0));
		instructors.add(instructor);

		Instructor instructor1 = new Instructor();
		instructor1.setId(2);
		instructor1.setName("Boyas");
		instructor1.setNovice(loadMembersData.get(1));
		instructors.add(instructor1);

		return instructors;

	}

	public static List<Member> loadMembers() {
		List<Member> MembersList = new ArrayList<>();

		Member novice1 = new Novice();
		novice1.setId(1);
		novice1.setMemberType("novice");
		novice1.setName("Chloe");

		Member novice2 = new Novice();
		novice2.setId(2);
		novice2.setMemberType("novice");
		novice2.setName("Charlotte");

		Member novice3 = new Novice();
		novice3.setId(3);
		novice3.setMemberType("novice");
		novice3.setName("Grace");

		Member mblh = new MBLH();
		mblh.setId(4);
		mblh.setName("Joshua");
		mblh.setMemberType("mblh");

		Member mblh1 = new MBLH();
		mblh1.setId(5);
		mblh1.setName("Thomas");
		mblh1.setMemberType("mblh");

		Member mblh2 = new MBLH();
		mblh2.setId(6);
		mblh2.setName("Daniel");
		mblh2.setMemberType("mblh");

		MembersList.add(novice1);
		MembersList.add(novice2);
		MembersList.add(novice3);

		MembersList.add(mblh);
		MembersList.add(mblh1);
		MembersList.add(mblh2);

		return MembersList;

	}

	public static List<Booking> loadBookings() {

		List<Booking> bookings = new ArrayList<Booking>();

		Booking booking = new Booking();
		booking.setMemberId(loadMembers().get(0).getId());
		booking.setSlot("1-09:00");
		booking.setLessonId(loadLessions().get(0).getId());
		booking.setMotorBoatId(loadMotorBoats().get(0).getId());
		booking.setInstructorId(loadInstructors().get(0).getId());
		
		Booking booking2 = new Booking();
		booking2.setMemberId(loadMembers().get(0).getId());
		booking2.setSlot("2-09:00");
		booking2.setLessonId(loadLessions().get(0).getId());
		booking2.setMotorBoatId(loadMotorBoats().get(0).getId());
		booking2.setInstructorId(loadInstructors().get(0).getId());
		
		Booking booking1 = new Booking();
		booking1.setMemberId(loadMembers().get(1).getId());
		booking1.setSlot("2-09:00");
		booking1.setLessonId(loadLessions().get(1).getId());
		booking1.setMotorBoatId(loadMotorBoats().get(1).getId());
		booking1.setInstructorId(loadInstructors().get(1).getId());
		bookings.add(booking);
		bookings.add(booking1);
		bookings.add(booking2);
		return bookings;
	}
}
