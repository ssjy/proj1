package io_p;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import javax.swing.JFrame;



public class ExtMain extends JFrame{
	class FileOrder
	{
		String src;
		String dst;
		
		HashMap<String , String> map = new HashMap<>();
		public FileOrder(String src, String dst) {
			this.src = src;
			this.dst = dst;
			
			map.put("jpg", "img");
			map.put("png", "img");
			map.put("gif", "img");
			map.put("bmp", "img");
			
			map.put("txt", "doc");
			map.put("doc", "doc");
			map.put("hwp", "doc");
			map.put("ppt", "doc");
			map.put("xls", "doc");
			map.put("pptx", "doc");
			map.put("xlsx", "doc");
			map.put("docx", "doc");
			
			setDir(new File(src));
			
		}
		
		void setDir(File ppp)
		{
			File [] files = ppp.listFiles();
			
			for(File ff:files)
			{
				if(ff.isDirectory())
				{
					setDir(ff);
				}else{
					
					int dotPos = ff.getName().lastIndexOf(".");
					
					String ori = ff.getName().substring(0,dotPos);
					String ext = ff.getName().toLowerCase().substring(dotPos+1);
					
					String par = dst+"/etc";
					if(map.containsKey(ext))
						par = dst+"/"+map.get(ext);
					
					File parPath = new File(par);
					if(!parPath.exists())
						parPath.mkdirs();
					
					String fileName = par+"/"+ff.getName();
					
					File moveFF = new File(fileName);
					
					int cnt =0;
					if(moveFF.exists())
					{
					
						fileName = par+"/"+ori+"_"+cnt+"."+ext;
						
						moveFF = new File(fileName);
						while(moveFF.exists())
						{
							cnt++;
							fileName = par+"/"+ori+"_"+cnt+"."+ext;
							
							moveFF = new File(fileName);
						}	
					}
					
					try {
						FileInputStream fis = new FileInputStream(ff);
						FileOutputStream fos = new FileOutputStream(moveFF);
						
						byte [] buf = new byte[1024];
						int len = 0;
						while(fis.available()>0)
						{
							len = fis.read(buf);
							fos.write(buf, 0, len);
						}
						System.out.println(len);
						fos.close();
						fis.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					
					
					
				}
			}
		}
		
		
	}
	
	public ExtMain() {
		// TODO Auto-generated constructor stub
		setBounds(1600, 0, 300, 200);
		
		FileDialog fd = new FileDialog(this,"폴더선택", FileDialog.LOAD);
		setVisible(true);
		
		fd.setDirectory("fff");
		fd.setVisible(true);
		
		String ffff =fd.getDirectory();
		
		if(ffff!=null)
			new FileOrder(ffff, "zzz");
		else
			System.out.println("파일을 선택해주세요");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ExtMain();
	}

}
