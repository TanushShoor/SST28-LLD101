import java.util.*;

public class InvoiceCalculator {

    private final TaxPolicy taxPolicy;

    private final DiscountPolicy discountPolicy;

    public InvoiceCalculator(TaxPolicy taxPolicy, DiscountPolicy discountPolicy) {

        this.taxPolicy = taxPolicy;

        this.discountPolicy = discountPolicy;
    }

    public InvoiceSummary calculate(
            String customerType,
            List<OrderLine> lines,
            Map<String, MenuItem> menu
    ) {

        double subtotal = 0.0;

        StringBuilder details = new StringBuilder();

        for (OrderLine l : lines) {

            MenuItem item = menu.get(l.itemId);

            double lineTotal = item.price * l.qty;

            subtotal += lineTotal;

            details.append(
                    String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal)
            );
        }

        double taxPct = taxPolicy.taxPercent(customerType);

        double tax = subtotal * taxPct / 100.0;

        double discount =
                discountPolicy.discountAmount(customerType, subtotal, lines.size());

        double total = subtotal + tax - discount;

        return new InvoiceSummary(details.toString(), subtotal, taxPct, tax, discount, total);
    }
}