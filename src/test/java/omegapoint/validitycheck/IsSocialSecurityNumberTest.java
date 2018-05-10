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
	private CandidateData<Long> cd4;
	private CandidateData<String> cd5;
	private CandidateData<String> cd6;
	private ValidityCheck check;

	@Before
	public void init() {
		check = new IsSocialSecurityNumber();

		//Correct
		cd1 = new CandidateData<Long>(199305237100L);
		cd2 = new CandidateData<String>("199505233297");
		cd3 = new CandidateData<String>("19950523-7850");

		//Wrong
		cd4 = new CandidateData<Long>(199515237850L);
		cd5 = new CandidateData<String>("199505227850");
		cd6 = new CandidateData<String>("19950523-7853");
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

	}

	@Test
	public void isSocialSecurityNumberFalse() {
		boolean result;

		//Wrong
		result = check.isValid(cd4);
		Assert.assertFalse(result);

		result = check.isValid(cd5);
		Assert.assertFalse(result);

		result = check.isValid(cd6);
		Assert.assertFalse(result);
	}

}
