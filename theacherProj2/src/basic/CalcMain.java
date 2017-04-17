package basic;
/*
 * 1항 연산자
 *   - : 음수표현 (숫자)
 *   ! : 부정 (boolean)
 *   ++,-- : 증감(1씩 증가, 감소) 
 *    전위처리 연산  ++변수 : 먼저 계산하여 변수에 입력
 *    후위처리 연산  변수++ : 변수 실행 후 ++ 연산
 * 
 * 
    <표기식>
    int x = a + b;
    param : a, b
    return : x

   2항 연산자
 * 
 *   2.1 산술   ---> 
     param  숫자형 or 문자열
     return 숫자형 or 문자열
 *    +,-,*,/,%
 *    문자열은 연산이 되지 않음 에러 --> 숫자만 가능
 *    단 + 는 문자열 사용시 문자열을 결합하는 연산자로 사용

 *   2.2 비교  ---> 
      param  숫자형  or 문자열
      return boolean (true,false)
 *    >  크다    초과
 *    >=  크거나 같다 이상  =가 같이 들어가는 경우 반드시 뒤에써야 한다
 *    <=  작거나 같다  이하    = 가 먼저 입력되는 경우 대입으로 인지
 *    <  작다    미만 
 *    ==  같다
 *    !=  다르다

 *   2.3 논리  ---> 
     param  boolean형
       return boolean (true,false)
 *    && - and (연산항이 모두 참일때 참)
 *    || -or (연산항 중 하나라도 참이면 참)
 *    ^ -xor (연산항의 값이 다를때만 참)   
 *    Boolean을 연산항으로 사용

 * 2.4 shift 비트 연산 ----> 
     param  숫자형
     return 2진 자리이동
 *    x<<n  정수x를 n비트 왼쪽으로 이동 오른쪽은 0으로 채움

      x>>n  정수x를 n비트 오른쪽으로 이동    오른쪽은 양수 :0, 음수:1로 채움

     x>>>n 정수x를 n비트 오른쪽으로 이동    오른쪽은 0으로 채움
 

 * 2.5 비트 연산 ---->
           param  숫자형
           return 숫자형
         a:1110₂    14
         b:0101₂     5
         
       &   0100
       |   1111
       ^   1011
         
         c=a&b=0100₂   4
         c=a|b=1111₂   15
         c=a^b=1011₂   11


   215   --> 0 1101 0111
   432   --> 1 1011 0000
---------------------------------
         &   0 1001 0000   --> 144
         |   1 1111 0111   --> 503
         ^   1 0110 0111   --> 359

2.7  대입연산자
param = 숫자형

return => 숫자형

연산자
설명
예
왼쪽예의 변수값
=
데이터를 저장(대체)
a = 4
4
+=
변수에 더하기또는 문자열을 연결한 값을 대입
a +=2
a +='건강합니다'('나는')
a값이 4일경우6
나는 건강합니다
-=
변수에 뺀 값을 대입
a -=2
a 값이 4인경우 2
*=
변수에 곱한 값을 대입
a *=2
a 값이 4인경우 8
/=
변수에 나눈값을 대입
a /=2
a 값이 4인 경우 2
%=
변수에 나머지 값을 대입
a %=2
a 값이 4인 경우 0
 

 * 
 * 3항 연산자 ---> if문 
 *   조건 ?  참일때 값  : 거짓일때 값
 *   
 *   조건은 boolean 형으로 결과가 유추되야 함
 *   조건이 true -> 참일때 값
 *   조건이 false -> 거짓일때 값
 * 
 * 
 * 형변환 --> 형변환은 아무거나 되는 것이 아닌 변형가능한 자료형만 된다
 *           숫자 <--> 숫자,  char <--> int  char의 숫자값이 있어 int형으로 가능
 *    
 *   묵시적 형변환
 *   : 연산과정에서 자신과 연산되는 자료형으로 결과를 바꾸어 놓는 형변환
 * 
 *   명시적 형변환
 *   : 묵시적 형변환을 피하기 위해 계산되는 과정전에 일시적으로 형을 변환
 *      (자료형)값;  형태로 변환
 * 
 */
public class CalcMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		/*2항 연산자
		 * 
		 *   2.1 산술   ---> 
		     param  숫자형 or 문자열
		     return 숫자형 or 문자열
		 *    +,-,*,/,%
		 *    문자열은 연산이 되지 않음 에러 --> 숫자만 가능
		 *    단 + 는 문자열 사용시 문자열을 결합하는 연산자로 사용*/
		
		int x2 = 14, y2 = 5;
		String str1 = "추주헌", str2 = "김진향";
		
		System.out.println(x2+y2);
		System.out.println(x2-y2);
		System.out.println(x2*y2);
		System.out.println(x2/y2);
		System.out.println(x2%y2);
		
		System.out.println(str1+str2);
		System.out.println(x2+y2+str1);
		System.out.println(str1+x2+y2);
		//                "추주헌14" + 5 =>"추주헌145" 
		System.out.println(1+x2);
		System.out.println('1'+x2);
		System.out.println("1"+x2);
		
		System.out.println(x2+" + "+y2+" = "+(x2+y2));
		System.out.println(x2+" - "+y2+" = "+(x2-y2));
		System.out.println(x2+" * "+y2+" = "+x2*y2);
		System.out.println(x2+" / "+y2+" = "+(x2/y2));
		System.out.println(x2+" % "+y2+" = "+(x2%y2));
		/*
		 * 14 + 5 = 19
		 * 14 - 5 = 9
		 * 14 * 5 = 70
		 * 14 / 5 = 2
		 * 14 % 5 = 4
		 * System.out.println(str1-str2);
		System.out.println(str1*str2);
		System.out.println(str1/str2);
		System.out.println(str1%str2);
		
		**   2.2 비교  ---> 
      param  숫자형  or 문자열
      return boolean (true,false)
 *    >  크다    초과
 *    >=  크거나 같다 이상  =가 같이 들어가는 경우 반드시 뒤에써야 한다
 *    <=  작거나 같다  이하    = 가 먼저 입력되는 경우 대입으로 인지
 *    <  작다    미만 
 *    ==  같다
 *    !=  다르다
		*
		*/
		int x3 = 20, y3 = 35;
		
		System.out.println(x3+" > "+y3+" = "+(x3>y3));
		System.out.println(x3+" >= "+y3+" = "+(x3>=y3));
		System.out.println(x3+" <= "+y3+" = "+(x3<=y3));
		System.out.println(x3+" < "+y3+" = "+(x3<y3));
		System.out.println(x3+" == "+y3+" = "+(x3==y3));
		System.out.println(x3+" != "+y3+" = "+(x3!=y3));
		/*
		System.out.println(x3>=y3);
		System.out.println(x3<=y3);
		System.out.println(x3<y3);
		System.out.println(x3==y3);
		System.out.println(x3!=y3);*/
		System.out.println();
		System.out.println(str1==str2);
		System.out.println(str1!=str2);
		
/*		*   2.3 논리  ---> 
	     param  boolean형
	       return boolean (true,false)
	 *    && - and (연산항이 모두 참일때 참)
	 *    || -or (연산항 중 하나라도 참이면 참)
	 *    ^ -xor (연산항의 값이 다를때만 참)   
	 *    Boolean을 연산항으로 사용
*/
		System.out.println();
		boolean x4 = false, y4 = false;
		System.out.println(x4 && y4);
		System.out.println(x4 || y4);
		System.out.println(x4 ^ y4);
		
		int money = 300, height = 190;
		
		//boolean mmChk = money >=1000;
		//boolean hhChk = height>= 185;
		
		System.out.println("And:"+(money >=1000 && height>= 185));
		/*System.out.println("Or:"+(mmChk || hhChk));
		System.out.println("Xor:"+(mmChk ^ hhChk));*/
		
		boolean x5 = false;
		String res = x5 ? "난 참이지롱" : "난 거짓이지롱";
		System.out.println(res);
		
		boolean marry = money >=1000 && height>= 185;
		String mmStr = marry ? "결혼가능합니다.":"혼자사는 것도...";
		
		System.out.println(mmStr);
		
		int jum =98;
		
		
		String grade =
				//jum >=70 ? "미":
				jum >=90 ? "수": 
				jum >=80 ? "우":
				jum >=70 ? "미":
				jum >=60 ? "양":
					"가";
		
		System.out.println(grade);
		
		
		
		/** 1항 연산자
		 *   - : 음수표현 (숫자)
		 *   ! : 부정 (boolean)
		 *   ++,-- : 증감(1씩 증가, 감소) 
		 *    전위처리 연산  ++변수 : 먼저 계산하여 변수에 입력
		 *    후위처리 연산  변수++ : 변수 실행 후 ++ 연산*/
		
		int x1 = 24;
		boolean bo1 = true;
		System.out.println(-x1);
		System.out.println(!bo1);
		
		//x1 = x1 +1;
		x1++;
		System.out.println(x1);
		System.out.println(++x1);
		System.out.println(x1);
		System.out.println(--x1);
		//System.out.println(x1**);
		//System.out.println(x1//);
		
		int a=5, b = 6, c = 10, d;
		
		d = a++ + ++c - b-- * --a + a++;
		
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		System.out.println("c:"+c);
		System.out.println("d:"+d);
		
		int x6 = 23;
		System.out.println(x6<<2);
		System.out.println(92>>2);
		System.out.println(92>>>2);
		
		System.out.println(-23<<2);
		System.out.println(-92>>2);
		System.out.println(-92>>>2);
		
		
		int aaa = 300;
		byte bbb = (byte)aaa;
		// -128,-127, ~ -1,0,1,2~ 125,126,127
		// 0,1,2~ 125,126,127,-128,-127, ~ -1
		System.out.println(bbb);
		
		System.out.println(14&5);
		System.out.println(14|5);
		System.out.println(14^5);
		//1110
		//0101
		//& : 0100 
		
		int x7 = 10;
		//x7 = x7 + 5;
		//x7 += 5;
		System.out.println(x7 += 5);
		System.out.println(x7 -= 3);
		System.out.println(x7 *= 2);
		System.out.println(x7 /= 3);
		System.out.println(x7 %= 5);
		//System.out.println(x7 += "퓨퓨퓨퓨퓨전");
		String str3 = "퓨퓨퓨퓨퓨전";
		//System.out.println(x7 += str3);
		System.out.println(str3 += x7);
		
		
	}

}
