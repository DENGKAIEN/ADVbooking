package cc.biibi.njl.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.biibi.njl.dao.CustomersDAO;
import cc.biibi.njl.impl.NJLImpl;
import cc.biibi.njl.setget.Customers;

/**
 * Servlet implementation class NJLServlet
 */
@WebServlet("*.html")
public class NJLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//��װ�����ö���
	CustomersDAO customersDAO = new NJLImpl();
	
	//Ĭ�Ϸ���
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ô˷���
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();//��ȡServlet·��
		String methodpath = path.substring(1, path.length()-5);//��ȡ��ַ.֮ǰ���ַ����Ҵ��ַ�Ϊservlet�еķ���
		System.out.println(methodpath);
		try{
			//ͨ�������ȡ������                              ���˽�з���
			Method method = getClass().getDeclaredMethod(methodpath,HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);//ͨ��������ñ�������еķ���
						  //����    ����1         ����2
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//д�����ݿⷽ��
	@SuppressWarnings("unused")
	private void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//1. ��ȡ������
		request.setCharacterEncoding("utf-8");//���ñ���
		String wechat = request.getParameter("wechat");
		String username = request.getParameter("username");
		String mobile = request.getParameter("mobile");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String orderroom = request.getParameter("orderroom");
		String repast =request.getParameter("repast");
		String remarks = request.getParameter("remarks");

		
		//2. �ѱ�������װΪһ��Customers����customer
		Customers customers = new Customers(wechat, username, mobile, startdate, 
										   enddate, orderroom, repast, remarks);
		
		//3. ����CustomersDAO �� save(Customer customer) ִ�б������
		customersDAO.save(customers);
		
		//4. �ض���thank.jsp ҳ��
		response.sendRedirect("thank.jsp");
		
		//����ԤԼȷ�϶���
		customersDAO.IsMobile(mobile);
		
	}
}
