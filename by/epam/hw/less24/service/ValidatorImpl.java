package by.epam.hw.less24.service;
import java.util.Map;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
	
	private MatchersMapMaker maker = new MatchersMapMaker();
	private final String paramSeparator = ", ";
	private final String correct = "Correct";
	private String message = "Incorrect input data:";
	private final String email = maker.getKeyEmail();
	private final String password = maker.getKeyPassword();
	private final String username = maker.getKeyUsername();
	private Map<String, Pattern> matchersMap = maker.makeMap();

	@Override
	public String validate(String value) {

		String stringData[] = value.split(paramSeparator);
		String usernameInput = stringData[0];
		String passwordInput = stringData[1];
		String emailInput = stringData[2];

		if (!matchersMap.get(email).matcher(emailInput).matches()) {
			message += " " + email;
		}

		if (!matchersMap.get(username).matcher(usernameInput).matches()) {
			message += " " + username;
		}

		if (!matchersMap.get(password).matcher(passwordInput).matches()) {
			message += " " + password;
		}

		if ((matchersMap.get(email).matcher(emailInput).matches()
				&& matchersMap.get(username).matcher(usernameInput).matches()
				&& matchersMap.get(password).matcher(passwordInput).matches())) {
			message = correct;
		}
		return message;
	}
}