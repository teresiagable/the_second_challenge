package gable.wallet.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gable.wallet.entity.PlayerAccount;
import gable.wallet.entity.PlayerTransaction;

@Service
@Transactional
public class PlayerWalletServiceImpl {

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
}
