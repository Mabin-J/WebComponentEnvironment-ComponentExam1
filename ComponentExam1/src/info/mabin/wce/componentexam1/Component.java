package info.mabin.wce.componentexam1;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.w3c.dom.Node;

import info.mabin.wce.manager.ComponentAbstract;
import info.mabin.wce.manager.exception.ComponentException;

public class Component extends ComponentAbstract implements ServletContextListener{
	protected ServletContext contextServlet;
	
	private static Component instance;
	private String testString = "";
	
	public static Component getInstance(){
		return instance;
	}
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		instance = this;
		// ======== Read & Set Servlet
		contextServlet = event.getServletContext();
		
		try {
			loadComponent(contextServlet, this);
		} catch (ComponentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		try {
			unloadComponent();
		} catch (ComponentException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void initComponent() {
		// TODO Auto-generated method stub
		for(int i = 0; i < config.getLength(); i++){
			Node tmpNode = config.item(i);
			
			if(tmpNode.getNodeName().equals("TestString")){
				testString = tmpNode.getTextContent();
			}
		}
	}

	@Override
	protected void destroyComponent() {
		// TODO Auto-generated method stub
	}

	public String getTestString(){
		return testString;
	}
	
	void setTestString(String testString){
		this.testString = testString;
	}
}
