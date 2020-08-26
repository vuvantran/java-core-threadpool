package vu.tran.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {

	private ExecutorService requestThreadPool;
	public static final String THREAD_POOL_ATTRIBUTE_NAME = "RequestListener";

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("---- Initialize servlet request context -----");
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		if (request.getRequestURI().contains("requestTestServlet")) {
			System.out.println("Initialize new thread-pool and use it in request scope");
			requestThreadPool = Executors.newFixedThreadPool(2);

			int proc = Runtime.getRuntime().availableProcessors();
			System.out.println("Numbers of core available in your processor:" + proc);

			// add thread-pool into servlet context
			sre.getServletContext().setAttribute(THREAD_POOL_ATTRIBUTE_NAME, requestThreadPool);
		}
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("---- destroying servlet request context -----");
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		if (request.getRequestURI().contains("requestTestServlet")) {
			sre.getServletContext().removeAttribute(THREAD_POOL_ATTRIBUTE_NAME);
			System.out.println("---- shutting down thread-pool -----");
			requestThreadPool.shutdownNow();
		}
	}

}
