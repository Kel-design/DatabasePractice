package com.cupitmadland.newstudent;

import com.cupitmadland.newstudent.controller.StudentController;
import com.cupitmadland.newstudent.model.Student;
import com.cupitmadland.newstudent.view.StudentView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Student model = retrieveStudentFromDatabase();
    	StudentView view = new StudentView();
    	
    	StudentController controller = new StudentController(model, view);
    	
    	controller.updateView();
    	
    	model.setName("John");
    	model.setRollnum("20");
    	controller.updateView();
    	
       
    }
    
    private static Student retrieveStudentFromDatabase() {
    	Student stu = new Student();
        stu.setName("Robert");
        stu.setRollnum("10");
        
    	return stu;
    }
    
    
}
