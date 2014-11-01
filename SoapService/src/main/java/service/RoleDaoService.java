package service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import dao.Role;
@WebService
public interface RoleDaoService {

	@WebMethod
	public Role findByName(String name);
	
}
