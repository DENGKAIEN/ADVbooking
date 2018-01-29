/*
 * ���ݿ����ɾ�Ĳ�
 * */

package cc.biibi.njl.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cc.biibi.njl.db.JdbcUtils;

public class DAO<T> {

	//��ҪDBUtils��jar��
	private QueryRunner queryRunner = new QueryRunner();//QueryRunner���ṩ��sql��������API
	
	private Class<T> clazz;
	
	public DAO() {
			
		//�������͵Ĺ����߼��ӿ�(Type)
		Type superClass = getClass().getGenericSuperclass();//��ô��з��͵ĸ���
						  //����ʱ��       
		
		if(superClass instanceof ParameterizedType){//instanceof:ǰһ���Ǻ�һ����ʵ��
			
			//��ó���ķ��Ͳ�����ʵ������
			ParameterizedType parameterizedType = (ParameterizedType)superClass;
				
			Type [] typeArgs = parameterizedType.getActualTypeArguments();
												 //���ر�ʾ������ʵ�����Ͳ����� Type ���������
			
			if(typeArgs != null && typeArgs.length > 0){
				if(typeArgs[0] instanceof Class){
					clazz = (Class<T>) typeArgs[0];
						
				}
			}
		}
	}
	
	//����T��Ӧ��List
	public List<T> getForList(String sql,Object ...args){
		
		Connection connection = null;
		try{
			connection  = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql,new BeanListHandler<>(clazz),args);
														
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
		
		return null;
	}
	
	//��ɾ��
	public void update(String sql,Object ... args){
		
		Connection connection = null;
		
		try{
			connection = JdbcUtils.getConnection();
			queryRunner.update(connection, sql, args);//���ݿ� INSERT DELETE UPDATE ����
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtils.releaseConnection(connection);//���ݿ�ر�
		}
	}
}
