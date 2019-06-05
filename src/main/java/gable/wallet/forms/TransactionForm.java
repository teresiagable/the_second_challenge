package gable.wallet.forms;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

public class TransactionForm {

	@NotBlank(message = "This field is required")
	private String transactionId;
	@Digits(message = "This field is required", fraction = 0, integer = 10)
	private int playerId;
	@Digits(message = "This field is required", fraction = 4, integer = 10)
	private BigDecimal amount;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
