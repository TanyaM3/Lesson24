package by.epam.hw.less24.main;

import by.epam.hw.less24.service.ValidatorImpl;
import by.epam.hw.less24.view.View;

public class Main {
	
	public static void main(String[]args) {
		ValidatorImpl validator = new ValidatorImpl();
		View view = new View();
		String request = "ivan34, Vanbrt61, ivanivanov33@mail.ru";
		view.giveResult(validator.validate(request));
	}
}