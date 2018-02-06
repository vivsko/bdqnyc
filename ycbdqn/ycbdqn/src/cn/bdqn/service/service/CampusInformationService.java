package cn.bdqn.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.bdqn.entity.CampusInformation;


public interface CampusInformationService {
		//��ѯ��¼����
		public int getCount();
		//����id��ѯ��ѯ
		public CampusInformation getCampusInformationById(Integer uuid);
		//��ҳ��ʾ��ѯ
		public List<CampusInformation> getCampusInformationList(int currentPageNo,int pageSize);
		
		public int deleteCampusInformationById(Integer uuid);

		public int addCampusInformation(CampusInformation campusInformation);
}
