package com.techlabs.state.model;

public class StopState implements State{

	@Override
	public void doAction(Context context) {
		// TODO Auto-generated method stub
		System.out.println("Player is in stop state");
		context.setState(this);
	}
	@Override
	public String toString() {
		return "Stop state";
	}
	
}