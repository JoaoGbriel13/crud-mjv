# API CRUD de Usuários

## Visão Geral

Este projeto contém uma API básica de CRUD (Create, Read, Update, Delete) para gerenciar dados de usuários. A API é construída utilizando o framework Spring Boot e segue uma estrutura padrão com um Controller, Service, ServiceImpl, Repository, DTO (Data Transfer Object) e a classe `UserModel`.

## Componentes

### 1. UserController

A classe `UserController` é responsável por lidar com solicitações HTTP relacionadas aos dados do usuário. Utiliza o `UserService` para executar a lógica de negócios necessária. Os endpoints disponíveis são:

- `GET /user/get-all`: Recuperar todos os usuários.
- `GET /user/all-by-age`: Recuperar usuários por idade.
- `GET /user/get-by-id`: Recuperar um usuário por ID.
- `POST /user/save-user`: Salvar um novo usuário.
- `PUT /user/update-user/{id}`: Atualizar um usuário existente.
- `DELETE /user/delete/{id}`: Excluir um usuário por ID.

### 2. UserService

A interface `UserService` define o contrato para gerenciar operações relacionadas ao usuário. É implementada por `UserServiceImpl`.

### 3. UserServiceImpl

A classe `UserServiceImpl` implementa a lógica de negócios especificada na interface `UserService`. Interage com o `UserRepository` para acesso a dados e realiza operações como criação, recuperação, atualização e exclusão de usuários.

### 4. UserDTO

A classe `UserDTO` (Data Transfer Object) representa a estrutura de dados para transferência de informações relacionadas ao usuário entre o cliente e o servidor. É usada no `UserController` para criar e atualizar usuários.

### 5. UserMapper

Uma classe de mapeamento (não mostrada aqui) pode ser implementada para converter entre a entidade `User` e `UserDTO` para uma conversão de dados eficiente.

### 6. UserRepository

A interface `UserRepository` define métodos para interações com o banco de dados relacionadas à entidade `User`. Ela estende o `JpaRepository` do Spring Data JPA para operações comuns de CRUD.

### 7. UserModel

A classe `UserModel` representa a entidade de usuário, que pode ser mapeada para a tabela correspondente no banco de dados.

## Uso

Para utilizar a API, faça solicitações HTTP aos endpoints especificados com parâmetros adequados. Certifique-se de que a aplicação esteja configurada corretamente e a conexão com o banco de dados esteja estabelecida.

Exemplo de uso:

```bash
curl -X GET http://localhost:8080/user/get-all
```

## Configuração

1. Clone o repositório.
2. Configure a conexão com o banco de dados no arquivo `application.properties`.
3. Execute a aplicação.

Sinta-se à vontade para estender e personalizar a funcionalidade com base nos requisitos específicos.
