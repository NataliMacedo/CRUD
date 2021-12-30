## Documentação

Bem vindo! Esta documentação deve ajudá-lo a se familiarizar com os recursos disponíveis na API CRUD, que tem por objetivo realizar o cadastro de pessoas. Ela foi desenvolvida em Java, utilizando Micronaut e Maven.

## Recursos

- URL base

A URL base é a URL raiz de toda a API, se você fizer uma solicitação e receber de volta uma resposta 404 NÃO ENCONTRADA , verifique a URL base primeiro. A URL base para a API CRUD é: https://crudpessoaqa.herokuapp.com/person . Ao acessar a URL base é possível obter as informações sobre todas as pessoas cadastradas na API.

- Pessoa

O recurso pessoa é um indivíduo com dados únicos a ser cadastrado.

Endpoints:

GET - "/" : Lista todas as pessoas cadatradas na API CRUD. Seu status é 200, OK. Caso nenhuma pessoa tenha sido cadastrada, retorna lista vazia.

GET - "/id": Obtem os dados da pessoa de id informado. Seu status code é 200, OK. Caso o id informado não pertença a nenhuma pessoa cadastrada, o status retornado deve ser 404 Not Found.

POST - "/" + body : Realiza a inclusão da pessoa quando os dados informados são corretos, seu status é 201 Created. Caso os dados apresentem alguma informação incorreta, a pessoa não é cadastrada e o status será 400 Bad Request. 

PUT - "/id" + body: Atualiza os dados da pessoa de id informado. Seu status code é 200, OK. Caso o id informado não pertença a nenhuma pessoa cadastrada, o status retornado deve ser 404 Not Found.

DELETE - "/id": Exclui a pessoa de id informado. Seu status code é 204, No Content. Caso o id informado não pertença a nenhuma pessoa cadastrada, o status retornado deve ser 404 Not Found.

Atributos:

    -   id : identificador único, do tipo Long, gerado automaticamente para cada pessoa cadastrada.
    -   name: do tipo String, é obrigatório ser informado no momento do cadastro,  
    -   age:  do tipo int, é obrigatório ser informado no cadastro com valor acima de 0.
    -   cpf:  do tipo String, é obrigatório ser informado de maneira única tanto no momento do cadastro quanto na atualização.

Mais informações podem ser consultadas no arquivo: swagger.json.