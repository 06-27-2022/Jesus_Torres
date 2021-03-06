package com.business.repository;

import java.util.List;

import com.business.model.reimbursementticket;

public interface reimbursementticketRepository {
	List<reimbursementticket> findAllRT();
	
	void newTicket(reimbursementticket ticket);
	
	List<reimbursementticket> findAllPendignRT();
	
	reimbursementticket findbyticketID(int id);
	
	void editTicketstatusbyId(int id, String approvalstatus);
	
}
