package gable.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gable.wallet.entity.PlayerTransaction;
import gable.wallet.repository.PlayerTransactionRepository;
import gable.wallet.service.PlayerWalletService;

@RestController
public class WalletController {
	
	private PlayerWalletService service;
	private PlayerTransactionRepository transRepo;
	
	@Autowired
	public WalletController(PlayerWalletService walletService , PlayerTransactionRepository transRepo) {
		super();
		this.service = walletService;
		this.transRepo=transRepo;

	}
	
	@GetMapping("/transactions/{id}")
	public ResponseEntity<PlayerTransaction> getTransaction(@PathVariable int id){
		try {
			return ResponseEntity.ok(transRepo.findById(id));
		
		}catch(IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}		
	}
	
	@RequestMapping("/")
	public String home() {
		return "WalletController!";
	}
}
