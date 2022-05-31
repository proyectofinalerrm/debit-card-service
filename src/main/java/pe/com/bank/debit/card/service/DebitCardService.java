package pe.com.bank.debit.card.service;

import pe.com.bank.debit.card.dto.AddDebitCardDTO;
import pe.com.bank.debit.card.entity.DebitCardEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DebitCardService {
	
	
	public Flux<DebitCardEntity> listAllDebitCard();

    public Mono<DebitCardEntity> findDebitCardById(String id);

    public Mono<DebitCardEntity> createDebitCard(DebitCardEntity debitCardEntity);

    public Mono<Void> deleteDebitCardById(String id);

    public Mono<DebitCardEntity> updateDebitCard(DebitCardEntity debitCardEntity, String id);
    
    public Mono<DebitCardEntity> createDebitCardUpdateAccount(AddDebitCardDTO addDebitCardDTO);

}
