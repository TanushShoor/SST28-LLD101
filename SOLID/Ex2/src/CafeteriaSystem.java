import java.util.*;

public class CafeteriaSystem {

    private final Map<String, MenuItem> menu = new LinkedHashMap<>();

    private final InvoiceRepository repository;

    private final InvoiceCalculator calculator;

    private int invoiceSeq = 1000;

    public CafeteriaSystem() {

        TaxPolicy taxPolicy = new DefaultTaxPolicy();

        DiscountPolicy discountPolicy = new DefaultDiscountPolicy();

        this.calculator = new InvoiceCalculator(taxPolicy, discountPolicy);

        this.repository = new FileInvoiceRepository();
    }

    public void addToMenu(MenuItem i) {

        menu.put(i.id, i);
    }

    public void checkout(String customerType, List<OrderLine> lines) {

        String invId = "INV-" + (++invoiceSeq);

        InvoiceSummary summary =
                calculator.calculate(customerType, lines, menu);

        String printable = InvoiceFormatter.format(invId, summary);

        System.out.print(printable);

        repository.save(invId, printable);

        System.out.println(
                "Saved invoice: " + invId +
                        " (lines=" + repository.countLines(invId) + ")"
        );
    }
}