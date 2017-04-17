package collection_p;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.TreeSet;

class Character
{
	String name, kind;
	LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
	public Character(String name, String kind, int level, int val, int freq) {
		super();
		this.name = name;
		this.kind = kind;
		map.put("레벨", level);
		map.put("가치", val);
		map.put("빈도", freq);
	}
	@Override
	public String toString() {
		return name + "\t" + kind + "\t" + map;
	}
	
}

class CharCom implements Comparator<Character>
{
	String kind;

	public CharCom(String kind) {
		super();
		this.kind = kind;
	}
	@Override
	public int compare(Character o1, Character o2) {
		// TODO Auto-generated method stub
		
		int res = o2.map.get(kind)-o1.map.get(kind);
		if(res==0) res=1;
		return res;
	}
}
public class GameCharacterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Character> data = new ArrayList<>();
		
		data.add(new Character("티모, ", "엘프", 10, 30, 30));
        data.add(new Character("쓰래쉬", "악당", 20, 40, 80));
        data.add(new Character("트페", "엘프", 30, 50, 90));
        data.add(new Character("리산드라", "악당", 40, 70,66));
        data.add(new Character("소나", "오크", 50, 80, 40));
        data.add(new Character("모르가나", "악당", 60, 30, 65));
        data.add(new Character("카르마", "몬스터", 70, 20, 12));
        data.add(new Character("퀸", "오크", 80, 60, 54));
        data.add(new Character("아리", "악당", 90, 90, 23));
        data.add(new Character("카르마", "몬스터", 22, 10, 87));
        data.add(new Character("킨드", "오크", 28, 10, 67));
        data.add(new Character("블리츠크랭크", "오크", 64, 10, 46));
        data.add(new Character("오리아나", "몬스터", 99, 10, 78));
        data.add(new Character("코그모", "엘프", 55, 10, 100));
        data.add(new Character("임종천", "몬스터", 66, 45, 89));
        data.add(new Character("김진향", "엘프", 87, 24, 78));
        data.add(new Character("추주헌", "몬스터", 33, 65, 67));
        data.add(new Character("민정훈", "오크", 11, 23, 40));
        data.add(new Character("김경환", "엘프", 5, 12, 30));
        
        String kind = "빈도";
        
        Iterator<Character> dit = data.iterator();
        TreeMap<String, TreeSet<Character>> map = new TreeMap<>();
        while(dit.hasNext())
        {
        	Character ch = dit.next();
        	
        	TreeSet<Character> nowSS = map.get(ch.kind);
        	
        	if(nowSS==null)
        		map.put(ch.kind, nowSS = new TreeSet<>(new CharCom(kind)));
        		
        	nowSS.add(ch);
        }
        
        Iterator<String> mit = map.keySet().iterator();
        
        while(mit.hasNext())
        {
        	String key = mit.next();
        	System.out.println(key+">>>>>>");
        	
        	Iterator<Character>sit = map.get(key).iterator();
        	
        	while(sit.hasNext())
        	{
        		System.out.println(sit.next());
        	}
        	
        }
	}

}
