package oops;
class SlamPlayer
{
	String name, pos;
	int jum;
	
	void init (String name, String pos,	int jum)
	{
		this.name = name;
		this.pos = pos;
		this.jum = jum;
	}
	
	void print()
	{
		String str = name+"\t"+pos+"\t"+jum;
		System.out.println(str);
		
	}
	
	
}
class SlamTeam
{
	String name;
	SlamPlayer [] players = new SlamPlayer [0];
	
	void add (String name, String pos,	int jum )
	{
		SlamPlayer [] buf = new SlamPlayer[players.length+1];
		
		for (int i = 0; i < players.length; i++) {
			buf[i] = players[i];
		}
		buf[players.length] = new SlamPlayer();
		
		buf[players.length].init(name, pos, jum);
		
		players = buf;
		
		
	}
}

class BestTeam
{
	
	SlamTeam bestPlayers(SlamTeam [] teams)
	{
		String [] pos = {"c","pf","sf","pg","sg"};
		
		SlamTeam res = new SlamTeam();
		
				
		for (int i = 0; i < pos.length; i++) {
			res.add("", pos[i],0);
			for(SlamTeam tt: teams)
			{
				for (int j = 0; j < tt.players.length; j++) {
					
					if(pos[i]==tt.players[j].pos 
							&& res.players[i].jum <tt.players[j].jum )
					{
						res.players[i] = tt.players[j];
					}
					
				}
			}
		}
		
		return res;
		
			
	}
	
	
	
	
}
public class SlamDunk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		SlamTeam bs = new SlamTeam();
		bs.name = "북산";
		bs.add("채치수", "c", 99);
		bs.add("정대만", "cg", 77);
		bs.add("송태섭", "pg", 88);
		bs.add("강백호", "pf", 88);
		bs.add("서태웅", "sf", 94);
		
		SlamTeam nn = new SlamTeam();
		nn.name = "능남";
		nn.add("변덕규", "c", 91);
		nn.add("윤대협", "pf", 99);
		nn.add("허태환", "pg", 73);
		nn.add("황태산", "pf", 77);
		nn.add("하상태", "sg", 30);
		
		SlamTeam hn = new SlamTeam();
		hn.name = "해남";
		hn.add("이정환", "pg",98);
		hn.add("신준섭", "sg",97);
		hn.add("전호장", "sf",87);
		hn.add("임현수", "sg",91);
		hn.add("고민구", "c",84);
		
		SlamTeam bp = new BestTeam().bestPlayers(
				new SlamTeam[]{bs, nn, hn});
		
		for(SlamPlayer sp : bp.players)
		{
			sp.print();
		}
	}

}
