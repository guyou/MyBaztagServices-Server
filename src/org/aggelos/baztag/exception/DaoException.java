package org.aggelos.baztag.exception;

/**
 * A simple typed exception to signify dao issues
 * @author Sinmaniphel
 *
 */
public class DaoException extends Exception {

	public DaoException() {
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

}
