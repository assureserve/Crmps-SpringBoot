package com.crmps.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.crmps.domain.Person;

@Component
public class PersonDao {
	private static final Logger LOG = LoggerFactory.getLogger(PersonDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Person> findByLastName(String lastName) {
		LOG.info("Querying Person");
		String sql="select uid,first_name,last_name,govt_id,pic_url,user_id from person where last_name = ?";
		List<Person> personList = jdbcTemplate.query(sql
				, new Object[] { lastName } ,
				(rs, rowNum) -> {
					Person person = new Person();
					person.setUid(rs.getString("uid"));
					person.setFirstName(rs.getString("first_name"));
					person.setLastName(rs.getString("last_name"));
					person.setGovermentId(rs.getString("govt_id"));
					person.setPictureURL(rs.getString("pic_url"));
					person.setUserId(rs.getString("user_id"));
					return person;
				});
		return personList;
	}
	
	
	public Person findByUserId(String userId) {
		LOG.info("Querying Person");
		Person onePerson = jdbcTemplate.queryForObject(
				"select uid,first_name,last_name,govt_id,pic_url,user_id from person where user_id = ?", new Object[] { userId } ,
				(rs, rowNum) -> {
					Person person = new Person();
					person.setUid(rs.getString("uid"));
					person.setFirstName(rs.getString("first_name"));
					person.setLastName(rs.getString("last_name"));
					person.setGovermentId(rs.getString("govt_id"));
					person.setPictureURL(rs.getString("pic_url"));
					person.setUserId(rs.getString("user_id"));
					return person;
				});
		return onePerson;
	}
	
	public Person findByUid(String uid) {
		LOG.info("Querying Person");
		Person onePerson = jdbcTemplate.queryForObject(
				"select uid,first_name,last_name,govt_id,pic_url,user_id from person where uid = ?", new Object[] { uid } ,
				(rs, rowNum) -> {
					Person person = new Person();
					person.setUid(rs.getString("uid"));
					person.setFirstName(rs.getString("first_name"));
					person.setLastName(rs.getString("last_name"));
					person.setGovermentId(rs.getString("govt_id"));
					person.setPictureURL(rs.getString("pic_url"));
					person.setUserId(rs.getString("user_id"));
					return person;
				});
		return onePerson;
	}
	
	
	public int addPerson(Person person) {
		LOG.info("Inserting Person");
		String sql ="insert into person ( uid,first_name,last_name,govt_id,pic_url,user_id ,password"
				+ ",created_by,updated_by, created_timestamp,updated_timestamp) "
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		int value = jdbcTemplate.update(sql,new Object[] {
					person.getUid()
					,person.getFirstName()
					,person.getLastName()
					,person.getGovermentId()
					,person.getPictureURL()
					,person.getUserId()
					,person.getPassword()
					,person.getCreatedBy()
					,person.getUpdatedBy()
					,person.getCreatedTimestamp()
					,person.getUpdatedTimestamp()

				});
		return value;
	}
	
	

}
