/**
 * 
 */
package com.technojade.allybot.integration;

import java.net.URL;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ugam.sharma
 *
 */
@Component
@Slf4j
public class SmsUtil {

	@Value("${sms.authorization.api.key}")
	private String smsAuthorizationApiKey;

	@Value("${sms.route}")
	private String route;

	@Value("${sms.url}")
	private String smsUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public JsonNode sendOtpOnly(String mobileNumber, String otp) {
		log.info("otp sending started for mobileNumber {}", mobileNumber);
		JsonNode node = null;
		try {
			String strSmsURL = smsUrl.concat("?")
					.concat("authorization").concat("=").concat(smsAuthorizationApiKey)
					.concat("&variables_values").concat("=").concat(otp)
					.concat("&route").concat("=").concat(route)
					.concat("&numbers").concat("=").concat(mobileNumber);
			URL url = new URL(strSmsURL);
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<JsonNode> entity = new HttpEntity<JsonNode>(headers);
			ResponseEntity<JsonNode> responseEntity = restTemplate.exchange(url.toURI(),HttpMethod.GET, entity, JsonNode.class);
			
			if(null != responseEntity.getBody()  && responseEntity.getStatusCodeValue() == 200) {
				node = responseEntity.getBody();
				log.info("Otp sent and request id {}", node.get("request_id").asText());
			}
			
		} catch (Exception e) {
			log.error("exception occured while sending otp ", e);
		}
		
		return node;
	}
	/**
	 * this method is used to send the user name and password of user
	 * @param mobileNumber
	 * @param otp
	 * @return
	 */
	public JsonNode sendOtpWithUserCredential(String mobileNumber, String otp) {
		log.info("otp sending started for mobileNumber {}", mobileNumber);
		JsonNode node = null;
		try {
			String strSmsURL = smsUrl.concat("?")
					.concat("authorization").concat("=").concat(smsAuthorizationApiKey)
					.concat("&variables_values").concat("=").concat(otp)
					.concat("&route").concat("=").concat(route)
					.concat("&numbers").concat("=").concat(mobileNumber);
			URL url = new URL(strSmsURL);
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<JsonNode> entity = new HttpEntity<JsonNode>(headers);
			ResponseEntity<JsonNode> responseEntity = restTemplate.exchange(url.toURI(),HttpMethod.GET, entity, JsonNode.class);
			
			if(null != responseEntity.getBody()  && responseEntity.getStatusCodeValue() == 200) {
				node = responseEntity.getBody();
				log.info("Otp sent and request id {}", node.get("request_id").asText());
			}
			
		} catch (Exception e) {
			log.error("exception occured while sending otp ", e);
		}
		
		return node;
	}
	
	
//	public JsonNode verifyOtp(String otp, String mobileNumber) {
//		log.info("otp veriication started for mobileNumber {} and otp {}", mobileNumber, otp);
//		JsonNode node = null;
//		try {
//			String strSmsURL = smsUrl.concat("?")
//					.concat("authorization").concat("=").concat(smsAuthorizationApiKey)
//					.concat("variables_values").concat("=").concat(variableValues)
//					.concat("route").concat("=").concat(route)
//					.concat("numbers").concat("=").concat(mobileNumber);
//			URL url = new URL(strSmsURL);
//			HttpHeaders headers = new HttpHeaders();
//			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//			HttpEntity<JsonNode> entity = new HttpEntity<JsonNode>(headers);
//			ResponseEntity<JsonNode> responseEntity = restTemplate.exchange(url.toURI(),HttpMethod.GET, entity, JsonNode.class);
//			
//			if(null != responseEntity.getBody()  && responseEntity.getStatusCode() != HttpStatus.OK) {
//				node = responseEntity.getBody();
//			}
//			
//		} catch (Exception e) {
//			log.error("exception occured while sending otp ", e);
//		}
//		
//		return node;
//	}
}
