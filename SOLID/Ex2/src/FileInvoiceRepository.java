public class FileInvoiceRepository implements InvoiceRepository {

    private final FileStore store = new FileStore();

    @Override
    public void save(String id, String content) {

        store.save(id, content);
    }

    @Override
    public int countLines(String id) {

        return store.countLines(id);
    }
}