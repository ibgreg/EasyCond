# EasyCond
EasyCond – Sistema de Gestão de Condomínio


PREPARANDO O AMBIENTE NO QUAL O EASYCOND SERÁ INSTALADO 
(Vou fazer um Batch Script para dar uma automatizada nesses processos. 
Seria ideal se implementássemos um setup do aplicativo para instalar e configurar todos os pré-requisitos.)
-------------------------------------------------------

- Instalação do Apache Tomcat
  =>  Windows:    
    * Instalar o Apache Tomcat na raiz da partição C: do Windows
    
  => Linux (Ubuntu)
  
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

  => Windows
  => Linux (Ubuntu)
  
-------------------- //-------------------- //-------------------- //-------------------- //-------------------- //
    
