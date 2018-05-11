package omegapoint.validitycheck;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import omegapoint.data.CandidateData;
import omegapoint.validitycheck.ValidityCheck;
import omegapoint.validitycheck.IsSocialSecurityNumber;

public class IsSocialSecurityNumberTest {

    private CandidateData<Long> cd1;
    private CandidateData<String> cd2;
    private CandidateData<String> cd3;
    private CandidateData<String> cd4;
    private CandidateData<Long> cd5;
    private CandidateData<String> cd6;
    private CandidateData<String> cd7;
    private CandidateData<String> cd8;
    private CandidateData<String> cd9;
    private ValidityCheck check;

    @Before
    public void init() {
	check = new IsSocialSecurityNumber();

	//Correct
	cd1 = new CandidateData<Long>(199305237100L);
	cd2 = new CandidateData<String>("199305237100L");
	cd3 = new CandidateData<String>("199505233297");
	cd4 = new CandidateData<String>("19950523-7850");

	//Wrong
	cd5 = new CandidateData<Long>(199515237850L);
	cd6 = new CandidateData<String>("199515237850L");
	cd7 = new CandidateData<String>("199505227850");
	cd8 = new CandidateData<String>("19950523-7853");
	cd9 = new CandidateData<String>(null);

    }

    @Test
    public void isSocialSecurityNumberTrue() {
	boolean result;

	//Correct
	result = check.isValid(cd1);
	Assert.assertTrue(result);

	result = check.isValid(cd2);
	Assert.assertTrue(result);

	result = check.isValid(cd3);
	Assert.assertTrue(result);

	result = check.isValid(cd4);
	Assert.assertTrue(result);

    }

    @Test
    public void isSocialSecurityNumberFalse() {
	boolean result;

	//Wrong
	result = check.isValid(cd5);
	Assert.assertFalse(result);

	result = check.isValid(cd6);
	Assert.assertFalse(result);

	result = check.isValid(cd7);
	Assert.assertFalse(result);

	result = check.isValid(cd8);
	Assert.assertFalse(result);

	result = check.isValid(cd9);
	Assert.assertFalse(result);
    }

}
