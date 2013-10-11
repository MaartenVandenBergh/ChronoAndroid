package model;

import view.IView;

public interface IModel {
	
	public void addView(IView view)throws IllegalArgumentException;
	public void removeView(IView view)throws IllegalArgumentException;
	public void notifyView(int index)throws IllegalArgumentException;
	public void notifyAllViews();
	
	public void addSecond();
	public int getSeconds();
	public void setSecond(int sec) throws IllegalArgumentException;
	public int getMinutes();
	public void setMinutes(int min) throws IllegalArgumentException;
	public int getHours();
	public void setHours(int h) throws IllegalArgumentException;
	void setTrigger(ITrigger trigger) throws IllegalArgumentException;
	ITrigger getTrigger();
	
	void startTrigger();
	void stopTrigger();
	void reset();
	
	void updateFromTrigger();
	public boolean isTriggerRunning();
}
