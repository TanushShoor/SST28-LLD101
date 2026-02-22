public class InvoiceFormatter {

    public static String format(String invoiceId, InvoiceSummary s) {

        StringBuilder out = new StringBuilder();

        out.append("Invoice# ").append(invoiceId).append("\n");

        out.append(s.details);

        out.append(String.format("Subtotal: %.2f\n", s.subtotal));

        out.append(String.format("Tax(%.0f%%): %.2f\n", s.taxPct, s.tax));

        out.append(String.format("Discount: -%.2f\n", s.discount));

        out.append(String.format("TOTAL: %.2f\n", s.total));

        return out.toString();
    }
}