import java.util.List;
import java.util.stream.Collectors;

public class BookingUtil {
	public static long bookingCount(int memberId) {

		long count = DataLoad.loadBookings().stream().filter(item -> (item.getMemberId() == memberId)).count();
		return count;
	}

	public static long hireCount(int memberId) {

		long count = DataLoad.loadBoatHires().stream().filter(item -> item.getMemberid() == memberId).count();
		return count;
	}

	public static long noofBoatsBusyAtThisSlot(String slot) {
		List<Integer> list = DataLoad.loadBookings().stream().filter(item -> item.getSlot().equalsIgnoreCase(slot))
				.map(item -> item.getMotorBoatId()).distinct().collect(Collectors.toList());
		List<Integer> list1 = DataLoad.loadBoatHires().stream().filter(item -> item.getSlot().equalsIgnoreCase(slot))
				.map(item -> item.getMotorBoatId()).distinct().collect(Collectors.toList());
		list.addAll(list1);
		list.stream().distinct().collect(Collectors.toList()).size();
		return list.size();
	}
}
