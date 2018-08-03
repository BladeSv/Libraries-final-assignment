package by.htp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reader implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 2053488333778154190L;
	private static int id_count=0;
	private final int id;
	private String name;
	private String secondName;
	private String surname;
	private String login;
	private String pass;

	private String status;
	private String phoneNumber;
	private List<BookTransaction> takenBooks = new ArrayList<BookTransaction>();
	private List<GregorianCalendar> returnBooke=new ArrayList<GregorianCalendar>();

	public Reader() {
		super();
		id_count++;
		this.id = id_count;

	
	}
	public Reader(int id,String name, String secondName, String surname, String login, String pass, String status,
			String phoneNumber, List<BookTransaction> takenBooks, List<GregorianCalendar> returnBooke) {
		super();
		
		this.id = id;
		this.name = name;
		this.secondName = secondName;
		this.surname = surname;
		this.login = login;
		this.pass = pass;
		this.status = status;
		this.phoneNumber = phoneNumber;
		this.takenBooks = takenBooks;
		this.returnBooke = returnBooke;
	}
	public Reader(String name, String secondName, String surname, String login, String pass, String status,
			String phoneNumber, List<BookTransaction> takenBooks, List<GregorianCalendar> returnBooke) {
		super();
		id_count++;
		this.id = id_count;
		this.name = name;
		this.secondName = secondName;
		this.surname = surname;
		this.login = login;
		this.pass = pass;
		this.status = status;
		this.phoneNumber = phoneNumber;
		this.takenBooks = takenBooks;
		this.returnBooke = returnBooke;
	}

	public static int getId_count() {
		return id_count;
	}

	public static void setId_count(int id_count) {
		Reader.id_count = id_count;
	}

	public int getId() {
		return id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<GregorianCalendar> getReturnBooke() {
		return returnBooke;
	}

	public void setReturnBooke(List<GregorianCalendar> returnBooke) {
		this.returnBooke = returnBooke;
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
		result = prime * result + id;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((returnBooke == null) ? 0 : returnBooke.hashCode());
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
		if (id != other.id)
			return false;
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
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (returnBooke == null) {
			if (other.returnBooke != null)
				return false;
		} else if (!returnBooke.equals(other.returnBooke))
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
		return "Reader id: "+id+" " + surname + " " + name + " " + secondName + ", login: " + login + ", pass: " + pass
				+ ", phone number: " + phoneNumber + ", number read books:" + returnBooke.size() + ", number taken books:"
				+ takenBooks.size();
	}

}
