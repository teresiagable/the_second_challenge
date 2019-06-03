package gable.wallet.service;

import java.math.BigDecimal;
import java.util.List;

import gable.wallet.entity.PlayerAccount;
import gable.wallet.entity.PlayerTransaction;

public interface PlayerWalletService {

	PlayerAccount create(PlayerAccount playerAccount);
	
	PlayerTransaction credit(PlayerAccount playerAccount, BigDecimal amount);
	
	PlayerTransaction debit(PlayerAccount playerAccount, BigDecimal amount);
	
	BigDecimal getBalace(int playerId);
	
	List <PlayerTransaction> getTransactionsByPlayerId(int playerId);
	
	
	

}