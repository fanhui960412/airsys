package testDao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import config.AppConfig;
import config.TestConfig;
import dao.prototype.IAccountDao;
import entity.Account;
import util.Pager;

/**
 * Spring单元测试
 * 
 * @author 范晖
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class TestAccountDao {
	@Autowired
	private IAccountDao actDao;
	@Test
	public void testFindById() {
		System.out.println(actDao.find(1));
	}
	@Test
	public void testFindAll() {
		List<Account> acts = actDao.findAll();
		for (Account account : acts) {
			System.out.println(account);
		}
		
	}
	@Test
	public void testDelete() {
		actDao.delete(13);
	}
	
	@Test
	public void testSaveOrUpdate() {
		actDao.saveOrUpdate(new Account("xhh",100000));
		actDao.saveOrUpdate(new Account(1,"zhangsan",6000));
	}
	@Test
	public void testTotal() {
		System.out.println(actDao.totalItems());
	}
	@Test
	public void testPager() {
		
		System.out.println(actDao.find(0, 5));
	}
}
