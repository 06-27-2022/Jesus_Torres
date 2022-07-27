package com.business.model;

public class reimbursementticket {

	private int id;
	
	private double ammount;
	
	private String description;
	
	private String approvalstatus;
	
	public reimbursementticket() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Creates a reimbursement ticket using all fields. Typically for retrieving reimbursement ticket from the database
	 * @param id
	 * @param ammount
	 * @param description
	 * @param approvalstatus
	 */
	public reimbursementticket(int id, double ammount, String description, String approvalstatus) {
		this.id = id;
		this.ammount = ammount;
		this.description = description;
		this.approvalstatus=approvalstatus;
	}
	/**
	 * Takes a given ammount and description to create a reimbursement ticket. Intended for users to created reimbursement
	 * tickets.
	 * @param ammount
	 * @param description
	 */
	public reimbursementticket(double ammount, String description) {
		this.ammount = ammount;
		this.description = description;
		this.approvalstatus = "PENDING";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getAmmount() {
		return ammount;
	}
	public void setAmmount(double ammount) {
		this.ammount=ammount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	public String getApprovalStatus() {
		return approvalstatus;
	}
	public void setApprovalStatus(String approvalstatus) {
		this.approvalstatus=approvalstatus;
	}
}
