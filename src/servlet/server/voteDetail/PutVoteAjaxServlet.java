package servlet.server.voteDetail;

import utils.UserUtils;
import utils.UserVoteUtils;
import utils.VoteUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/PutVoteAjaxServlet")
public class PutVoteAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        //获取请求页面的投票ID
        Integer id = Integer.parseInt(req.getParameter("id"));
        //用户ID
        String name = (String) req.getSession().getAttribute("userName");
        if(name == null || name.length() < 5) {
            out.print("游客，请登录投票。");
            out.flush();
            out.close();
            return ;
        }
        //判断用户是否投过该票
        if(UserUtils.isVote(name, id.toString())){
            //为该id投票并增加票数
            if(VoteUtils.addVoteCount(id)){
                out.print("投票成功。");
                //记录用户投票时间
                UserVoteUtils.setVote((String) req.getSession().getAttribute("userName"), req.getParameter("id"));
            }
        } else {
            out.print("投票失败，您已投过票。");
        }

        out.flush();
        out.close();
    }
}
