package gable.wallet.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@Autowired
	public WalletController(PlayerWalletService walletService , PlayerTransactionRepository transRepo) {
		super();
		this.service = walletService;

	}
	
	@GetMapping("/transactions/{id}")
	public ResponseEntity<PlayerTransaction> getTransaction(@PathVariable int id){
		try {
			return ResponseEntity.ok(service.getTransactionById(id));
		
		}catch(IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}		
	}
	
	@GetMapping("/transactions/playerid={id}")
	public ResponseEntity<List <PlayerTransaction>> getPlayerTransactions(@PathVariable int id){
		List<PlayerTransaction> transfers = service.getTransactionsByPlayerId(id);
		
		return transfers.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(transfers);		
	
	}
	
	@GetMapping("/transactions/all")
	public ResponseEntity<List <PlayerTransaction>> getAllTransactions(){
		List<PlayerTransaction> transfers = service.getAllTransactions();
		
		return transfers.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(transfers);		
	
	}
	
	@GetMapping("/playeraccounts/all")
	public ResponseEntity<List <PlayerAccount>> getAllPlayerAccounts(){
		List<PlayerAccount> transfers = service.getAllPlayerAccounts();
		
		return transfers.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(transfers);		
	
	}
	
	@PostMapping("/transfer")
	public ResponseEntity<PlayerTransaction> create(@RequestBody @Valid TransactionForm form){
				
		PlayerTransaction newTrans = service.creditDebit(
										form.getExternalId(),
										service.findPlayerById(form.getPlayerId()), 
										form.getAmount());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newTrans);
	}
	
	@PostMapping("/playeraccount")
	public ResponseEntity<PlayerAccount> createPlayer(@RequestBody @Valid PlayerAccountForm form){
		
		PlayerAccount newPlayer = service.createAccount(new PlayerAccount(
								form.getName()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newPlayer);
	}
		
	
	@RequestMapping("/")
	public String home() {
		return "WalletController!";
	}
	
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> productValidationException(MethodArgumentNotValidException e){
		Map<String,String> errors = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return errors;
	}
}
