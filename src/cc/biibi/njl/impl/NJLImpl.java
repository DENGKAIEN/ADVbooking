package cc.biibi.njl.impl;

import java.util.List;

import cc.biibi.njl.dao.CustomersDAO;
import cc.biibi.njl.dao.DAO;
import cc.biibi.njl.setget.Customers;

public class NJLImpl extends DAO<Customers> implements CustomersDAO {

	//д�����ݿ�
	@Override
	public void save(Customers customers) {
		
		String sql = "INSERT INTO customer(wechatid,name,mobile,startdate,enddate,orderroom,repast,remarks) VALUES(?,?,?,?,?,?,?,?)";
		update(sql,customers.getWechat(),customers.getUsername(),customers.getMobile(),
				customers.getStartdate(),customers.getEnddate(),customers.getOrderroom(),
				customers.getRepast(),customers.getRemarks());

	}

	//ͨ��΢�źŻ��ֻ��Ż�ȡ��������
	@Override
	public List<Customers> getAll(String wechat, String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	//ͨ��΢�źŻ��ֻ��Ÿ��´�������
	@Override
	public List<Customers> setAll(String wechat, String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	//ͨ��΢�źŻ��ֻ���ɾ����������
	@Override
	public void del(String wechat, String mobile) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean IsMobile(String mobile) {
		// TODO Auto-generated method stub
		System.out.println("����ֻ����ǣ�"+mobile);
		return false;
	}

}
