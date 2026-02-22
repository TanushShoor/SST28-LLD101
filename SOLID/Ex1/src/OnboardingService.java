import java.util.*;

public class OnboardingService {

    private final StudentRepository repository;

    private final RawInputParser parser;

    private final StudentValidator validator;

    private final StudentPrinter printer;

    public OnboardingService(FakeDb db) {

        this.repository = new FakeDbRepository(db);

        this.parser = new RawInputParser();

        this.validator = new StudentValidator();

        this.printer = new StudentPrinter();
    }
    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.


    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        Map<String, String> kv = parser.parse(raw);

        List<String> errors = validator.validate(kv);

        if (!errors.isEmpty()) {

            printer.printErrors(errors);

            return;
        }

        String name = kv.get("name");
        String email = kv.get("email");
        String phone = kv.get("phone");
        String program = kv.get("program");

        String id = IdUtil.nextStudentId(repository.count());

        StudentRecord record =
                new StudentRecord(id, name, email, phone, program);

        repository.save(record);

        printer.printSuccess(record, repository.count());
    }
}
