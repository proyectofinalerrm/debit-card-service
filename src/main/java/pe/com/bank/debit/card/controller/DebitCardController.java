package pe.com.bank.debit.card.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pe.com.bank.debit.card.dto.AddDebitCardDTO;
import pe.com.bank.debit.card.entity.DebitCardEntity;
import pe.com.bank.debit.card.service.DebitCardService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/v1")
public class DebitCardController {
	
	
	DebitCardService debitCardService;
	
	@GetMapping
    public Flux<DebitCardEntity> getAllDebitCard() {
        return debitCardService.listAllDebitCard();
    }

    @GetMapping("/getDebitCard/{id}")
    public Mono<DebitCardEntity> getDebitCardById(@PathVariable String id) {
        return debitCardService.findDebitCardById(id);
    }

    @PostMapping("/createDebitCard")
    public Mono<DebitCardEntity> createDebitCard(@RequestBody DebitCardEntity debitCardEntity) {
        return debitCardService.createDebitCard(debitCardEntity);
    }

    @PutMapping("/updateDebitCard/{id}")
    public Mono<DebitCardEntity> updateDebitCard(@RequestBody DebitCardEntity debitCardEntity, @PathVariable String id) {
        return debitCardService.updateDebitCard(debitCardEntity, id);
    }
    
    @PostMapping("/createDebitCardUpdateAccount")
    public Mono<DebitCardEntity> createDebitCardUpdateAccount(@RequestBody AddDebitCardDTO addDebitCardDTO) {
        return debitCardService.createDebitCardUpdateAccount(addDebitCardDTO);
    }

}
