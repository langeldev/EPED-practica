package es.uned.lsi.eped.pract2023_2024;

public class Tune implements TuneIF{
	 private String title, author, genre, album;
	 private int year, duration;
	 /* Constructor de la clase que implementa TuneIF */
	 /* @param -una cadena de caracteres con el título de la canción */
	 /* -una cadena de caracteres con el autor de la canción */
	 /* -una cadena de caracteres con el género de la canción */
	 /* -una cadena de caracteres con el álbum al que pertenece */
	 /* -un entero con el año de publicación de la canción */
	 /* -un entero con la duración en segundos de la canción */
	 /* @pre -t != "" && a != "" && g != "" && al != "" && y > 0 && d > 0 */
	 Tune(String t, String a, String g, String al, int y, int d){
		 this.title = t;
			this.author = a;
			this.genre = g;
			this.album = al;
			this.year = y;
			this.duration = d;
	 }

	@Override
	public boolean match(QueryIF q) {
		return (this.title.equalsIgnoreCase(q.getTitle()) || q.getTitle().equals(""))
			&& (this.author.equalsIgnoreCase(q.getAuthor()) || q.getAuthor().equals(""))
			&& (this.genre.equalsIgnoreCase(q.getGenre()) || q.getGenre().equals(""))
			&& (this.album.equalsIgnoreCase(q.getAlbum()) || q.getAlbum().equals(""))
			&& (this.year >= q.getMin_year())
			&& (this.year <= q.getMax_year() || q.getMax_year() == -1)
			&& (this.duration >= q.getMin_duration())
			&& (this.duration <=  q.getMax_duration() || (q.getMax_duration() == -1));
	}
}
 