package omegapoint.validitycheck;

import omegapoint.data.CandidateData;

public class IsSocialSecurityNumber implements ValidityCheck {


	private <T> boolean isNull(T obj) {
		if (obj == null) {
			return true;
		}
		return false;
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
