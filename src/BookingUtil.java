import java.util.List;

public class BookingUtil {
	public static long bookingCount(int memberId) {
		List<Booking> loadBookings = DataLoad.loadBookings();
		long count = loadBookings.stream().filter(item -> (item.getMemberId() == memberId)).count();
		return count;
	}
}
