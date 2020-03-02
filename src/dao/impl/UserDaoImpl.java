package dao.impl;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现dao接口中的操作类
 */
import dao.UserDao;
import entity.Users;

public class UserDaoImpl implements UserDao {
    //保存用户信息的方法
	@Override
	public void save(Users user) {
     //创建一个集合保存信息
	  List<Users> list=new ArrayList<Users>();
	  list.add(user);
	  for (Users users : list) {
		System.out.println(users.getName()+","+users.getAge());
	   }
	}

}
