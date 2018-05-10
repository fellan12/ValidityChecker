package omegapoint.validitycheck;

import omegapoint.data.CandidateData;

public interface ValidityCheck {

	<T> boolean isValid(CandidateData<T> data);
	String getCheckName();

}
