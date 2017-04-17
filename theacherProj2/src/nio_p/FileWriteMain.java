package nio_p;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriteMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Path path = Paths.get("fff/nio.txt");
		
		FileChannel fcw = FileChannel.open(
				path,
				StandardOpenOption.CREATE, 
				StandardOpenOption.WRITE);
		
		String data = "�ɷ��ɷ��ɷ�";
		
		Charset charset = Charset.defaultCharset();
		ByteBuffer buf = charset.encode(data);
		
		
		
		System.out.println("������ ��:"+fcw.write(buf));
		
		fcw.close();
	}

}
