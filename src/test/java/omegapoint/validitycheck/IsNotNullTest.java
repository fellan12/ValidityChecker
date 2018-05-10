package omegapoint.validitycheck;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import omegapoint.data.CandidateData;
import omegapoint.validitycheck.IsNotNull;
import omegapoint.validitycheck.ValidityCheck;


public class IsNotNullTest {

	private CandidateData<Long> cd1;
	private CandidateData<String> cd2;
	private CandidateData<Long> cd3;
	private CandidateData<String> cd4;
	private ValidityCheck check;

	@Before
	public void init() {
		check = new IsNotNull();

		//Correct
		cd1 = new CandidateData<Long>(199505233297L);
		cd2 = new CandidateData<String>("199505233297");

		//Wrong
		cd3 = new CandidateData<Long>(null);
		cd4 = new CandidateData<String>(null);

	}

	@Test
	public void isNotNullTrue() {
		boolean result;

		result = check.isValid(cd1);
		Assert.assertTrue(result);

		result = check.isValid(cd2);
		Assert.assertTrue(result);
	}

	@Test
	public void isNotNullFalse() {
		boolean result;

		result = check.isValid(cd3);
		Assert.assertFalse(result);

		result = check.isValid(cd4);
		Assert.assertFalse(result);
	}

}
