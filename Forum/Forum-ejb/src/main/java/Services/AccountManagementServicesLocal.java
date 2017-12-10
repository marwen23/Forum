package Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import Entities.ResponsibilityOf;
import Entities.User;

@Local
public interface AccountManagementServicesLocal {
	Boolean addUser(User user);
	
	Boolean updateUser(User user);

	User findUserById(Integer id);

	void deleteUserById(Integer id);

	void deleteUser(User user);

	List<User> findAllUser();

	ArrayList<User> listAlphabetically(ArrayList<User> users);

	List<User> findAllUserByRole(String role);

	List<User> findAllModeratorByResponsibilityOf(ResponsibilityOf responsibleOf);

	List<User> findAllUserByEnabled(Boolean enabled);

	User Authentification(String username, String password);

	User findUserByUsername(String username);

	User findUserByEmail(String email);

	User findUserByPassword(String password);

	List<User> findAllUserByResponsibilityOf(ResponsibilityOf responsibleOf);

	boolean updateUser(Integer id, String username, String password, String role);

	boolean updateUser1(Integer id, String username, String password, String role, ResponsibilityOf responsibleOf);

	Boolean updateUser(Integer id, String role);

	void blocUser(boolean en, int id);

	boolean updateProfilModerator(String username, String password, String email);

	List<User> findAllUserNotAdmin(String admin);

	List<User> findAllUserNotAdminAndModerator(String user);

	List<User> findAllUserNotAdminAndUser(String moderator);

	User updateUser1(Integer id, ResponsibilityOf responsibleOf);
	// List<User> findAllUserandModeratorByEnabled(Boolean enabled);
	// List<User> findAllModeratorByResponsibilityOf(ResponsibilityOf
	// responsibleOf);
	User recuppererMotDePasse(String emailUsername);
}
