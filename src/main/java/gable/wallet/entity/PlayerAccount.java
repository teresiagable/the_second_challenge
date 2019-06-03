package gable.wallet.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player_account")
public class PlayerAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	private BigDecimal amount;

	public PlayerAccount() {
	}

	public PlayerAccount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getPlayerId() {
		return playerId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	protected PlayerAccount updateAccountAmount(BigDecimal transactionAmount) {
		this.amount = this.amount.add(transactionAmount);
		return this;
	}

}
