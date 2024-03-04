package test.daos;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import test.beans.UserModel;

@Repository
public class TestDao {
	
	private JdbcTemplate jdbcTemplate;

	public TestDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Map<String,Object>> getData(){
		String sql="select sapid,firstName,lastName,emailId,mobile from exam.students limit 10;";
		List<Map<String,Object>> data = jdbcTemplate.queryForList(sql);
		return data;
	}
	
	public UserModel getDataByUsername(String username){
		String sql="SELECT username,password,roles FROM user.usermodel where username=?;";
		return jdbcTemplate.queryForObject(sql, new Object[] {username},new BeanPropertyRowMapper<UserModel>(UserModel.class));
	}

}
