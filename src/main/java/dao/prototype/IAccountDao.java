package dao.prototype;

import java.sql.Connection;
import java.util.List;

import entity.Account;
import util.Pager;

/**
 * AccountDao
 * 
 * @author 范晖
 *
 */
public interface IAccountDao {
	Account find(int id);
	void saveOrUpdate(Account act);
	void delete(int id);
	List<Account> findAll();
	List<Account> find(int offset, int pageSize); // 0 Integer.MaxValue
	int totalItems();		//获取总条目数

}
