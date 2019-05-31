package gable.wallet.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gable.wallet.entity.PlayerAccount;
import gable.wallet.entity.PlayerTransaction;
import gable.wallet.repository.PlayerWalletRepository;

@Service
@Transactional
public class PlayerWalletServiceImpl {
	
	private PlayerWalletRepository walletRepo;
	
	public PlayerWalletServiceImpl(PlayerWalletRepository walletRepo) {
		this.walletRepo = walletRepo;
	}
	
	public boolean commitTransaction(PlayerAccount thePlayerAccount, BigDecimal changeAmount) {
		boolean result = false;
		BigDecimal theNewAmount = thePlayerAccount.getAmount().add(changeAmount);
		if (theNewAmount.compareTo(BigDecimal.ZERO) >= 0) {
			PlayerTransaction newTransaction = new PlayerTransaction(thePlayerAccount,changeAmount,theNewAmount);
			
			//this.amount = theNewAmount;
			result = true;
		}
		return result;
	}
	
	public PlayerAccount save(PlayerAccount playerAccount) {
		return walletRepo.save(playerAccount);
	}
	

	public PlayerAccount update(int userId, PlayerAccount updatedUser) {
		
//		PlayerAccount original = findById(userId);		
//			original.setName(updatedUser.getName());
//			original.setEmail(updatedUser.getEmail());
//			original.setPictureUrl(updatedUser.getPictureUrl());
//		return userRepo.save(original);
	
	}
}
