package Grafo;

import java.util.ArrayList;
import java.util.List;


public class Arista<T> {
	
	private Vertice<T> origin;
	private Vertice<T> end;
	
	
	public Arista() {
		
	}
	
	public Arista(Vertice<T> origin, Vertice<T> end) {
		super();
		this.origin = origin;
		this.end = end;
			
	}

	public Vertice<T> getOrigin() {
		return origin;
	}

	public void setOrigin(Vertice<T> origin) {
		this.origin = origin;
	}

	public Vertice<T> getEnd() {
		return end;
	}

	public void setEnd(Vertice<T> end) {
		this.end = end;
	}

	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
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
		Arista other = (Arista) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		return true;
	}

	

		
}
