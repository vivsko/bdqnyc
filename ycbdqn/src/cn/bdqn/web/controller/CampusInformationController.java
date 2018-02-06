package cn.bdqn.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;

import cn.bdqn.entity.CampusInformation;
import cn.bdqn.service.service.CampusInformationService;
import cn.bdqn.utils.Constants;
import cn.bdqn.utils.PageSupport;
import cn.bdqn.utils.Src;

@Controller
@RequestMapping(value = "/CampusInformation")
public class CampusInformationController {

	private Logger logger = Logger.getLogger(CampusInformationController.class);

	@Resource
	private CampusInformationService campusInformationService;

	// ��ҳ��ʾ��ѯ�б�
	@RequestMapping(value = "/sys/list")
	public String getCampusInformationList(Model model,
			@RequestParam(value = "pageIndex", required = false) String pageIndex) {
		int pageSize = Constants.pageSize;
		int currentPageNo = 1;
		if(pageIndex != null){
			currentPageNo = Integer.parseInt(pageIndex);
		}
		int totalCount = campusInformationService.getCount();
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();

		if (currentPageNo < 1) {
			currentPageNo = 1;
		} else if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}

		List<CampusInformation> campusInformationList = campusInformationService
				.getCampusInformationList((currentPageNo - 1) * pageSize, pageSize);
		model.addAttribute("campusInformationList", campusInformationList);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("totalCount", totalCount);

		return "campusInformation/campusInformationinfolist";
	}

	// ��ҳ��ʾ��ѯ�б�
	@RequestMapping(value = "/campusInformationList.json", method = RequestMethod.GET)
	@ResponseBody
	public String getCampusInformationList(@RequestParam(required = false) String pageIndex) {
	/*	System.out.println("~~~~~~~~����");*/
		
		int pageSize = 6;
		int currentPageNo = 1;
		if(pageIndex != null){
			currentPageNo = Integer.parseInt(pageIndex);
		}
		int totalCount = campusInformationService.getCount();
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();

		if (currentPageNo < 1) {
			currentPageNo = 1;
		} else if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}

		List<CampusInformation> campusInformationList = campusInformationService
				.getCampusInformationList((currentPageNo - 1) * pageSize, pageSize);
		/*System.out.println("���ȡ���������������������������������������������������"+campusInformationList.size());*/
		HashMap map=new HashMap();
		map.put("campusInformationList", campusInformationList);
		map.put("pages", pages);
		
		return JSONArray.toJSONString(map);
	}

	// ����id��ѯ
	@RequestMapping(value = "/sys/campusInformationById")
	public String view(@RequestParam Integer uuid, Model model) {
		CampusInformation campusInformation = campusInformationService.getCampusInformationById(uuid);
		model.addAttribute("campusInformation", campusInformation);
		return "campusInformation/campusInformationinfoview";
	}

	// ����id��ѯ
	@RequestMapping(value = "/viewcampusInformation")
	@ResponseBody
	public CampusInformation getview(@RequestParam Integer uuid) {
	/*	System.out.println("sd~~~~~~~~~~~~~~~~~~`"+uuid);*/
		CampusInformation campusInformation = campusInformationService.getCampusInformationById(uuid);
		return campusInformation;
	}

	// ɾ��

	@RequestMapping(value = "/sys/deleteCampusInformation", method = RequestMethod.GET)
	public Object deleteById(Model model, @RequestParam Integer uuid) {
		int count = campusInformationService.deleteCampusInformationById(uuid);
		model.addAttribute("count", count);
		return "redirect:/CampusInformation/sys/list";
	}
//������ת
	@RequestMapping(value="/sys/addCampusInformation.html")
	public String add() {
		return "campusInformation/campusInformationinfoAdd";
	}
	
	// ���ӱ���
	@RequestMapping(value = "/sys/addCampusInformation")
	public String addSave(CampusInformation campusInformation,HttpSession session,HttpServletRequest request) {
		String getsrc=Src.getsrc(campusInformation.getContent());
		campusInformation.setCreateTime(new Date().getTime());
		campusInformation.setPicPath(getsrc);
		String contents=Src.getEle(campusInformation.getContent());
		campusInformation.setContent(contents);
		if(campusInformationService.addCampusInformation(campusInformation)>0){
			return "redirect:/CampusInformation/sys/list";
		}
		 return "campusInformation/campusInformationinfoAdd";
	}

}
