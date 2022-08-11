package com.mowitnow.kata.exceptions;

import java.io.Serializable;

public enum MowerMessage {
	INCORRECT_DATA ("Incorrect data"), INCORRECT_ORIENTATION ("Incorrect orientation"),
	INCORRECT_INSTRUCTION("Incorrect instruction"),INCORRECT_POSITION("Incorrect position"),
	FILE_NOT_EXIST("File not exist");
	private final String message;
	MowerMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}