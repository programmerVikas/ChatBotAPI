package com.technojade.allybot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technojade.allybot.entity.BookedRoomInfo;
import com.technojade.allybot.entity.UserBookingDetail;

@Repository
public interface RoomInfoRepository extends JpaRepository<BookedRoomInfo, Long>{

	public void deleteAllByOnlineBookingId(Long onlineBId);
	
	public BookedRoomInfo findByOnlineBookingId(Long onlineId);

}