package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    private String studentName;
    private String studentID;
    private int yearOfBirth;
    private boolean status;

    private static final String studentID_regX = "^5([6-9]?)061([0-2]?)([0-9]{3})$";

    public Student()
    {
        // implement here
        studentName = "John Doe";
        studentID = "560610000";
        yearOfBirth = 1990;
        status = false;
    }
    // implement all missing constructors here

    public Student(String name, String id)
    {
        studentName = name;
        if(isValidStudent_id(id))
        {
            studentID = id;
        }
        else
        {
            studentID = "560610000";
        }
        yearOfBirth = 1990;
        status = false;
    }

    public Student(String name, String id, int year)
    {
        studentName = name;
        if(isValidStudent_id(id))
        {
            studentID = id;
        }
        else
        {
            studentID = "560610000";
        }
        if(isValidYOB(year))
        {
            yearOfBirth = year;
        }
        else
        {
            yearOfBirth = 1990;
        }
        status = false;
    }

    public Student(String name, String id, int year, boolean stat)
    {
        studentName = name;
        if(isValidStudent_id(id))
        {
            studentID = id;
        }
        else
        {
            studentID = "560610000";
        }
        if(isValidYOB(year))
        {
            yearOfBirth = year;
        }
        else
        {
            yearOfBirth = 1990;
        }
        status = stat;
    }

    // implement all get and set methods here

    public String getName()
    {
        return studentName;
    }

    public void setName(String name)
    {
        if(name.equalsIgnoreCase(""))
        {
            return;
        }
        studentName = name;
    }

    public String getStudent_id()
    {
        return studentID;
    }

    public void setStudent_id(String id)
    {
        if(id.equalsIgnoreCase(""))
        {
            return;
        }
        if(!isValidStudent_id(id))
        {
            return;
        }
        studentID = id;
    }

    public int getYearOfBirth()
    {
        return yearOfBirth;
    }
    public void setYearOfBirth(int year)
    {
        if(!isValidYOB(year))
        {
            return;
        }
        yearOfBirth = year;
    }

    public boolean getStatus()
    {
        return status;
    }
    public boolean isActive()
    {
        return (status = true);
    }

    @Override
    public String toString()
    {
        String o = studentName + " (" + studentID + ") was born in " + yearOfBirth + " and is ";
        if(isActive())
        {
            o = o + "active";
        }
        else
        {
            o = o + "inactive";
        }
        o = o + " student.";
        return o;
    }

    private boolean isValidStudent_id(String id)
    {
        Pattern p = Pattern.compile(studentID_regX);
        Matcher m = p.matcher(id);
        if(!m.find())
        {
            return false;
        }
        return true;
    }

    private boolean isValidYOB(int yob)
    {
        if(yob < 1990)
        {
            return false;
        }
        return true;
    }


}
