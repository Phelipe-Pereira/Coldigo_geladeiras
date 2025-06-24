# Projeto REST - COLDIGO Geladeiras

Este projeto é um sistema web completo para cadastro, consulta, edição e exclusão de produtos e marcas, utilizando Java, Jakarta EE, Jersey e banco de dados relacional. Desenvolvido como parte do estudo de desenvolvimento web no SENAI.

## Tecnologias Utilizadas

- Java 11+
- Jakarta EE 5.0
- Jersey 3.1.10
- Maven
- JUnit 5
- Apache Tomcat 9+
- Banco de Dados Relacional (ex: MySQL, PostgreSQL)
- HTML, CSS, JavaScript (jQuery)

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/example/projetotrilhawebinte/
│   │       ├── db/           # Conexão com banco de dados
│   │       ├── jdbc/         # DAOs JDBC
│   │       ├── jdbcinterface/# Interfaces DAO
│   │       ├── modelo/       # Modelos de domínio
│   │       └── rest/         # Serviços REST
│   └── webapp/
│       ├── css/              # Estilos
│       ├── js/               # Scripts JavaScript
│       ├── pages/            # Páginas JSP/HTML
│       └── WEB-INF/          # Configurações web.xml
└── test/                     # Testes unitários
```

## Configuração e Execução

1. **Clone o repositório:**
   ```bash
   git clone <url-do-repositorio>
   ```
2. **Importe o projeto na sua IDE** como um projeto Maven.
3. **Configure o banco de dados** (crie as tabelas `marcas` e `produtos` conforme o modelo relacional utilizado).
4. **Ajuste as configurações de conexão** no código, se necessário.
5. **Execute o comando:**
   ```bash
   mvn clean install
   ```
6. **Configure o Tomcat** (ou outro servidor compatível) e faça o deploy do arquivo WAR gerado.
7. **Acesse a aplicação:**
   - Área administrativa: `http://localhost:8080/ProjetoTrilhaWebInte/pages/admin/`
   - Endpoints REST: `http://localhost:8080/ProjetoTrilhaWebInte/rest/`

## Endpoints REST Principais

- `/rest/produto/buscar`         - Buscar produtos
- `/rest/produto/inserir`        - Inserir novo produto (POST)
- `/rest/produto/alterar`        - Alterar produto (PUT)
- `/rest/produto/excluir/{id}`   - Excluir produto (DELETE)
- `/rest/marca/buscar`           - Buscar marcas
- `/rest/marca/inserir`          - Inserir nova marca (POST)
- `/rest/marca/alterar`          - Alterar marca (PUT)
- `/rest/marca/excluir/{id}`     - Excluir marca (DELETE)

## Testes

Os testes unitários podem ser executados via Maven:
```bash
mvn test
```

## Licença

Este projeto é de uso educacional e está sob a licença [escolha sua licença, ex: MIT, Apache 2.0, etc.].

---
Desenvolvido como parte do projeto de estudo do SENAI.
