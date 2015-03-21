package info.mabin.wce.componentexam1;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import info.mabin.wce.manager.Logger;
import info.mabin.wce.manager.eventlistener.EventListenerConfigurationImpl;

public class EventListenerConfiguration implements EventListenerConfigurationImpl{
	private Logger logger;
	private Component component = Component.getInstance();

	public EventListenerConfiguration() {
		try {
			logger = Logger.getInstance(this.getClass());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void eventChangedConfiguration(NodeList configuration) {
		logger.i("Configuration Changed!");
		
		String testString = "";
		
		for(int i = 0; i < configuration.getLength(); i++){
			Node tmpNode = configuration.item(i);
			
			if(tmpNode.getNodeName().equals("TestString")){
				testString = tmpNode.getTextContent();
			}
		}
		
		logger.i("Changed TestString is '" + testString + "'");
		component.setTestString(testString);
	}
}
