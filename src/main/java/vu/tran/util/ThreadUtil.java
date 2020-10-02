package vu.tran.util;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Callable;

public class ThreadUtil {

	public static Callable getNewCallableTask(String threadPoolName) {
		UUID uuid = UUID.randomUUID();
		return new Callable() {
			public Object call() {
				System.out.println("A new thread of " + threadPoolName + " " + uuid.toString() + " is executed at: "
						+ new Date().toString());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("A new thread of " + threadPoolName + " " + uuid.toString() + " is completed at: "
						+ new Date().toString());
				return null;
			}
		};
	}

	public static Callable getNewCallableTask(String threadPoolName, int sleepTimeInMilisecond) {
		UUID uuid = UUID.randomUUID();
		return new Callable() {
			public Object call() {
				System.out.println("A new thread of " + threadPoolName + " " + uuid.toString() + " is executed at: "
						+ new Date().toString());
				try {
					Thread.sleep(sleepTimeInMilisecond);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("A new thread of " + threadPoolName + " " + uuid.toString() + " is completed at: "
						+ new Date().toString());
				return null;
			}
		};
	}
}
