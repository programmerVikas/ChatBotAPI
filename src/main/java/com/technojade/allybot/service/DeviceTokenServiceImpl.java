package com.technojade.allybot.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technojade.allybot.entity.DeviceTokenMst;
import com.technojade.allybot.repository.DeviceTokenRepository;

@Service
public class DeviceTokenServiceImpl implements DeviceTokenService {

	@Autowired
	private DeviceTokenRepository deviceTokenRepository;

	@Override
	public DeviceTokenMst saveDeviceToken(DeviceTokenMst deviceTokenMst) {

		Optional<DeviceTokenMst> findByUserid = deviceTokenRepository.findByUseridOrAgentId(deviceTokenMst.getUserid(),
				deviceTokenMst.getAgentId());
		if (findByUserid.isPresent()) {
			deviceTokenRepository.deleteById(findByUserid.get().getId());
		} else {
			deviceTokenMst.setCreatedOn(LocalDateTime.now());
			deviceTokenMst.setCreatedBy(deviceTokenMst.getUserid() != null ? deviceTokenMst.getUserid()
					: deviceTokenMst.getAgentId() != null ? Long.valueOf(deviceTokenMst.getAgentId()) : 0L);
		}

		deviceTokenRepository.save(deviceTokenMst);
		return deviceTokenMst;
	}

}
