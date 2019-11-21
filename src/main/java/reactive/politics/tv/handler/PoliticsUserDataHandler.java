/**
 * 
 */
package reactive.politics.tv.handler;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactive.politics.tv.confidential.user.model.PoliticsUser;
import reactive.politics.tv.confidential.user.repository.PoliticsUserDataRespository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author David
 * 
 * The handler function implements the request methods for the API
 *   using Spring Webflux.fn and functional programming
 *
 */

@Component
public class PoliticsUserDataHandler {
	
	private PoliticsUserDataRespository politicsUserRepository;

	public void PoliticsUserDataService(PoliticsUserDataRespository repository) {
		
	    this.politicsUserRepository = repository;
	    
	}
	
	
	public Mono<ServerResponse> readPoliticsUserData(ServerRequest request) {
		
		Flux<PoliticsUser> politicsUserDataStream = politicsUserRepository.findAll();
		
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(politicsUserDataStream, PoliticsUser.class);
	}
	
	public void createPoliticsUser(String fn, String ln, String e){
		
		PoliticsUser politicsUser = new PoliticsUser();
		
		politicsUser.set_first_name(fn);
		politicsUser.set_last_name(ln);
		politicsUser.set_email(e);
		
		politicsUserRepository.save(politicsUser);
		
	}
	
	public Mono<Void> deletePoliticsUser(PoliticsUser user){
		
		Mono<Void> deletePoliticsUserStream = politicsUserRepository.delete(user);
		
		return deletePoliticsUserStream;
	}

	public Mono<Long> countTotalPoliticsUsers(){
		
		Mono<Long> countTotalPoliticsUsersStream = politicsUserRepository.count();
		
		return countTotalPoliticsUsersStream;
		
	}
	
}
