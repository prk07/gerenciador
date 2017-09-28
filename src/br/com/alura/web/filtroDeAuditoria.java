package br.com.alura.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*")
public class filtroDeAuditoria implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		
		String requestURI = req.getRequestURI();
		
		String usuario = getUsuario(req);
		
		System.out.println("Usuario: "+usuario+" acessando a URI: "+requestURI);
		
		arg2.doFilter(arg0, arg1);
		
	}

	private String getUsuario(HttpServletRequest req) {
		String usuario = "Deslogado";

		Cookie[] cookies = req.getCookies();
		
		if(cookies == null) return usuario;
		
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("usuario.logado")){
				usuario = cookie.getValue();; 
			}
		}
		return usuario;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
