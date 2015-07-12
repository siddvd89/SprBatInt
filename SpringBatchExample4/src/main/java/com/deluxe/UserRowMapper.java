package com.deluxe;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User user = new User();

		user.setColorType(rs.getString("color_typ"));
		user.setColorDesc(rs.getString("color_desc"));	

		return user;
	}

}