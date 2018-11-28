package com.etec.managedBean;

import javax.faces.bean.ManagedBean;

import com.etec.DAO.AlunoDao;
import com.etec.aluno.Aluno;

@ManagedBean
public class AlunoMB {

	public Aluno aluno = new Aluno();
	
	public AlunoDao alunodao = new AlunoDao();

	
	public AlunoDao getAlunodao() {
		return alunodao;
	}
	public void setAlunodao(AlunoDao alunodao) {
		this.alunodao = alunodao;
	}


	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public String PesquisarAluno() {
		return "aluno";
	}
	
	
	public String TesteAluno() throws Exception {
		String teste = null;
		teste =  alunodao.readDataBase();
		return teste;
	}
	public String CadastrarAluno() throws Exception {
		String ok = "sucesso";
		ok = alunodao.InsertDataBase(aluno);
		return ok;
	}
	public String telaCadastro() {
		return "cadastro";
	}
	//Pesquisa Aluno pelo nome com query "like"

	public String pesquisar() throws Exception {
		
		aluno = alunodao.pesquisarAluno(aluno.getNome());
		return "visualizar";
		
	}
	
}
