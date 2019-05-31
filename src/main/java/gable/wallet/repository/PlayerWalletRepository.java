package gable.wallet.repository;

import org.springframework.data.repository.CrudRepository;

import gable.wallet.entity.PlayerAccount;

public interface PlayerWalletRepository extends CrudRepository<PlayerAccount,Integer>{
	
	PlayerAccount findById(int playerId);

}
