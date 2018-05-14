package mx.com.clip.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.clip.entiy.Transaction;

/**
 * The Class ObjectMapperService.
 *
 * @author Oliver Mar Ramirez
 */
public class ObjectMapperService {

	/**
	 * Read json with object mapper.
	 *
	 * @param value
	 *            the value
	 * @return the transaction
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static Transaction readJsonWithObjectMapper(String value) throws IOException {
		final ObjectMapper objectMapper = new ObjectMapper();
		final Transaction trans = objectMapper.readValue(value, Transaction.class);
		return trans;
	}

	/**
	 * Write json with object mapper.
	 *
	 * @param value
	 *            the value
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static String writeJsonWithObjectMapper(Transaction value) throws IOException {
		final ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(value);
	}

	private ObjectMapperService() {
		super();
	}
}
