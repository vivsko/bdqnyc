package cn.bdqn.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.entity.EmpStar;

public interface EmpStarMapper {
	
	//��¼��
	public int getCount()throws Exception;
	//��ѯ���� ����id 
	public EmpStar getEmpStarByUuid(@Param("uuid")Integer uuid) throws Exception;
	//��ҳ
	public List<EmpStar> getEmpStarList(@Param("currentPageNo")Integer currentPageNo,@Param("pageSize")Integer pageSize)throws Exception;
	//����
	public int addEmpStar(EmpStar empStar)throws Exception;
	
	public int modifyEmpStar(EmpStar empStar)throws Exception;
	//ɾ��
	public int deleteEmpStarByUuid(@Param(value="uuid")Integer uuid)throws Exception;
}
