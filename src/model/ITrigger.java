package model;

public interface ITrigger {
	
	void setIModel(IModel model)throws IllegalArgumentException;
	IModel getModel();
	int getPeriod();
	void setPeriod(int period)throws IllegalArgumentException;
	
	void startTrigger();
	void stopTrigger();
	boolean isRunning();
}
