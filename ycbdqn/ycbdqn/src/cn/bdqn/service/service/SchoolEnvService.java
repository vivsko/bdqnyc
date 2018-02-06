package cn.bdqn.service.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.entity.SchoolEnv;

public interface SchoolEnvService {
	
	
		public List<SchoolEnv> getAllEnv(@Param(value="from")Integer currentPageNo,
									  @Param(value="pageSize")Integer pageSize);

		//查找信息条数
		public Integer count()throws Exception;
		
		
		//根据uuid删除信息
		public Integer deleteByuuid(@Param(value="uuid")Integer uuid) throws Exception;
		
		
		//添加信息
		/*public List<SchoolEnv> add(@Param(value="uuid")Integer uuid,@Param(value="picPath")Integer picPath,@Param(value="createTime")Integer createTime)throws Exception;*/
		public boolean add(SchoolEnv schoolEnv)throws Exception;

		public List<SchoolEnv> getSchoolEnv();
		
}
