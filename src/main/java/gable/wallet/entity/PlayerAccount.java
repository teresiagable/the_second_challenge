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

	
	//AccountSum instead of amount to hide the "real" name of the field.
	public BigDecimal getAccountSum() {
		return amount;
	}

	//AccountSum instead of amount to hide the "real" name of the field.
	public PlayerAccount addToAccountSum(BigDecimal transactionAmount) {
		this.amount = this.amount.add(transactionAmount);
		return this;
	}

	@Override
	public String toString() {
		return "PlayerAccount Id=" + playerId + ", accountsum=" + amount + "]";
	}
	
	

}
