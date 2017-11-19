package com.pokecard.utils;



public class GenerateId {

	public static String userId(){
		return "usr"+getAleaId();
	}
	public static String cardId(){
		return "crd"+getAleaId();
	}
	public static String basketId(){
		return "bkt"+getAleaId();
	}
	
	public static String getChatId(){
		return "cht"+getAleaId();
	}
	public static String getMessageId(){
		return "msg"+getAleaId();
	}
	
	public static String getMeetingId(){
		return "mtg"+getAleaId();
	}
	
	
	
	private static String getAleaId() {
		String s = "";
		for (int i = 0; i < 16; i++) {
			s += aleaAscii();
		}
		//System.out.println();
		return s;
	}

	private static char aleaAscii() {
		char c;
		double d = Math.random();
		if (d < 0.3) {
			c = (char) ((int) (Math.random() * 10 + 48));
		}
		else if (d < 0.6) {
			c = (char) ((int) (Math.random() * 26 + 65));
		}
		else {
			c = (char) ((int) (Math.random() * 26 + 97));
		}
		return c;
	}

	public static void main(String[] args) {
		System.out.println(userId());
	}

}
