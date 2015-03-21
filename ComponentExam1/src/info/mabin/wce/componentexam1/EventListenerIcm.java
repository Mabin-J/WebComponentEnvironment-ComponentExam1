package info.mabin.wce.componentexam1;

import java.util.Set;

import info.mabin.wce.componentexam1.servlet.SampleServlet;
import info.mabin.wce.componentexam2.icm.IcmExam1;
import info.mabin.wce.manager.Logger;
import info.mabin.wce.manager.eventlistener.EventListenerIcmImpl;
import info.mabin.wce.manager.exception.IcmNotRegisteredException;

public class EventListenerIcm implements EventListenerIcmImpl{
	private Logger logger;
	
	public EventListenerIcm() {
		try {
			logger = Logger.getInstance(this.getClass());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void eventRegisteredIcm(String canonicalName) {
		logger.d("IcmCanonicalName: " + canonicalName);
		if(canonicalName.equals("info.mabin.wce.componentexam2.icm.IcmExam1")){
			logger.i("IcmExam1 of Exam2 is Registered");
			
			try {
				IcmExam1 icmExam1 = new IcmExam1();
				SampleServlet.setExam2Icm1(icmExam1);
			} catch (IcmNotRegisteredException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

	@Override
	public void eventRegisteredIcm(Set<String> setCanonicalName) {
		for(String canonicalName: setCanonicalName){
			this.eventRegisteredIcm(canonicalName);
		}
	}

	@Override
	public void eventUnregisteredIcm(String canonicalName) {
		if(canonicalName.equals("info.mabin.wce.componentexam2.icm.IcmExam1")){
			SampleServlet.removeExam2Icm1();
			logger.i("IcmExam1 of Exam2 is Unregistered");
		}
	}
}
