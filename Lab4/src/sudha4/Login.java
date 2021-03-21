package sudha4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;

public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        String uname = req.getParameter("uname");
        String pass = req.getParameter("pass");
        String myContextParam = req.getSession().getServletContext().getInitParameter("uname1");
        String myContextParam1 = req.getSession().getServletContext().getInitParameter("pass1");
        if(uname.equals(myContextParam)){
        	if(pass.equals(myContextParam1)) {
	            RequestDispatcher rs = req.getRequestDispatcher("Welcome");
	            rs.forward(req, res);
        	}
        	else {
        		out.println("<h2> Password is incorrect! Kindly Enter with a Correct Password. </h2>");
                RequestDispatcher rs = req.getRequestDispatcher("index.html");
                rs.include(req, res);
        	}
        }
        else
        {
           out.println("<h2> Username is incorrect! Kindly Enter a Correct Username. </h2>");
           RequestDispatcher rs = req.getRequestDispatcher("index.html");
           rs.include(req, res);
        }
    }  
}