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
    //创建一个集合保存信息
	  List<Users> list=new ArrayList<Users>();
	@Override
	public void save(Users user) {
	  list.add(user);
	  for (Users users : list) {
		System.out.println(users.getName()+","+users.getAge());
	   }
	}

	@Override
	public void updat(Users user) {
		System.out.println("执行修改用户的方法！！！");
	}

}
