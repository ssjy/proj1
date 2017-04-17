package oops;

//총무부 - 사원명, 사원번호, 연봉
//웹부 - 사원명, 사원번호,연봉, 특기
//영업부 - 사원명, 사원번호, 실적건수
class OverSawon {
	String name, spec, depart;
	int num, money, sale;

	OverSawon init(String name, int num, int money) {
		depart = "총무부";
		init(name, num, money, 0, "");
		return this;
	}

	OverSawon init(String name, int num, int money, String spec) {
		depart = "웹부";
		init(name, num, money, 0, spec);
		
		return this;
	}

	OverSawon init(String name, int num, double sale) {
		depart = "영업부";
		init(name, num, 0, sale, "");
		
		return this;
	}
	
	void init(String name, int num, int money, double sale, String spec)
	{
		this.name = name;
		this.num = num;
		this.money = money;
		this.spec = spec;
		this.sale = (int) sale;
	}

	void print() {
		String str = 
				depart + "\t" + 
				name + "\t" +
				num + "\t" +
				money + "\t" +
				spec + "\t" + 
				sale;
		System.out.println(str);
	}
}

public class OverSawonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OverSawon [] os = {
				new OverSawon().init("춘주헌", 1, 5000),
				new OverSawon().init("하주헌", 2, 6000, "개그"),
				new OverSawon().init("추주헌", 3, 150.0),
				new OverSawon().init("동주헌", 4, 7000)
		};
		
		for(OverSawon oo : os)
		{
			oo.print();
		}
	}

}
