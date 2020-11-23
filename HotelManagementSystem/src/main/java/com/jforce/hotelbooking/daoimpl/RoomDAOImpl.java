package com.jforce.hotelbooking.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jforce.hotelbooking.dao.IRoomDAO;
import com.jforce.hotelbooking.model.Book;
import com.jforce.hotelbooking.model.Room;
import com.jforce.hotelbooking.model.Search;

@Repository("roomSearchDAO")
public class RoomDAOImpl implements IRoomDAO {
	private static final String SELECT_ROOM_DETAILS="SELECT ROOM_ID,ROOM_TYPE,STATUS FROM ROOM_TAB WHERE ROOM_TYPE=? AND STATUS=?";
	private static final String UDATE_ROOM_BOOKING="UPDATE ROOM_TAB SET STATUS=?,START_DATE=?,END_DATE=? WHERE ROOM_ID=? AND ROOM_TYPE=?";
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public List<Room> searchRoom(Search search) {
		List<Room> roomList=null;
		roomList=jt.query(SELECT_ROOM_DETAILS, rs->{
			List<Room> rooms=null;
			Room room=null;
			rooms=new ArrayList();
			while(rs.next()) {
				room=new Room();
				room.setRoomId(rs.getInt(1));
				room.setRoomType(rs.getString(2));
				room.setStatus(rs.getString(3));
				rooms.add(room);
			}
			return rooms;
		}, search.getRoomType(),"AVALIABLE");
		return roomList;
	}

	@Override
	public int updateBooking(Book book) {
		int result=0;
		result=jt.update(UDATE_ROOM_BOOKING,"BOOKED",book.getStartDate(),book.getEndDate(),book.getRoomId(),book.getRoomType());
		return result;
	}

}
