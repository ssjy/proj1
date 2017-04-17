package net_p;

public class ChatMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChatHome gu = new ChatHome("Ã¤ÆÃ");
		new MultiCastSender(gu).start();
		new MultiCastRecieverMain(gu).start();

	}

}
