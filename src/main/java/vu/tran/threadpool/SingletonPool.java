package vu.tran.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonPool {

	public static final String THREAD_POOL_ATTRIBUTE_NAME = "SingletonPool";

	private static SingletonPool sInstance;
	private ExecutorService threadPool;

	private SingletonPool() {
		this.threadPool = Executors.newFixedThreadPool(3);
	}

	public static SingletonPool getInstance() {
		if (sInstance == null) {

			synchronized (SingletonPool.class) {

				sInstance = new SingletonPool();
			}
			return sInstance;
		}
		return sInstance;
	}

	public ExecutorService getBackgroundTasks() {
		return threadPool;
	}
}
