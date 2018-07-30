package by.htp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Reader implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 2053488333778154190L;
private String name;
private String secondName;
private String surname;
private String login;
private String pass;
private int nunberReadBooks;
private String status;

private List<BookTransaction> takenBooks =new ArrayList<BookTransaction>();








public Reader(String name, String secondName, String surname, String login, String pass, int nunberReadBooks,
		String status, List<BookTransaction> takenBooks) {
	super();
	this.name = name;
	this.secondName = secondName;
	this.surname = surname;
	this.login = login;
	this.pass = pass;
	this.nunberReadBooks = nunberReadBooks;
	this.status = status;
	this.takenBooks = takenBooks;
}


public String getPass() {
	return pass;
}


public void setPass(String pass) {
	this.pass = pass;
}


public void setLogin(String login) {
	this.login = login;
}





public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}





public Reader() {
	super();
	// TODO Auto-generated constructor stub
}


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSecondName() {
	return secondName;
}
public void setSecondName(String secondName) {
	this.secondName = secondName;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}




public String getLogin() {
	return login;
}


public int getNunberReadBooks() {
	return nunberReadBooks;
}
public void setNunberReadBooks(int nunberReadBooks) {
	this.nunberReadBooks = nunberReadBooks;
}
public List<BookTransaction> getTakenBooks() {
	return takenBooks;
}
public void setTakenBooks(List<BookTransaction> takenBooks) {
	this.takenBooks = takenBooks;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((login == null) ? 0 : login.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + nunberReadBooks;
	result = prime * result + ((pass == null) ? 0 : pass.hashCode());
	result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	result = prime * result + ((surname == null) ? 0 : surname.hashCode());
	result = prime * result + ((takenBooks == null) ? 0 : takenBooks.hashCode());
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
	Reader other = (Reader) obj;
	if (login == null) {
		if (other.login != null)
			return false;
	} else if (!login.equals(other.login))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (nunberReadBooks != other.nunberReadBooks)
		return false;
	if (pass == null) {
		if (other.pass != null)
			return false;
	} else if (!pass.equals(other.pass))
		return false;
	if (secondName == null) {
		if (other.secondName != null)
			return false;
	} else if (!secondName.equals(other.secondName))
		return false;
	if (status == null) {
		if (other.status != null)
			return false;
	} else if (!status.equals(other.status))
		return false;
	if (surname == null) {
		if (other.surname != null)
			return false;
	} else if (!surname.equals(other.surname))
		return false;
	if (takenBooks == null) {
		if (other.takenBooks != null)
			return false;
	} else if (!takenBooks.equals(other.takenBooks))
		return false;
	return true;
}


@Override
public String toString() {
	return "Reader [name=" + name + ", secondName=" + secondName + ", surname=" + surname + ", login=" + login
			+ ", pass=" + pass + ", nunberReadBooks=" + nunberReadBooks + ", status=" + status + ", takenBooks="
			+ takenBooks + "]";
}

 
}
