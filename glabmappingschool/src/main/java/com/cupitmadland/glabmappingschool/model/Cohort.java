package com.cupitmadland.glabmappingschool.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cohort")
public class Cohort implements Serializable{

	
	private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int cid;
		private String CName;
		private String duration;
		
		public Cohort() {
			
		}

		public Cohort(String cName, String duration) {
			super();
			CName = cName;
			this.duration = duration;
		}

		public int getCid() {
			return cid;
		}

		public void setCid(int cid) {
			this.cid = cid;
		}

		public String getCName() {
			return CName;
		}

		public void setCName(String cName) {
			CName = cName;
		}

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

		@Override
		public String toString() {
			return "Cohort [cid=" + cid + ", CName=" + CName + ", duration=" + duration + "]";
		}
		
		

	

}
