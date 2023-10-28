package com.cupitmadland.hibernateuser;

import com.cupitmadland.hibernateuser.controller.HibernateQueryLang;
import com.cupitmadland.hibernateuser.controller.UserService;
import com.cupitmadland.hibernateuser.model.User;

public class App 
{
    public static void main( String[] args )
    {
    	
    	HibernateQueryLang obj = new HibernateQueryLang();
    	//obj.useFromClause();
    	//obj.useOrderByClause();
    	
    	//obj.useMultiSelectExpressionClause();
    	
    	//obj.useGroupByClause();
    	
    	//obj.useNameParameters();
    	
    	
    	obj.updateUser();
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
       //UserService obj = new UserService();
       //obj.createUserTable();
       
       //obj.createUser();
       
       //obj.findUser(4);
       
       //obj.updateUser(3);
       
       //obj.deleteUser(3);
       
    }
}
