package com.cupitmadland.theschool;

import com.cupitmadland.theschool.util.GenerateDataUtil;


public class App 
{
    public static void main( String[] args )
    {
       GenerateDataUtil obj = new GenerateDataUtil();  
       obj.createDataManyToOne();
       
       //GenerateDataUtil.createDataOneToMany();
       //GenerateDataUtil.createDataOneToOne();
       GenerateDataUtil.createDataManyToMany();
    	
    //GenerateDataUtil.createDataManyToOne(); (if GenerateDataUtil was static you could just invoke it w/o create an instance
    }
}
