package com.cupitmadland.HibernateJPABeginner;

import com.cupitmadland.HibernateJPABeginner.controller.FindUser_Hql;
import com.cupitmadland.HibernateJPABeginner.controller.UserService;

public class App 
{
    public static void main( String[] args )
    {
      //UserService obj = new UserService();
      //obj.createUserTable();
      
      //obj.createUser();
      
      //obj.findingUser(2);
      
      //obj.updatingUser(3);
      
      //obj.deletingUser(3);
    	
    	FindUser_Hql u = new FindUser_Hql();
    	//u.findUser();
    	//u.findUserSelect();
    	//u.getRecordbyId();
    	//u.getRecords();
    	//u.getmaxSalary();
    	//u.getmaxSalaryGroupBy();
    	u.NamedQueryExample();
    }
}
