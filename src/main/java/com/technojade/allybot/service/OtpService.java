/**
 * 
 */
package com.technojade.allybot.service;

import java.time.LocalDateTime;

import com.technojade.allybot.entity.OtpEntity;
import com.technojade.allybot.entity.UserBookingInfo;

/**
 * @author BC70873
 *
 */
public interface OtpService {

	public String send(String mobileNumber);
	
	public String sendOtpOnly(String mobileNumber);

	public String sendOtpWithCredential(String mobileNumber);

	public boolean validate(String mobileNumber, String otp);

	public OtpEntity validate(String otp);

	public OtpEntity validateEmployee(String otp);

	public String sendOtpOnlyWithCheckoutDate(String primaryMobileNumber, LocalDateTime chkoutdate);
	
}
