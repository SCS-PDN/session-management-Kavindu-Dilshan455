import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import srcmainjava.course;

@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO: Implement enrollment logic
        // 1. Get courseId from URL parameter
        // 2. Get current user's session
        // 3. Add course to enrolled list in session
        // 4. Redirect back to DashboardServlet
        String courseId = request.getParameter("courseId");

        
        List<course> allCourses = (List<course>) request.getAttribute("courses");
        

        HttpSession session = request.getSession();
        List<course> enrolledCourses = (List<course>) session.getAttribute("enrolledCourses");
        if (enrolledCourses == null) {
            enrolledCourses = new ArrayList<>();
        }

       
        if (allCourses != null) {
            for (course course : allCourses) {
                if (course.getCourseId().equals(courseId)) {
                    enrolledCourses.add(course);
                    break;
                }
            }
        }

        
        session.setAttribute("enrolledCourses", enrolledCourses);


        response.sendRedirect("DashboardServlet?msg=Successfully+enrolled+in+course");

    }
}