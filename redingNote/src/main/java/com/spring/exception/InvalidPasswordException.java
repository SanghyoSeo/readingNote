package com.spring.exception;

public class InvalidPasswordException extends Exception {

	public InvalidPasswordException() {
		super("존재하지 않는 아이디입니다.");
	}
}
