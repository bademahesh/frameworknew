package com.library.common;

public class StepCounter {
	public static int step=0;
	public String stepNumber() {
		step=step+1;
		String nstep=String.format("%02d", step);
		return nstep;
	}
//reset step number
	public void resetStepCount() {
		step=0;
	}
}
