package gable.wallet.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gable.wallet.entity.PlayerAccount;
import gable.wallet.entity.PlayerTransaction;
import gable.wallet.forms.PlayerAccountForm;
import gable.wallet.forms.TransactionForm;
import gable.wallet.repository.PlayerTransactionRepository;
import gable.wallet.service.PlayerWalletService;

@RestController
public class WalletController {
	
	private PlayerWalletService service;
	//private PlayerTransactionRepository transRepo;
	
	@Autowired
	public WalletController(PlayerWalletService walletService , PlayerTransactionRepository transRepo) {
		super();
		this.service = walletService;
		//this.transRepo=transRepo;

	}
	
	@GetMapping("/transactions/{id}")
	public ResponseEntity<PlayerTransaction> getTransaction(@PathVariable int id){
		try {
			return ResponseEntity.ok(service.findTransactionById(id));
		
		}catch(IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}		
	}
	
	
	@PostMapping("/transfer")
	public ResponseEntity<PlayerTransaction> create(@RequestBody @Valid TransactionForm form){
				
		PlayerTransaction newTrans = service.creditDebit(
										form.getExternalId(),
										service.findPlayerById(form.getPlayerId()), 
										BigDecimal.TEN);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newTrans);
	}
	
	@PostMapping("/playeraccount")
	public ResponseEntity<PlayerAccount> create(@RequestBody @Valid PlayerAccountForm form){
		
		PlayerAccount newPlayer = service.createAccount(new PlayerAccount(
								form.getName(),
								BigDecimal.TEN));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newPlayer);
	}
	
	
	
	@RequestMapping("/")
	public String home() {
		return "WalletController!";
	}
}
