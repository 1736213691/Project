package servlet.server.page;

import bean.Vote;
import utils.VoteUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *  我的主页
 */
@WebServlet("/MyIndexServlet")
public class MyIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取当前页
        HttpSession ss = req.getSession();
        ss.setAttribute("num", 1);
        ss.setAttribute("content", ss.getAttribute("userName"));
        ss.setAttribute("by", "name");
        req.getRequestDispatcher("SearchVoteListServlet").forward(req,resp);
    }
}
