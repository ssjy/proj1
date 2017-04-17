package net_p;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			URL url = new URL("http://comic.naver.com/webtoon/detail.nhn?titleId=20853&no=300&weekday=wed");
			
			System.out.println(url.getAuthority());
			System.out.println(url.getContent());
			System.out.println(url.getDefaultPort());
			System.out.println(url.getPort());
			System.out.println(url.getAuthority());
			System.out.println(url.getFile());
			System.out.println(url.getHost());
			System.out.println(url.getQuery());
			System.out.println(url.getProtocol());
			System.out.println(url.toURI());
			
			System.out.println("-------------------");
			
			InputStreamReader isr = new InputStreamReader(url.openStream());
			BufferedReader br = new BufferedReader(isr);
			
			String line;
			
			while((line=br.readLine())!=null)
			{
				System.out.println(line);
			}
			
			br.close();
			isr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
