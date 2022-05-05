public class BookingUtil {
	public static long bookingCount(int memberId) {
		
		long count = DataLoad.loadBookings().stream().filter(item -> (item.getMemberId() == memberId)).count();
		return count;
	}
}
