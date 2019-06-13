package action.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import model.User;
import service.Utils;
import service.user.LoginService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setName(username);
        user.setPassword(password);

        ServletContext servletContext = this.getServletContext();

        String pathClass = LoginServlet.class.getResource("/").getPath();
        String rootPath = pathClass.substring(0, pathClass.indexOf("WEB-INF"));
        servletContext.setAttribute("rootPath", rootPath);

        HttpSession session = request.getSession();
        if (!LoginService.checkLogin(user)) {
            session.setAttribute("loginResult", "false");
            session.setAttribute("errorMessage", "用户名或密码错误");
            response.sendRedirect("/");
        } else {
            session.removeAttribute("errorMessage");
            session.setAttribute("loginResult", "true");
            session.setAttribute("username", user.getName());
            session.setAttribute("phase", service.Utils.getPhase());
            servletContext.setAttribute("user", user);
            servletContext.setAttribute("phase", Utils.getPhase());
            response.sendRedirect("/");
        }
    }
}
