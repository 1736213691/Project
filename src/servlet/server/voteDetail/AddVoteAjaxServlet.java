package servlet.server.voteDetail;

import utils.VoteUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  添加投票
 */
@WebServlet("/AddVoteAjaxServlet")
public class AddVoteAjaxServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("id");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if(content.length()<120 && name != null && title.length() < 16) {
            if(VoteUtils.getUserVotes(name) <=15 && VoteUtils.addVote(title, name, content)){
                out.print("true");
            } else out.print("false");
        } else out.print("false");
        out.flush();
        out.close();
    }
}
