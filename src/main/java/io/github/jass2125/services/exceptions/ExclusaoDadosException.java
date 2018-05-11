package io.github.jass2125.services.exceptions;

public class ExclusaoDadosException extends RuntimeException {

	public ExclusaoDadosException(RuntimeException e, String msg) {
		super(msg, e);
	}

}
