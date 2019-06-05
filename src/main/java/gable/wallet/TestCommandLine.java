package gable.wallet;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gable.wallet.entity.PlayerAccount;
import gable.wallet.entity.PlayerTransaction;
import gable.wallet.repository.PlayerAccountRepository;
import gable.wallet.repository.PlayerTransactionRepository;
import gable.wallet.service.PlayerWalletService;
import gable.wallet.service.PlayerWalletServiceImpl;

@Component
@Transactional(rollbackFor = Exception.class)
public class TestCommandLine  implements CommandLineRunner{
	
	private PlayerAccountRepository accountRepo;
	private PlayerTransactionRepository transRepo;
	private PlayerWalletService pwService;

	public TestCommandLine(PlayerAccountRepository accountRepo, PlayerTransactionRepository transRepo, PlayerWalletService pwService ) {
		this.accountRepo = accountRepo;
		this.transRepo = transRepo;
		this.pwService = new PlayerWalletServiceImpl(accountRepo, transRepo);
	}

	@Override
	public void run(String... args) throws Exception {
		
		PlayerAccount p1 = pwService.createAccount(new PlayerAccount("nisse"));
		PlayerAccount p2 = pwService.createAccount(new PlayerAccount("lisa"));
		
		pwService.creditDebit("ext123", p1, BigDecimal.valueOf(100.00));
		pwService.creditDebit("ext124", p1, BigDecimal.valueOf(33.333333));
		
		pwService.creditDebit("ext125", p1, BigDecimal.valueOf(-33.333333));
//		PlayerTransaction pt = pwService.creditDebit("ext126", p2, BigDecimal.valueOf(-3.333));
		
		System.out.println("All player wallets "); 
		accountRepo.findAll().forEach(System.out::println);		
		transRepo.findAll().forEach(System.out::println);	
		
	}
	
	
	
	
	
	

}
