public class FakeDbRepository implements StudentRepository{
    private final FakeDb db;

    public FakeDbRepository(FakeDb db) {
        this.db = db;
    }

    @Override
    public void save(StudentRecord record) {
        db.save(record);
    }

    @Override
    public int count() {
        return db.count();
    }
}
