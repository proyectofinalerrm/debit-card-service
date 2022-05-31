package pe.com.bank.debit.card.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import pe.com.bank.debit.card.client.entity.AccountEntity;
import reactor.core.publisher.Mono;

@Component
public class AccountRestClient {
	
	private WebClient webClient;		
	  
	  public AccountRestClient(WebClient webClient) {
	        this.webClient = webClient;
	    }
	  
	  
	  @Value("${restClient.accountUrl}")
	  private String accountUrl;
	  
	  
	  
	  public Mono<AccountEntity> getAccountCard(String cardId){
		  var url = UriComponentsBuilder.fromHttpUrl(accountUrl)
	                .queryParam("cardId", cardId)
	                .buildAndExpand().toUriString();
		  
		  return  webClient
	                .get()
	                .uri(url)
	                .retrieve()
	                .bodyToMono(AccountEntity.class)
	                .log();

	  }
	  
	  public Mono<AccountEntity> getAccountById(String accoundId){
		  var url = accountUrl.concat("/{accoundId}");
		  
		  return  webClient
	                .get()
	                .uri(url,accoundId)
	                .retrieve()
	                .bodyToMono(AccountEntity.class)
	                .log();

	  }
	  
	  
	  public Mono<AccountEntity> updateAccountById(AccountEntity accountEntity,String id){
		  var url = accountUrl.concat("/update/{id}");
		  
		  return  webClient
	                .put()
	                .uri(url,id)
	                .body(Mono.just(accountEntity), AccountEntity.class)
	                .retrieve()
	                .bodyToMono(AccountEntity.class)
	                .log();

	  }

}
