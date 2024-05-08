package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class PlayList implements PlayListIF{
	
	private String playListID;
	private List<Integer> list;
	
	public PlayList(String playListID) {
		this.playListID = playListID;
		this.list = new List<>();
	}
	
	public String getPlayListID() {
		return this.playListID;
	}
	
	@Override
	public ListIF<Integer> getPlayList() {
		return this.list;
	}

	@Override
	public void addListOfTunes(ListIF<Integer> lT) {
		for (int i = 1; i<= lT.size(); i++) {
			this.list.insert(this.list.size() + 1, lT.get(i));
		}
	}

	@Override
	public void removeTune(int tuneID) {
		int pos = 1;
		while(pos <= this.list.size()) {
			if(this.list.get(pos) == tuneID) {
				list.remove(pos);
			}else {
				pos++;
			}
		}
	}

}
