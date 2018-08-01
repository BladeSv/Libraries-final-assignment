package by.htp.entities;

import java.io.Serializable;

public class Autor implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = -3948939046148889299L;
private String name;
private String surname;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public Autor(String name, String surname) {
	super();
	this.name = name;
	this.surname = surname;
}
public Autor() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return ", autor: "+name+" " + surname ;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((surname == null) ? 0 : surname.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	Autor other = (Autor) obj;
	if (surname == null) {
		if (other.surname != null)
			return false;
	} else if (!surname.equals(other.surname))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}

	
}
