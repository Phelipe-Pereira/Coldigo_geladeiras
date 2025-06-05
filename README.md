# Projeto REST com Jakarta EE e Jersey

Este é um projeto de exemplo que demonstra a implementação de serviços REST usando Jakarta EE e Jersey.

## Tecnologias Utilizadas

- Java 11
- Jakarta EE 5.0
- Jersey 3.1.10
- Maven
- JUnit 5.9.2

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── projetotrilhawebinte/
│   │               └── rest/
│   └── webapp/
│       └── WEB-INF/
│           └── web.xml
```

## Configuração

O projeto utiliza Maven para gerenciamento de dependências. As principais dependências incluem:

- `jakarta.servlet-api`: API de Servlet do Jakarta EE
- `jersey-container-servlet`: Implementação do Jersey para Servlets
- `jersey-hk2`: Suporte a injeção de dependências
- `jersey-media-json-jackson`: Suporte a JSON

## Como Usar

1. Clone o repositório
2. Importe o projeto em sua IDE como um projeto Maven
3. Execute `mvn clean install` para baixar as dependências
4. Configure um servidor de aplicação (como Tomcat) em sua IDE
5. Deploy o projeto no servidor

## Endpoints REST

Os serviços REST estarão disponíveis no caminho base `/rest/*`. Por exemplo:
```
http://localhost:8080/ProjetoTrilhaWebInte/rest/
```

## Desenvolvimento

Para criar novos serviços REST:

1. Crie uma nova classe no pacote `com.example.projetotrilhawebinte.rest`
2. Use as anotações do Jakarta RS:
   - `@Path`: Define o caminho do recurso
   - `@GET`, `@POST`, `@PUT`, `@DELETE`: Define o método HTTP
   - `@Produces`: Define o tipo de conteúdo retornado
   - `@Consumes`: Define o tipo de conteúdo aceito

## Testes

O projeto inclui JUnit 5 para testes unitários. Os testes podem ser executados via Maven:

```bash
mvn test
```

## Licença

[Sua escolha de licença]

## Contribuição

[Instruções para contribuição]

---
Desenvolvido como parte do projeto de estudo do SENAI.
