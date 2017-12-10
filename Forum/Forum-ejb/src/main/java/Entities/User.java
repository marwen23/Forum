package Entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private Date dateOfBirth;
	private String role;
	private boolean enabled;
	private ResponsibilityOf responsibleOf;
	
	@OneToMany(mappedBy="userSender")
	private List<Message> messagesSent;
	
	@OneToMany(mappedBy="userReceiver")
	private List<Message> messagesReceived;
	
	@OneToMany(mappedBy="user")
	private List<Rating> ratings;
	
	@OneToMany(mappedBy="user")
	private List <Comment> comments;
	
	@OneToOne(mappedBy="user")
	private Favorites favorites;
	public Favorites getFavorites() {
		return favorites;
	}
	public void setFavorites(Favorites favorites) {
		this.favorites = favorites;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	public List<Message> getMessagesSent() {
		return messagesSent;
	}
	public void setMessagesSent(List<Message> messagesSent) {
		this.messagesSent = messagesSent;
	}
	public List<Message> getMessagesReceived() {
		return messagesReceived;
	}
	public void setMessagesReceived(List<Message> messagesReceived) {
		this.messagesReceived = messagesReceived;
	}
	public List<Message> getMessages() {
		return messagesSent;
	}
	public void setMessages(List<Message> messages) {
		this.messagesSent = messages;
	}

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}   
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}   
	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	
	
	}
	public ResponsibilityOf getResponsibleOf() {
		return responsibleOf;
	}
	public void setResponsibleOf(ResponsibilityOf responsibleOf) {
		this.responsibleOf = responsibleOf;
	}
   
}
