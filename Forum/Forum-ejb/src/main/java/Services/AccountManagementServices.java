package Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entities.Content;
import Entities.ResponsibilityOf;
import Entities.User;


/**
 * Session Bean implementation class AccountManagementServices
 */
@Stateless
public class AccountManagementServices implements AccountManagementServicesRemote, AccountManagementServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public AccountManagementServices() {
        // TODO Auto-generated constructor stub
    }
public Boolean addUser(User user){
	Boolean b = false;
	try {
		entityManager.persist(user);
		b = true;
	} catch (Exception e) {

		System.err.println("problem in subscription ...");
	}
	return b;
}

public Boolean updateUser(User user){
	Boolean b = false;
	try {
	entityManager.merge(user);
	b = true;
	} catch (Exception e) {

		System.err.println("problem in Update ...");
	}
	return b;
}
public Boolean updateUser(Integer id,String role){
	User user;
	try {
		user=findUserById(id);
		user.setRole(role);
		entityManager.merge(user);
	return true;
} catch (Exception e) {
	return false;
}}
	public User updateUser1(Integer id,ResponsibilityOf responsibleOf){
		User user = null;
		try {
			user=findUserById(id);
			user.setResponsibleOf(responsibleOf);
			entityManager.merge(user);
			
	} catch (Exception e) {
		return user;
	}
		return user;
}

public User findUserById(Integer id){
	return entityManager.find(User.class, id);
}
public void deleteUserById(Integer id){
	entityManager.remove(findUserById(id));
}
public void deleteUser(User user){
	entityManager.remove(entityManager.merge(user));
}
public List<User>findAllUser(){
	return entityManager.createQuery("Select u from User u").getResultList();
}
public List<User>findAllUserNotAdmin(String admin){
	return entityManager.createQuery("Select u from User u where u.role not like :x  ")
	.setParameter("x", admin).getResultList();
	
}
public List<User>findAllUserNotAdminAndModerator(String user){
	return entityManager.createQuery("Select u from User u where u.role like :x  ")
	.setParameter("x", user).getResultList();
	
}
public List<User>findAllUserNotAdminAndUser(String moderator){
	return entityManager.createQuery("Select u from User u where u.role like :x  ")
	.setParameter("x", moderator).getResultList();
	
}
public ArrayList<User> listAlphabetically(ArrayList<User> users) {
    class AlphabeticalComparator implements Comparator<User> {
        @Override
        public int compare(User cnt1, User cnt2) {
            return cnt1.getUsername().compareTo(cnt2.getPassword());
        }
    }
    Collections.sort(users, new AlphabeticalComparator());
    return users;
}
public User Authentification(String username, String password) {
	
		User user = null;
		try {
			user = (User) entityManager.createQuery("SELECT u FROM User u WHERE u.username=:username AND u.password=:password",User.class)
					.setParameter("username", username).setParameter("password", password).getSingleResult();
		} catch (Exception e) {
		}

		return user;	
} 
public User findUserByUsername(String username) {
	TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username=:username",User.class);
	query.setParameter("username", username);
	try {
		System.out.println("found");
		User user = query.getSingleResult();	
		return user;
		
	} catch (Exception e) {
		return null;
	}
}
public User findUserByPassword(String password) {
	TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.password=:password",User.class);
	query.setParameter("password", password);
	try {
		System.out.println("found");
		User user = query.getSingleResult();	
		return user;
		
	} catch (Exception e) {
		return null;
	}
} 
public User findUserByEmail(String email) {
	TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=:email",User.class);
	query.setParameter("email", email);
	try {
		System.out.println("found");
		User user = query.getSingleResult();	
		return user;
		
	} catch (Exception e) {
		return null;
	}
} 
public List<User> findAllUserByRole(String role){
	Query query =entityManager.createQuery("Select u FROM User u WHERE u.role=:role");
			query.setParameter("role", role);
	
			return query.getResultList();
}
public List<User> findAllUserByResponsibilityOf(ResponsibilityOf responsibleOf){
	Query query =entityManager.createQuery("Select u FROM User u WHERE u.responsibleOf=:responsibleOf");
	query.setParameter("responsibleOf", responsibleOf);

	return query.getResultList();
}
@Override
public List<User> findAllModeratorByResponsibilityOf(ResponsibilityOf responsibleOf) {
	Query query =entityManager.createQuery("Select u FROM User u WHERE u.responsibleOf=:responsibleOf");
	query.setParameter("responsibleOf", responsibleOf);

	return query.getResultList();
}
public List<User> findAllUserByEnabled(Boolean enabled) {
	Query query =entityManager.createQuery("Select u FROM User u WHERE u.enabled=:enabled");
	query.setParameter("enabled", enabled);

	return query.getResultList();
}
public boolean updateUser(Integer id, String username, String password, String role) {
	User u;
	try {
		u=findUserById(id);
		u.setUsername(username);
		u.setPassword(password);
		u.setRole(role);
		entityManager.merge(u);
		return true;
	} catch (Exception e) {
		return false;
	}
}
	public boolean updateUser1(Integer id, String username, String password, String role, ResponsibilityOf responsibleOf) {
		User u;
		try {
			u=findUserById(id);
			u.setUsername(username);
			u.setPassword(password);
			u.setRole(role);
			u.setResponsibleOf(responsibleOf);
			entityManager.merge(u);
			return true;
		} catch (Exception e) {
			return false;
		}
		
}
	public void blocUser(boolean en,int id){
		User u;
	
			u=findUserById(id);
			u.setEnabled(en);
			entityManager.merge(u);
	}
	public boolean updateProfilModerator(String username, String password,String email){
		User u ;
		try{
		u=findUserByUsername(username);
		u.setUsername(username);
		u.setPassword(password);
		u.setEmail(email);
		entityManager.merge(u);
		return true;
		}catch(Exception e){
			return false;
		}
	}
	@Override
	public User recuppererMotDePasse(String emailUsername) {
		String requete= "select u from User u where u.email=:email or u.username=:username";
		try{
			return entityManager.createQuery(requete,User.class)
					.setParameter("email", emailUsername)
					.setParameter("username", emailUsername)
					.getSingleResult();

		}catch(Exception e){
			return null;
		}
		
	}
	


	
	
}
