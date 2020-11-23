package com.jforce.hotelbooking.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jforce.hotelbooking.cammand.BookCammand;
import com.jforce.hotelbooking.cammand.GuestCammand;
import com.jforce.hotelbooking.cammand.LoginCammand;
import com.jforce.hotelbooking.cammand.SearchRoomCammand;
import com.jforce.hotelbooking.dto.BookDTO;
import com.jforce.hotelbooking.dto.GuestDTO;
import com.jforce.hotelbooking.dto.LoginDTO;
import com.jforce.hotelbooking.dto.RoomDTO;
import com.jforce.hotelbooking.model.Search;
import com.jforce.hotelbooking.service.IGuestMgmtService;

@Controller
public class GuestController {
	@Autowired
	private IGuestMgmtService gstService;
	
	@RequestMapping("/welcome")
	public String getHomePage() {
		return "home";
	}
	
	@GetMapping("/login")
	public String getLoginPage(@ModelAttribute("logGstCmd") LoginCammand logGuest) {
		return "login";
	}
	
	@PostMapping("/login")
	public String processGuest(Map<String,Object> map,
										   @ModelAttribute("logGstCmd") LoginCammand logGuest,
										   BindingResult br) {
		String result=null;
		LoginDTO dto=null;
		
		//Convert cammand to dto 
		dto=new LoginDTO();
		BeanUtils.copyProperties(logGuest, dto);
		
		//invoke service class verifyGuest(-) method
		result=gstService.verifyGuest(dto);
		
		if(result.equalsIgnoreCase("Guest Found"))
			return "user_profile";
		else {
			map.put("logMsg",result);
			return "login";
		}
	}
	@GetMapping("/register")
	public String getRegisterPage(@ModelAttribute("gstCmd") GuestCammand guest) {
		return "register";
	}
	
	@PostMapping("/register")
	public String processGuestRegistration(HttpSession session,
										   @ModelAttribute("gstCmd") GuestCammand guest,
										   BindingResult br) {
		GuestDTO dto=null;
		String regStatus=null;
		
		//Convert cammand class to dto
		dto=new GuestDTO();
		BeanUtils.copyProperties(guest, dto);
		
		//call the service method
		regStatus=gstService.registerGuest(dto);
		//keep model attribute and vale in session scope
		session.setAttribute("regMsg",regStatus);
		//return lvn
		return "redirect:register";
	}
	
	@GetMapping("/search_rooms")
	public String getRoomSeracePage(@ModelAttribute("serRoomCmd") SearchRoomCammand cmd) {
		return "search_rooms";
	}
	
	@PostMapping("/search_rooms")
	public String processRoomSearch(Map<String,Object> map,
									@ModelAttribute("serRoomCmd") SearchRoomCammand cmd,
									BindingResult br) {
		List<RoomDTO> roomDTO=null;
		Search search=null;
		//Convert cmd to Search
		search=new Search();
		BeanUtils.copyProperties(cmd, search);
		//use service
		roomDTO=gstService.getAvaliableRooms(search);
		map.put("roomDTO",roomDTO);
		return "avaliable_rooms_list";
	}
	
	@ModelAttribute("roomTypes")
	public List<String> getRoomTypes(){
		List<String> roomTypeList=null;
		
		roomTypeList= new ArrayList<String>();
		
		roomTypeList.add("STANDARD");
		roomTypeList.add("DELUXE");
		roomTypeList.add("LUXURY");
		
		return roomTypeList;
	}
	@GetMapping("/book")
	public String getBookRoomForm(Map<String,Object> map,
						   @RequestParam("rNo") int roomNo,
						   @RequestParam("type") String roomType,
						   @ModelAttribute("bkCmd") BookCammand bkCmd) {
		map.put("rNo", roomNo);
		map.put("type", roomType);
		return "date_book";
	}
	@PostMapping("/book")
	public String bookRoom(HttpServletRequest req,
						   Map<String,Object> map,
				 		   @ModelAttribute("bkCmd") BookCammand bkCmd,
				 		   BindingResult br) {
		int roomNo=0;
		String roomType=null;
		BookDTO dto=null;
		String result=null;
		//Read form request param value
		roomType=req.getParameter("type");
		roomNo=Integer.parseInt(req.getParameter("rNo"));
		
		System.out.println(roomType);
		System.out.println(roomNo);
		
		//values to bkCmd
		bkCmd.setRoomId(roomNo);
		bkCmd.setRoomType(roomType);
		//copy all properties to BookDTO class
		dto=new BookDTO();
		BeanUtils.copyProperties(bkCmd, dto);
		//Use service and call the method
		result=gstService.processRoomBoking(dto);
		if(result.equalsIgnoreCase("Booking Successed")) {
			map.put("roomNo", roomNo);
			map.put("roomType", roomType);
			map.put("startDate", bkCmd.getStartDate());
			map.put("endDate", bkCmd.getEndDate());
			return "booking_result";
		}
		
		else {
			map.put("resMsg", result);
			return "book";
		}
			
	}
}
