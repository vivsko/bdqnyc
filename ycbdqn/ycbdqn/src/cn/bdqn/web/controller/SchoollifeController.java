package cn.bdqn.web.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.bdqn.entity.Schoollife;
import cn.bdqn.service.service.SchoollifeService;
import cn.bdqn.utils.Constants;
import cn.bdqn.utils.PageSupport;
import cn.bdqn.utils.Src;

@Controller
@RequestMapping(value="/schoollife")
public class SchoollifeController {

	private Logger logger = Logger.getLogger(SchoollifeController.class);
	@Resource
	private SchoollifeService schoollifeService;
	
	@RequestMapping(value="/sys/schoollifelist.html")
	public String getSLifeList(Model model,@RequestParam(value="pageIndex",required=false) String pageIndex){
		
    	int pageSize = Constants.pageSize;
    	
    	int currentPageNo = 1;
		
    	if(pageIndex != null){
    		try{
    			currentPageNo = Integer.valueOf(pageIndex);
    		}catch(NumberFormatException e){
    			return "redirect:/user/syserror.html";
    		}
    	}	
    		
    	int totalCount	= schoollifeService.getTotalCount();
    	
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
    	List<Schoollife> sList = schoollifeService.getSchoollifeListByPage(currentPageNo, pageSize);
		List<Schoollife> allSlList = schoollifeService.getAllSchoollifeList();
		model.addAttribute("allSlList", allSlList);
		model.addAttribute("sList", sList);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);
		return "schoollife/schoollifelist";
	}
	
	@RequestMapping(value="/getSchoollife.json",method=RequestMethod.GET)
	@ResponseBody
	public String getScloolLife(){
		logger.info("getScloolLifeById>>>>>>>>>>>>>>>>>>>>>>>>");
		List<Schoollife> schoollifeList = schoollifeService.getAllSchoollifeList();
		return JSONArray.toJSONString(schoollifeList);
	}
	
	@RequestMapping(value="/sys/checkSchoolLife.html")
	public String getScloolLifeById(@RequestParam("uuid")String uuid,Model model){
		logger.info("getScloolLifeById>>>>>>>>>>>>>>>>>>>>>>>>");
		Schoollife schoollife = schoollifeService.getAllSchoollifeById(Integer.parseInt(uuid));
		model.addAttribute("schoollife",schoollife);
		return "schoollife/schoolView";
	}
	@RequestMapping(value="/sys/delschoollife.html")
	public String delete(@RequestParam("uuid")String uuid,Model model){
		int result = schoollifeService.delete(Integer.parseInt(uuid));
		if (result>0) {
			return "redirect:/schoollife/sys/schoollifelist.html";
		}else{
			return "schoollife/schoollifelist";
		}
	}
	
	@RequestMapping(value="/sys/add.html")
	public String add(@ModelAttribute("schoollife") Schoollife schoollife){
		return "schoollife/schoollifeadd";
	}
	
	@RequestMapping(value="/sys/addsave.html",method=RequestMethod.POST)
	public String addsave(Schoollife schoollife){
		logger.debug("addschoollifeSave<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		String getsrc = Src.getsrc(schoollife.getContent());
		schoollife.setPicPath(getsrc);
		schoollife.setCreateTime(new Date().getTime());
		if(schoollifeService.add(schoollife)){
			return "redirect:/schoollife/sys/schoollifelist.html";
		}
		 return "schoollife/schoollifeadd";
	}

}
