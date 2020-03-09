package com.gft2.sitecasa.domain;

public enum Genero {
	
	SERTANEJO ("Sertanejo"),
	FORRO ("Forró"),
	SAMBA ("Samba"),
	PAGODE ("Pagode"),
	ROCK ("Rock"),
	AXE ("Axé");
	
	
	private String generoMusical;

	public String getGeneroMusical() {
		return generoMusical;
	}

	private Genero(String generoMusical) {
		this.generoMusical = generoMusical;
	}
	
	


}
