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
 *  删除投票
 */
@WebServlet("/DeleteVoteServlet")
public class DeleteVoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");


        String id = req.getParameter("id");
        if(VoteUtils.deleteVote(Integer.parseInt(id))) {
            req.getRequestDispatcher("MyIndexServlet").forward(req,resp);
        }
    }
}