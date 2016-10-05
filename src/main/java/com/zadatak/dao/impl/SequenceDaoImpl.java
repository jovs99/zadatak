package com.zadatak.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.zadatak.dao.SequenceDao;
import com.zadatak.model.Sequence;

public class SequenceDaoImpl implements SequenceDao{

	DataSource dataSource ;

	public DataSource getDataSource(){
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	@Override
	public void addNewSequence(Sequence sequence) throws SQLException {
		// TODO Auto-generated method stub
		String sqlQuery = "INSERT INTO sequence (submitted_by, purpose, date_created)"
                + " VALUES (?, ?, ?)";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(sqlQuery);
		pstmt.setString(1, sequence.getSubmittedBy());
		pstmt.setString(2, sequence.getPurpose());
		pstmt.setString(3, sequence.getDate());
		int valuesUpdated = pstmt.executeUpdate();
		
//		jdbcTemplate.update(sql, sequence.getSubmittedby(), sequence.getPurpose(),
//				sequence.getDate());
		
	}

	@Override
	public void deleteSequence(int sequenceId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sequence getSequenceId(int sequenceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sequence> listOfSequences() throws SQLException {
		// TODO Auto-generated method stub
		String sqlQuery = "SELECT * FROM sequence";

		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(sqlQuery);
		ResultSet resultSet = pstmt.executeQuery();
		List<Sequence> sequenceList = new ArrayList<Sequence>();

		while(resultSet.next()){
			Sequence seq = new Sequence();
        	seq.setId(resultSet.getInt("seqId"));
        	seq.setSubmittedBy(resultSet.getString("submitted_by"));
        	seq.setPurpose(resultSet.getString("purpose"));
        	seq.setDate(resultSet.getString("date_created"));
        	sequenceList.add(seq);
		}
		
	    return sequenceList;
	}

	@Override
	public List<Sequence> listOfFoundedSequences(String searchValue) throws SQLException {
		// TODO Auto-generated method stub
		String sqlQuery = "SELECT * FROM sequence WHERE purpose LIKE '%"+searchValue+"%'";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(sqlQuery);
		ResultSet resultSet = pstmt.executeQuery();
		List<Sequence> sequenceList = new ArrayList<Sequence>();
		
		while(resultSet.next()){
			Sequence seq = new Sequence();
        	seq.setId(resultSet.getInt("seqId"));
        	seq.setSubmittedBy(resultSet.getString("submitted_by"));
        	seq.setPurpose(resultSet.getString("purpose"));
        	seq.setDate(resultSet.getString("date_created"));
        	sequenceList.add(seq);
		}
		
	    return sequenceList;
	}

}
