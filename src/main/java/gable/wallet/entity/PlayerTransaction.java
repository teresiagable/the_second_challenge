package gable.wallet.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player_transactions")
public class PlayerTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	private int playerId;
	private BigDecimal amount;
	private BigDecimal playerAmountAfter;
	
	
	
//	public PlayerTransaction(int playerId, BigDecimal amount, BigDecimal playerAmountAfter) {
//		this.playerId = playerId;
//		this.amount = amount;
//		this.playerAmountAfter = playerAmountAfter;
//	}

	public PlayerTransaction(PlayerAccount thePlayerAccount, BigDecimal changeAmount, BigDecimal theNewAmount) {
		this.playerId = thePlayerAccount.getPlayerId();
		this.amount = changeAmount;
		this.playerAmountAfter = theNewAmount;
	}
	
	public PlayerTransaction() {
	}

}
