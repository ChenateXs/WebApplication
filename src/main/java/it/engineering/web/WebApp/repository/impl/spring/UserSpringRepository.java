package it.engineering.web.WebApp.repository.impl.spring;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import it.engineering.web.WebApp.entity.User;
import it.engineering.web.WebApp.repository.IcrudRepository;

@Repository(value = "userSpringRepository")
public class UserSpringRepository implements IcrudRepository<User, Long>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UserSpringRepository() {
	}

	@Override
	public void create(User entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User read(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Long id, User entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		String query = "SELECT * FROM user";

		return jdbcTemplate.query(query, (ResultSet rs, int rowNum) -> {
			System.out.println(rs);
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));	
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			return user;
		});
	}

}
