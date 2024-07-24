package com.techlabs.state.test;

import com.techlabs.state.model.Context;
import com.techlabs.state.model.StartState;
import com.techlabs.state.model.StopState;

public class StateApplicationTest {

	public static void main(String[] args) {
		
		Context context = new Context();
		StartState startState = new StartState();
		startState.doAction(context);
		System.out.println(context.getState().toString());

		StopState stopState = new StopState();
		stopState.doAction(context);
		System.out.println(context.getState().toString());

	}

}