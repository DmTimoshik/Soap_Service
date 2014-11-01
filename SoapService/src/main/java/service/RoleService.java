package service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.Role;
import dao.RoleDao;

@WebService(endpointInterface = "service.RoleDaoService")
public class RoleService implements RoleDaoService {

	public RoleService() {
	}
	
	@Autowired
    private RoleDao roleDao;
	
	
	@Transactional
	@WebMethod
	public Role findByName(String string) {
		return roleDao.findByName(string);
	}
	
}
