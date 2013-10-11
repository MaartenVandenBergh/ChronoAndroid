package controller;

import model.IModel;

public class Controller implements IController{
	IModel model;

	public Controller(IModel model){
		setModel(model);
	}
	
	@Override
	public void addSecond() {
		this.model.addSecond();
		
	}

	@Override
	public int getSeconds() {
		return this.model.getSeconds();
	}

	@Override
	public void setSecond(int sec) throws IllegalArgumentException {
		this.model.setSecond(sec);
		
	}

	@Override
	public int getMinutes() {
		return this.model.getMinutes();
	}

	@Override
	public void setMinutes(int min) throws IllegalArgumentException {
		this.model.setMinutes(min);
		
	}

	@Override
	public int getHours() {
		return this.model.getHours();
	}

	@Override
	public void setHours(int h) throws IllegalArgumentException {
		this.model.setHours(h);
		
	}

	@Override
	public void startTrigger() {
		this.model.startTrigger();	
	}
	@Override
	public void stopTrigger() {
		this.model.stopTrigger();
	}

	@Override
	public void reset() {
		this.model.reset();
		
	}
	@Override
	public IModel getModel() {
		return this.model;
	}
	@Override
	public void setModel(IModel model) throws IllegalArgumentException {
		if(model != null){
			this.model = model;
		}
		else{
			throw new IllegalArgumentException("Invalid model");
		}
	}

	@Override
	public boolean isTriggerRunning() {
		return this.model.isTriggerRunning();
	}

}
