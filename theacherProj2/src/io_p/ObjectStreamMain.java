package io_p;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


class SerChild extends SerData{

	String name;
	public SerChild(String str, int cnt, String name) {
		super(str, cnt);
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	private static final long serialVersionUID = 5678L;
	@Override
	public String toString() {
		return "SerChild [name=" + name + ", str=" + str + ", cnt=" + cnt + "]";
	}
	
}

public class ObjectStreamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileOutputStream fos = new FileOutputStream("fff/sd.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			
			oos.writeInt(123);
			oos.writeBoolean(true);
			oos.writeDouble(123.456);
			oos.writeUTF("윤성문 일찍오자");
			oos.writeObject(new SerData("추주추주", 100));
			oos.writeObject(new int []{123,456,789});
			oos.writeObject(new ArrayList<>());
			oos.writeObject(new SerData[]{new SerData("추주추주", 100)});
			oos.writeObject(new SerChild("추주추주", 100,"추주헌"));
			
			oos.flush();
			oos.reset();
			
			oos.close();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
