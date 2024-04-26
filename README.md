# exercise_sysmatch
Automation exercise for presenting to Sysmatch

# README - Projeto de Testes API

## Descrição do Projeto
Este projeto de testes foi desenvolvido para testar as operações básicas em uma API RESTful que gere utilizadores, posts, comentários e tarefas (todos). Utiliza-se as seguintes operações CRUD (Create, Read, Update, Delete) e operações de busca de recursos aninhados.

## Recursos Disponíveis
1. Utilizadores (Users)
2. Posts
3. Comentários (Comments)
4. Tarefas (Todos)

## Endpoints da API
- https://gorest.co.in/public/v2/users
- https://gorest.co.in/public/v2/posts
- https://gorest.co.in/public/v2/comments
- https://gorest.co.in/public/v2/todos

## Operações Suportadas
1. **POST /public/v2/users**: Cria um novo utilizador.
2. **GET /public/v2/users/{Id_User}**: Obtém detalhes de um utilizador específico.
3. **PUT|PATCH /public/v2/users/{Id_User}**: Atualiza detalhes de um utilizador.
4. **DELETE /public/v2/users/{Id_User}**: Remove um utilizador.
5. **GET /public/v2/users/{Id_User}/posts**: Obtém posts de um utilizador.
6. **GET /public/v2/posts/{Id_Post}/comments**: Obtém comentários de um post.
7. **GET /public/v2/users/{Id_User}/todos**: Obtém tarefas de um utilizador.
8. **POST /public/v2/users/{Id_User}/posts**: Cria um post para um utilizador.
9. **POST /public/v2/posts/{Id_Post}/comments**: Cria um comentário para um post.
10. **POST /public/v2/users/{Id_User}/todos**: Cria uma tarefa para um utilizador.

## Ferramenta de Testes Utilizada
O projeto de testes foi desenvolvido utilizando o Katalon na versão 8.6.8. O Katalon oferece recursos robustos para automação de testes de API, permitindo a criação de scripts de teste eficientes e a execução de testes de forma automatizada.

## Instruções para Execução dos Testes
1. Certifique-se de ter o Katalon Studio instalado na sua máquina.
2. Faça o download deste projeto de testes.
3. Abra o Katalon Studio e importe o projeto.
4. Configure as variáveis de ambiente necessárias, como URL da API, chaves de autenticação, etc., conforme necessário.
5. Execute os testes individualmente ou em conjunto para validar o comportamento da API de acordo com os cenários definidos.

## Observações Adicionais
- Certifique-se de ter acesso à internet para executar os testes, pois eles dependem da comunicação com a API online.
- Mantenha as credenciais de acesso à API de forma segura e não compartilhe informações sensíveis no código-fonte do projeto.
- Caso a estrutura da API ou os endpoints sejam modificados, atualize os scripts de teste correspondentes para garantir a precisão dos testes.

---

# API Testing Project README

## Project Description
This testing project was developed to test basic operations on a RESTful API that manages users, posts, comments, and todos (tasks). It involves CRUD operations (Create, Read, Update, Delete) and nested resource retrieval operations.

## Available Resources
1. Users
2. Posts
3. Comments
4. Todos

## API Endpoints
- https://gorest.co.in/public/v2/users
- https://gorest.co.in/public/v2/posts
- https://gorest.co.in/public/v2/comments
- https://gorest.co.in/public/v2/todos

## Supported Operations
1. **POST /public/v2/users**: Creates a new user.
2. **GET /public/v2/users/{Id_User}**: Retrieves details of a specific user.
3. **PUT|PATCH /public/v2/users/{Id_User}**: Updates details of a user.
4. **DELETE /public/v2/users/{Id_User}**: Deletes a user.
5. **GET /public/v2/users/{Id_User}/posts**: Retrieves posts of a user.
6. **GET /public/v2/posts/{Id_Post}/comments**: Retrieves comments of a post.
7. **GET /public/v2/users/{Id_User}/todos**: Retrieves todos of a user.
8. **POST /public/v2/users/{Id_User}/posts**: Creates a post for a user.
9. **POST /public/v2/posts/{Id_Post}/comments**: Creates a comment for a post.
10. **POST /public/v2/users/{Id_User}/todos**: Creates a todo for a user.

## Testing Tool Used
The testing project was developed using Katalon Studio version 8.6.8. Katalon offers robust features for API testing, allowing the creation of efficient test scripts and automated test execution.

## Instructions for Test Execution
1. Ensure that Katalon Studio is installed on your machine.
2. Download this testing project.
3. Open Katalon Studio and import the project.
4. Configure necessary environment variables such as API URL, authentication keys, etc., as required.
5. Execute the tests individually or collectively to validate API behavior according to the defined scenarios.

## Additional Notes
- Ensure you have internet access to execute the tests as they rely on communication with the online API.
- Keep API access credentials secure and do not share sensitive information in the project source code.
- If the API structure or endpoints change, update the corresponding test scripts to ensure test accuracy.

This README should help guide anyone interested in executing or contributing to the testing project. Adapt it as needed to include more details or specific setup instructions.
