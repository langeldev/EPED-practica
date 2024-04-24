package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class PlayListManager implements PlayListManagerIF{
	List<PlayList> pl;
	
	public PlayListManager() {
		this.pl = new List<>();
	}

	@Override
	public boolean contains(String playListID) {
		// TODO Auto-generated method stub
		
		return false;
	}


	/**
	 * Devuelve un listado de los identificadores de las listas 
	 */
	@Override
	public ListIF<String> getIDs() {
		// TODO Auto-generated method stub
		List<String> ls = new List<>(); 
		for(int i = 1; i <= this.pl.size(); i++) {
			ls.insert(i, pl.get(i).getPlayListID());
		}
		return ls;
	}
/**
 * Precondicion para crearla no debe existir
 */
	@Override
	public void createPlayList(String playListID) {
		// TODO Auto-generated method stub
		PlayList newPL = new PlayList(playListID);
		this.pl.insert(pl.size() + 1, newPL);
	}

	/**
	 * Eliminar 
	 * @Pre debe exisit 
	 */
	@Override
	public void removePlayList(String playListID) {
//		// TODO Auto-generated method stub
//		while(this.pl.iterator().hasNext()) {
//			if()
//		}
		for(int i =1; i <= this.pl.size(); i++) {
			if ((this.pl.get(i).getPlayListID()).equals(playListID)) {
				this.pl.remove(i);
			}
		}
	}

	@Override
	public PlayListIF getPlayList(String playListID) {
		// TODO Auto-generated method stub
		for(int i =1; i <= this.pl.size(); i++) {
			if ((this.pl.get(i).getPlayListID()).equals(playListID)) {
				return this.pl.get(i);
			}
		}
		//  no persiste datos 
		return new PlayList(playListID);
	}

}
