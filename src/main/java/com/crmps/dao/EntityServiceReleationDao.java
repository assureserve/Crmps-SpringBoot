package com.crmps.dao;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.crmps.domain.ProductWorkItem;
import com.crmps.domain.ServiceProduct;
import com.crmps.domain.WorkHour;

@Component
public class EntityServiceReleationDao {
	private static final Logger LOG = LoggerFactory.getLogger(EntityServiceReleationDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addSerivceProduct(String entityUid,ServiceProduct productReleation) {
		LOG.info("Inserting addSerivceProduct ");
		String sql =" insert into entity_service_product_rel (entity_uid,service_product_type_uid,service_product_sub_type_uid "
				+ ",created_by,updated_by, created_timestamp,updated_timestamp) "
				+ " VALUES (?,?,?,?,?,?,?)";
		int value = jdbcTemplate.update(sql,new Object[] {
					entityUid
					,productReleation.getServiceProductUid()
					,productReleation.getServiceProductSubUid()
					,productReleation.getCreatedBy()
					,productReleation.getUpdatedBy()
					,productReleation.getCreatedTimestamp()
					,productReleation.getUpdatedTimestamp()
				});
		return value;
	}

	
	public int addWorkHours(String entityUid,WorkHour workHour) {
		LOG.info("Inserting addSerivceProduct ");
		String sql =" insert into entity_working_hour (uid,entity_uid,day,from_time, to_time "
				+ ",created_by,updated_by, created_timestamp,updated_timestamp) "
				+ " VALUES (?,?,?,?,?,?,?,?,?)";
		int value = jdbcTemplate.update(sql,new Object[] {
					workHour.getUid()
					,entityUid
					,workHour.getDay()
					,workHour.getFromTime()
					,workHour.getToTime()
					,workHour.getCreatedBy()
					,workHour.getUpdatedBy()
					,workHour.getCreatedTimestamp()
					,workHour.getUpdatedTimestamp()
				});
		return value;
	}
	
	public int addEnityProductWorkItem(String entityUid, ProductWorkItem workItem) {
		LOG.info("Inserting addSerivceProduct ");
		String sql =" insert into entity_product_work_item (uid,entity_uid,service_product_type_uid,product_item_uid , current_history "
				+ ",created_by,updated_by, created_timestamp,updated_timestamp) "
				+ " VALUES (?,?,?,?,?,?,?,?,?)";
		int value = jdbcTemplate.update(sql,new Object[] {
					workItem.getUid()
					,entityUid
					,workItem.getServiceProductUid()
					,workItem.getProductItemUid()
					,workItem.getCurrentOrHistory()
					,workItem.getCreatedBy()
					,workItem.getUpdatedBy()
					,workItem.getCreatedTimestamp()
					,workItem.getUpdatedTimestamp()
				});
		return value;
	}
	
	
	public List<ServiceProduct> findServiceProductRel(String entityUid) {
		LOG.info("Querying findServiceProductRel");
		String sql="select  sp.uid , es.entity_uid ,sp.description  "
				+ ",sp.created_by,sp.updated_by, sp.created_timestamp,sp.updated_timestamp "
				+ " from entity_service_product_rel es, service_product_type sp  "
				+ " where es.service_product_type_uid = sp.uid and es.entity_uid =?";
		List<ServiceProduct> serviceProdList = jdbcTemplate.query(sql
				, new Object[] { entityUid } ,
				(rs, rowNum) -> {
					ServiceProduct prodRel = new ServiceProduct();
					prodRel.setUid(rs.getString("uid") ) ;
					prodRel.setDescription(rs.getString("description"));
					prodRel.setCreatedBy(rs.getString("created_by"));
					prodRel.setUpdatedBy(rs.getString("updated_by"));
					prodRel.setCreatedTimestamp(rs.getTimestamp("created_timestamp"));
					prodRel.setUpdatedTimestamp(rs.getTimestamp("updated_timestamp"));
					return prodRel;
				});
		return serviceProdList;
	}
	
	
	public List<ProductWorkItem> findWorkProductItemsByUid(String entityUid) {
		LOG.info("Querying findWorkedProductItemsByUid");
		String sql=" select pi.uid ,pi.description , current_history"
				+ ",pi.created_by,pi.updated_by, pi.created_timestamp,pi.updated_timestamp "
				+ " from entity_product_work_item ew, product_item pi where ew.product_item_uid = pi.uid and ew.entity_uid=? "; 
		List<ProductWorkItem> workHistoryList = jdbcTemplate.query(sql
				, new Object[] { entityUid } ,
				(rs, rowNum) -> {
					ProductWorkItem workHistory = new ProductWorkItem();
					workHistory.setUid(rs.getString("uid") ) ;
					workHistory.setDescription(rs.getString("description"));
					workHistory.setCurrentOrHistory(rs.getString("current_history"));
					workHistory.setCreatedBy(rs.getString("created_by"));
					workHistory.setUpdatedBy(rs.getString("updated_by"));
					workHistory.setCreatedTimestamp(rs.getTimestamp("created_timestamp"));
					workHistory.setUpdatedTimestamp(rs.getTimestamp("updated_timestamp"));
					return workHistory;
				});
		return workHistoryList;
	}
	
	public List<WorkHour> findWorkingHours(String entityUid) {
		LOG.info("Querying findWorkedProductItemsByUid");
		String sql="select uid,entity_uid , day,from_time ,to_time "
				+ ",created_by,updated_by, created_timestamp,updated_timestamp "
				+ " from entity_working_hour where entity_uid=? "; 
		List<WorkHour> workHourList = jdbcTemplate.query(sql
				, new Object[] { entityUid } ,
				(rs, rowNum) -> {
					WorkHour workHour = new WorkHour();
					workHour.setUid(rs.getString("uid") ) ;
					workHour.setDay(rs.getString("day"));
					workHour.setFromTime(rs.getString("from_time"));
					workHour.setToTime(rs.getString("to_time"));
					workHour.setCreatedBy(rs.getString("created_by"));
					workHour.setUpdatedBy(rs.getString("updated_by"));
					workHour.setCreatedTimestamp(rs.getTimestamp("created_timestamp"));
					workHour.setUpdatedTimestamp(rs.getTimestamp("updated_timestamp"));
					return workHour;
				});
		return workHourList;
	}
}
