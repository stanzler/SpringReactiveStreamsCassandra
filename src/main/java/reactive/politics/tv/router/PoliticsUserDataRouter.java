/**
 * 
 */
package reactive.politics.tv.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactive.politics.tv.handler.PoliticsUserDataHandler;

/**
 * @author David
 *
 */

@Configuration
public class PoliticsUserDataRouter {
	
	@Bean
	public RouterFunction<ServerResponse> politicsUserDataListAll(PoliticsUserDataHandler politicsUserDataHandler) {
		
		return RouterFunctions.route(RequestPredicates.GET("/users/")
				.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), politicsUserDataHandler::readPoliticsUserData);

	}

}
