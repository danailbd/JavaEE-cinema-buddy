package email;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("email")
public class EmailManager {
	
	private static final Response RESPONSE_OK = Response.ok().build();
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void registerUser(Email email) {
        email.sendMessage();
    }

}
