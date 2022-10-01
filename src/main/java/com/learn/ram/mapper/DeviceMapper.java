package com.learn.ram.mapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.learn.ram.entity.Device;
import com.learn.ram.model.DeviceDto;

@Component
public class DeviceMapper {

	public List<DeviceDto> mapDevices(List<Device> devices) {
		return devices.stream().map(d -> {
			return new DeviceDto(d.getDeviceId(), d.getDeviceName(), d.getVersion(), d.getConnectionStatus());
		}).collect(Collectors.toList());
	}

	public Device mapDevice(DeviceDto dto) {
		return Arrays.asList(dto).stream().map(d -> {
			return new Device(d.getDeviceName(), d.getVersion(), d.getConnectionStatus());
		}).findFirst().get();
	}

}
