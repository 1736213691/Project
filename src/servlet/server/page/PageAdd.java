package servlet.server.page;

import servlet.server.SearchVoteListServlet;
import utils.VoteUtils;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/PageAdd")
public class PageAdd extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ss = req.getSession();
        Integer num = (Integer)ss.getAttribute("num");
        String content = (String)ss.getAttribute("content");
        String by = (String)ss.getAttribute("by");
        Integer maxN = VoteUtils.getVotesNum(content, by)-1;;
        if(num < maxN/(Integer)getServletContext().getAttribute("votePageNum")+1){
            req.getSession().setAttribute("num", (Integer)ss.getAttribute("num")+1);
        }
        resp.sendRedirect("SearchVoteListServlet");
    }
}