import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import srcmainjava.course;



@WebServlet("/DashboardServlet")


public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO: Implement dashboard logic
        // 1. Check if user is logged in (session)
        // 2. Create a list of courses (hardcoded)
        // 3. Store courses in request attribute
        // 4. Forward to dashboard.jsp

        List<course> courses = new ArrayList<>();
        courses.add(new course("csc2102", "Web Development", "Prof. saman"));
        courses.add(new course("csc2101", "programming using dbms", "Prof. amalka"));
        courses.add(new course("csc3103", "server side programing", "Prof. isuru"));

        
        request.setAttribute("courses", courses);

       
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }
}