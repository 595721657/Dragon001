package dao;

import entity.Users;

public interface UserDao {
    //保存用户信息的方法
	void save(Users user);
    void updat(Users user);
}
