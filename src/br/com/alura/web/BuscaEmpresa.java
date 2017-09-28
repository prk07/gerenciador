package br.com.alura.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

import java.util.Collection;

public class BuscaEmpresa implements Tarefa {
	
	public BuscaEmpresa() {
		System.out.println("Construindo uma servlet do tipo BuscaEmpresa " + this);
	}	

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String filtro = req.getParameter("filtro");		
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);		
		req.setAttribute("empresas", empresas);										
		return "/WEB-INF/paginas/buscaEmpresas.jsp";
	}
}
