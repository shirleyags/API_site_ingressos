package com.gft2.sitecasa.domain;

import java.io.Serializable;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity <ID extends Serializable> implements Serializable {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private ID code;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		AbstractEntity other = (AbstractEntity) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	public ID getCode() {
		return code;
	}

	public void setCode(ID code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "code = " + code;
	}
	
	
	
	
	
	
	

}
