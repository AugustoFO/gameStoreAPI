# Loja de Games - Backend com Spring

Este é o backend de uma aplicação para uma loja de games, desenvolvida com Spring Boot. O sistema permite o gerenciamento de produtos classificados por categorias, com operações de CRUD (Create, Read, Update, Delete) para Produto e Categoria.

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal para o desenvolvimento do backend.
- **JPA (Java Persistence API)**: Para interação com o banco de dados.
- **Spring Data JPA**: Para simplificar a implementação de repositórios.
- **Banco de Dados**: Configurado no `application.properties` (por exemplo, H2, MySQL, etc).
- **Insomnia**: Para testar os endpoints da API.

## Estrutura do Projeto

- **Model**: Contém as classes `Produto`(Classe mãe abstrata), `ProdutoDigital` e `ProdutoFisico`(Classe filhas concretas), além da `Categoria`, que representam os dados que serão manipulados.
- **Repository**: Interface que contém os métodos para interagir com o banco de dados.
- **Controller**: Controladores que expõem os endpoints REST para manipulação das entidades.

## Endpoints da API

### **Categorias**
- **POST /categoria**: Cria uma nova categoria.
- **GET /categoria**: Retorna todas as categorias.
- **GET /categoria/{id}**: Retorna uma categoria específica por ID.
- **PUT /categoria/{id}**: Atualiza uma categoria existente.
- **DELETE /categoria/{id}**: Deleta uma categoria por ID.
- **GET /categoria/nome/{nome}**: Retorna categorias filtradas por nome.

### **Produtos**
- **POST /produto/digital**: Cria um novo produto digital.
- **POST /produto/fisico**: Cria um novo produto físico.
- **GET /produto**: Retorna todos os produtos.
- **GET /produto/digital**: Retorna todos os produtos digitais.
- **GET /produto/fisico**: Retorna todos os produtos físicos.
- **GET /produto/{id}**: Retorna um produto específico por ID.
- **PUT /produto/digital/{id}**: Atualiza um produto digital.
- **PUT /produto/fisico/{id}**: Atualiza um produto físico.
- **DELETE /produto/{id}**: Deleta um produto por ID.
- **GET /produto/nome/{nome}**: Retorna produtos filtrados por nome.

## Relacionamento

O projeto implementa um relacionamento **One-to-Many** entre `Categoria` e `Produto`. Ou seja, uma categoria pode ter vários produtos associados a ela.

## Configuração do Banco de Dados

A configuração do banco de dados está presente no arquivo `application.properties`. Você pode configurar o banco de dados conforme a necessidade:

```properties
# Configuração para H2 (para testes em memória)
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
