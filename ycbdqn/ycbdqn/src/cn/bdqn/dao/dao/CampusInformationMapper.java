package cn.bdqn.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.entity.CampusInformation;

public interface CampusInformationMapper {
	//��ѯ��¼����
	public int getCount();
	//����id��ѯ��ѯ
	public CampusInformation getCampusInformationById(@Param("uuid")Integer uuid);
	//��ҳ��ʾ��ѯ
	public List<CampusInformation> getCampusInformationList(@Param("currentPageNo")Integer currentPageNo,@Param("pageSize")Integer pageSize);

	public int deleteCampusInformationById(@Param("uuid")Integer uuid);
	
	public int addCampusInformation(CampusInformation campusInformation);
}
