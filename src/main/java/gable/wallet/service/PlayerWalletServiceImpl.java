package gable.wallet.service;

import java.math.BigDecimal;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gable.wallet.entity.PlayerAccount;
import gable.wallet.entity.PlayerTransaction;
import gable.wallet.exceptions.EntityNotFoundException;
import gable.wallet.exceptions.NotEnoughMoneyException;
import gable.wallet.repository.PlayerAccountRepository;
import gable.wallet.repository.PlayerTransactionRepository;


@Service
@Transactional
public class PlayerWalletServiceImpl implements PlayerWalletService   {
	
	private PlayerAccountRepository accountRepo;
	private PlayerTransactionRepository transRepo;
	
	public PlayerWalletServiceImpl(PlayerAccountRepository walletRepo, PlayerTransactionRepository transRepo) {
		this.accountRepo = walletRepo;
		this.transRepo = transRepo;
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
	public PlayerAccount createAccount(PlayerAccount playerAccount) {
		return accountRepo.save(playerAccount);
	}
	

//	@Override
//	public PlayerTransaction credit(String externalId, PlayerAccount playerAccount, BigDecimal amount) {
//
//		PlayerTransaction transaction = new PlayerTransaction();
//		PlayerAccount wallet =  playerAccount.addToAccountSum(amount);
//		
//		transaction.create(externalId, playerAccount, amount);
//		
//		accountRepo.save(wallet);
//		return transRepo.save(transaction);
//				
//	}

	@Override
	public PlayerTransaction creditDebit(String externalId, PlayerAccount playerAccount, BigDecimal amount)
			throws SQLIntegrityConstraintViolationException, NotEnoughMoneyException {
		BigDecimal accountSum = playerAccount.getAccountSum();

		if (accountSum.add(amount).compareTo(BigDecimal.ZERO) < 0) {
			// not enough money on the account
			throw new NotEnoughMoneyException("Cannot withdraw more than " + playerAccount.getAccountSum());
		} else {

			PlayerTransaction transaction = new PlayerTransaction();
			PlayerAccount wallet = playerAccount.addToAccountSum(amount);

			transaction.create(externalId, playerAccount, amount);

			accountRepo.save(wallet);
			return transRepo.save(transaction);
		}

	}

	@Override
	public List<PlayerTransaction> getTransactionsByPlayerId(int playerId) {
		
		return transRepo.findAllByPlayerId(playerId);
	}

	@Override
	public PlayerTransaction findTransactionById(int transactionId) {

		Optional<PlayerTransaction> result = transRepo.findById(transactionId);
		
		return result.orElseThrow(() -> new EntityNotFoundException("Transaction with id " + transactionId + " could not be found"));		
	}
	
	
}
