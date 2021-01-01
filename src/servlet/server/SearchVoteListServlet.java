package servlet.server;

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
import java.util.zip.Inflater;

@WebServlet("/SearchVoteListServlet")
public class SearchVoteListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取当前页
        HttpSession ss = req.getSession();
        Integer n = (Integer)ss.getAttribute("num");
        String content = (String)ss.getAttribute("content");
        String by = (String)ss.getAttribute("by");
        Integer pageNum = (Integer) getServletContext().getAttribute("votePageNum");
        if(content == null){
            return ;
        }
        Integer maxN = VoteUtils.getVotesNum(content, by);

        req.setAttribute("voteList", VoteUtils.searchVoteList(content , by, n, pageNum));
        //获取最大页号
        req.setAttribute("maxNum", (maxN-1)/pageNum+1);
        req.setAttribute("num", n);
        req.getRequestDispatcher("applicat/voteList.jsp").forward(req,resp);
    }
}
