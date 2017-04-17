package nio_p;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyMain2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path path = Paths.get("fff/abcde.jpg");
		Path path2 = Paths.get("fff/aaaa.jpg");
		
		Files.copy(path, path2, StandardCopyOption.REPLACE_EXISTING);
	}

}
