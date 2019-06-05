package gable.wallet.exceptions;

public class NotEnoughMoneyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotEnoughMoneyException() {
		super();
	}

	public NotEnoughMoneyException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
