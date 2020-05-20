package com.banksystem.action;

import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.banksystem.entity.*;
import com.banksystem.service.*;
import com.opensymphony.xwork2.ActionSupport;

public class Transaction extends ActionSupport implements RequestAware,
		SessionAware {
	// ʹ��UserService�ӿ��������Բ����set������������ע��
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// ʹ��transactionService�ӿ��������Բ����set������������ע��
	private TransactionService transactionService;

	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	private Map<String, Object> request;

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	private Map<String, Object> session;

	public void setSession(Map<String, Object> session) {
		this.session = session;
		account = (Account) session.get("user");
	}

	// ����Account��������
	private Account account;

	// ����TransactionLog�������get��set���������ڷ�װҳ�������
	private TransactionLog log;

	public TransactionLog getLog() {
		return log;
	}

	public void setLog(TransactionLog log) {
		this.log = log;
	}

	// ��ҳʵ����
	private Pager pager;

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	/**
	 * ��ʾ���׼�¼
	 * 
	 * @return
	 */
	public String list() {
		// ��ȡ����ʾҳҳ��
		int curPage = pager.getCurPage();
		// ���ݴ���ʾҳҳ����˻������ȡ���׼�¼
		List<TransactionLog> logs = transactionService.getLogs(account, curPage);
		// ����˻��Ľ��׼�¼������������ʼ����ҳ��Pager���󣬲�������perPageRows��rowCount����
		pager = transactionService.getPagerOfLogs(account);
		// ����Pager�����еĴ���ʾҳҳ��
		pager.setCurPage(curPage);
		request.put("logs", logs);
		return "success";
	}

	/**
	 * ת��
	 * 
	 * @return
	 */
	public String transfer() {
		// �����Զ��巽��isEnable�ж��˻��Ƿ񶳽�
		if (isEnable()) {
			// ʹ��ִ��isEnable������session�����»�ȡ���˻����󣬸�������Ϣ����log�й������˻��������Ը�ֵ
			log.setAccount(account);
			session.put("user", account);
			// ����ҵ�񷽷�������ת�˷������˷����˻���Accout�е������ڽ�����Ϣ��transaction_log����Ӽ�¼
			return isSuccess(transactionService.transfer(log));
		}
		return "message";
	}

	/***
	 * ���
	 * 
	 * @return
	 */
	public String deposit() {
		// �����Զ��巽��isEnable�ж��˻��Ƿ񶳽�
		if (isEnable()) {
			// ʹ��ִ��isEnable������session�����»�ȡ���˻����󣬸�������Ϣ����log�й������˻��������Ը�ֵ
			log.setAccount(account);
			session.put("user", account);
			// ����ҵ�񷽷��������˻���Accout�е������ڽ�����Ϣ��transaction_log����Ӽ�¼
			return isSuccess(transactionService.deposit(log));
		}
		return "message";
	}

	/**
	 * ȡ��
	 * 
	 * @return
	 */
	public String withdrawal() {
		// //�����Զ��巽��isEnable�ж��˻��Ƿ񶳽�
		if (isEnable()) {
			// ʹ��ִ��isEnable������session�����»�ȡ���˻����󣬸�������Ϣ����log�й������˻��������Ը�ֵ
			log.setAccount(account);
			session.put("user", account);
			// ����ҵ�񷽷��������˻���Accout�е������ڽ�����Ϣ��transaction_log����Ӽ�¼
			return isSuccess(transactionService.withdrawal(log));
		}
		return "message";
	}

	/**
	 * �ж��˻��Ƿ񶳽�
	 * 
	 * @return
	 */
	private boolean isEnable() {
		// ��session�����»�ȡAccount���󣬸ö����ڵ�¼�ɹ�ʱ�ѱ��浽session��
		userService.reflush(account);
		if (account.getStatus().getName().equals("����")) {
			request.put("message", "�Բ��𣡸��˻�Ҳ������,�޷�������ز���<br>");
			return false;
		}
		return true;
	}

	// ����ִ�н������ʾ�����ɹ���ʧ����Ϣ
	private String isSuccess(boolean flag) {
		if (flag) {
			request.put("message", "�����ɹ���");
			return "message";
		}
		request.put("message",
				"����ʧ�ܣ�<a href='javascript:history.go(-1)'>����</a>");
		return "message";

	}

	@Override
	public void validate() {
		super.validate();
	}

	/**
	 * ȡ��ҳ��У�飬�����ж��˻�����Ƿ����
	 */
	public void validateWithdrawal() {
		// �Ƚ�ȡ��ҳ������Ľ�����˻����
		if (log.getTrMoney() > account.getBalance()) {
			this.addFieldError("log.trMoney", "�����˻����㣡");
		}
	}

	/**
	 * ת��ҳ��У�飬�ж��Ƿ�������˻�ת�ˡ������˻��Ƿ���ڼ�ת���˻�����Ƿ����
	 */
	public void validateTransfer() {
		if (log.getOtherid().intValue() == account.getAccountid().intValue()) {
			this.addFieldError("log.otherid", "������ת�˸��Լ���");
		}
		if (userService.getAccount(log.getOtherid()) == null) {
			this.addFieldError("log.otherid", "���˻������ڣ�");
		}
		if (log.getTrMoney() > account.getBalance()) {
			this.addFieldError("log.trMoney", "�����˻����㣡");
		}
	}

	public TransactionService getTransactionService() {
		return transactionService;
	}

	public UserService getUserService() {
		return userService;
	}

}
