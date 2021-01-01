package servlet.server;

import utils.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdatePassServlet")
public class UpdatePassServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = (String)req.getSession().getAttribute("userName");
        String before = req.getParameter("before");
        String pass = req.getParameter("password");
        PrintWriter out = resp.getWriter();

        if(UserUtils.identify(name, before) > 0) {
            if(UserUtils.updatePass(name, pass)) {
              out.print(1);
            } else out.print(-1);
        } else {
            out.print(-1);
        }
    }
}
