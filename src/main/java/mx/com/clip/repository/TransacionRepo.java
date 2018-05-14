package mx.com.clip.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import mx.com.clip.entiy.Transaction;

/**
 * The Interface TransacionRepo.
 *
 *
 * @author Oliver Mar Ramirez
 */
@Transactional(readOnly = true)
public interface TransacionRepo extends JpaRepository<Transaction, Serializable> {

	/**
	 * Find by transaction id.
	 *
	 * @param transactionId
	 *            the transaction id
	 * @return the transaction
	 */
	@Query("from Transaction where transaction_id =?1")
	Transaction findByTransactionId(String transactionId);

	/**
	 * Find by userand transaction id.
	 *
	 * @param user_id
	 *            the user_id
	 * @param transactionId
	 *            the transaction id
	 * @return the transaction
	 */
	@Query("from Transaction where user_id = ?1 and transaction_id =?2")
	Transaction findByUserandTransactionId(Long user_id, String transactionId);

	/**
	 * Find by user id.
	 *
	 * @param userId
	 *            the user id
	 * @return the list
	 */
	@Query("from Transaction where user_id = ?1 order by date asc")
	List<Transaction> findByUserId(Long userId);

	/**
	 * Sum transactions.
	 *
	 * @param userId
	 *            the user id
	 * @return the double
	 */
	@Query("select sum(amount) from Transaction where user_id = ?1")
	Double sumTransactions(Long userId);

}
