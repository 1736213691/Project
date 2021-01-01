package servlet.server.voteDetail;

import bean.Vote;
import utils.UserVoteUtils;
import utils.VoteUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 投票详情
 */
@WebServlet("/VotePageServlet")
public class VotePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("id");
        String voteName = req.getParameter("votename");
        String name = (String)req.getSession().getAttribute("userName");
        req.setAttribute("currentVote", VoteUtils.selectOne(Integer.parseInt(s)));
        req.setAttribute("uservotelist", UserVoteUtils.getList(s));
        if(voteName != null && voteName.equals(name)) {
            req.getRequestDispatcher("applicat/updateVote.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("applicat/vote.jsp").forward(req, resp);
        }
    }
}
