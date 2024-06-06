package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.Light;
import com.techlabs.model.SecurityCamera;
import com.techlabs.model.SmartDevice;
import com.techlabs.model.SmartHome;
import com.techlabs.model.Thermostat;

public class SmartHomeManagementTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String deviceID;
		String deviceName;
		double temperature;
		boolean on;

		System.out.println("Enter the maximum number of smart devices in that can be added in your smart home");
		int numberOfSmartdevices = scanner.nextInt();
		SmartHome smartHome = new SmartHome(numberOfSmartdevices);

		System.out.println("Enter Device ID for Light");
		scanner.nextLine();
		deviceID = scanner.nextLine();

		System.out.println("Enter Device name for Light");
		deviceName = scanner.nextLine();
		SmartDevice light = new Light(deviceID, deviceName);
		smartHome.addDevice(light);

		System.out.println();

		System.out.println("Enter Device ID for Thermostat");
		deviceID = scanner.nextLine();

		System.out.println("Enter Device name for Thermostat");
		deviceName = scanner.nextLine();

		System.out.println("Enter initial temperture for thermostat");
		temperature = scanner.nextDouble();
		SmartDevice thermostat = new Thermostat(deviceID, deviceName, temperature);
		smartHome.addDevice(thermostat);

		System.out.println();

		System.out.println("Enter Device ID for Security camera");
		scanner.nextLine();
		deviceID = scanner.nextLine();

		System.out.println("Enter Device name for Security camera");
		deviceName = scanner.nextLine();
		SmartDevice securityCamera = new SecurityCamera(deviceID, deviceName);
		smartHome.addDevice(securityCamera);

		System.out.println();

		System.out.println("If you want to turn on light enter true or else enter false");
		on = scanner.nextBoolean();
		smartHome.controlDevice(light.getDeviceId(), on);

		System.out.println("If you want to turn on thermostat enter true or else enter false");
		on = scanner.nextBoolean();
		smartHome.controlDevice(thermostat.getDeviceId(), on);

		System.out.println("If you want security camera to  start recording enter true or else enter false");
		on = scanner.nextBoolean();
		smartHome.controlDevice(securityCamera.getDeviceId(), on);

		smartHome.listAllDevices();

		scanner.close();
	}

}
