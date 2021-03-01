# Controle de Ponto API


### Descrição do projeto

API REST que faz o controle de registros de ponto de um funcionário. 

### STATUS

- Alocações (Finalizado)
- Registros (Finalizado)
- Momentos (Em progresso)
- Relatórios (Em progresso)
- Testes:
   - AlocacaoResource
   - Integração
- Documentação pelo Swagger (Finalizado)
- Docker 

### Pré-requisitos

- JDK 11 e Maven
- Banco MySQL 
- IntelliJ ou Eclipse, preferencialmente

### Foi utilizado

- Postman 
- Docker
OBS: Para subir o banco manualmente: usar os scripts script.sql e data.sql

### Instalação da aplicação

- mvn install 

### Iniciar aplicação

- Rodar a classe FolhaDePontoApplication

### Comando para os testes (unitários e integração)

- mvn integration-test ou mvn test ou mvn install
ou "Run Test" do IntelliJ


## Comportamento da API:

`POST v1/batidas/`

##### Response

    HTTP/1.1 200 OK
    Content-Type: application/json

    {
        "dia":"2021-02-28",
        "horarios":["08:00:00", "12:00:00", "13:02:00", "17:00:00"]
    }
    
    
  `GET v1/batidas/` 
     
   ##### Response
     
       HTTP/1.1 200 OK
       Content-Type: application/json
         
       {
               "id": 1,
               "dia": "2021-02-28",
               "primeiroHorario": "08:00:00",
               "segundoHorario": "12:00:00",
               "terceiroHorario": "13:00:00",
               "quartoHorario": "17:00:00",
               "momento": {
                   "id": 1,
                   "dataHora": "2021-02-28 18:40:30"
               }
           }
           
           
           
  `GET v1/batidas/momento` 
  
  ##### Response
  
      HTTP/1.1 200 OK
      Content-Type: application/json
      
      {
              "id": 1,
              "dataHora": "2021-02-28 18:40:30"
          }
     
    
    
`POST v1/alocacoes/`

##### Response

    HTTP/1.1 200 OK
    Content-Type: application/json

    {
        "dia" : "2021-02-28", 
        "tempo" : "PT8H00M0S", 
        "nomeProjeto" : "ACME Corporation"
    }
  
  
  
 `GET v1/alocacoes/` 
 
 ##### Response
 
     HTTP/1.1 200 OK
     Content-Type: application/json
     
     {  
          "id": 1,
          "dia": "2021-02-28",
          "tempo": "08:00:00",
          "nomeProjeto": "ACME Corporation"
     }
        