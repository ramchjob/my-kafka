package com.learn.ram.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Device {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deviceId;
	
	@Column
	private String deviceName;
	
	@Column
	private String version;
	
	@Column
	private String connectionStatus;
	
	public Device() {
		
	}

	public Device(String deviceName, String version, String connectionStatus) {
		super();
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
