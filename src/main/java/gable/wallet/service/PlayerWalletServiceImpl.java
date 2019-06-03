package gable.wallet.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gable.wallet.entity.PlayerAccount;
import gable.wallet.entity.PlayerTransaction;
import gable.wallet.repository.PlayerWalletRepository;

@Service
@Transactional
public class PlayerWalletServiceImpl implements PlayerWalletService   {
	
	private PlayerWalletRepository walletRepo;
	
	public PlayerWalletServiceImpl(PlayerWalletRepository walletRepo) {
		this.walletRepo = walletRepo;
	}
	
//	public boolean commitTransaction(PlayerAccount thePlayerAccount, BigDecimal changeAmount) {
//		boolean result = false;
//		BigDecimal theNewAmount = thePlayerAccount.getAmount().add(changeAmount);
//		if (theNewAmount.compareTo(BigDecimal.ZERO) >= 0) {
//			PlayerTransaction newTransaction = new PlayerTransaction(thePlayerAccount,changeAmount,theNewAmount);
//			
//			//this.amount = theNewAmount;
//			result = true;
//		}
//		return result;
//	}
	

	@Override
	public PlayerAccount create(PlayerAccount playerAccount) {
		return walletRepo.save(playerAccount);
	}
	

	@Override
	public PlayerTransaction credit(PlayerAccount playerAccount, BigDecimal amount) {

		return null;
	}

	@Override
	public PlayerTransaction debit(PlayerAccount playerAccount, BigDecimal amount) {
		//check if there are enough money on the account
		//do transaction
		//else return error		
		return null;
	}

	@Override
	public BigDecimal getBalace(int playerId) {
		// TODO Auto-generated method stub
		return null;//walletRepo.findByPlayerId(playerId);
	}

	@Override
	public List<PlayerTransaction> getTransactionsByPlayerId(int playerId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
