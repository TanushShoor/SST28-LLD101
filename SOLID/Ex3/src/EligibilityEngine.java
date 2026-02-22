import java.util.*;

public class EligibilityEngine {

    private final FakeEligibilityStore store;

    private final List<EligibilityRule> rules;

    public EligibilityEngine(FakeEligibilityStore store) {

        this.store = store;

        this.rules = List.of(
                new DisciplinaryRule(),
                new CgrRule(),
                new AttendanceRule(),
                new CreditsRule()
        );
    }

    public void runAndPrint(StudentProfile s) {

        ReportPrinter p = new ReportPrinter();

        EligibilityEngineResult r = evaluate(s);

        p.print(s, r);

        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {

        List<String> reasons = new ArrayList<>();

        for (EligibilityRule rule : rules) {

            String result = rule.check(s);

            if (result != null) {

                reasons.add(result);

                return new EligibilityEngineResult("NOT_ELIGIBLE", reasons);
            }
        }

        return new EligibilityEngineResult("ELIGIBLE", reasons);
    }
}