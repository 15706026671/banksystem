package com.banksystem.service;

import java.util.List;

import com.banksystem.entity.*;


public interface PersoninfoService {
	//�޸ĸ�����Ϣ
	public boolean modifyPersoninfo(Personinfo personinfo);
	
	//��Ӹ�����Ϣ
	public boolean add(Personinfo personinfo);

	//��ȡȫ��������Ϣ
	public List getAllPersoninfo();
	
	//����������ѯ������Ϣ
	public List searchPersoninfo(Personinfo personinfo);
	
	//�����˻�״̬��ȡ������Ϣ
	public List searchPersoninfo(Status status);
}
