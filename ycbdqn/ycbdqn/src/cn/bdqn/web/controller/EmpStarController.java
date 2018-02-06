package cn.bdqn.web.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cn.bdqn.entity.EmpStar;
import cn.bdqn.service.service.EmpStarService;
import cn.bdqn.utils.PageSupport;
import cn.bdqn.utils.Src;

@Controller
@RequestMapping(value="/empStar")
public class EmpStarController {

	private Logger logger = Logger.getLogger(EmpStarController.class);
	@Resource
	private EmpStarService empStarService;
	

	@RequestMapping(value="/sys/list")
	public String getCampusInformationByUuid(Model model,
			@RequestParam(value="pageIndex",required=false)Integer pageIndex
			){
		List<EmpStar> empList = null;
		int pageSize =5;
		Integer currentPageNo = 1;
		
		if(pageIndex != null){
			currentPageNo = Integer.valueOf(pageIndex);
		}
		int count =0;
		try {
			count= empStarService.getCount();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(count);
		int totalPageCount = pages.getTotalPageCount();
		if(currentPageNo < 1){
			currentPageNo = 1;
		}else if(currentPageNo > totalPageCount){
			currentPageNo = totalPageCount;
		}
		try {
			empList = empStarService.getEmpStarList((currentPageNo-1)*pageSize, pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("empList",empList);
		model.addAttribute("currentPageNo",currentPageNo);
		model.addAttribute("totalPageCount",totalPageCount);
		return "EmpStar/empStarList";
	}
		//��ҳ��ʾ��ѯ�б�
		@RequestMapping(value = "/empList.json", method = RequestMethod.GET)
		@ResponseBody
		public String getCampusInformationList(@RequestParam String pageIndex,Model model) {
			System.out.println("����mingxingbiao");
			int pageSize = 4;
			int currentPageNo = 1;
			if(pageIndex != null){
				currentPageNo = Integer.valueOf(pageIndex);
			}
			int totalCount = 0;
			try {
				totalCount = empStarService.getCount();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PageSupport pages=new PageSupport();
	    	pages.setCurrentPageNo(currentPageNo);
	    	pages.setPageSize(pageSize);
	    	pages.setTotalCount(totalCount);
	    	int totalPageCount = pages.getTotalPageCount();
	    	
	    	if(currentPageNo < 1){
	    		currentPageNo = 1;
	    	}else if(currentPageNo > totalPageCount){
	    		currentPageNo = totalPageCount;
	    	}
	    	
	    	List<EmpStar> empList = null;
			try {
				empList = empStarService.getEmpStarList((currentPageNo-1)*pageSize, pageSize);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.addAttribute("empList", empList);
			model.addAttribute("pages", pages);
			return JSONArray.toJSONString(model);
		}
		
		//��ʾ��ҳ���Ǳ�
				@RequestMapping(value = "/empIndexList.json", method = RequestMethod.GET)
				@ResponseBody
				public List<EmpStar> getCampusInformationList(@RequestParam String pageIndex) {
					int pageSize =4;
					int currentPageNo = 1;
					int totalCount =0;
					try {
						totalCount= empStarService.getCount();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					PageSupport pages = new PageSupport();
					pages.setCurrentPageNo(currentPageNo);
					pages.setPageSize(pageSize);
					pages.setTotalCount(totalCount);
					int totalPageCount = pages.getTotalPageCount();
					/*if(currentPageNo < 1){
						currentPageNo = 1;
					}else if(currentPageNo > totalPageCount){
						currentPageNo = totalPageCount;
					}*/
					List<EmpStar> empList = null;
					try {
						empList = empStarService.getEmpStarList((currentPageNo-1)*pageSize, pageSize);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(empList);
					return empList;
				}
		
		//����id��ѯ
		@RequestMapping(value="/sys/viewEmpStar",method=RequestMethod.GET)
		public String view(@RequestParam Integer uuid,Model model){
			EmpStar empStar=null;
			System.out.println("�M��");
			try {
				empStar = empStarService.getEmpStarByUuid(uuid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("empStar",empStar);
			return "EmpStar/empStarView";
		}
		
		//����id��ѯ
		@RequestMapping(value = "/viewEmpStar.json", method = RequestMethod.GET)
		@ResponseBody
		public EmpStar getview(@RequestParam Integer uuid) {
			EmpStar empStar = null;
			try {
				empStar = empStarService.getEmpStarByUuid(uuid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return empStar;
		}
		//����
		@RequestMapping(value="/sys/empadd")
		public String addEmpStar(){
			return "EmpStar/empStarAdd";
		}
		@RequestMapping(value = "/sys/addEmpStar")
		public String addSave(EmpStar empStar, HttpSession session, HttpServletRequest request) {
			String src = Src.getsrc(empStar.getContent());
			empStar.setCreateTime(new Date().getTime());
			empStar.setPicPath(src);
			String content = Src.getEle(empStar.getContent());
			empStar.setContent(content);
			try {
				if(empStarService.addEmpStar(empStar)){
					return "redirect:/empStar/sys/list";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			 return "EmpStar/empStarAdd";
		}
		//ɾ��
		  @RequestMapping(value="/sys/delemp",method=RequestMethod.GET)
		 public Object delEmp(@RequestParam Integer uuid){
		    	System.out.println("ɾ��*************************"+uuid);
				try {
					empStarService.deleteEmpStarByUuid(uuid);
				} catch (Exception e) {
			e.printStackTrace();
				}
		        return "redirect:/empStar/sys/list";
		    }
}
