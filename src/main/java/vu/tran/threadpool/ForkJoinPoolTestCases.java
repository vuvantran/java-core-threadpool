package vu.tran.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

import vu.tran.util.ThreadUtil;

public class ForkJoinPoolTestCases {

	public static void commonPoolWithOneTaskTooLong() {
		System.out.println("Number of paralellism of current common pool: " + ForkJoinPool.getCommonPoolParallelism());
		System.out.println("Number of paralellism of current pool: " + ForkJoinPool.commonPool().getPoolSize());

		System.out.println("Submit tasks to ForkJoinPool.CommonPool");
		ForkJoinPool.commonPool().submit(ThreadUtil.getNewCallableTask("CommonPool 1", 25_000));
		ForkJoinPool.commonPool().submit(ThreadUtil.getNewCallableTask("CommonPool 2", 2000));
		ForkJoinPool.commonPool().submit(ThreadUtil.getNewCallableTask("CommonPool 3", 2000));
		ForkJoinPool.commonPool().submit(ThreadUtil.getNewCallableTask("CommonPool 4", 2000));
		ForkJoinPool.commonPool().submit(ThreadUtil.getNewCallableTask("CommonPool 5", 2000));
		ForkJoinPool.commonPool().submit(ThreadUtil.getNewCallableTask("CommonPool 6", 2000));
		ForkJoinPool.commonPool().submit(ThreadUtil.getNewCallableTask("CommonPool 7", 2000));
		ForkJoinPool.commonPool().submit(ThreadUtil.getNewCallableTask("CommonPool 8", 2000));
		ForkJoinPool.commonPool().submit(ThreadUtil.getNewCallableTask("CommonPool 9", 2000));
		ForkJoinPool.commonPool().submit(ThreadUtil.getNewCallableTask("CommonPool 10", 2000));
	}

	public static void definedPoolWithOneTaskTooLong(int size) {
		ForkJoinPool pool = new ForkJoinPool(size);
		System.out.println("Number of paralellism of current pool: " + pool.getParallelism());
		System.out.println("Pool size: " + pool.getPoolSize());

		System.out.println("Submit tasks to defined ForkJoinPool");
		pool.submit(ThreadUtil.getNewCallableTask("ForkJoinPool 1", 25_000));
		pool.submit(ThreadUtil.getNewCallableTask("ForkJoinPool 2", 2000));
		pool.submit(ThreadUtil.getNewCallableTask("ForkJoinPool 3", 2000));
		pool.submit(ThreadUtil.getNewCallableTask("ForkJoinPool 4", 2000));
		pool.submit(ThreadUtil.getNewCallableTask("ForkJoinPool 5", 2000));
		pool.submit(ThreadUtil.getNewCallableTask("ForkJoinPool 6", 2000));
		pool.submit(ThreadUtil.getNewCallableTask("ForkJoinPool 7", 2000));
		pool.submit(ThreadUtil.getNewCallableTask("ForkJoinPool 8", 2000));
		pool.submit(ThreadUtil.getNewCallableTask("ForkJoinPool 9", 2000));
		pool.submit(ThreadUtil.getNewCallableTask("ForkJoinPool 10", 2000));
//		pool.shutdown();
	}

	public static void definedExecutorServicePoolWithTaskTooLong(int size) {
		ExecutorService pool = Executors.newFixedThreadPool(size);

		System.out.println("Submit tasks to ExecutorServicePool");
		pool.submit(ThreadUtil.getNewCallableTask("ExecutorServicePool 1", 25_000));
		pool.submit(ThreadUtil.getNewCallableTask("ExecutorServicePool 2", 2000));
		pool.submit(ThreadUtil.getNewCallableTask("ExecutorServicePool 3", 2000));
		pool.submit(ThreadUtil.getNewCallableTask("ExecutorServicePool 4", 2000));
		pool.submit(ThreadUtil.getNewCallableTask("ExecutorServicePool 5", 2000));
		pool.submit(ThreadUtil.getNewCallableTask("ExecutorServicePool 6", 2000));
		pool.submit(ThreadUtil.getNewCallableTask("ExecutorServicePool 7", 2000));
		pool.submit(ThreadUtil.getNewCallableTask("ExecutorServicePool 8", 2000));
		pool.submit(ThreadUtil.getNewCallableTask("ExecutorServicePool 9", 2000));
		pool.submit(ThreadUtil.getNewCallableTask("ExecutorServicePool 10", 2000));
//		pool.shutdown();
	}
}
