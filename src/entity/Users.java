package entity;
/**
 * 用户类
 * @author 黄龙
 *
 */
public class Users {
     private String name;//姓名
     private int age;//年龄
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Users(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Users() {
		super();
	}
    
}
