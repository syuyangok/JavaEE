package dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // step1 get parameters from request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // step2 put parameter value to user object
        User loginuser = new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);

        // step 3 check user info in database
        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        // step 4 check result of database.
        if(user == null){
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else{
            // put user info to request
            request.setAttribute("user", user);
            // jump to new servlet
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }


    }
}
