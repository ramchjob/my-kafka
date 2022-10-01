package com.learn.ram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.ram.entity.Device;
import com.learn.ram.mapper.DeviceMapper;
import com.learn.ram.model.DeviceDto;
import com.learn.ram.repository.DeviceRepository;

@Service
public class DeviceService {

	@Autowired
	DeviceRepository repository;

	@Autowired
	DeviceMapper mapper;

	public List<DeviceDto> getDevices() {
		List<Device> devices = repository.findAll();

		return mapper.mapDevices(devices);
	}

	public DeviceDto createDevice(DeviceDto dto) {
		Device dbDevice =  repository.save(mapper.mapDevice(dto));
		return mapper.mapDevices(List.of(dbDevice)).get(0);
	}

}
