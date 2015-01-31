package org.usfirst.frc2667.Robot_2015.util;

import java.util.ArrayList;
import java.util.List;

public class Logger {

	private static final List<String> messages = new ArrayList<>();
	
	/**
	 * Print message
	 * @param message
	 */
	public static void log(String message) {
		log(message);
	}
	
	/**
	 * Print formatted message
	 * @param format
	 * @param args
	 */
	public static void log(String format, Object... args) {
		String message = "[RoboRio]: " + format + "%n";
		System.out.printf(message, args);
		messages.add(message);
	}
}
