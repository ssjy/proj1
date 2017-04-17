package oops;

/*// 부산여행 - 해운대, 광안리, 자갈치시장
     300        20     10        10
//춘천여행 - 소양강, 닭갈비, 춘천호, 
     200        10    20      30
//수원 여행 - 수원성, 수원역, 수원집, 수원강, 수원공항, 수원 운동장, 수원산
     200         10   10         5      15       10       20         10
//대전 여행 - 엑스포, 대전역, 대전강, 대전집, 대전산, 대전공항
                 5      7       5      10      20      15

//투어 일정 ---> 해운대,     춘천호,       수원집,  수원강,       대전역
                 20 + 300 +   30 +   200 +  5  +    15 +   200 +  7  
*/

class CityLogic{
	City [] citys;
	int currCity;//현재도시
	Place currPlace;//현재여행지
	
	void init(City [] citys)
	{
		this.citys = citys;
		currCity = 0;
		currPlace = null;
	}
	
	void travel(String place)
	{
		for(int i = currCity ; i<citys.length;i++)
		{
			for (int j = 0; j < citys[i].places.length; j++) {
				if(place==citys[i].places[j].name)
				{
					for (int k = currCity; k < i; k++) {
						City.totDist+=citys[k].cityDist;
					}
					City.totDist+=citys[i].places[j].dist;
					currCity = i;
					currPlace = citys[i].places[j];
				}
			}
		}
		
	}
	
	void print()
	{
		System.out.println(City.totDist);
	}
	
	
}

class City{
	
	static int totDist=0;
	
	Place [] places;
	String cityName;
	int cityDist;
	
	City init(String cityName,	int cityDist, Place [] places)
	{
		this.cityName = cityName;
		this.cityDist=cityDist;
		this.places = places;
		
		return this;
	}
}
class Place{
	String name;
	int dist;
	
	Place init(String name,	int dist)
	{
		this.name = name;
		this.dist=dist;
		
		return this;
	}
}

public class TravelMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		CityLogic logic = new CityLogic();
		logic.init(new City []{
				new City().init(
					"부산", 
					300, 
					new Place [] {
						new Place().init("해운대", 20),
						new Place().init("광안리", 10),
						new Place().init("자갈치", 10)}),
				new City().init(
					"춘천", 
					200, 
					new Place [] {
						new Place().init("소양강", 10),
						new Place().init("닭갈비", 20),
						new Place().init("춘천호", 30)}),
				
				 
				new City().init(
						"수원", 
						200, 
						new Place [] {
							new Place().init("수원성", 10),
							new Place().init("수원집", 10),
							new Place().init("수원역", 5),
							new Place().init("수원강", 15),
							new Place().init("수원공항", 10),
							new Place().init("수원 운동장", 20),
							new Place().init("수원산", 30)}),
				

				new City().init(
						"대전", 
						0, 
						new Place [] {
							new Place().init("엑스포", 5),
							new Place().init("대전역", 7),
							new Place().init("대전강", 5),
							new Place().init("대전집", 10),
							new Place().init("대전산", 20),
							new Place().init("대전공항", 15)})
			}
		
		
		 );
		     
		logic.travel("해운대");
		logic.travel("춘천호");
		logic.travel("수원집");
		logic.travel("수원강");
		logic.travel("대전역");
		
		logic.print();
	}

}
