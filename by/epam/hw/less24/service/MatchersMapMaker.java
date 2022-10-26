package by.epam.hw.less24.service;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MatchersMapMaker {

	private final String email = "([.[^@\\s]]+)@([.[^@\\s]]+)\\.([a-z]+)";
	private final String password = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{8,20}";
	private final String username = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";

	private final String keyEmail = "email";
	private final String keyPassword = "password";
	private final String keyUsername = "username";

	private final Pattern emailPattern = Pattern.compile(email);
	private final Pattern passwordPattern = Pattern.compile(password);
	private final Pattern usernamePattern = Pattern.compile(username);

	private Map<String, Pattern> matchersMap = new HashMap<String, Pattern>();

	public Map<String, Pattern> makeMap() {

		matchersMap.put(keyEmail, emailPattern);
		matchersMap.put(keyPassword, passwordPattern);
		matchersMap.put(keyUsername, usernamePattern);

		return matchersMap;
	}

	public String getKeyEmail() {
		return keyEmail;
	}

	public String getKeyPassword() {
		return keyPassword;
	}

	public String getKeyUsername() {
		return keyUsername;
	}
}