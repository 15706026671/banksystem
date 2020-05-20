package com.banksystem.service;

import java.util.List;

import com.banksystem.entity.*;

public interface TransactionService {

	//���ݻ�ȡ���׼�¼
	public List getLogs(Account account,int page);

	//ת��
	public boolean transfer(TransactionLog log);
	
	//���
	public boolean deposit(TransactionLog log);
	
	//ȡ��
	public boolean withdrawal(TransactionLog log);	
	
	//����˻��Ľ��׼�¼����,������ʼ����ҳ��Pager����,��������perPageRows��rowCount����	 
	public Pager getPagerOfLogs(Account account);
	
}