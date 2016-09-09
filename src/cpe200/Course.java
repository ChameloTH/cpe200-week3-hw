package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {

    private static final String courseIDregX = "^[0-9]{6}$";

    private String courseName;
    private String courseID;
    private String lecturer;
    private int maxStudents;
    private int noStudents;

    public Course()
    {
        courseName = "TBA";
        courseID = "000000";
        lecturer = "TBA";
        maxStudents = 30;
        noStudents = 0;
    }

    public Course(String n, String cid) {
        // implement here
        courseName = n;
        courseID = cid;
        lecturer = "TBA";
        maxStudents = 30;
        noStudents = 0;
    }

    public Course(String n, String cid, String l) {
        // implement here
        courseName = n;
        courseID = cid;
        lecturer = l;
        maxStudents = 30;
        noStudents = 0;
    }

    public Course(String n, String cid, String l, int max) {
        courseName = !n.equalsIgnoreCase("")?n:"TBA";
        // implement the rest here
        courseID = cid;
        lecturer = l;
        maxStudents = max;
        noStudents = 0;
    }

    public String getCourse_name() {
        return courseName;
    }

    public void setCourse_name(String course_name)
    {
        if(course_name.equalsIgnoreCase(""))
        {
            return;
        }
        courseName = course_name;
    }

    public String getCourse_id() {
        return courseID;
    }

    public void setCourse_id(String course_id)
    {
        if(course_id.equalsIgnoreCase(""))
        {
            return;
        }
        if(!isValidCourse_id(course_id))
        {
            return;
        }
        courseID = course_id;
    }

    // implement the other get and set methods here
    public String getLecturer() {
        // implement here
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        // implement here
        if(lecturer.equalsIgnoreCase(""))
        {
            return;
        }
        this.lecturer = lecturer;
    }

    public int getMax_students() {
        // implement here
        return maxStudents;
    }

    public void setMax_students(int max_students) {
        // implement here
        if(max_students < 10)
        {
            return;
        }
        maxStudents = max_students;
    }

    public int getNo_students() {
        // implement here
        return noStudents;
    }

    public void setNo_students(int no_students) {
        // implement here
        if(no_students > maxStudents)
        {
            return;
        }
        if(no_students < 0)
        {
            return;
        }
        noStudents = no_students;
    }

    @Override
    public String toString() {
        String o = courseName + " ("
                + courseID + "), Teacher: "
                + this.lecturer + ", has ";

        // implement the rest here
        if(noStudents < 1)
        {
            o = o + "NO student, [maximum: " +maxStudents + "]";
        }
        else if(noStudents == 1)
        {
            o = o + "ONE student, [maximum: " +maxStudents + "]";
        }
        else
        {
            o = o + noStudents + " students, [maximum: " +maxStudents + "]";
        }
        return o;
    }

    private boolean isValidCourse_id(String id) {
        Pattern p = Pattern.compile(courseIDregX);
        Matcher m = p.matcher(id);

        // implement the rest here
        if(!m.find())
        {
            return false;
        }
        return true;
    }
}
