package nio_p;

import java.io.IOException;
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




public class AsyncFileReadMain {

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
					EnumSet.of(StandardOpenOption.READ),
					service
			);
			
			
			
			ByteBuffer buf = ByteBuffer.allocate((int)channel.size());
			
			class Attach{
				Path path;
				AsynchronousFileChannel channel;
				ByteBuffer buf;
				/**
				 * @param path
				 * @param channel
				 * @param buf
				 */
				public Attach(Path path, AsynchronousFileChannel channel, ByteBuffer buf) {
					this.path = path;
					this.channel = channel;
					this.buf = buf;
				}
					
			}
			
			CompletionHandler<Integer, Attach> myHandler =  new CompletionHandler<Integer, Attach>() {

				@Override
				public void completed(Integer result, Attach attachment) {
					// TODO Auto-generated method stub
					
					attachment.buf.flip();
					Charset charset = Charset.defaultCharset();
					String data = charset.decode(buf).toString();
					
					System.out.println(
							attachment.path.getFileName()+":"+
							data+":"+
							Thread.currentThread().getName());
					
					try {
						channel.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}

				@Override
				public void failed(Throwable exc, Attach attachment) {
					// TODO Auto-generated method stub
					try {
						channel.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};

			
			
			Attach attr= new Attach(path, channel,buf);
			
			channel.read(buf, 0,attr, myHandler);
			
			//channel.close();
			
		}
		
		service.shutdown();
	}

}
