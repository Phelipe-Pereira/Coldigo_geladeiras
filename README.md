# Coldigo Geladeiras 🧊

## Sobre o Projeto
Sistema web desenvolvido para gerenciamento e apresentação da loja Coldigo Geladeiras, especializada em refrigeração desde 2007. O projeto inclui uma interface pública para clientes e uma área administrativa protegida.

## 🛠️ Tecnologias Utilizadas
* Java 11
* Jakarta Servlet 5.0
* Apache Tomcat 9.0.96
* Maven
* HTML5/CSS3/JavaScript

## 📁 Estrutura do Projeto
~~~
src/
  ├── main/
  │   ├── java/          # Backend Java
  │   ├── webapp/        # Frontend
  │   │   ├── pages/     
  │   │   │   ├── admin/ # Área Administrativa
  │   │   │   └── sites/ # Interface Pública
  │   │   ├── css/      
  │   │   ├── js/       
  │   │   └── imgs/     
  │   └── resources/    
  └── test/             
~~~

## 🚀 Como Executar
1. Certifique-se de ter instalado:
   * JDK 11+
   * Apache Tomcat 9.0.96
   * Maven 3.x

2. Clone o repositório:
~~~bash
git clone [url-do-repositório]
~~~

3. Compile o projeto:
~~~bash
mvn clean install
~~~

4. Deploy no Tomcat:
   * Deploy via IDE (recomendado para desenvolvimento)
   * Ou copie o WAR para a pasta webapps do Tomcat

## 📌 Endpoints
* **Interface Pública**: `/ProjetoTrilhaWebInte_war_exploded/`
* **Área Administrativa**: `/ProjetoTrilhaWebInte_war_exploded/pages/admin/`

## 🔧 Configuração de Desenvolvimento
* IDE recomendada: IntelliJ IDEA
* Configurar Tomcat na IDE
* Usar "war exploded" para desenvolvimento

## 📋 Funcionalidades
* Catálogo de produtos
* Gestão de estoque
* Área administrativa
* Sistema de contato
