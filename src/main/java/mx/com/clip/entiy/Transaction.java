/*
 * Software Creado por Aleph-IT prohibida su repoduccion total o parcial con cualquier fin.
 */
package mx.com.clip.entiy;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The Class Transaction.
 *
 * @author Oliver Mar Ramirez
 */
@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The transaction_id. */
	@Id
	@Basic(optional = false)
	@Column(name = "transaction_id")
	private String transaction_id;

	/** The amount. */
	@Column(name = "amount")
	private Double amount;

	/** The description. */
	@Column(name = "description")
	private String description;

	/** The date. */
	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;

	/** The user_id. */
	@Column(name = "user_id")
	private Long user_id;

	/**
	 * Instantiates a new transaction.
	 */
	public Transaction() {
		super();
	}

	/**
	 * Instantiates a new transaction.
	 *
	 * @param transactionId
	 *            the transaction id
	 */
	public Transaction(String transactionId) {
		this.transaction_id = transactionId;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public Double getAmount() {
		return this.amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount
	 *            the new amount
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date
	 *            the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.transaction_id != null ? this.transaction_id.hashCode() : 0);
		return hash;
	}

	/**
	 * Equals.
	 *
	 * @param object
	 *            the object
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Transaction)) {
			return false;
		}
		final Transaction other = (Transaction) object;
		if ((this.transaction_id == null && other.transaction_id != null) || (this.transaction_id != null && !this.transaction_id.equals(other.transaction_id))) {
			return false;
		}
		return true;
	}

	/**
	 * Instantiates a new transaction.
	 *
	 * @param transactionId
	 *            the transaction id
	 * @param amount
	 *            the amount
	 * @param description
	 *            the description
	 * @param date
	 *            the date
	 * @param user_id
	 *            the user_id
	 */
	public Transaction(String transactionId, Double amount, String description, Date date, Long user_id) {
		super();
		this.transaction_id = transactionId;
		this.amount = amount;
		this.description = description;
		this.date = date;
		this.user_id = user_id;
	}

	/**
	 * Instantiates a new transaction.
	 *
	 * @param transactionId
	 *            the transaction id
	 * @param amount
	 *            the amount
	 * @param description
	 *            the description
	 * @param date
	 *            the date
	 * @param user_id
	 *            the user_id
	 */
	public Transaction(String transactionId, Double amount, String description, Date date, String user_id) {
		super();
		this.transaction_id = transactionId;
		this.amount = amount;
		this.description = description;
		this.date = date;
		this.user_id = Long.valueOf(user_id);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Transaction [transactionId=" + this.transaction_id + ", amount=" + this.amount + ", description=" + this.description + ", date=" + this.date + ", user_id=" + this.user_id + "]";
	}

	/**
	 * Gets the transaction_id.
	 *
	 * @return the transaction_id
	 */
	public String getTransaction_id() {
		return this.transaction_id;
	}

	/**
	 * Sets the transaction_id.
	 *
	 * @param transaction_id
	 *            the new transaction_id
	 */
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	/**
	 * Gets the user_id.
	 *
	 * @return the user_id
	 */
	public Long getUser_id() {
		return this.user_id;
	}

	/**
	 * Sets the user_id.
	 *
	 * @param user_id
	 *            the new user_id
	 */
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
}
