package br.com.easycond.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SpringUtil {

	public static String obterUsuarioLogado() {
		Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
		String username =  auth.getName();
		
		return username;
	}
}
