package testService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import entity.Account;
/**
 * AccountService测试
 * @author 范晖
 *
 */
import service.prototype.IAccountService;
import util.Pager;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class TestAccountService {

	@Autowired
	private IAccountService actService;

	@Test
	public void testFind() {
		System.out.println(actService.listAccounts(1, 100));
		System.out.println(actService.searchAccount(1));
	}

	@Test
	public void test01() {
		Pager<Account> oo = (Pager<Account>) actService.listPaged(1, 5);
		System.out.println(oo.getTotal());
		System.out.println(actService.listPaged(1, 5));
	}
}
