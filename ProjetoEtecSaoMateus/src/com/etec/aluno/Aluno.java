package com.etec.aluno;

public class Aluno {
	private String RM;
	private String nome;
	private String status;
	
	public Aluno () {
		
	}
	
	public Aluno(String rM, String nome, String status) {
		super();
		RM = rM;
		this.nome = nome;
		this.status = status;
	}

	public String getRM() {
		return RM;
	}
	public void setRM(String rM) {
		RM = rM;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
