package util_p;

import java.util.regex.Pattern;

/*1. ¾ÆÀÌµğ : ¿µ¹®´ë¹®ÀÚ¼Ò¹®ÀÚ ¼ıÀÚ Æ¯¼ö±âÈ£ Á¶ÇÕ
2. »çÁø Ã·ºÎ-->¿µ¹®,¼ıÀÚ.ÀÌ¹ÌÁö È®ÀåÀÚ
ÀÌ¹ÌÁö(jpg, jpeg, bmp, png, gif)  --  ´ë¼Ò¹®ÀÚ ±¸ºĞ¾øÀ½
3. ¿ìÆí¹øÈ£ °Ë»ö - ±¸´ÜÀ§ (ÃÊ¼º°Ë»ö)*/
public class RegisterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			String [] pp = {".*[a-z].*",".*[A-Z].*",".*[0-9].*",".*[_.].*"};
			String tot = "[a-zA-Z0-9_.]*";
			
			String id = "abA_cd123";
			
			boolean idChk = false;
			if(!Pattern.matches(tot, id))
			{
				idChk = true;
			}else{
				for(String ppp: pp)
				{
					if(!Pattern.matches(ppp, id))
						idChk = true;
				}
			}
			
			if(idChk) throw new Exception("id ¿¡·¯");
			
			String ff = "fefef.jpg";
			
			if(!Pattern.matches(".*\\.(jpg|png|gif|bmp)", ff.toLowerCase()))
				throw new Exception("ÆÄÀÏ ¿¡·¯");
			
			
			
			String [][] zipStr = {
					{"¤¡","°¡-ƒ‰"},
					{"¤¤","³ª-ˆ¢"},
					{"¤§","´Ù-‹L"},
					{"¤©","¶ó-¡"},
					{"¤±","¸¶-“J"},
					{"¤²","¹Ù-•½"},
					{"¤µ","»ç-šï"},
					{"¤·","¾Æ-Ÿç"},
					{"¤¸","ÀÚ-£ "},
					{"¤º","Â÷-¯†"},
					{"¤»","Ä«-µi"},
					{"¤¼","Å¸-»M"},
					{"¤½","ÆÄ-À˜"},
					{"¤¾","ÇÏ-ÆR"},
					{"¤³","ºü-˜ª"},
					{"¤¹","Â¥-Âö"},
					{"¤¨","µû-ê"},
					{"¤¢","±î-…ù"},
					{"¤¶","½Î-Ï"},
			};
			
			String [] qq = {
					"°­³²±¸","ºĞ´ç±¸","³ë¿ø±¸","¸¶Æ÷ºÎ",
					"±¸³ë±¸","¹Ù´Ù±¸","³ëÀÎ±¸"
					
			};
			
			String gu = "¤¡¤¤";
			
			String guReg =".*";
			
			for (int i = 0; i < gu.length(); i++) {
				
				for(String [] zip: zipStr)
				{
					if((gu.charAt(i)+"").equals(zip[0]))
						guReg+="["+zip[1]+"]";
				}
			}
			guReg+=".*";
			
			for(String qqq : qq)
			{
				if(Pattern.matches(guReg, qqq))
					System.out.println(qqq);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
