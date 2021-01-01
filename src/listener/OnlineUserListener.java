package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.awt.*;
import java.io.PrintWriter;

@WebListener("在线人数监听器")
public class OnlineUserListener implements HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //获取session域对象
        se.getSession().setAttribute("userName", "游客");
        ServletContext context = se.getSession().getServletContext();
        if(context.getAttribute("onlineNum") == null) {
            //初始化计数变量
            context.setAttribute("onlineNum", 0);
        }

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        ServletContext context = se.getSession().getServletContext();
        if("isLogin".equals(se.getName())) {
            //如果添加了isLogin属性，则表示用户登录，人数加一
            context.setAttribute("onlineNum", (Integer)context.getAttribute("onlineNum")+1);
        }
    }

    public void attributeRemoved(HttpSessionBindingEvent se){
        ServletContext context = se.getSession().getServletContext();
        if("isLogin".equals(se.getName())) {
            //如果属性被删除，则表示用户登出，人数减一
            context.setAttribute("onlineNum", (Integer)context.getAttribute("onlineNum")-1);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        se.getSession().removeAttribute("isLogin");
    }
}
