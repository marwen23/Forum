package mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Entities.User;
import Services.AccountManagementServicesLocal;


@ManagedBean
@ViewScoped
public class UserBean {
	private List<User> users = new ArrayList<>();
	@EJB
	private AccountManagementServicesLocal accountManagementServicesLocal;

	public User doFindUserByUsername(String username) {
		return accountManagementServicesLocal.findUserByUsername(username);
	}

	public List<User> getUsers() {
		users = accountManagementServicesLocal.findAllUser();
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
