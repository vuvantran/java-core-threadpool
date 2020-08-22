package com.memorynotfound.resource;

import com.memorynotfound.ApplicationStartUpListener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

@WebServlet(name = "OrderServlet", value = "/order")
public class OrderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        ServletContext ctx = request.getServletContext();

        ExecutorService threadPool = (ExecutorService) ctx.getAttribute(ApplicationStartUpListener.THREAD_POOL_ATTRIBUTE_NAME);
        System.out.println("Thread-pool is already shutdown? " + threadPool.isShutdown());
        threadPool.submit(this.getNewCallableTask());
    }

    private Callable getNewCallableTask() {
        return new Callable() {
            public Object call() {
                System.out.println("The order is executed at" + new Date().toString());
                return null;
            }
        };
    }

}
