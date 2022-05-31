package pe.com.bank.debit.card.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.com.bank.debit.card.client.AccountRestClient;
import pe.com.bank.debit.card.client.entity.AccountEntity;
import pe.com.bank.debit.card.dto.AddDebitCardDTO;
import pe.com.bank.debit.card.entity.DebitCardEntity;
import pe.com.bank.debit.card.repository.DebitCardRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class DebitCardServiceImpl implements DebitCardService{
	
	DebitCardRepository debitCardRepository;
	AccountRestClient accountRestClient;

	    public Flux<DebitCardEntity> listAllDebitCard(){
	        return debitCardRepository.findAll();
	    }

	    public Mono<DebitCardEntity> findDebitCardById(String id){
	        return debitCardRepository.findById(id);
	    }

	    public Mono<DebitCardEntity> createDebitCard(DebitCardEntity debitCardEntity){
	        return debitCardRepository.save(debitCardEntity);
	    }
	    
	    public Mono<DebitCardEntity> createDebitCardUpdateAccount(AddDebitCardDTO addDebitCardDTO){
	    	
	    	
	    	
	    	DebitCardEntity  debitCardEntity = new DebitCardEntity();
    		debitCardEntity.setNumberCard(addDebitCardDTO.getNumberCard());
    		debitCardEntity.setOpeningDate(addDebitCardDTO.getOpeningDate());
    		debitCardEntity.setDueDate(addDebitCardDTO.getDueDate());
    		debitCardEntity.setCvv(addDebitCardDTO.getCvv());
    		debitCardEntity.setOnlinePayment(addDebitCardDTO.getOnlinePayment());
    		debitCardEntity.setCustomerId(addDebitCardDTO.getCustomerId());	 
	    	
    		return debitCardRepository.save(debitCardEntity).flatMap( debitCard -> {
    			
    			AccountEntity accountEntity = new AccountEntity();
    			accountEntity.setCardId(debitCard.getCardId());
    			accountEntity.setCardLabel("CP");
    					
    					
    			return accountRestClient.updateAccountById(accountEntity,addDebitCardDTO.getAccountId()).flatMap( c -> {
    				return Mono.just(debitCard);
    			});
    		});
    		    	
	    	
	    }

	    public Mono<Void> deleteDebitCardById(String id) {
	        return debitCardRepository.deleteById(id);
	    }

	    public Mono<DebitCardEntity> updateDebitCard(DebitCardEntity debitCardEntity, String id) {
	        return debitCardRepository.findById(id)
	                .flatMap(debitCard -> {
	                	debitCard.setNumberCard(debitCardEntity.getNumberCard() != null ? debitCardEntity.getNumberCard() : debitCard.getNumberCard());
	                	debitCard.setOpeningDate(debitCardEntity.getOpeningDate() != null ? debitCardEntity.getOpeningDate() : debitCard.getOpeningDate());
	                	debitCard.setDueDate(debitCardEntity.getDueDate() != null ? debitCardEntity.getDueDate() : debitCard.getDueDate());
	                	debitCard.setCvv(debitCardEntity.getCvv() != null ? debitCardEntity.getCvv() : debitCard.getCvv());
	                	debitCard.setOnlinePayment(debitCardEntity.getOnlinePayment() != null ? debitCardEntity.getOnlinePayment() : debitCard.getOnlinePayment());
	                	debitCard.setCustomerId(debitCardEntity.getCustomerId() != null ? debitCardEntity.getCustomerId() : debitCard.getCustomerId());
	     
	                    return debitCardRepository.save(debitCard);
	                });
	    }
	    

}
