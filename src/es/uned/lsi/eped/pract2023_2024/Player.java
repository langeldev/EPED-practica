package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class Player implements PlayerIF {
 
	private TuneCollection T;
	private PlayListManager plmanager;
	private PlayBackQueue pbQueue;
	private RecentlyPlayed rPlayed;
		
	 /* Constructor de la clase que implementa PlayerIF */
	 /* @param -una colección de canciones como un objeto TuneCollectionIF */
	 /* -un entero representando el número máximo de canciones */
	 /* reproducidas que se pueden almacenar */
	 Player(TuneCollectionIF T,int maxRecentlyPlayed){
		this.T = (TuneCollection) T;
		this.plmanager = new PlayListManager();
		this.pbQueue = new PlayBackQueue();
		this.rPlayed = new RecentlyPlayed(maxRecentlyPlayed);
	
	}

	@Override
	public ListIF<String> getPlayListIDs() {
		// TODO Auto-generated method stu
		return this.plmanager.getIDs();
	}

	@Override
	public ListIF<Integer> getPlayListContent(String playListID) {
		// TODO Auto-generated method stub
		PlayList pl = (PlayList) this.plmanager.getPlayList(playListID);
		return pl.getPlayList();
	}

	@Override
	public ListIF<Integer> getPlayBackQueue() {
		// TODO Auto-generated method stub
		return this.pbQueue.getContent();
	}

	@Override
	public ListIF<Integer> getRecentlyPlayed() {
		// TODO Auto-generated method stub
		return  this.rPlayed.getContent(); //this.rPlayed.getContent();
	}

	@Override
	public void createPlayList(String playListID) {
		// TODO Auto-generated method stub 
		this.plmanager.createPlayList(playListID);	
	}

	@Override
	public void removePlayList(String playListID) {
		// TODO Auto-generated method stub
		this.plmanager.removePlayList(playListID);
		
	}

	@Override
	public void addListOfTunesToPlayList(String playListID, ListIF<Integer> lT) {
		// TODO Auto-generated method stub
		PlayList pl = (PlayList) this.plmanager.getPlayList(playListID);
		pl.addListOfTunes(lT); 
	}

	@Override
	public void addSearchToPlayList(String playListID, String t, String a, String g, String al, int min_y, int max_y,
			int min_d, int max_d) {
		QueryIF query = new Query(t, a, g, al,min_y,max_y, min_d, max_d);
		ListIF<Integer> list = new List<>();
		int j= 1;
		for (int i = 0;  i < this.T.size(); i++) {
			if ((this.T.getTune(i)).match(query)) {
				list.insert(j++, i);
			}
		}
		addListOfTunesToPlayList(playListID, list);
	}

	@Override
	public void removeTuneFromPlayList(String playListID, int tuneID) {
		// TODO Auto-generated method stub
		PlayList pl = (PlayList) this.plmanager.getPlayList(playListID);
		pl.removeTune(tuneID); 
	}

	@Override
	public void addListOfTunesToPlayBackQueue(ListIF<Integer> lT) {
		// TODO Auto-generated method stub
		this.pbQueue.addTunes(lT);
	}

	@Override
	public void addSearchToPlayBackQueue(String t, String a, String g, String al, int min_y, int max_y, int min_d,
			int max_d) {
		QueryIF query = new Query(t, a, g, al,min_y,max_y, min_d, max_d);
		ListIF<Integer> list = new List<>();
		int j= 1;
		for (int i = 0;  i < this.T.size(); i++) {
			if ((this.T.getTune(i)).match(query)) {
				list.insert(j++, i);
			}
		}
		
		this.pbQueue.addTunes(list);
		
	}

	@Override
	public void addPlayListToPlayBackQueue(String playListID) {
		// TODO Auto-generated method stub
		PlayList pl = (PlayList) this.plmanager.getPlayList(playListID);
		this.pbQueue.addTunes(pl.getPlayList());
		
	}

	@Override
	public void clearPlayBackQueue() {
		this.pbQueue.clear();
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		if (!this.pbQueue.isEmpty()){
			this.rPlayed.addTune(this.pbQueue.getFirstTune());
			this.pbQueue.extractFirstTune();
		}
	}

}
