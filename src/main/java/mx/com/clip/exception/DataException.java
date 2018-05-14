package mx.com.clip.exception;

/**
 * The Class DataException.
 * 
 * @author Oliver Mar Ramirez
 */
public class DataException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new negocio exception.
	 *
	 * @param message
	 *            the message
	 */
	public DataException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new negocio exception.
	 */
	public DataException() {
		super();
	}

	/**
	 * Instantiates a new negocio exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public DataException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new negocio exception.
	 *
	 * @param cause
	 *            the cause
	 */
	public DataException(Throwable cause) {
		super(cause);
	}

}
