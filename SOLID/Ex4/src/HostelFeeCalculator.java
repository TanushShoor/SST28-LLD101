import java.util.*;

public class HostelFeeCalculator {

    private final FakeBookingRepo repo;

    private final RoomPricing roomPricing;

    private final AddOnPricing addOnPricing;

    // ADD THIS FIELD
    private final Random random = new Random(1);

    public HostelFeeCalculator(FakeBookingRepo repo) {

        this.repo = repo;

        this.roomPricing = new DefaultRoomPricing();

        this.addOnPricing = new DefaultAddOnPricing();
    }

    public void process(BookingRequest req) {

        Money monthly = calculateMonthly(req);

        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        // FIX HERE
        String bookingId = "H-" + (7000 + random.nextInt(1000));

        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {

        Money total = roomPricing.priceFor(req.roomType);

        for (AddOn addOn : req.addOns) {

            total = total.plus(addOnPricing.priceFor(addOn));
        }

        return total;
    }
}