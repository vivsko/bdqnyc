package cn.bdqn.service.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.entity.EmpStar;

public interface EmpStarService {

	public int getCount()throws Exception;
	//��ѯ���� ����id 
	public EmpStar getEmpStarByUuid(@Param("uuid")Integer uuid) throws Exception;
	//��ҳ
	public List<EmpStar> getEmpStarList(@Param("currentPageNo")Integer currentPageNo,@Param("pageSize")Integer pageSize)throws Exception;
	//����
	public boolean addEmpStar(EmpStar empStar)throws Exception;
	
	public boolean modifyEmpStar(EmpStar empStar)throws Exception;
	//ɾ��
	public boolean deleteEmpStarByUuid(@Param(value="uuid")Integer uuid)throws Exception;
}
