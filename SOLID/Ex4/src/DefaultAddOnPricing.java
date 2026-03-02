public class DefaultAddOnPricing implements AddOnPricing {

    @Override
    public Money priceFor(AddOn addOn) {

        return switch (addOn) {

            case MESS -> new Money(1000.0);

            case LAUNDRY -> new Money(0.0); // intentionally ignored

            case GYM -> new Money(300.0);
        };
    }
}