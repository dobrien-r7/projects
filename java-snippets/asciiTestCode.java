/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.Exception;
import java.io.*;
import org.jmock.Mockery;
import org.jmock.Expectations;

/* Name of the class has to be "Main" only if the class is public. */
public class asciiTestCode
{
    public static void main (String[] args) throws java.lang.Exception
	{

        String words = "Hi There"; //creating a string var named 'words'
        char index = words.charAt(0);
        System.out.println(index);


        String wwords = "2"; 
        char iindex = wwords.charAt(0);
        System.out.println(iindex);

        //ResultSet rs 
		Mockery mockery = new Mockery();
		final ResultSet resultSet = mockery.mock(ResultSet.class);
		
		mockery.checking(new Expectations() {{
		    allowing(resultSet).getString(status); will(returnValue("my first string"));
		    allowing(resultSet).getString(2); will(returnValue("my second string"));
		}});
		
		// resultSet is now a java.sql.ResultSet object, which you can pass to your legacy code
		resultSet.getString(1);
    }
}