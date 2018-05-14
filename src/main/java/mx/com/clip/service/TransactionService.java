package mx.com.clip.service;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.clip.entiy.Transaction;
import mx.com.clip.exception.DataException;
import mx.com.clip.repository.TransacionRepo;
import mx.com.clip.util.ObjectMapperService;

/**
 * The Class TransactionService.
 *
 * @author Oliver Mar Ramirez
 */
@Service
public class TransactionService {

	/** The transaction repository. */
	@Autowired
	private TransacionRepo tranRepo;

	/**
	 * Show a specific transaction
	 *
	 * @param cleanArguments
	 *            the list of arguments
	 * @throws DataException
	 *             the data exception
	 */
	public void show(List<String> cleanArguments) throws DataException {
		try {
			final Long userId = Long.parseLong(cleanArguments.get(0));
			final String transactionId = cleanArguments.get(1);
			final Transaction tt = this.tranRepo.findByUserandTransactionId(userId, transactionId);
			if (tt == null) {
				System.out.println("Transaction not found");
			} else {
				System.out.println(ObjectMapperService.writeJsonWithObjectMapper(tt));
			}
		} catch (final NumberFormatException e) {
			e.printStackTrace();
			throw new DataException("invalid User Id");
		} catch (final IOException e) {
			e.printStackTrace();
			throw new DataException("invalid transaccion data");
		}
	}

	/**
	 * Adds the transaction to the database.
	 *
	 * @param cleanArguments
	 *            the list of arguments
	 * @throws DataException
	 *             the data exception
	 */
	public void add(List<String> cleanArguments) throws DataException {
		try {
			final Long userId = Long.parseLong(cleanArguments.get(0));
			final Transaction tt = ObjectMapperService.readJsonWithObjectMapper(cleanArguments.get(2));
			tt.setTransaction_id(this.generateTransactionId());
			if (!tt.getUser_id().equals(userId)) {
				throw new DataException("User Id is not the same in transaction data");
			}
			this.tranRepo.save(tt);
			System.out.println(ObjectMapperService.writeJsonWithObjectMapper(tt));
		} catch (final NumberFormatException e) {
			e.printStackTrace();
			throw new DataException("invalid User Id");
		} catch (final IOException e) {
			e.printStackTrace();
			throw new DataException("invalid transaccion data");
		}

	}

	/**
	 * Generate transaction id.
	 *
	 * @return the string
	 */
	private String generateTransactionId() {
		final StringBuilder stb = new StringBuilder();
		stb.append(RandomStringUtils.randomAlphanumeric(8).toLowerCase()).append("-");
		stb.append(RandomStringUtils.randomAlphanumeric(4).toLowerCase()).append("-");
		stb.append(RandomStringUtils.randomAlphanumeric(4).toLowerCase()).append("-");
		stb.append(RandomStringUtils.randomAlphanumeric(4).toLowerCase()).append("-");
		stb.append(RandomStringUtils.randomAlphanumeric(12).toLowerCase());
		return stb.toString();
	}

	/**
	 * Sum all transactions for one specific user_id.
	 *
	 * @param cleanArguments
	 *            the list of arguments
	 * @throws DataException
	 *             the data exception
	 */
	public void sum(List<String> cleanArguments) throws DataException {
		try {
			final Long userId = Long.parseLong(cleanArguments.get(0));
			final Double tt = this.tranRepo.sumTransactions(userId);
			if (tt == null) {
				System.out.println("Transaction not found");
			} else {
				final StringBuilder stb = new StringBuilder();
				stb.append("{\"user_id\":").append(userId).append(",");
				stb.append("\"sum\":").append(tt).append("}");
				System.out.println(stb.toString());
			}
		} catch (final NumberFormatException e) {
			e.printStackTrace();
			throw new DataException("invalid User Id");
		}

	}

	/**
	 * List all transactions of the same user.
	 *
	 * @param cleanArguments
	 *            the list of arguments
	 * @throws DataException
	 *             the data exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void list(List<String> cleanArguments) throws DataException, IOException {
		try {
			final Long userId = Long.parseLong(cleanArguments.get(0));
			final List<Transaction> tt = this.tranRepo.findByUserId(userId);
			tt.forEach(x -> {
				try {
					System.out.println(ObjectMapperService.writeJsonWithObjectMapper(x));
				} catch (final IOException e1) {
					e1.printStackTrace();
				}
			});
		} catch (final NumberFormatException e) {
			e.printStackTrace();
			throw new DataException("invalid User Id");
		}

	}

}
