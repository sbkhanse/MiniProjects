package com.jforce.hotelbooking.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jforce.hotelbooking.dao.IGuestDAO;
import com.jforce.hotelbooking.dao.IRoomDAO;
import com.jforce.hotelbooking.dto.BookDTO;
import com.jforce.hotelbooking.dto.GuestDTO;
import com.jforce.hotelbooking.dto.LoginDTO;
import com.jforce.hotelbooking.dto.RoomDTO;
import com.jforce.hotelbooking.model.Book;
import com.jforce.hotelbooking.model.Guest;
import com.jforce.hotelbooking.model.Login;
import com.jforce.hotelbooking.model.Room;
import com.jforce.hotelbooking.model.Search;
import com.jforce.hotelbooking.service.IGuestMgmtService;

@Service("gstService")
public class GuestMgmtServiceImpl implements IGuestMgmtService {
	@Autowired
	private IGuestDAO gstDAO;
	@Autowired 
	private IRoomDAO roomDAO;
	
	@Override
	public String registerGuest(GuestDTO dto) {
		int result=0;
		Guest guest;
		//Convert dto to model class
		guest=new Guest();
		BeanUtils.copyProperties(dto,guest);
		//use DAO 
		result=gstDAO.insertGuest(guest);
		
		//convert result into string 1->Registration successed and 0-> registration faild
		return (result==0)?"Registration Failed...!":"Registration Successed...!";
	}

	@Override
	public String verifyGuest(LoginDTO dto) {
		Login login=null;
		int result=0;
		
		//Convert dto to login model class
		login=new Login();
		BeanUtils.copyProperties(dto, login);
		
		//Use DAO
		result=gstDAO.validateGuest(login);
		
		//process the result and return
		return (result==0)?"Guest Not Found...Please Provide Correct Username and Password.":"Guest Found";
	}

	@Override
	public List<RoomDTO> getAvaliableRooms(Search search) {
		List<Room> roomList=null;
		//Use injected DAO class
		roomList=roomDAO.searchRoom(search);
		List<RoomDTO> roomDTO=new ArrayList();
		//Convert model class to DTO class
		roomList.forEach(room->{
			RoomDTO dto=new RoomDTO();
			BeanUtils.copyProperties(room, dto);
			dto.setSerNo(roomDTO.size()+1);
			roomDTO.add(dto);
		});
		return roomDTO;
	}

	@Override
	public String processRoomBoking(BookDTO bkDTO) {
		int result=0;
		Book book=null;
		
		//Convert bkDTO to Model class
		book=new Book();
		BeanUtils.copyProperties(bkDTO, book);
		
		//Use roomDAO and calls the method
		result=roomDAO.updateBooking(book);
		
		//Process the result and return
		return (result==0)?"Room Bookin is Failed...Please Try Again...!":"Booking Successed";
	}

}
