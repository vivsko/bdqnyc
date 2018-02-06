package cn.bdqn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.bdqn.dao.dao.EnterpriseRecruitmentMapper;
import cn.bdqn.entity.EnterpriseRecruitment;
import cn.bdqn.service.service.EnterpriseRecruitmentService;

@Service("EnterpriseRecruitmentServiceImpl")
public class EnterpriseRecruitmentServiceImpl implements EnterpriseRecruitmentService{
	
	
	@Resource
	private EnterpriseRecruitmentMapper enterpriseRecruitmentMapper;

	@Override
	public List<EnterpriseRecruitment> getEnterpriselist(Integer currentPageNo, Integer pageSize) {
		
		
		return enterpriseRecruitmentMapper.getEnterpriselist((currentPageNo-1)*pageSize, pageSize);
	}

	@Override
	public Integer count() throws Exception {
		
		return enterpriseRecruitmentMapper.count();
	}
}
