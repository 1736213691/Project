package servlet.init;

import com.fasterxml.jackson.databind.ObjectMapper;
import utils.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/AcountAjaxServlet")
public class AcountAjaxServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = UTF-8");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        String pattern = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(name);

        String msg = null;
        if(!m.matches()) {
            msg = "邮箱不合法";
        } else if(!UserUtils.isExist(name)) {
            msg = "验证通过";
        } else msg = "邮箱已存在";

        ObjectMapper om = new ObjectMapper();
        om.writeValue(out, msg);


        out.flush();
        out.close();
    }
}
