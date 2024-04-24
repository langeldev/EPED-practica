package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class RecentlyPlayed implements RecentlyPlayedIF{
	private List<Integer> list;
	private int maxRecentlyPlayed;
	
	public RecentlyPlayed(int maxRecentlyPlayed)
	{
		this.list = new List<>() ;
		this.maxRecentlyPlayed = maxRecentlyPlayed;
	}
	
	@Override
	public ListIF<Integer> getContent() {
		List<Integer> result =new List<>();
		int j = 1;
		for (int i =  this.list.size();i >= 1; i--) {
			result.insert(j++ ,this.list.get(i));
		}
		return result ;
	}

	@Override
	public void addTune(int tuneID) {
		this.list.insert(this.list.size()+ 1 ,tuneID);
		if (this.list.size() > this.maxRecentlyPlayed) {
			this.list.remove(1);
		}		
	}

}
