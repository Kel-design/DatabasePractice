package com.cupitmadland.glabmappingschool;

import com.cupitmadland.glabmappingschool.util.GenerateDataUtil;

public class App {
	public static void main(String[] args) {
		GenerateDataUtil obj = new GenerateDataUtil();
		obj.createDataManyToOne();
		//GenerateDataUtil.createDataOneToMany();
		//GenerateDataUtil.createDataOneToOne();
		GenerateDataUtil.createDataManyToMany();

	}
}
