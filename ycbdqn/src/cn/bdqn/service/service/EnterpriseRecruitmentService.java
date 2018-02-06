package cn.bdqn.service.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.entity.EnterpriseRecruitment;

public interface EnterpriseRecruitmentService {
	
	
	public List<EnterpriseRecruitment> getEnterpriselist(@Param(value="from")Integer currentPageNo,
			  @Param(value="pageSize")Integer pageSize); 
	
	//查找信息条数
			public Integer count()throws Exception;
		
	
}
