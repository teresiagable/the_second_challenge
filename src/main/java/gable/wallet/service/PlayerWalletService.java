package gable.wallet.service;

import java.math.BigDecimal;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import gable.wallet.entity.PlayerAccount;
import gable.wallet.entity.PlayerTransaction;
import gable.wallet.exceptions.NotEnoughMoneyException;

public interface PlayerWalletService {

	PlayerAccount createAccount(PlayerAccount playerAccount);

	PlayerTransaction creditDebit(String externalId, PlayerAccount playerAccount, BigDecimal amount);
			//throws SQLIntegrityConstraintViolationException, NotEnoughMoneyException;

	List<PlayerTransaction> getTransactionsByPlayerId(int playerId);

	PlayerTransaction findTransactionById(int transactionId);

	PlayerAccount findPlayerById(int playerId);

}