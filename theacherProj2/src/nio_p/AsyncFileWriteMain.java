package nio_p;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyHandler<Integer, Attach>  implements CompletionHandler<Integer, Attach> {

	@Override
	public void completed(Integer result, Attach attachment) {
		// TODO Auto-generated method stub
		
		System.out.println(result+"");
		
	}

	@Override
	public void failed(Throwable exc, Attach attachment) {
		// TODO Auto-generated method stub
		
	}
}

class Attach{
	Path path;
	AsynchronousFileChannel channel;
	/**
	 * @param path
	 * @param channel
	 */
	public Attach(Path path, AsynchronousFileChannel channel) {
		this.path = path;
		this.channel = channel;
	}
	
}


public class AsyncFileWriteMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ExecutorService service = 
				Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors());
		
		for (int i = 0; i <10; i++) {
		
			Path path = Paths.get("nnn/ff"+i+".txt");
			//path = nnn/ff0.txt;
			Files.createDirectories(path.getParent());
									// nnn/
			///nnn 디렉토리를 만들어라
			
			AsynchronousFileChannel channel  = AsynchronousFileChannel.open(
					path,
					EnumSet.of(StandardOpenOption.CREATE, 
							StandardOpenOption.WRITE),
					service
			);
			
			Charset charset = Charset.defaultCharset();
			
			ByteBuffer buf = charset.encode("윤성문은 좋겠네");
			
			
			
			Attach attr= new Attach(path, channel);
			
			channel.write(buf, 0, attr, new  MyHandler());
			
			channel.close();
			
		}
		
		service.shutdown();
	}

}
