package io_p;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File ff = new File("fff/vvv/yyy");
		
		System.out.println(ff.exists());
		System.out.println(ff.getName());
		System.out.println(ff.isDirectory());
		System.out.println(ff.isFile());
		System.out.println(ff.getPath());
		System.out.println(ff.getAbsolutePath());
		System.out.println(ff.getParent());
		
		System.out.println(ff.delete());
		
		//System.out.println(ff.mkdir());
		System.out.println(ff.mkdirs());
		System.out.println("---------------");
		ff =  new File("fff");
		
		File [] files = ff.listFiles();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		for(File f : files)
		{
			String attr = "";
			if(f.isDirectory()) attr="[dir]";
			else{
				attr = f.length()+" ";
				attr+= f.canRead() ? "R":" ";
				attr+= f.canWrite() ? "W":" ";
				attr+= f.isHidden() ? "H":" ";
				
				
			}
			
			System.out.println(f.getName()+"\t"+attr+"\t"+
			sdf.format(f.lastModified()));
			
		}
		
		
	}

}
