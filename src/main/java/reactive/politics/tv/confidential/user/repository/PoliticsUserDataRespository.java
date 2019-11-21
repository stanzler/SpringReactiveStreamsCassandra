/**
 * 
 */
package reactive.politics.tv.confidential.user.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactive.politics.tv.confidential.user.model.PoliticsUser;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author David
 *
 */
public interface PoliticsUserDataRespository extends ReactiveCrudRepository<PoliticsUser, Long> {
	
	//read
	Flux<PoliticsUser> findAll();
	
	//Mono<User> findById(ID id);
	
	Mono<Void> delete(PoliticsUser user);
	
	Mono<Long> count();
	
	Mono<PoliticsUser> save(PoliticsUser user);
	
}
