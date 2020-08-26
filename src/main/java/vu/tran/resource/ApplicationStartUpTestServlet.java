package vu.tran.resource;

import java.util.concurrent.ExecutorService;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vu.tran.threadpool.ApplicationStartUpListener;
import vu.tran.util.ThreadUtil;

@WebServlet(urlPatterns = "/applicationStartUpListener/submitNewTask", loadOnStartup = 1)
public class ApplicationStartUpTestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        ServletContext ctx = request.getServletContext();

        ExecutorService threadPool = (ExecutorService) ctx.getAttribute(ApplicationStartUpListener.THREAD_POOL_ATTRIBUTE_NAME);
        System.out.println("Thread-pool is already shutdown? " + threadPool.isShutdown());
        System.out.println("Submit new task to thread-pool");
        threadPool.submit(ThreadUtil.getNewCallableTask(ApplicationStartUpListener.THREAD_POOL_ATTRIBUTE_NAME));
    }

}
