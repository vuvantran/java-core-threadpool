package vu.tran.resource;

import java.util.concurrent.ForkJoinPool;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vu.tran.util.ThreadUtil;

@WebServlet(urlPatterns = "/folkJoinTestServlet/submitNewTask", loadOnStartup = 1)
public class FolkJoinTestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Number of paralellism of current common pool: " + ForkJoinPool.getCommonPoolParallelism());
		ForkJoinPool threadPool = new ForkJoinPool(4);
		System.out.println("Pool running in async mode? " + threadPool.getAsyncMode());
		System.out.println("Pool size: " + threadPool.getPoolSize());

		System.out.println("Submit new task to thread-pool");
		threadPool.submit(ThreadUtil.getNewCallableTask("ForkJoinPool"));
	}

}
