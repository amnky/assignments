package com.techlabs.model;

import java.util.UUID;

public class Utility {

	public static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
	
}