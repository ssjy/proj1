package pac.pac1;

import pac.pac2.CCC;
//import pac.pac2.EEE;
import pac.pac2.*;
import pac.pac2.sub.*;

class AAA
{
	int a =10;
	private int b = 15;
	void meth()
	{
		System.out.println("pac1_AAA_meth():"+b);
	}
}

class ExtCCC extends CCC
{
	//int pb = b;
	//int pd = d;
	int pc = c;
}

public class PacMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AAA p1a = new AAA();
		BBB p1b = new BBB();
		pac.pac1.CCC p1c = new pac.pac1.CCC();
		CCC p2c = new CCC();
		EEE p1e = new EEE();
		pac.pac2.EEE p2e = new pac.pac2.EEE();
		pac.pac2.sub.FFF p2sf = new pac.pac2.sub.FFF();
		ExtCCC xc = new ExtCCC();
		
		System.out.println("p1a.a:"+p1a.a);
		//System.out.println("p1a.b:"+p1a.b);
		System.out.println("p1b.a:"+p1b.a);
		System.out.println("p1c.a:"+p1c.a);
		System.out.println("p2c.a:"+p2c.a);
		//System.out.println("p2c.b:"+p2c.b);
		System.out.println("p1e.a:"+p1e.a);
		System.out.println("p2e.a:"+p2e.a);
		System.out.println("xc.a:"+xc.a);
		//System.out.println("xc.b:"+xc.b);
		//System.out.println("xc.d:"+xc.d);
		//System.out.println("xc.c:"+xc.c);
		System.out.println("xc.pc:"+xc.pc);
		
		p1a.meth();
		p1b.meth();
		p1c.meth();
		p2c.meth();
		p1e.meth();
		p2e.meth();
		p2sf.meth();
		
		
		
	}

}


///// 외부에서 패키지를 생성하고  사용하세요

/// 외국(대만제) 핸드폰 부품
     /// - 카메라, 마이크, 배터리 
/// 국내(삼성) 핸드폰 생성 
    /// 만드는 회사 -삼성
    /// 핸드폰 - 갤럭시
/// 사진찍기, 전화하기, 터지기



