package gable.wallet;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gable.wallet.entity.PlayerAccount;
import gable.wallet.repository.PlayerWalletRepository;

@Component
@Transactional(rollbackFor = Exception.class)
public class TestCommandLine  implements CommandLineRunner{
	
	private PlayerWalletRepository walletRepo;

	public TestCommandLine(PlayerWalletRepository walletRepo) {
		this.walletRepo = walletRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		PlayerAccount p1 = walletRepo.save(new PlayerAccount(BigDecimal.ZERO));
		PlayerAccount p2 = walletRepo.save(new PlayerAccount(BigDecimal.ZERO));
		PlayerAccount p3 = walletRepo.save(new PlayerAccount(BigDecimal.ZERO));
		
		System.out.println("All player wallets "); 
		walletRepo.findAll().forEach(System.out::println);
		
		BigDecimal bd = walletRepo.getAmountByPlayerId(1);
		System.out.println("Player id 1 amount "+ bd);
		

		
		
		
		
	}
	
	
	
	
	
	

}
