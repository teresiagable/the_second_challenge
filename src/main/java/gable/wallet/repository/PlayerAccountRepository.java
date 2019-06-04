package gable.wallet.repository;

import org.springframework.data.repository.CrudRepository;

import gable.wallet.entity.PlayerAccount;

public interface PlayerAccountRepository extends CrudRepository<PlayerAccount,Integer>{
	
	PlayerAccount findByPlayerId(int playerId);
	


}
