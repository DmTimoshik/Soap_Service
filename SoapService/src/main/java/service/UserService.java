package service;



import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.User;
import dao.UserDao;

@WebService(endpointInterface = "service.UserDaoService")
public class UserService implements UserDaoService {

	@Autowired
    private UserDao userDao;
	
	public UserService(){}
	
	@Transactional
	@WebMethod
	public void create(User user) {
		userDao.create(user);
	}
	
	@Transactional
	@WebMethod
	public void update(User user) {
		userDao.update(user);
	}
	
	@Transactional
	@WebMethod
	public void remove(User user) {
		userDao.remove(user);
	}
	
	@Transactional
	@WebMethod
	public List<User> findAll() {
		return userDao.findAll();

	}
	
	@Transactional
	@WebMethod
	public User findByLogin(String login) {
		return userDao.findByLogin(login);

	}
	
	@Transactional
	@WebMethod
	public User findByEmail(String email) {
		return userDao.findByEmail(email);

	}


	
}
