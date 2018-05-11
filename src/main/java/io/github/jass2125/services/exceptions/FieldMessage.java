package io.github.jass2125.services.exceptions;

import java.util.List;

import io.github.jass2125.resources.exceptions.StandardError;

public class FieldMessage extends StandardError {

	private static final long serialVersionUID = 1L;
	private List<String> errors;

	public FieldMessage() {
		super();
	}

	public FieldMessage(Integer value, String message, Long currentTimeMillis) {
		super(value, message, currentTimeMillis);
	}

	public void addError(String error) {
		this.errors.add(error);
	}

	public List<String> getErrors() {
		return errors;
	}

}
