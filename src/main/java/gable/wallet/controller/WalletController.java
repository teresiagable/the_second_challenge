package gable.wallet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

	@RequestMapping("/")
	public String home() {
		return "WalletController!";
	}
}
