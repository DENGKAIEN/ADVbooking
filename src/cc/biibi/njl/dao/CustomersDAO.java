/*
 * ����һ��dao�ӿ�
 * */

package cc.biibi.njl.dao;

import java.util.List;

import cc.biibi.njl.setget.Customers;

public interface CustomersDAO {

	//ԤԼ����д�����ݿ�
	public void save(Customers customers);
	
	//ͨ��΢�źŻ��ֻ��Ų������ݿ���������
	public List<Customers> getAll(String wechat,String mobile);
	
	//ͨ��΢�źŻ��ֻ��Ÿ������ݿ���������
	public List<Customers> setAll(String wechat,String mobile);
	
	//ͨ��΢�źŻ��ֻ���ɾ�����ݿ���������
	public void del(String wechat,String mobile);
	
	//ͨ���ֻ��Ų������,�����Ͷ���
	public boolean IsMobile(String mobile);

}
