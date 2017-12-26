package com.drf.springboot.control;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drf.springboot.domain.User;
import com.drf.springboot.server.FirstServer;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyFirstControl {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private FirstServer firstServer;
	@RequestMapping("/json")
	@ResponseBody
	public Object json()
	{
		int[] a= {1,1,1};
		return a;
	}
	@RequestMapping("/index")
	public String index(Model model)
	{
		model.addAttribute("a", "b");
		return "/index";
	}
	@RequestMapping("/second")
	@ResponseBody
	public User second()
	{
		
		User user = jdbcTemplate.query("select * from aa", new ResultSetExtractor<User>(){

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next())
				{
					User user =new User();
					user.setId(rs.getInt(1));
					user.setName1(rs.getString(3));
					user.setName2(rs.getString(2));
					return user;
				}
				return null;
			}});
		return user;
	}
	@RequestMapping("/thired")
	@ResponseBody
	public void thired()
	{
		firstServer.add();
	}
	@RequestMapping("/four")
	@ResponseBody
	public User four()
	{
		return firstServer.get();
	}
}
