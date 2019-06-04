package gable.wallet.forms;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

public class TransactionForm {
	
	@NotBlank(message = "This field is required")
	private String externalId;
	@Digits(message = "This field is required", fraction = 0, integer = 10)
	private int playerId;
	@Digits(message = "This field is required", fraction = 2, integer = 6)
	private BigDecimal amount;
	
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
//	public BigDecimal getAmount() {
//		return amount;
//	}
//	public void setAmount(BigDecimal amount) {
//		this.amount = amount;
//	}
	
	
	
}
