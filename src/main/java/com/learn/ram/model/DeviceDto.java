package com.learn.ram.model;

public class DeviceDto {
	
	private Integer deviceId;
	private String deviceName;
	private String version;
	private String connectionStatus;
	public DeviceDto(Integer deviceId, String deviceName, String version, String connectionStatus) {
		super();
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.version = version;
		this.connectionStatus = connectionStatus;
	}
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getConnectionStatus() {
		return connectionStatus;
	}
	public void setConnectionStatus(String connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	
}
