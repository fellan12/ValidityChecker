package omegapoint.validitycheck;

import omegapoint.data.CandidateData;

public class IsNotNull implements ValidityCheck {

    /*
     * Check if generic candidate data is valid
     */
    public <T> boolean isValid(CandidateData<T> data) {
	if (data == null || data.getContent() == null)
	    return false;
	return true;
    }

    public String getCheckName() {
	return "IsNotNull Check";
    }

}
