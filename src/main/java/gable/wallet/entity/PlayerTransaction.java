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
	private int transactionId;
	@Column(unique = true)
	private String externalId;
	private int playerId;
	private BigDecimal amount;
	private BigDecimal playerAmountAfter;

	public BigDecimal getPlayerAmountAfter() {
		return playerAmountAfter;
	}

	public void setPlayerAmountAfter(BigDecimal playerAmountAfter) {
		this.playerAmountAfter = playerAmountAfter;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public String getExternalId() {
		return externalId;
	}

	public int getPlayerId() {
		return playerId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public PlayerTransaction(String externalId, int playerId, BigDecimal amount, BigDecimal playerAmountAfter) {
		super();
		this.externalId = externalId;
		this.playerId = playerId;
		this.amount = amount;
		this.playerAmountAfter = playerAmountAfter;
	}

	public PlayerTransaction() {
	}

	@Override
	public String toString() {
		return "PlayerTransaction [transactionId=" + transactionId + ", externalId=" + externalId + ", playerId="
				+ playerId + ", amount=" + amount + ", playerAmountAfter=" + playerAmountAfter + "]";
	}

	public void create(String externalId, PlayerAccount playerAccount, BigDecimal changeAmount) {

		this.externalId = externalId;
		this.playerId = playerAccount.getPlayerId();
		this.amount = changeAmount;
		this.playerAmountAfter = playerAccount.getAccountSum();

	}

}
