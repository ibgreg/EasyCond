# EasyCond – Sistema de Gestão de Condomínio
Este é o repositório do sistema EasyCond. O projeto tem como objetivo facilitar a gestão administrativa e financeira de condomínios para os administradores, síndicos e condôminos, através de um sistema WEB com interface responsiva para PCs e dispositivos móveis. Além de contar com as principais funcionalidades essenciais para gestão do condomínio (quadro de avisos, reserva de espaços, registro de visitantes e entre outros), o principal diferencial do projeto é o sistema de assembleia online. Através dele, os sindicos podem cadastrar as pautas a serem discutidas e através de um sistema de votação de enquete os condôminos vão votar e dar os seus comentários e/ou sugestões para chegar a uma conclusão de forma rápida.
<br/>
<br/>
<strong>Recursos utilizados:</strong>
<br/>
<br/>
<ul>
  <li>Java v1.8</li>
  <li>JSF v2.2</li>
  <li>Hibernate v4.3.6</li>
  <li>MySQL Server v5.6</li>
  <li>Spring Framework v3.2.6</li>
  <li>PrimeFaces v6.1</li>
  <li><a href="http://archives.materializecss.com/0.100.2/">Materialize CSS v0.100.2 (apenas para a tela de login)</a></li>
  <li><a href="https://github.com/algaworks/layout-primefaces-patagonia">Layout Patagonia (layout gratuito para o PrimeFaces desenvolvido pela AlgaWorks)</a></li>
</ul>

PREPARANDO O AMBIENTE NO QUAL O EASYCOND SERÁ INSTALADO
-------------------------------------------------------

- Instalação do Apache Tomcat
  =>  Windows:    
    * Instalar o Apache Tomcat na raiz da partição C: do Windows
    
  => Linux (Ubuntu)
    * Instalar o Apache Tomcat no diretório /var/local/
-------------------- //-------------------- //-------------------- //-------------------- //-------------------- //  

- Instalação do Java
  => Windows
  => Linux (Ubuntu)
  
-------------------- //-------------------- //-------------------- //-------------------- //-------------------- //  

- Variáveis de ambiente 
  => Windows:
    * Criar e definir a variável de ambiente do sistema CATALINA_HOME para o caminho do diretório de instalação do Apache Tomcat
    * Criar e definir a variável de ambiente do sistema JAVA_HOME para o caminho do diretório de instalação do JDK
    
  => Linux (Ubuntu)
    * Definir a variável de ambiente CATALINA_HOME adicionando ao final do arquivo 'profile' localizado no diretório \etc\ o seguinte comando: export CATALINA_HOME=[caminho do diretório de instalação do apache tomcat]
    * Definir a variável de ambiente JAVA_HOME adicionando ao final do arquivo 'profile' o seguinte comando: export CATALINA_HOME=[caminho do diretório de instalação do JDK]
  
 -------------------- //-------------------- //-------------------- //-------------------- //-------------------- //   
    
- Instalação do Apache Tomcat Service
  =>  Windows:    
    * Através do CMD do Windows, acessar o pasta bin do diretório de instalação do Apache Tomcat pelo comando 
    'cd %CATALINA_HOME%\bin'
    * Executar o comando 'service install'
    * Se tudo correr bem, será exibida a mensagem 'The service 'Tomcat' has been installed.'  
    
  => Linux (Ubuntu)
  
 -------------------- //-------------------- //-------------------- //-------------------- //-------------------- //   
   
- Instalação do MySQL Server

  * Para ambas as plataformas, fazer o download do MySQLServer e instalá-lo
  
-------------------- //-------------------- //-------------------- //-------------------- //-------------------- //
    
