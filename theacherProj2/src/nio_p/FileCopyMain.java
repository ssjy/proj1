package nio_p;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileCopyMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Path path = Paths.get("fff/abcde.jpg");
		
		FileChannel fcr = FileChannel.open(
				path, 
				StandardOpenOption.READ);
		
		FileChannel fcw = FileChannel.open(
				Paths.get("fff/qeer.jpg"),
				StandardOpenOption.CREATE, 
				StandardOpenOption.WRITE);
		
		
		
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		int cnt=0;
		
		while(true)
		{
			cnt = fcr.read(buf);
			
			if(cnt ==-1)
				break;
			
			buf.flip();
			fcw.write(buf);

			buf.clear();
		}
		
		fcr.close();
		fcw.close();
	}

}
