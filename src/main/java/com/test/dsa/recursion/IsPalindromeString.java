package com.test.dsa.recursion;

import java.time.LocalDateTime;
import java.util.Locale;

public class IsPalindromeString {
	public static void main(String[] args) {
		System.out.println(LocalDateTime.now());
		final var abA = isPalindrome("A man, a plan, a canal: Panama");
		System.out.println(LocalDateTime.now());
		System.out.println(abA);

		System.out.println(LocalDateTime.now());
		final var isPalindrome = isPalindromeTwoPointerApproach("A man, a plan, a canal: Panama");
		System.out.println(LocalDateTime.now());
		System.out.println(isPalindrome);
	}

	public static boolean isPalindromeRecursion(char[] chars, int i) {
		return  false;
	};

	public static boolean isPalindrome(String s) {
		System.out.println(s);
		final var actual = s.replaceAll("\\W+|_+", "").toLowerCase(Locale.ENGLISH);
		System.out.println(actual);
		final var charArray = actual.toCharArray();

		int half = charArray.length / 2;

		for(int i=0;i < half; i++) {
			char temp = charArray[i];
			charArray[i] = charArray[charArray.length - 1 - i];
			charArray[charArray.length - 1 - i] = temp;
		}

		String reversedString = new String(charArray);
		System.out.println(reversedString);
		return actual.equals(reversedString);
	}

	public static boolean isPalindromeTwoPointerApproach(String s) {
		int first = 0;
		int last = s.length() -1;
		final var charArray = s.toCharArray();

		while(first <= last) {
			char firstChar = charArray[first];
			char lastChar = charArray[last];
			if(!Character.isLetterOrDigit(firstChar)) {
				first++;
			} else if(!Character.isLetterOrDigit(lastChar)) {
				last--;
			} else {
				if(Character.toLowerCase(firstChar) != Character.toLowerCase(lastChar))
					return false;

				first++;
				last--;
			}

		}

		return true;
	}
}


