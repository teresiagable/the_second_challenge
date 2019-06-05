package gable.wallet.service;

import java.math.BigDecimal;
import java.util.List;

import gable.wallet.entity.PlayerAccount;
import gable.wallet.entity.PlayerTransaction;

public interface PlayerWalletService {

	PlayerAccount createAccount(PlayerAccount playerAccount);
	
	PlayerAccount findPlayerById(int playerId);

	PlayerTransaction creditDebit(String externalId, PlayerAccount playerAccount, BigDecimal amount);

	List<PlayerTransaction> getTransactionsByPlayerId(int playerId);

	PlayerTransaction getTransactionById(int transactionId);

	List<PlayerTransaction> getAllTransactions();

	List<PlayerAccount> getAllPlayerAccounts();

}