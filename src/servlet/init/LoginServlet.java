package servlet.init;

import bean.User;
import utils.DBUtils;
import utils.UserUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private String message;

    @Override
    public void init(ServletConfig config) throws ServletException {
        if(config.getServletContext().getAttribute("votePageNum") == null){
            config.getServletContext().setAttribute("votePageNum", 20);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        String id = req.getParameter("userId");
        String password = req.getParameter("userPass");
        int ident = UserUtils.identify(id, password);
        if(ident > 0){

            HttpSession ss = req.getSession();
            //用户首次登录，初始化变量
            if(ss.getAttribute("isLogin") == null){
                //登录状态
                ss.setAttribute("isLogin", true);
                ss.setAttribute("num", 1);
                ss.setAttribute("content", "");
                ss.setAttribute("by", "id");
            }
            ss.setAttribute("userName", id);

            if(ident == 10)
                resp.sendRedirect("/ov/admin/admin.html");
            else resp.sendRedirect("SearchVoteListServlet?num=1");

        } else {
            out.println("登录失败，可能原因是");
            out.println("1.密码不正确");
            out.println("2.账号不存在");

        }
        out.flush();
        out.close();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}