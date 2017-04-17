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
		
		String data = "케로케로케로";
		
		Charset charset = Charset.defaultCharset();
		ByteBuffer buf = charset.encode(data);
		
		
		
		System.out.println("데이터 량:"+fcw.write(buf));
		
		fcw.close();
	}

}
