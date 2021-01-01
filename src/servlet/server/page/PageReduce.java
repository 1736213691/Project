package servlet.server.page;

import utils.VoteUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/PageReduce")
public class PageReduce extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ss = req.getSession();
        Integer num = (Integer)ss.getAttribute("num");
        if(num > 1){
            req.getSession().setAttribute("num", (Integer)ss.getAttribute("num")-1);
        }
        resp.sendRedirect("SearchVoteListServlet");
    }
}