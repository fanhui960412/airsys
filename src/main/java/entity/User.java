package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import util.DateUtil;

/**
 * 实体类 你现在没有用框架，所以你没有感觉 javaBean （1） 实体最好实现序列化接口 （2） 实体类应该有缺省的构造器（显式的）
 * （3）对属性要有getter 和setter方法 （4） 重写toString (5) 重写equals和Hashcode (6)强烈建议在重写equals方法的时候，重写hashCode方法
 *  如果你这个类将来要放置到Set集合中的时候，你必须重写equals和hashcode方法
 *  TreeSet   TreeMap
 *  
 *  自反性:  x.equals(x) 一定是true
	对null:  x.equals(null) 一定是false
	对称性:  x.equals(y)  和  y.equals(x)结果一致
	传递性:  a 和 b equals , b 和 c  equals，那么 a 和 c也一定equals。
	一致性:  在某个运行时期间，2个对象的状态的改变不会影响equals的决策结果，那么，在这个运行时期间，无论调用多少次equals，都返回相同的结果。
 * 实体类里的方法是可以做些事情的，不是一成不变的
 * 
 * @author 范晖
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String pwd;
	private int age;
	private Date birth;

	public User() {
	}

	public User(String name, String pwd, int age, Date birth) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.birth = birth;
	}

	public int getId() {
		return id;
	}
	
	public User setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}

	public String getPwd() {
		return pwd;
	}

	public User setPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}

	public int getAge() {
		return age;
	}

	public User setAge(int age) {
		this.age = age;
		return this;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		// this.birth = birth;
		// this.birth=new Date(birth)
		this.birth = DateUtil.toDate("yyyy-MM-dd", birth);
	}

	@Override
	public String toString() {
		return "User [name="
				+ name + ", pwd="
				+ pwd + ", age="
				+ age + ", birth=" 
				+ DateUtil.dateToString("yyyy-MM-dd", birth) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		return result;
	}

	/**
	 * equals方法 与对象的地址没有任何关系
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)     //  自反性
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())    //  不是一个类型
			return false;
		User other = (User) obj;    // 同类
		if (age != other.age)
			return false;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}

}
