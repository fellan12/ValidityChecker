package omegapoint.validitychecker;

import omegapoint.validitycheck.IsSocialSecurityNumber;
import omegapoint.validitycheck.IsNotNull;
import omegapoint.validitychecker.ValidityChecker;
import omegapoint.data.CandidateData;

import java.util.*;

public class Main {

    public static void main( String[] args ) {

	ValidityChecker checker = new ValidityChecker("results");
	List<CandidateData<Long>> dataLong = new ArrayList<CandidateData<Long>> ();
	List<CandidateData<String>> dataString = new ArrayList<CandidateData<String>> ();

	//Correct
	dataLong.add(new CandidateData<Long>(197802022389L));
	dataLong.add(new CandidateData<Long>(198204112380L));
	dataString.add(new CandidateData<String>("197802022389L"));
	dataString.add(new CandidateData<String>("198204112380L"));
	dataString.add(new CandidateData<String>("19780202-2389"));
	dataString.add(new CandidateData<String>("19820411-2380"));

	//Wrong
	dataString.add(new CandidateData<String>("19820411-2381"));
	dataString.add(new CandidateData<String>(null));

	checker.addCheck(new IsNotNull());
	checker.addCheck(new IsSocialSecurityNumber());

	checker.run(dataLong);
	checker.run(dataString);
    }
}
