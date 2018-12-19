
package com.whh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**描述：
 * @author 王浩浩
 * @Date 2018年10月15日 下午6:54:05
 */
public class Myservlet extends HttpServlet{

	  public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setCharacterEncoding("GBK");
	        //获取用户名和密码
	        String username = request.getParameter("username");

	        String password = request.getParameter("password");
	        //获取UserDao实例
	        UserDao userDao = new UserDao();

	        User user = userDao.login(username,password);
	        // 判断user是否为空
	        if(user != null){
	        // 转发到LoginSuccess.jsp页面
	        //  getRequestDispatcher()是请求转发
	                request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
	        }else{
	        // 登录失败
	            request.getRequestDispatcher("loginFailed.jsp").forward(request, response);
	                }
	        }

	    public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }


}
