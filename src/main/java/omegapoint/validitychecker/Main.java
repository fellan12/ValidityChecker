package omegapoint.validitychecker;

import omegapoint.validitycheck.IsSocialSecurityNumber;
import omegapoint.validitycheck.IsNotNull;
import omegapoint.validitychecker.ValidityChecker;
import omegapoint.data.CandidateData;

public class Main {

    public static void main( String[] args ) {

        ValidityChecker checker = new ValidityChecker();

        CandidateData<Long> id1 = new CandidateData<Long>(197802022389L);
        CandidateData<Long> id2 = new CandidateData<Long>(198204112380L);
        CandidateData<String> id3 = new CandidateData<String>("198204112380L");
        CandidateData<Long> id4 = new CandidateData<Long>(197802022389L);
        CandidateData<String> id5 = new CandidateData<String>("19820411-2380");
        CandidateData<String> id6 = new CandidateData<String>(null);

        checker.addCheck(new IsNotNull());
        checker.addCheck(new IsSocialSecurityNumber());

        checker.run(id1);
        checker.run(id2);
        checker.run(id3);
        checker.run(id4);
        checker.run(id5);
        checker.run(id6);
    }
}
