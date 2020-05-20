package org.hotilsframework.web.servlet;

import org.hotilsframework.utils.StringUtils;
import org.hotilsframework.web.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hireny
 * @className DispatcherServlet
 * @create 2020-05-12 9:13
 */
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 7287917540747054239L;

    /**
     * 初始化 Servlet
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {

    }

    /**
     * 执行请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String requestPath = WebUtils.getRequestPath(req);

        // 跳转到首页
        if (StringUtils.equals(requestPath, "/")) {
            // redirect
            resp.sendRedirect(req.getContextPath() + "/" + "index");
            return;
        }
    }

    /**
     * 销毁
     */
    @Override
    public void destroy() {
        super.destroy();
    }
}
