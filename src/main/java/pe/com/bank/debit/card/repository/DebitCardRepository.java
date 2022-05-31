package pe.com.bank.debit.card.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import pe.com.bank.debit.card.entity.DebitCardEntity;

@Repository
public interface DebitCardRepository extends ReactiveMongoRepository<DebitCardEntity, String>{

}
