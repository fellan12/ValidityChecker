package omegapoint.validitychecker;

import java.util.*;
import omegapoint.validitycheck.ValidityCheck;
import omegapoint.data.CandidateData;

public class ValidityChecker {

    List<ValidityCheck> checks = new ArrayList<ValidityCheck>();

    /*
     * Add ValidityCheck to checker
     */
    public void addCheck(ValidityCheck check){
	checks.add(check);
    }

    /*
     * Run ValidityChecker
     *
     * Runs every added ValidityCheck on the inputet CandidateData
     */
    public <T> void run(CandidateData<T> data) {

	boolean valid = false;
	String msg;

	for (ValidityCheck check : checks) {
	    valid = check.isValid(data);
	    if (valid) {
		msg = check.getCheckName() + ": PASSED";
	    } else {
		msg = check.getCheckName() + ": FAILED";
	    }

	    System.out.println(msg);
	}
    }
}
