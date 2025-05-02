import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO: Implement login logic
        // 1. Get username & password from request
        // 2. Validate credentials (hardcode a few users)
        // 3. If valid:
        //    - Create session
        //    - Store username in cookie
        //    - Redirect to DashboardServlet
        // 4. If invalid, redirect back to login.html

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        
        if (("student1".equals(username) && "pass1".equals(password)) ||
            ("student2".equals(username) && "pass2".equals(password))) {
            
            
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            
            Cookie userCookie = new Cookie("user", username);
            userCookie.setMaxAge(60 * 60 * 24); // 1 day expiry
            response.addCookie(userCookie);

            
            response.sendRedirect("DashboardServlet");
        } else {
            response.sendRedirect("login.html?error=1");
        }
    }
}