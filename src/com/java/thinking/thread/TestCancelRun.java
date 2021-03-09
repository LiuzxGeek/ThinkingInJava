package com.java.thinking.thread;

import java.util.Timer;
import java.util.TimerTask;

/*
*@author:liuxian
*@date:2018年5月14日
*/
public class TestCancelRun {
	private static Timer timer = new Timer();
	private static TimerTask timerTask = new TimerTask() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("timerTask" + System.currentTimeMillis());
			timer.cancel();
		}
	};

	public static void main(String[] args) {
		run();
	}

	public static void run() {
		timer.schedule(timerTask, 300);
	}

}
