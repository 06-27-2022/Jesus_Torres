package com.business.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.business.model.reimbursementticket;
import com.business.util.connectionUtil;

public class reimbursementticketRepositoryImpl implements reimbursementticketRepository{

	@Override
	public List<reimbursementticket> findAllRT() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		List<reimbursementticket> alltickets= new ArrayList<>();
		
		final String SQL = "select * from reimbTickets";
		
		try {
			conn = connectionUtil.getNewConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			while(set.next()) {
				reimbursementticket ticket = new reimbursementticket(
						set.getInt(1),
						set.getDouble(2),
						set.getString(3),
						set.getString(4));
				alltickets.add(ticket);
										
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return alltickets;
	}

	@Override
	public void newTicket(reimbursementticket ticket) {
		Connection conn = null;
		
		PreparedStatement stmt = null;
		
		final String SQL = "insert into reimbTickets values(default, ?, ? , 'PENDING')";
		
		try {
			conn =connectionUtil.getNewConnection();
			stmt = conn.prepareStatement(SQL);
			
			stmt.setDouble(1,ticket.getAmmount());
			stmt.setString(2, ticket.getDescription());
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<reimbursementticket> findAllPendignRT() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		List<reimbursementticket> allpendingtickets= new ArrayList<>();
		
		final String SQL = "select * from reimbTickets where approvalstatus = 'PENDING'";
		
		try {
			conn = connectionUtil.getNewConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			while(set.next()) {
				reimbursementticket ticket = new reimbursementticket(
						set.getInt(1),
						set.getDouble(2),
						set.getString(3),
						set.getString(4));
				allpendingtickets.add(ticket);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return allpendingtickets;
	}

	@Override
	public reimbursementticket findbyticketID(int id) {
		reimbursementticket ticketSearch = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from reimbTickets where id = ?";
		
		try {
			conn=connectionUtil.getNewConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, id);
			set = stmt.executeQuery();
			
			if(set.next()) {
				ticketSearch = new reimbursementticket(
						set.getInt(1),
						set.getDouble(2),
						set.getString(3),
						set.getString(4));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return ticketSearch;
	}

	@Override
	public void editTicketstatusbyId(int id, String approvalstatus) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "update reimbTickets set approvalstatus = ? where id = ?";
		
		try {
			conn=connectionUtil.getNewConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1,approvalstatus);
			stmt.setInt(2, id);
			stmt.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
