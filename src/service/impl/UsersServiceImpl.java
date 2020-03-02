package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.Users;
import service.UsersService;

public class UsersServiceImpl implements UsersService {
   //ÒµÎñ²ã
	UserDao dao=new UserDaoImpl();
	@Override
	public void save(Users user) {
		 dao.save(user);
	}

}
