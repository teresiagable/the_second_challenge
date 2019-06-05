package gable.wallet.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player_transactions")
public class PlayerTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String transactionId;
	private int playerId;
	private BigDecimal amount;
	private BigDecimal playerAmountAfter;

	public BigDecimal getPlayerAmountAfter() {
		return playerAmountAfter;
	}

	public void setPlayerAmountAfter(BigDecimal playerAmountAfter) {
		this.playerAmountAfter = playerAmountAfter;
	}

	public int getid() {
		return id;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public int getPlayerId() {
		return playerId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public PlayerTransaction(String transactionId, int playerId, BigDecimal amount, BigDecimal playerAmountAfter) {
		super();
		this.transactionId = transactionId;
		this.playerId = playerId;
		this.amount = amount;
		this.playerAmountAfter = playerAmountAfter;
	}

	public PlayerTransaction() {
	}

	@Override
	public String toString() {
		return "PlayerTransaction [id=" + id + ", transactionId=" + transactionId + ", playerId="
				+ playerId + ", amount=" + amount + ", playerAmountAfter=" + playerAmountAfter + "]";
	}

	public void create(String transactionId, PlayerAccount playerAccount, BigDecimal changeAmount) {

		this.transactionId = transactionId;
		this.playerId = playerAccount.getPlayerId();
		this.amount = changeAmount;
		this.playerAmountAfter = playerAccount.getAccountSum();

	}

}
