package com.banksystem.action;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.banksystem.entity.*;
import com.banksystem.service.*;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements RequestAware,
		SessionAware {
	
	//����ͨ��@Resourceע��ע�������userService����ʡ��set����
	@Resource private UserService userService;
	
	//����ͨ��@Resourceע��ע�������personinfoService����ʡ��set����	
	@Resource private PersoninfoService personinfoService;
	
	Map<String, Object> request;
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
	
	Map<String, Object> session;
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	//����Admin���Ͷ������ڷ�װ����Ա��¼��ҳ��ı�������
	private Admin admin;		
	private Account account;	
	//����Personinfo���Ͷ������ڷ�װҳ���������
	private Personinfo personinfo;
	private Password pwd;
	//������װ��"����"��"����"��"ɾ��"��ť�������Ĳ���
	private int id;
	private Status status;	
	
	
	/**
	 * �Ե�¼ҳ�������֤������û����������Ƿ���ȷ
	 */
	public void validateLogin(){
		//����ҵ�񷽷�������username��ȡ����Ա
		Admin a=userService.getAdmin(admin.getUsername());
		if(a==null){
			this.addFieldError("username", "�û���������");
		}else{
			if(!admin.getPassword().equals(a.getPassword())){
				this.addFieldError("password", "���벻��ȷ");
			}
			admin=a;
		}
	}	
	/**
	 * ��¼
	 * @return
	 */
	public String login(){
		
		if(admin!=null){
			session.put("admin",admin);
			return "success";
		}
		return "login";
	}
	
	/**
	 * ��ѯ�˻�
	 * @return
	 */
	public String listUsers(){
		//����ҵ�񷽷��������˻�״̬��ȡ������Ϣ��״̬Ϊ0��ʾ��ȡ���пͻ�
		List users=personinfoService.searchPersoninfo(status);
		request.put("users",users);
		return "users";
		
	}
	
	//ע��
	public String logout(){
		session.remove("admin");
		return "login";
	}
	
	/**
	 * �Կ���ҳ�����У�飬��֤�û����Ƿ��Ѵ��ڡ�һ������ֻ֤��ӵ��һ���˻�
	 */
	public void validateKaihu(){
		if(userService.getAccount(account.getUsername())!=null){
			request.put("message", "�û����Ѵ���");
		}
		//��ȡ���������ĸ�����Ϣ�����������Ϊ����ҳ������д������֤��
		List list = personinfoService.searchPersoninfo(personinfo);
		//�������д������֤���ڸ�����Ϣ���Ѵ��ڣ�����ʾ������Ϣ
		if(list.size()>0){
			this.addFieldError("personinfo.cardid", "һ������ֻ֤��ӵ��һ���˻�");
		}		
	}	
	//����
	public String kaihu(){
	    //����ҵ�񷽷������˻���Account�������˻�
		userService.addAccount(account);
		//����ҵ�񷽷����������Ϣ��personinfo���Ӹ�����Ϣ
		account = userService.getAccount(account.getUsername());
		personinfo.setAccount(account);
		personinfoService.add(personinfo);
		request.put("message", "���ӳɹ�");
		return "message";		
	}
	
	/**
	 * ���޸�����ҳ�������֤
	 */
	public void validateChangepwd(){
		admin=(Admin)session.get("admin");
		if(!pwd.getOldpwd().equals(admin.getPassword())){
			this.addFieldError("pwd.oldpwd", "���벻��ȷ");
		}
		if(!pwd.getNewpwd().equals(pwd.getConfirmpwd())){
			this.addFieldError("pwd.confirmpwd", "�������벻һ��");
		}
	}	
	//�޸�����
	public String changepwd(){
		admin.setPassword(pwd.getNewpwd());
		if(userService.modifyAdmin(admin)){
			session.put("admin",admin);
			request.put("message", "�����޸ĳɹ���");
			return "message";
		}
		request.put("message", "�����޸�ʧ�ܣ�");
		return "message";
	}
	
	/**
	 * ɾ���˻�
	 */	
	public String del(){
		//����ҵ�񷽷���ɾ���˻���ͬʱ���м���ɾ��
		userService.delAccount(id);
		return "list";
	}
	/**
	 * ��ѯ�˻�
	 */	
	public String search(){
		List users=personinfoService.searchPersoninfo(personinfo);
		request.put("users",users);
		return "users";
	}
	/**
	 * �����˻�
	 * @return
	 */
	public String enabled(){
		userService.enabled(id);
		return "list";
	}
	/**
	 * �����˻�
	 * @return
	 */
	public String locking(){
		userService.locking(id);
		return "list";
	}	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Personinfo getPersoninfo() {
		return personinfo;
	}
	public void setPersoninfo(Personinfo personinfo) {
		this.personinfo = personinfo;
	}
	public Password getPwd() {
		return pwd;
	}
	public void setPwd(Password pwd) {
		this.pwd = pwd;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	

}