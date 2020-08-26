package vu.tran.resource;

import java.util.concurrent.ExecutorService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vu.tran.threadpool.SingletonPool;
import vu.tran.util.ThreadUtil;

@WebServlet(urlPatterns = "/singletonTestServlet/submitNewTask", loadOnStartup = 1)
public class SingletonTestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        ExecutorService threadPool = SingletonPool.getInstance().getBackgroundTasks();
        System.out.println("Thread-pool is already shutdown? " + threadPool.isShutdown());
        System.out.println("Submit new task to thread-pool");
        threadPool.submit(ThreadUtil.getNewCallableTask(SingletonPool.THREAD_POOL_ATTRIBUTE_NAME));
    }

}
