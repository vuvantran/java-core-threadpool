package vu.tran.resource;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vu.tran.threadpool.ForkJoinPoolTestCases;

@WebServlet(urlPatterns = "/folkJoinTestServlet/submitNewTask", loadOnStartup = 1)
public class FolkJoinTestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		int size;
		String testCase = request.getParameter("testcase");
		switch (testCase) {
		case "1":
			ForkJoinPoolTestCases.commonPoolWithOneTaskTooLong();
			break;
		case "2":
			size = Integer.parseInt(request.getParameter("size"));
			ForkJoinPoolTestCases.definedPoolWithOneTaskTooLong(size);
			break;
		case "3":
			size = Integer.parseInt(request.getParameter("size"));
			ForkJoinPoolTestCases.definedExecutorServicePoolWithTaskTooLong(size);
		default:
			break;
		}
	}
}
