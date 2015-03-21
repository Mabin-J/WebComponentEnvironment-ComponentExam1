package info.mabin.wce.componentexam1;

import java.util.List;

import info.mabin.wce.manager.Logger;
import info.mabin.wce.manager.ComponentAbstract.ComponentManifest;
import info.mabin.wce.manager.eventlistener.EventListenerComponentImpl;

public class EventListenerComponent implements EventListenerComponentImpl{
	private Logger logger;
	
	public EventListenerComponent() {
		try {
			logger = Logger.getInstance(this.getClass());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void eventRegisteredComponent(ComponentManifest manifest) {
		if(manifest.getPackageName().equals("info.mabin.wce.componentexam2")){
			logger.i("Exam2 Component is Registered!");
			logger.i("Exam2 Component's Version is " + manifest.getVersionName());
		}
	}

	@Override
	public void eventRegisteredComponent(List<ComponentManifest> listManifest) {
		for(ComponentManifest manifest: listManifest){
			this.eventRegisteredComponent(manifest);
		}
	}

	@Override
	public void eventUnregisteredComponent(ComponentManifest manifest) {
		if(manifest.getPackageName() == "info.mabin.wce.componentexam2"){
			logger.i("Exam2 Component is Registered!");
		}
	}

}
