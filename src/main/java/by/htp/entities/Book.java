package by.htp.entities;

public class Book {
	private static int id_count=0;
	private final int id;
	private String title;
	private Autor autor;
	private int numberOutput;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public int getNumberOutput() {
		return numberOutput;
	}
	public void setNumberOutput(int numberOutput) {
		this.numberOutput = numberOutput;
	}
	public int getId() {
		return id;
	}
	public Book(int id, String title, Autor autor, int numberOutput) {
		super();
		id_count++;
		this.id = id_count;
		this.title = title;
		this.autor = autor;
		this.numberOutput = numberOutput;
	}
	public Book() {
		super();
		id_count++;
		this.id = id_count;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", autor=" + autor + ", numberOutput=" + numberOutput + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + id;
		result = prime * result + numberOutput;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (id != other.id)
			return false;
		if (numberOutput != other.numberOutput)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
	
}
