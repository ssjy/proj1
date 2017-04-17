package threeOOPS;

class Music{
    String name;
    String [] music;

    void musiclisten(){
    	System.out.println(name+"을 들어요---------------------");
    	for (int i = 0; i < music.length; i++) {
    		System.out.println("재생곡["+i+"]: "+music[i]);
		}
    	System.out.println(name+" 재생 끝---------------------");
    }
    void radiolisten(String freq){
        System.out.println("라디오 "+freq+" 를 들어요");
    }
    void recording(String [] files){
    	System.out.println("녹음을 시작해요------------------------");
    	for (int i = 0; i < files.length; i++) {
    		System.out.println("녹음파일["+i+"]:"+files[i]);
		}
    	System.out.println("녹음을 종료해요------------------------");
    }
    void searching(int number){
    	if(0<=number && number<music.length)
    		System.out.println(name+"에서 " +music[number]+"을 찾아요");
    	else
    		System.out.println(name+"에서 " +number+"을 찾을 수 없습니다.");
    		
    }
    void deletion(String name){
    	
    	boolean chk = false;
    	for (int i = 0; i < music.length; i++) {
			if(name==music[i])
				chk = true;
		}
    	
    	if(chk)
    	{
    		String [] buf = new String[music.length-1];
    		int cnt=0;
    		for (int i = 0; i < music.length; i++) {
    			if(name!=music[i])
    			{
    				buf[cnt]=music[i];
    				cnt++;
    			}
			}
    		music = buf;
    		System.out.println(name+"음악을 삭제해요");
    	}
    	else
        System.out.println(name+"이 존재하지 않습니다.");
    }
}
 
public class MusicMain {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       Music MP3_1=new Music();
       Music MP3_2=new Music();
       Music MP3_3=new Music();
       
       MP3_1.name="Twice 1집";
       MP3_1.music=new String []{"TT","미쳤나봐"};
       MP3_2.name="AOA와 소녀시대";
       MP3_2.music=new String []{"GLB","심쿵해","Hoot"};
       MP3_3.name="홍진영";
       MP3_3.music=new String []{"월량대표아적심","엄지척"};
    
       MP3_1.musiclisten();
       MP3_1.radiolisten("파워FM");
       
       MP3_2.musiclisten();
       MP3_2.recording(new String[]{"할미새사촌","업무1","숨김파일1"});
       
       MP3_3.searching(0);
       MP3_2.deletion("심쿵해");
       MP3_2.musiclisten();
    }
}