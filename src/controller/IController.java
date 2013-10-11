package controller;

import model.IModel;

public interface IController {
	IModel getModel();
	void setModel(IModel model)throws IllegalArgumentException;
	
	public void addSecond();
	public int getSeconds();
	public void setSecond(int sec) throws IllegalArgumentException;
	public int getMinutes();
	public void setMinutes(int min) throws IllegalArgumentException;
	public int getHours();
	public void setHours(int h) throws IllegalArgumentException;
	
	void startTrigger();
	void stopTrigger();
	void reset();
	boolean isTriggerRunning();
}
