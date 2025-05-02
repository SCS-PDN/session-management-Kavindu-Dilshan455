package srcmainjava;

public class course {
    
   
        private String courseId;
        private String courseName;
        private String instructor;
    
       
        public course(String courseId, String courseName, String instructor) {
            this.courseId = courseId;
            this.courseName = courseName;
            this.instructor = instructor;
        }
    
       
        public String getCourseId() { return courseId; }
        public String getCourseName() { return courseName; }
        public String getInstructor() { return instructor; }
    
}
