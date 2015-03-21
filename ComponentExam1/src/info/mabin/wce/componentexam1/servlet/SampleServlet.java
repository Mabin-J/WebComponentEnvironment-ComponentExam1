package info.mabin.wce.componentexam1.servlet;

import info.mabin.wce.componentexam1.Component;
import info.mabin.wce.componentexam2.icm.IcmExam1;
import info.mabin.wce.componentexam2.icm.IcmExam1Impl;
import info.mabin.wce.manager.Logger;
import info.mabin.wce.manager.icm.exception.IcmException;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleServlet
 */
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static IcmExam1 icmExam1;
	private Component component = Component.getInstance();
    
	private Logger logger;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleServlet() {
        super();
		try {
			logger = Logger.getInstance(this.getClass());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Sample Servlet 1!!</h1>");
		
		out.println("TestString in Configuration is '" + component.getTestString() + "'<br>\n");
		
		if(icmExam1 != null){
			try {
				out.println("ComponentExam2's Version: " + icmExam1.getVersionName() + "<br>\n");
				out.println("ComponentExam2's SumResult (123+321): " + icmExam1.sum(123, 321));
			} catch (IcmException e) {
				e.printStackTrace();
			}
		} else {
			out.println("ComponentExam2 is not Registered");
		}
		
		logger.d("SampleServlet Requested");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public static void setExam2Icm1(IcmExam1 icm){
		icmExam1 = icm;
	}
	
	public static void removeExam2Icm1(){
		icmExam1 = null;
	}
}
