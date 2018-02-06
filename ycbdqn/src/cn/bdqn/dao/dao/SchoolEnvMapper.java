package cn.bdqn.dao.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.entity.SchoolEnv;

public interface SchoolEnvMapper {
	
	
	//查找所有信息
	public List<SchoolEnv> getAllEnv(@Param("currentPageNo")Integer currentPageNo,
										@Param("pageSize")Integer pageSize);
	
	//查找信息条数
	public Integer count()throws Exception;
	

	//根据uuid删除信息
	public Integer deleteByuuid(@Param("uuid")Integer uuid) throws Exception;
	
	
	//添加信息
	/*public List<SchoolEnv> add(@Param("uuid")Integer uuid,@Param("picPath")String picPath,@Param("createTime")Integer createTime)throws Exception;*/
	public boolean add(SchoolEnv schoolEnv)throws Exception;

	public List<SchoolEnv> getSchoolEnv();
	
}
