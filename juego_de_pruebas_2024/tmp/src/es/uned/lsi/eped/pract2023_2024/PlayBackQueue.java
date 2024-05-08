package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.Queue;

public class PlayBackQueue implements PlayBackQueueIF{
	private Queue<Integer> queue;
	public PlayBackQueue() {
		this.queue = new Queue<>();
	}
	
	@Override
	public ListIF<Integer> getContent() {
		List<Integer> result = new List<Integer>();
		Queue<Integer> auxQueue = new Queue<>();	
		while (!this.queue.isEmpty())
		{
			result.insert(result.size() + 1, this.queue.getFirst());
			auxQueue.enqueue(this.queue.getFirst());
			this.queue.dequeue();
		}
		this.queue = auxQueue;
		return result;
	}

	@Override
	public boolean isEmpty() {
		return this.queue.isEmpty();
	}

	@Override
	public int getFirstTune() {
		return (int) this.queue.getFirst();
	}

	@Override
	public void extractFirstTune() {
		if (!this.queue.isEmpty()) {
			this.queue.dequeue();;		
		}		
	}

	@Override
	public void addTunes(ListIF<Integer> lT) {
		for (int i = 1; i <= lT.size(); i++ ) {
			this.queue.enqueue(lT.get(i));		
		}
	}

	@Override
	public void clear() {
		this.queue.clear();
	}

}
