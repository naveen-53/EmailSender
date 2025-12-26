package com.example.email.repo;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.email.model.EmailModel;

@Repository
public class EmailRepo {
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	
	private RowMapper<EmailModel> mapper = new RowMapper<>() {
		@Override
		public EmailModel mapRow(ResultSet rs,int row) throws SQLException{
			EmailModel em = new EmailModel();
			em.setId(rs.getInt("id"));
			em.setMailId(rs.getString("mail"));
			return em;
			
		}
	};
	
	public List<String> findAllEmail() {
        return jdbcTemplate.queryForList("SELECT email FROM email_table", String.class);
        
    }


}
