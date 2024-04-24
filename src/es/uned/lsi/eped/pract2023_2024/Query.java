package es.uned.lsi.eped.pract2023_2024;

public class Query implements QueryIF{
	private String title, author, genre, album;
	private int minYear, maxYear, minDuration, maxDuration; 
	public Query(String title, String author, String genre, String album, int minYear, int maxYear, int minDuration,
			int maxDuration) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.album = album;
		this.minYear = minYear;
		this.maxYear = maxYear;
		this.minDuration = minDuration;
		this.maxDuration = maxDuration;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getAuthor() {
		return this.author;
	}

	@Override
	public String getGenre() {
		return this.genre;
	}

	@Override
	public String getAlbum() {
		return this.album;
	}

	@Override
	public int getMin_year() {
		return this.minYear;
	}

	@Override
	public int getMax_year() {
		return 	this.maxYear;
	}

	@Override
	public int getMin_duration() {
		return this.minDuration ;
	}

	@Override
	public int getMax_duration() {
		return this.maxDuration;
	}

}
