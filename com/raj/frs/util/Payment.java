package com.raj.frs.util;

public interface Payment {
	public boolean findByCardNumber(String userid, String cardnumber);
	public String process(Payment payment);
}

