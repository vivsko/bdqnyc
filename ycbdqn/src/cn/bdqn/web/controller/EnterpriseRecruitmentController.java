package cn.bdqn.web.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cn.bdqn.entity.EnterpriseRecruitment;
import cn.bdqn.service.service.EnterpriseRecruitmentService;
import cn.bdqn.utils.Constants;
import cn.bdqn.utils.PageSupport;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseRecruitmentController {

	
	@Resource
	private EnterpriseRecruitmentService enterprise_recruitment_Service;
	
	
	
	
	
	private Logger logger = Logger.getLogger(SchoolEnvController.class);
	
	
	@RequestMapping("/list")
	public String select(Model model,@RequestParam(value="pageIndex",required=false) String pageIndex) {
		
		
		logger.info("页面下标:"+pageIndex);
		
		List<EnterpriseRecruitment> schoolEnvs = null;
		
		//页面容量
		int pageSize = Constants.pageSize;
		//当前页码
		Integer currentPageNo = 1;
		
		if(pageIndex != null){
			try{
				currentPageNo = Integer.valueOf(pageIndex);
			}catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		//总数量
		int totalCount = 0;
		try {
			totalCount = enterprise_recruitment_Service.count();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//总页面
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();
		
		//控制首页和尾页
		if(currentPageNo < 1) {
			currentPageNo = 1;
			
		}else if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}
		
		schoolEnvs = enterprise_recruitment_Service.getEnterpriselist(currentPageNo, pageSize);
		
		model.addAttribute("schoolEnvs", schoolEnvs);
		model.addAttribute("pages", pages);
		
		return "qiyezhaoping.html";
	}
	@RequestMapping("/enterpriseRecruitmentList")
	@ResponseBody
	public Object enterpriseRecruitmentList(@RequestParam(value="pageIndex",required=false) String pageIndex) {
		
		logger.info("页面下标:"+pageIndex);
		System.out.println("========================================================");
		List<EnterpriseRecruitment> schoolEnvs = null;
		
		HashMap<Object, Object> resultMsg = new HashMap<Object, Object>();
		//页面容量
		int pageSize = Constants.pageSize;
		//当前页码
		Integer currentPageNo = 1;
		
		if(pageIndex != null){
			try{
				currentPageNo = Integer.valueOf(pageIndex);
			}catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		//总数量
		int totalCount = 0;
		try {
			totalCount = enterprise_recruitment_Service.count();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//总页面
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();
		
		//控制首页和尾页
		if(currentPageNo < 1) {
			currentPageNo = 1;
			
		}else if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}
		
		schoolEnvs = enterprise_recruitment_Service.getEnterpriselist(currentPageNo, pageSize);
		
		resultMsg.put("schoolEnvs", schoolEnvs);
		/*List<PageSupport> pagelist = new ArrayList<PageSupport>();
		pagelist.add(pages);*/
		resultMsg.put("pages", pages);
		//resultMsg.put("pagelist", pagelist);
		/*model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo",currentPageNo);
		model.addAttribute("totalPageCount", totalPageCount);*/
		
		return JSONArray.toJSONString(resultMsg);
	}
	
	
}