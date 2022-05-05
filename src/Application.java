import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) {

	}

	public static void getMemberDetails() {
		System.out.println("List of Members");
		showListOfMembers();
		System.out.println("Please enter the Member Id");
		Scanner sc = new Scanner(System.in);
		int memId = sc.nextInt();
		List<Booking> bookings = DataLoad.loadBookings().stream().filter(item -> item.getMemberId() == memId)
				.collect(Collectors.toList());
		if (bookings.isEmpty()) {
			System.out.print("There are no bookings available for this member");
			
		} else {
				
		}

	}

	public static void booklessonForMember() {
		System.out.println("List of Members");

		Scanner sc = new Scanner(System.in);
		int memId = 0;
		boolean flag = true;
		while (flag) {

			showListOfMembers();
			System.out.println("Please enter the Member Id");
			memId = sc.nextInt();
			if (BookingUtil.bookingCount(memId) < 2) {
				flag = false;
			}
		}

		mainSection(memId);
	}

	public static void mainSection(int memId) {
		Scanner sc = new Scanner(System.in);
		if (BookingUtil.bookingCount(memId) < 3) {
			Optional<Member> memberOp = DataLoad.loadMembers().stream().filter(item -> item.getId() == memId)
					.findFirst();
			if (memberOp.isPresent()) {
				Member member = memberOp.get();
				int instructorId = 0;
				if (member.getMemberType().contains("novice")) {
					Optional<Instructor> instructorOp = DataLoad.loadInstructors().stream()
							.filter(item -> item.getNovice().getId() == memId).findFirst();
					if (instructorOp.isPresent()) {
						Instructor instructor = instructorOp.get();
						instructorId = instructor.getId();
						System.out.println(instructor.getName());

					}
				} else if (member.getMemberType().contains("mblh")) {
					printInstructors();

					System.out.print("Please enter the instructor id");
					instructorId = sc.nextInt();

				}

				slotBooking(instructorId, memId, sc);
				System.out.println("Booking is confirmed successfully");
			}
		}

	}

	private static void slotBooking(int instructorId, int memId, Scanner sc) {

		List<String> bookedSlots = DataLoad.loadBookings().stream()
				.filter(item -> item.getInstructorId() == instructorId).map(item -> item.getSlot())
				.collect(Collectors.toList());
		System.out.println("----Instructor Name----");
		System.out.println("-----Booked slots----");
		bookedSlots.stream().forEach(System.out::println);
		System.out.println("-----Available slots----");
		List<String> totallist = getAllslots();
		final List<String> availableSlots = totallist.stream().filter(x -> !bookedSlots.contains(x))
				.collect(Collectors.toList());
		System.out.println(String.join(",", availableSlots));
		System.out.println("Enter the Slot\nDay :");
		String day = sc.next();
		System.out.println("Enter the Slot\nHour :");
		String hour = sc.next();
		String slot = day.concat("-").concat(hour).concat(":00");
		printMotoboats();
		System.out.println("Enter the Motorboat Id:");
		int boatId = sc.nextInt();
		boolean availableSlot = isAvailableSlot(memId, instructorId, slot);
		if (!availableSlot) {
			System.out.println("Member or Instructor is already involved in lesson at this proposed time");
		}
		boolean availMotorBoat = isMotorBoatAvail(boatId);
		// Need to check if motorboat is not available for other one need to check
		boolean counter = true;
		while (counter && !availMotorBoat) {
			System.out.println("Enter Motor boat is not available for given slot");
			printMotoboats();
			System.out.println("Enter the Motorboat Id:");
			boatId = sc.nextInt();
			if (isMotorBoatAvail(boatId)) {
				counter = false;
				availMotorBoat = true;
			}
		}

		if (availableSlot && availMotorBoat) {
			Booking booking = new Booking(memId, instructorId, 1, slot, boatId);
			List<Booking> loadBookings = DataLoad.loadBookings();
			loadBookings.add(booking);
			DataLoad.loadBookings().add(booking);

		}

		System.out.println(DataLoad.loadBookings().size());
		System.out.println();
	}

	private static boolean isMotorBoatAvail(int boatId) {
		Optional<Booking> bookingOp = DataLoad.loadBookings().stream().filter(item -> item.getMotorBoatId() == boatId)
				.findFirst();
		if (bookingOp.isPresent()) {
			return false;
		}

		return true;
	}

	private static void printMotoboats() {
		System.out.println("ID| MotorBoat");
		DataLoad.loadMotorBoats().forEach(item -> {
			System.out.println(item.getId() + "|" + item.getName());
		});

	}

	private static void printInstructors() {
		System.out.println("ID| MotorBoat");
		DataLoad.loadInstructors().forEach(item -> {
			System.out.println(item.getId() + "|" + item.getName());
		});

	}

	private static boolean isAvailableSlot(int memId, int instruid, String slot) {

		Optional<Booking> bookingOp = DataLoad.loadBookings().stream().filter(item -> (item.getSlot().contains(slot)
				&& item.getMemberId() == memId && item.getInstructorId() == instruid)).findFirst();
		if (bookingOp.isPresent()) {
			return false;
		}

		return true;
	}

	static void showListOfMembers() {
		System.out.println("MemId|  Member Name");
		for (Member mem : DataLoad.loadMembers()) {

			System.out.println(mem.getId() + "|" + mem.getName());
		}
	}

	static List<String> getAllslots() {
		String slots[] = { "1-09:00", "1-10:00", "1-11:00", "1-12:00", "1-13:00", "1-14:00", "1-15:00", "1-16:00",
				"1-17:00", "1-18:00", "2-09:00", "2-10:00", "2-11:00", "2-12:00", "2-13:00", "2-14:00", "2-15:00",
				"2-16:00", "2-17:00", "2-18:00", "3-09:00", "3-10:00", "3-11:00", "3-12:00", "3-13:00", "3-14:00",
				"3-15:00", "3-16:00", "3-17:00", "3-18:00", "4-09:00", "4-10:00", "4-11:00", "4-12:00", "4-13:00",
				"4-14:00", "4-15:00", "4-16:00", "4-17:00", "4-18:00", "5-09:00", "5-10:00", "5-11:00", "5-12:00",
				"5-13:00", "5-14:00", "5-15:00", "5-16:00", "5-17:00", "5-18:00", "6-09:00", "6-10:00", "6-11:00",
				"6-12:00", "6-13:00", "6-14:00", "6-15:00", "6-16:00", "6-17:00", "6-18:00", "7-09:00", "7-10:00",
				"7-11:00", "7-12:00", "7-13:00", "7-14:00", "7-15:00", "7-16:00", "7-17:00", "7-18:00" };

		return Arrays.asList(slots);
	}
}
