package cn.bdqn.web.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;

import cn.bdqn.entity.SchoolEnv;
import cn.bdqn.service.service.SchoolEnvService;
import cn.bdqn.utils.Constants;
import cn.bdqn.utils.PageSupport;

@Controller
@RequestMapping("/school")
public class SchoolEnvController {
	
	@Resource
	private SchoolEnvService schoolEnvService;
	
	
	
	private Logger logger = Logger.getLogger(SchoolEnvController.class);
	
	@RequestMapping(value="/sys/list",method=RequestMethod.GET)
	public String select(Model model,@RequestParam(value="pageIndex",required=false) String pageIndex) {
		
		
		logger.info("页面下标:"+pageIndex);
		
		List<SchoolEnv> schoolEnvs = null;
		
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
			totalCount = schoolEnvService.count();
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
		
		schoolEnvs = schoolEnvService.getAllEnv(currentPageNo, pageSize);
		
		model.addAttribute("schoolEnvs", schoolEnvs);
		model.addAttribute("pages", pages);
		/*model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo",currentPageNo);
		model.addAttribute("totalPageCount", totalPageCount);*/
		
		return "schoolEnv/schoolEnvlist";
	}
	
	@RequestMapping(value="/sys/delete")
	public String deleteByuuid(@RequestParam(value="uuid") String uuid) {
		
		try {
			schoolEnvService.deleteByuuid(Integer.parseInt(uuid));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/school/sys/list";
	}
	
	@RequestMapping(value="/sys/add")
	public String add(@ModelAttribute("schoolEnv")SchoolEnv schoolEnv) {
		return "schoolEnv/schoolEnvadd";
	}
	
	
	
	@RequestMapping(value="/sys/addsave",method=RequestMethod.POST)
	public String addTeacherSave(SchoolEnv schoolEnv,HttpServletRequest request,
			@RequestParam(value="a_picPath",required= false) MultipartFile attach){
		logger.debug("addSchoolEnv<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		String idPicPath = null;
		if(!attach.isEmpty()){
			String path = "\\statics"+File.separator+"uploadfiles"; 
			String oldFileName = attach.getOriginalFilename();//原文件名
			String prefix=FilenameUtils.getExtension(oldFileName);//原文件后缀     
			int filesize = 500000;
	        if(attach.getSize() >  filesize){	//上传大小不得超过 500k
            	request.setAttribute("uploadFileError",Constants.FILEUPLOAD_ERROR_4);
	        	return "schoolEnvadd";
	        }else if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") 
            		|| prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")){//上传图片格式不正确
            	String fileName = RandomUtils.nextInt(1000000)+".jpg";  
                File targetFile = new File(path, fileName);  
                if(!targetFile.exists()){  
                    targetFile.mkdirs();  
                }  
                //保存  
                try {  
                	attach.transferTo(targetFile);  
                } catch (Exception e) {  
                    e.printStackTrace();  
                    request.setAttribute("uploadFileError",Constants.FILEUPLOAD_ERROR_2);
                    return "schoolEnv/schoolEnvadd";
                }  
                idPicPath = path+File.separator+fileName;
            }else{
            	request.setAttribute("uploadFileError",Constants.FILEUPLOAD_ERROR_3);
            	return "schoolEnv/schoolEnvadd";
            }
		}
		schoolEnv.setCreateTime(new Date().getTime());
		schoolEnv.setPicPath(idPicPath);
		try {
			if(schoolEnvService.add(schoolEnv)){
				return "redirect:/school/sys/list";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return "schoolEnv/schoolEnvadd";
	}

	@RequestMapping(value="getSchoolEnv.json",method=RequestMethod.GET)
	@ResponseBody
	public String getSchoolEnv() {
		List<SchoolEnv> schoolEnvList = schoolEnvService.getSchoolEnv();
		return JSONArray.toJSONString(schoolEnvList);
	}
	
	
	
	
	
	
	
}
       