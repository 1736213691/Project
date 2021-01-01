package servlet.init;

import utils.UserUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        String id = req.getParameter("userId");
        String password = req.getParameter("userPass");

        if(UserUtils.register(id, password)){
            out.println("<h1>" + "注册成功，正在返回登录页面......" + "</h1>");
            resp.sendRedirect("login.html");
        } else {
            out.println("注册失败，可能原因是<br>");
            out.println("1.账号已存在");
        }

        out.close();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}