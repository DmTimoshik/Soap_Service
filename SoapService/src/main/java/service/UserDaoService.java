package service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import dao.User;

@WebService
public interface UserDaoService {
	@WebMethod
	public void create(User user);
	@WebMethod
	public void update(User user);
	@WebMethod
	public void remove(User user);
	@WebMethod
	public List<User> findAll();
	@WebMethod
	public User findByLogin(String login);
	@WebMethod
	public User findByEmail(String email);
}
