/*
package cc.biibi.njl.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/add.html")
public class NJLFilter extends HttpFilter{
       
	private static final long serialVersionUID = 1L;


	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");//���ñ���
		String username = request.getParameter("username");
		String mobile = request.getParameter("mobile");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		
		String regname = "[^x00-xff]{2,5}+";//ƥ������
		String regmobile = "\\d{11}";//ƥ���ֻ���
		String regstartdate = "\\d{4}-\\d{2}-\\d{2}";
		String regenddate = "\\d{4}-\\d{2}-\\d{2}";
		if(!(username.matches(regname))){
			System.out.println("������������");
		}else if(!(mobile.matches(regmobile))){
			System.out.println("�ֻ�����������");
		}else if(!(startdate.matches(regstartdate))){
			System.out.println("��ʼ������������");
		}else if(!(enddate.matches(regenddate))){
			System.out.println("������������");
		}else{
			System.out.println("����һ��������");
			chain.doFilter(request, response);
		}
		
		
	}

	
	

}
*/