package com.jforce.hotelbooking.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jforce.hotelbooking.dao.IGuestDAO;
import com.jforce.hotelbooking.model.Guest;
import com.jforce.hotelbooking.model.Login;

@Repository("gstDAO")
public class GuestDAOImpl implements IGuestDAO {
	//Declare All queries at the top of class as static final
	private static final String INSERT_GUEST_DETAILS_QUERY="INSERT INTO GUEST_TAB VALUES (GSTID_SEQ.NEXTVAL,?,?,?,?,?)";
	private static final String SELECT_USER="SELECT COUNT(*) FROM GUEST_TAB WHERE USERNAME=? AND PASSWORD=?"; 
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int insertGuest(Guest guest) {
		//Declaring local variable at the top of method
		int result=0;
		//use jdbc templet
		result=jt.update(INSERT_GUEST_DETAILS_QUERY, guest.getGstName(),guest.getEmail(),guest.getMobile(),guest.getUsername(),guest.getPassword());
		return result;
		
		
		/*		Session ses =HibernateUtil.getSf().openSession();
				Transaction tx=null;
				try(ses){
					tx=ses.beginTransaction();
					
					//insert guest into db table
					ses.save(guest);
					
					//commit the transaction
					tx.commit();
			
				}catch (Exception e) {
					//commit the Transaction if any exception occur
					tx.rollback();
					e.printStackTrace();
				}*/
		
		
	}

	@Override
	public int validateGuest(Login login) {
		int result=0;
		//use jdbc templet
		result=jt.query(SELECT_USER, rs->{
			int count=0;
			if(rs.next())
				count=rs.getInt(1);
			return count;
		},login.getUsername(),login.getPassword());
		return result;
	}

}
