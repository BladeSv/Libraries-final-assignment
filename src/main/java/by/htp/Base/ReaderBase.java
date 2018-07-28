package by.htp.Base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import by.htp.entities.Reader;

public class ReaderBase implements Serializable {
private List<Reader> readerBase =new ArrayList<Reader>();








public ReaderBase(List<Reader> readerBase) {
	super();
	this.readerBase = readerBase;
}

public ReaderBase() {
	super();
	// TODO Auto-generated constructor stub
}

public List<Reader> getReaderBase() {
	return readerBase;
}

public void setReaderBase(List<Reader> readerBase) {
	this.readerBase = readerBase;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((readerBase == null) ? 0 : readerBase.hashCode());
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
	ReaderBase other = (ReaderBase) obj;
	if (readerBase == null) {
		if (other.readerBase != null)
			return false;
	} else if (!readerBase.equals(other.readerBase))
		return false;
	return true;
}

@Override
public String toString() {
	return "ReaderBase [readerBase=" + readerBase + "]";
}


}
