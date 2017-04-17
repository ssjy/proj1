package nio_p;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileReadMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Path path = Paths.get("fff/nio.txt");
		
		FileChannel fcw = FileChannel.open(
				path, 
				StandardOpenOption.READ);
		
		String data = "";
		
		Charset charset = Charset.defaultCharset();
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		int cnt=0;
		
		while(true)
		{
			cnt = fcw.read(buf);
			
			if(cnt ==-1)
				break;
			
			buf.flip(); //앞쪽으로 옮겨주는것
			data += charset.decode(buf).toString();
			buf.clear();
		}
		
		
		
		System.out.println("데이터:"+data);
		
		fcw.close();
	}

}
