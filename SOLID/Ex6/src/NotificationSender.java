public abstract class NotificationSender {

    protected final AuditLog audit;

    protected final NotificationFormatter formatter;

    protected final NotificationValidator validator;

    protected NotificationSender(
            AuditLog audit,
            NotificationFormatter formatter,
            NotificationValidator validator
    ) {
        this.audit = audit;
        this.formatter = formatter;
        this.validator = validator;
    }

    public final void send(Notification n) {

        if (validator != null)
            validator.validate(n);

        if (formatter != null)
            n = formatter.format(n);

        doSend(n);
    }

    protected abstract void doSend(Notification n);
}