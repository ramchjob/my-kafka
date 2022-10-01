package com.learn.ram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ram.model.DeviceDto;
import com.learn.ram.service.DeviceService;

@RestController
public class DeviceController {
	
	@Autowired
	DeviceService deviceService;
	
	@GetMapping("/devices")
	public ResponseEntity<List<DeviceDto>> getDevices() {
		List<DeviceDto> devices = deviceService.getDevices();
		return ResponseEntity.ok(devices);
	}
	
	@PostMapping("/devices")
	public ResponseEntity<DeviceDto> createDevice(@RequestBody DeviceDto dto) {
		DeviceDto device = deviceService.createDevice(dto);
		return ResponseEntity.ok(device);
	}

}
