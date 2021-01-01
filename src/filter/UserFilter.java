package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@WebFilter(
        description = "未登录拦截",displayName = "UserFilter",filterName = "UserFilter",
        dispatcherTypes = {DispatcherType.REQUEST},
        urlPatterns = {"*.jsp", "/IndexServlet", "/PutVoteAjaxServlet",
                "/SearchVoteListServlet", "/UpdatePassServlet", "/MyIndexServlet",
                "/PageAdd","/PageReduce", "/SearchServlet", "/VotePageServlet"}
)

public class UserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpSession ss = ((HttpServletRequest)servletRequest).getSession();

        if(ss.getAttribute("isLogin") == null) {
            //过滤未登录请求
            HttpServletResponse resp = (HttpServletResponse) servletResponse;
            resp.sendRedirect("login.html");
            return ;
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
