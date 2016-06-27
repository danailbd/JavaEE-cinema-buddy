package user;

//import java.util.HashSet;
//import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "Customer")
public class User {
	
	private String firstName;
	private String secondName;
    private String password;
    private String email;
    
    @Id
    private int userId;
   
   // @OneToMany
   // private Set<Movies> currentMovies = new HashSet<>();

    public User() {}

    public User(int userId, String firstName, String secondName, String password, String email) {
        this.userId = userId;
    	this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.email = email;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
    
    
	
}
