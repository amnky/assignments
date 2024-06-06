package com.techlabs.model;

public class SmartHome {
	private SmartDevice[] smartDevices;
	private int actualNumberOfSmartDevices;

	public SmartHome(int maximumNumberOfSmartDevices) {
		smartDevices = new SmartDevice[maximumNumberOfSmartDevices];
		actualNumberOfSmartDevices = 0;
	}

	public void addDevice(SmartDevice smartDevice) {
		if (actualNumberOfSmartDevices < smartDevices.length) {
			smartDevices[actualNumberOfSmartDevices] = smartDevice;
			actualNumberOfSmartDevices++;
			return;
		}
		System.out.println("Cannot add more devices, maximum smart devices limit reached");

	}

	public void controlDevice(String deviceID, boolean turnOn) {
		for (int i = 0; i < actualNumberOfSmartDevices; i++) {

			String tempDeviceID = smartDevices[i].getDeviceId();
			if (tempDeviceID.equals(deviceID)) {
				if (smartDevices[i] instanceof Controllable) {
					Controllable controllable = (Controllable) smartDevices[i];
					if (turnOn) {
						controllable.turnOn();
						return;
					}
					controllable.turnOff();
				}

				if (smartDevices[i] instanceof SecurityCamera) {
					SecurityCamera securityCamera = (SecurityCamera) smartDevices[i];
					if (turnOn) {
						securityCamera.startRecording();
						return;
					}
					securityCamera.stopRecording();
				}
				break;
			}
		}
	}

	public void listAllDevices() {
		for (int i = 0; i < actualNumberOfSmartDevices; i++) {

			System.out.println("Device ID : " + smartDevices[i].getDeviceId());
			System.out.println("Device Name : " + smartDevices[i].getName());
			if (smartDevices[i] instanceof Monitorable) {
				Monitorable monitorable = (Monitorable) smartDevices[i];
				System.out.println("Device Status : " + monitorable.getStatus());
			}
			if (smartDevices[i] instanceof Light) {
				Light light = (Light) smartDevices[i];
				System.out.println("Device Status : " + light.getStatus());
			}
			System.out.println();
		}
	}

}
