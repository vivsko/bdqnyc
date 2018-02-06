package cn.bdqn.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.entity.EnterpriseRecruitment;

public interface EnterpriseRecruitmentMapper {
	
	public List<EnterpriseRecruitment> getEnterpriselist(@Param(value="currentPageNo")Integer currentPageNo,
			  @Param(value="pageSize")Integer pageSize); 
	
	//查找信息条数
		public Integer count()throws Exception;
	
	
}
