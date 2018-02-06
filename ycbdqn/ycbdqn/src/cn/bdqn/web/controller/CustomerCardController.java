package cn.bdqn.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bdqn.entity.CustomerCard;
import cn.bdqn.service.service.CustomerCardService;
import cn.bdqn.utils.PageSupport;


@Controller
@RequestMapping(value = "/CustomerCard")
public class CustomerCardController {
	@Resource
	private CustomerCardService customerCardService;
	//分页查询
	@RequestMapping(value="/sys/customer_card.html")
	public String getAllCustomerCard(CustomerCard customerCard,Model model,@RequestParam(value="pageIndex",required=false) String pageIndex){
		List<CustomerCard> customerCardList = null;
		//页面容量
		int pageSize = 5;
		//当前页码
		Integer currentPageNo = 1;
		if(pageIndex != null){
			try{
				currentPageNo = Integer.valueOf(pageIndex);
			}catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		//总数量（表）
		int totalCount = 0;
		try {
			totalCount = customerCardService.getCustomerCardCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//总页数
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();
		//控制首页和尾页
		if(currentPageNo < 1){
			currentPageNo = 1;
		}else if(currentPageNo > totalPageCount){
			currentPageNo = totalPageCount;
		}
		try {
			customerCardList = customerCardService.getAllCustomerCard(currentPageNo, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("customerCardList", customerCardList);
		model.addAttribute("pages", pages);
		
		return "customercard/customercardlist";
	}
	/*@RequestMapping(value="/sys/add.html")
	public String add(){
		return "customercard/customercardadd";
	}
	//添加用户体验卡jsp
	@RequestMapping(value="/sys/addCustomerCard.html")
	public String addCustomerCard(CustomerCard customerCard){
		customerCard.setCreateTime(new Date().getTime());
		try {
			customerCardService.addCustomerCard(customerCard);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/CustomerCard/sys/customer_card.html";
	}*/
	//添加用户体验卡json
	@RequestMapping(value="/addcustomercard.json")
	@ResponseBody
	public Object customerCardAdd(CustomerCard customerCard){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		int count = 0;
		try {
			customerCard.setCreateTime(new Date().getTime());
			count = customerCardService.addCustomerCard(customerCard);
			if(count > 0){
				resultMap.put("resultMsg", "success");
			}else if(count == 0){
				resultMap.put("resultMsg", "error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}
	//删除用户体验卡
	@RequestMapping(value="/sys/delCustomerCard.html")
	public String delCustomerCard(@RequestParam(value="id")String id){
		try {
			customerCardService.deleteCustomerCardByUuid(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/CustomerCard/sys/customer_card.html";
	}
}
