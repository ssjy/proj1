 package object_p;
class Kanu{
   String name;
   int cnt;
   
   
   public Kanu(String name, int cnt) {
      super();
      this.name = name;
      this.cnt = cnt;
   }

   @Override
   public boolean equals(Object obj) {
      // TODO Auto-generated method stub
      return name.equals(((Kanu)obj).name);
   }

   @Override
   protected Object clone() throws CloneNotSupportedException {
      // TODO Auto-generated method stub
      return new Kanu(name, cnt);
   }
   
   @Override
   public String toString() {
      return "Kanu [name=" + name + ", cnt=" + cnt + "]";
   }
   
   
}
public class KanuMain {

   public static void main(String[] args) throws CloneNotSupportedException {
      // TODO Auto-generated method stub
      Kanu [] arr = {
            new Kanu("아메리카노", 1),
            new Kanu("아프리카노", 2),
            new Kanu("아메리카노", 1),
            new Kanu("러시아노", 3),
            new Kanu("아프리카노", 1)
      };
      
      Kanu [] 임종천 = new Kanu[0];
      
      for(Kanu kk: arr)                                /// 각 주문 내역 포문돌리기 시작
      {
         boolean chk = true; //chk 초기값 true로 초기화
         
         for(Kanu 버려: 임종천) // 임종천 포문 돌기 시작 -첫번쨰는 크기가 없으므로 안돌고 if문으로 넘어감
         {
            if(kk.equals(버려)) //주문내역과 버려가 같다면
            {
               버려.cnt+=kk.cnt; //버려의 갯수는 주문내역의 개수를 다 더한값
               chk=false;      //chk를 false로 대입해줌으로 for문 나감
            }
         }
         if(chk)    // chk가 true라면
         {
            Kanu [] 바꿔 = new Kanu[임종천.length+1]; // 바꿔라는 클래스생성(크기는 임종천길이+1)
            for (int i = 0; i < 임종천.length; i++) {  // 임종천의 길이만큼 돈다 -첫번째는 임종천이 안돔 두번쨰부터 돔
               바꿔[i] = 임종천[i]; //i의 순서에 맞게 바꿔에 임종천꺼 대입
            }
            바꿔[임종천.length]= (Kanu)kk.clone(); //바꿔[임종천길이번째] = 주문내역복제
            임종천 = 바꿔; // 바꿔의 값을 임종천 대입
         }
      }                                                  /// 여기까지 첫번째 for문 끝
      
      for(Kanu ret: 임종천) // 임종천 안의 객체를 하나씩 뽑아냄 - 당일 어떤메뉴를 얼마나 판매했는지 알 수 있음
      {
         System.out.println(ret); 
      }
  	System.out.println("------------------------");
	
	for(Kanu ret: arr) // 주문내역 뽑음
	{
		System.out.println(ret);
	}
   }

}