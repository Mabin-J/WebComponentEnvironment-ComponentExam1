package info.mabin.wce.componentexam1.icm;

import info.mabin.wce.componentexam1.Component;
import info.mabin.wce.componentexam1.icm.IcmExam1Impl;

public class IcmExam1 implements IcmExam1Impl{

	@Override
	public int sum(int param1, int param2) {
		return param1 + param2;
	}

	@Override
	public String getVersionName() {
		return Component.getInstance().getManifest().getVersionName();
	}

	@Override
	public Long getVersionCode() {
		return Component.getInstance().getManifest().getVersionCode();
	}
}
