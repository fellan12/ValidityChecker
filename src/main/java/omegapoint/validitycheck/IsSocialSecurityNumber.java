package omegapoint.validitycheck;

import omegapoint.data.CandidateData;

public class IsSocialSecurityNumber implements ValidityCheck {

    public <T> boolean isValid(CandidateData<T> data) {
	T content = data.getContent();
	if (isNull(content))
	    return false;
	if (!isCorrectType(content))
	    return false;

	if (content instanceof String)
	    return isValid((String)content);
	else if (content instanceof Long)
	    return isValid((Long)content);
	else
	    return false;
    }

    public boolean isValid(Long socialSecurityNumber) {
	return this.isValid(Long.toString(socialSecurityNumber));
    }

    public boolean isValid(String socialSecurityNumber) {
	if (!isSocialSecurityNumberFormat (socialSecurityNumber))
	    return false;

	String parsed = parse(socialSecurityNumber);
	int res = 0;
	for (int i=0; i<parsed.length ()-1; i++) {
	    int num = Character.getNumericValue(parsed.charAt(i));
	    int product = num * (2-i%2);       // multiply with 2 or 1    
	    res += product/10 + product%10;    // add digits of product to res
	}
	res = (10 - (res % 10)) % 10;

	return res == Character.getNumericValue(parsed.charAt(parsed.length ()-1));
    }

    private <T> boolean isNull(T obj) {
	if (obj == null) {
	    return true;
	}
	return false;
    }

    private <T> boolean isCorrectType(T input) {
	if (isNull(input)) {
	    return false;
	}
	if (input instanceof String)
	    return true;
	else if (input instanceof Long)
	    return true;
	else {
	    return false;
	}
    }


    private boolean isSocialSecurityNumberFormat(String socialSecurityNumber) {
	if (socialSecurityNumber.length() < 10 || socialSecurityNumber.length() > 13)
	    return false;
	for (int iter = 0 ; iter < socialSecurityNumber.length() ; iter++) {
	    char value = socialSecurityNumber.charAt(iter);
	    if (Character.isDigit(value) || value == '-' || value == 'L')
		continue;
	    else
		return false;
	}
	return true;
    }


    private String parse(String socialSecurityNumber) {
	String parsed = socialSecurityNumber;
	if (parsed.endsWith("L"))
	    parsed = parsed.replace("L", "");

	if (parsed.contains("-"))
	    parsed = parsed.replace("-", "");

	if (parsed.length() == 12)
	    parsed = parsed.substring(2);

	return parsed;
    }


    public String getCheckName() {
	return "Social Security Number Check";
    }

}
