# Microsserviço Cartório

Você já precisou tirar uma certidão de nascimento de um bebê que acabou de nascer? Já observou que o CPF é gerado nesse momento? Já pensou em como é gerado esse CPF e quem mantem esses registros?

Este projeto é um microsserviço responsável por enviar a solicitação da geração de um novo CPF para o microsserviço da receita (api-rest-kafka-springboot-receitaFederal), receber o CPF gerado e gravar na pessoa da requisição.

## Ferramentas

- Java 11
- Spring boot
- MySQL
- Apache Kafka

## Diagrama da aplicação

![Diagrama da aplicacao](/.github/diagram.png)
