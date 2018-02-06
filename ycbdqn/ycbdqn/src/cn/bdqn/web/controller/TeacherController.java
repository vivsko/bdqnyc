package cn.bdqn.web.controller;

import java.util.Date;
import java.util.HashMap;
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

import com.alibaba.fastjson.JSONArray;

import cn.bdqn.entity.Teacher;
import cn.bdqn.service.service.TeacherService;
import cn.bdqn.utils.Constants;
import cn.bdqn.utils.PageSupport;
import cn.bdqn.utils.Src;

@Controller
@RequestMapping(value="/teacher")
public class TeacherController {
	
	private Logger logger = Logger.getLogger(TeacherController.class);
	
	@Resource
	private TeacherService teacherService;
	
	//列表分页
	@RequestMapping(value="/sys/teacherList.html")
	public String teacherList(Model model,@RequestParam(value="pageIndex",required=false) String pageIndex){
		logger.debug("teacherList>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		int pageSize = Constants.pageSize;
		int currentPageNo = 1;
		if(pageIndex != null){
			currentPageNo = Integer.parseInt(pageIndex);
		}
		int totalCount = teacherService.getTeacherCount();
		
		PageSupport pageSupport = new PageSupport();
		pageSupport.setCurrentPageNo(currentPageNo);
		pageSupport.setPageSize(pageSize);
		pageSupport.setTotalCount(totalCount);
		int totalPageCount = pageSupport.getTotalPageCount();
		
		if(currentPageNo < 1){
			currentPageNo = 1;
		}else if(currentPageNo > totalPageCount){
			currentPageNo = totalPageCount;
		}
		List<Teacher> teacherList = teacherService.getTeacherList((currentPageNo-1)*pageSize, pageSize);
		model.addAttribute("teacherList", teacherList);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("totalCount", totalCount);
		return "teacher/teacherList";
	}
	
	//列表分页  JSON
	@RequestMapping(value="/teacherJSONList.json",method=RequestMethod.GET)
	@ResponseBody
	public String teacherJSON(Model model,@RequestParam(value="pageIndex",required=false) String pageIndex){
		logger.debug("teacherList>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		HashMap<Object, Object> resultMsg = new HashMap<Object, Object>();
		int pageSize = Constants.pageSize;
		int currentPageNo = 1;
		if(pageIndex != null){
			currentPageNo = Integer.parseInt(pageIndex);
		}
		int totalCount = teacherService.getTeacherCount();
		
		PageSupport pageSupport = new PageSupport();
		pageSupport.setCurrentPageNo(currentPageNo);
		pageSupport.setPageSize(pageSize);
		pageSupport.setTotalCount(totalCount);
		int totalPageCount = pageSupport.getTotalPageCount();
		
		if(currentPageNo < 1){
			currentPageNo = 1;
		}else if(currentPageNo > totalPageCount){
			currentPageNo = totalPageCount;
		}
		List<Teacher> teacherList = teacherService.getTeacherList((currentPageNo-1)*pageSize, pageSize);
		//model.addAttribute("teacherList", teacherList);
		resultMsg.put("teacherList", teacherList);
		resultMsg.put("pages", pageSupport);
		/*model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("totalCount", totalCount);*/
		return JSONArray.toJSONString(resultMsg);
	}

	//通过uuid查询对应的信息
	@RequestMapping(value="/sys/teacherById.html")
	public String teacherById(Model model,@RequestParam Integer uuid){
		logger.debug("teacherById<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		Teacher teacherById = teacherService.getTeacherById(uuid);
		model.addAttribute("teacherById",teacherById);
		return "teacher/teacherView";
	}
	
	//通过uuid删除对应的信息
	@RequestMapping(value="/sys/deleteTeacher.html")
	public String deleteTeacher(Model model,@RequestParam Integer uuid){
		logger.debug("deleteTeacher<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		int deleteTeacher = teacherService.deleteTeacher(uuid);
		model.addAttribute("deleteTeacher",deleteTeacher);
		return "redirect:/teacher/sys/teacherList.html";
	}
	
	// 跳转至添加页面
	@RequestMapping(value="/sys/addTeacherInfo.html")
	public String addTeacher(@ModelAttribute("teacher")Teacher teacher){
		logger.debug("addTeacherInfo<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return "teacher/teacherAdd";
	}
	
	// 添加后保存信息   上传文件
	@RequestMapping(value="/sys/addTeacherSave.html",method=RequestMethod.POST)
	public String addTeacherSave(Teacher teacher){
		logger.debug("addTeacherSave<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		String getsrc = Src.getsrc(teacher.getContent());
		teacher.setPicPath(getsrc);
		teacher.setContent(Src.getEle(teacher.getContent()));
		teacher.setCreateTime(new Date().getTime());
		if(teacherService.addTeacher(teacher) > 0){
			return "redirect:/teacher/sys/teacherList.html";
		}
		 return "teacher/teacherAdd";
	}
}
