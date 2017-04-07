package com.crmps.dao;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.crmps.domain.Address;

@Component
public class AddressDao {
	private static final Logger LOG = LoggerFactory.getLogger(AddressDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public int addAddress(Address address) {
		LOG.info("Inserting address");
		String sql ="INSERT INTO address (uid,street_1,street_2,city,state,zip,country,type"
				+ ",created_by,updated_by, created_timestamp,updated_timestamp) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		int value = jdbcTemplate.update(sql,new Object[] {
					address.getUid()
					,address.getStreet1()
					,address.getStreet2()
					,address.getCity()
					,address.getState()
					,address.getZip()
					,address.getCountry()
					,address.getType()
					,address.getCreatedBy()
					,address.getUpdatedBy()
					,address.getCreatedTimestamp()
					,address.getUpdatedTimestamp()

				});
		return value;
	}
	public List<Address> findByUid(String entityUid) {
		LOG.info("Querying Person");
		String sql="select a.uid,a.street_1,a.street_2,a.city,a.state,a.zip,a.country,a.type"
				+ ",a.created_by,a.updated_by, a.created_timestamp,a.updated_timestamp from Address a,entity_address_rel ar where ar.address_uid = a.uid and ar.entity_uid  = ?";
		List<Address> addressList = jdbcTemplate.query(sql
				, new Object[] { entityUid } ,
				(rs, rowNum) -> {
					Address address = new Address();
					address.setUid(rs.getString("uid") ) ;
					address.setStreet1(rs.getString("street_1"));
					address.setStreet2(rs.getString("street_2"));
					address.setCity(rs.getString("city"));
					address.setState(rs.getString("state"));
					address.setZip(rs.getString("zip"));
					address.setCountry(rs.getString("country"));
					address.setType(rs.getString("type"));
					address.setCreatedBy(rs.getString("created_by"));
					address.setUpdatedBy(rs.getString("updated_by"));
					address.setCreatedTimestamp(rs.getTimestamp("created_timestamp"));
					address.setUpdatedTimestamp(rs.getTimestamp("updated_timestamp"));
					return address;
				});
		return addressList;
	}
	
}
