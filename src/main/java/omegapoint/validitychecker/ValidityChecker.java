package omegapoint.validitychecker;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;

import omegapoint.validitycheck.ValidityCheck;
import omegapoint.data.CandidateData;

public class ValidityChecker {

    List<ValidityCheck> checks = new ArrayList<ValidityCheck>();
    String path;

    public ValidityChecker(String path) {
	this.path = path;
    }

    /*
     * Add ValidityCheck to checker
     */
    public void addCheck(ValidityCheck check){
	checks.add(check);
    }

    /*
     * Run ValidityChecker on list of CandidateData
     *
     * Runs every added ValidityCheck every CandidateData and save it
     */
    public <T> void run(List<CandidateData<T>> datalist) {
	if(!datalist.isEmpty ()) {

	    for (CandidateData<T> candidateData : datalist) {
		run (candidateData);
	    }
	} else {
	    System.err.println ("List of Candidate Data is empty!");
	}
    }

    /*
     * Run ValidityChecker
     *
     * Runs every added ValidityCheck on the inputed CandidateData and save it
     */
    public <T> void run(CandidateData<T> data) {

	boolean valid = false;
	StringBuilder builder = new StringBuilder();
	String msg;

	for (ValidityCheck check : checks) {
	    valid = check.isValid(data);
	    if (valid) {
		msg = check.getCheckName() + ": PASSED";
	    } else {
		msg = check.getCheckName() + ": FAILED";
	    }

	    builder.append (msg + "\n");
	}

	saveResults("CandidateDataID: " + data.getId () + "\n" + builder.toString ());
    }
    
    /*
     * Print results to file 
     */
    private void saveResults (String string) {
	try {
	    new File(path).mkdirs();
	    Files.write(Paths.get(path+"/"+LocalDate.now()+"-validity-results"),
	                string.getBytes (),
	                StandardOpenOption.APPEND,
	                StandardOpenOption.CREATE);
	} catch (IOException e) {
	    e.printStackTrace ();
	}
	System.out.println ("Results printed in: " + path+"/"+LocalDate.now()+"-validity-results");
    }
}
