package com.ck.ManagersAssignment.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Worker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstname;
	private String lastname;
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(
			name = "emp_relation",
			joinColumns = @JoinColumn(name = "employee_id"),
			inverseJoinColumns = @JoinColumn (name = "supervisor_id")
			)
	private List<Worker> staff;
	
	@OneToMany (fetch = FetchType.LAZY)
	@JoinTable(
			name = "emp_relation",
			joinColumns = @JoinColumn(name = "supervisor_id"),
			inverseJoinColumns = @JoinColumn(name = "employee_id")
			)
	private List<Worker> staffSupervisor;
	
	
	public List<Worker> getEmployees(){
		return staff;
	}
	
	public List<Worker> getSupervisors(){
		return staffSupervisor;
	}
	
	public void setEmployees(List<Worker> emp) {
		this.staff = emp;
	}
	
	public void setSupervisor(List<Worker> sup) {
		this.staffSupervisor = sup;
	}
	
}