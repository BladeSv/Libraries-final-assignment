package by.htp.entities;

import java.io.Serializable;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5999267296876099822L;
	private static int id_count=0;
	private final int id;
	private String title;
	private Autor autor;
	private String annotation;
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
	
	public String getAnnotation() {
		return annotation;
	}
	public void setAnnotation(String anotation) {
		this.annotation = anotation;
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
	
	public static int getId_count() {
		return id_count;
	}
	public static void setId_count(int id_count) {
		Book.id_count = id_count;
	}

	
	
	public Book(int id, String title, Autor autor, String annotation, int numberOutput) {
		super();
		this.id = id;
		this.title = title;
		this.autor = autor;
		this.annotation = annotation;
		this.numberOutput = numberOutput;
	}
	public Book() {
		super();
		id_count++;
		this.id = id_count;
		// TODO Auto-generated constructor stub
	}
	public String toStringSneaky() {
		return "Book id: " + id + ", book title: " + title + autor;
	}
	@Override
	public String toString() {
		return "Book id: " + id + ", book title: " + title + autor + ", book annotation: " + annotation;
			
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annotation == null) ? 0 : annotation.hashCode());
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
		if (annotation == null) {
			if (other.annotation != null)
				return false;
		} else if (!annotation.equals(other.annotation))
			return false;
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
