package cn.bdqn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.bdqn.dao.dao.SchoolEnvMapper;
import cn.bdqn.entity.SchoolEnv;
import cn.bdqn.service.service.SchoolEnvService;

@Service("schoolEnvService")
public class SchoolEnvServiceImpl implements SchoolEnvService{
	
	
	@Resource
	private SchoolEnvMapper schoolMapper;

	public SchoolEnvMapper getSchoolMapper() {
		return schoolMapper;
	}

	public void setSchoolMapper(SchoolEnvMapper schoolMapper) {
		this.schoolMapper = schoolMapper;
	}

	public List<SchoolEnv> getAllEnv(Integer currentPageNo, Integer pageSize) {
		
		return schoolMapper.getAllEnv((currentPageNo-1)*pageSize, pageSize);
	}

	public Integer count() throws Exception {

		
		return schoolMapper.count();
	}

	public Integer deleteByuuid(Integer uuid) throws Exception {
		int count = schoolMapper.deleteByuuid(uuid);
		
		return count;
	}

	public boolean add(SchoolEnv schoolEnv) throws Exception {
		
		return schoolMapper.add(schoolEnv);
	}

	@Override
	public List<SchoolEnv> getSchoolEnv() {
		
		return schoolMapper.getSchoolEnv();
	}

	

	

}
