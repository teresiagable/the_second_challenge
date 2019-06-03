package gable.wallet.repository;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import gable.wallet.entity.PlayerAccount;

public interface PlayerWalletRepository extends CrudRepository<PlayerAccount,Integer>{
	
	PlayerAccount findByPlayerId(int playerId);
	


}
