package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import entity.Account;
import service.prototype.IAccountService;

/**
 * 账户管理Controller
 * 
 * @author 范晖
 *
 */
@Controller // component
public class AccountController {
	@Autowired
	private IAccountService actService;

	@RequestMapping("/user/{id}")
	@ResponseBody
	public String getUser(@PathVariable("id") int id) {
		Account u = actService.searchAccount(id);
		List<Account> listAccounts = actService.listAccounts(1, 100);
		System.out.println(listAccounts);
		return JSON.toJSONString(u);
	}

	@RequestMapping("/user")
	public ModelAndView getUser() {
		ModelAndView mv = new ModelAndView("list");
		List<Account> acts = actService.listPaged(1, 100);
		mv.addObject("acts", acts);
		return mv;
	}
	
	@RequestMapping("/index")
	public ModelAndView getBack() {
		ModelAndView mv = new ModelAndView("admin/index");
	
		return mv;
	}

	@RequestMapping("/deleteuser/id")
	public String delete(@PathVariable("id") int id) {
		return "success";
	}

}
