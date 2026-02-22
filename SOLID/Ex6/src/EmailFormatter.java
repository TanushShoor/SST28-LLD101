public class EmailFormatter implements NotificationFormatter {

    private final int maxLen;

    public EmailFormatter(int maxLen) {
        this.maxLen = maxLen;
    }

    @Override
    public Notification format(Notification n) {

        String body = n.body;

        if (body != null && body.length() > maxLen) {
            body = body.substring(0, maxLen);
        }

        return new Notification(
                n.subject,
                body,
                n.email,
                n.phone
        );
    }
}