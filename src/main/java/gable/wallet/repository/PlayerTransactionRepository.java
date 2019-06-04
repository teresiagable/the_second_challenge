package gable.wallet.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import gable.wallet.entity.PlayerTransaction;

public interface PlayerTransactionRepository extends CrudRepository<PlayerTransaction,Integer>{
	
	List<PlayerTransaction> findAllByPlayerId(int playerId);

	PlayerTransaction save(PlayerTransaction playerTransaction) ;
	

}
