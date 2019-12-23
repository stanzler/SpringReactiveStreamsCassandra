/**
 * 
 */
package reactive.politics.tv.confidential.user.model;

//import lombok.AllArgsConstructor;
//import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;


/**
 * @author David
 *
 */

@Table
public class PoliticsUser {

  @Id
  private Long id;
  public String firstname;
  public String lastname;
  public String email;

  public void set_first_name(String fn) {

    firstname = fn;
  }

  public void set_last_name(String ln) {

    lastname = ln;
  }

  public void set_email(String e) {

    email = e;
  }

}
