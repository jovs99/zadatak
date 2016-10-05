package com.zadatak.dao;

import java.sql.SQLException;
import java.util.List;

import com.zadatak.model.Sequence;

public interface SequenceDao {
	
	public void addNewSequence(Sequence sequence) throws SQLException;
    
    public void deleteSequence(int sequenceId);
     
    public Sequence getSequenceId(int sequenceId);
     
    public List<Sequence> listOfSequences() throws SQLException;

	public List<Sequence> listOfFoundedSequences(String searchValue) throws SQLException;
}
