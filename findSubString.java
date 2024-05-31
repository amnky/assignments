package com.amnky.assignments;

import java.util.Scanner;

public class findSubString {

	private static int[] computeLPS(String pattern) {
		int m = pattern.length();
		int[] lps = new int[m];
		int len = 0;
		int i = 1;

		while (i < m) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}
	public static boolean isSubstring(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		int[] lps = computeLPS(str2);

		int i = 0;
		int j = 0;

		while (i < n) {
			if (str1.charAt(i) == str2.charAt(j)) {
				i++;
				j++;
			}
			if (j == m) {
				return true; // Match found
			}
			if (i < n && str1.charAt(i) != str2.charAt(j)) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string 1");
		String string1 = sc.next();
		System.out.println("Enter string 2");
		String string2 = sc.next();

		System.out.println(isSubstring(string1, string2));

		sc.close();

	}
}
