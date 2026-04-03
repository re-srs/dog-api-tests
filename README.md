# Dog API Tests

## Sobre o projeto

Este projeto contém testes automatizados para validar os endpoints da Dog API.

Os testes garantem que a API:

* Responde corretamente
* Retorna dados no formato esperado
* Se comporta corretamente em cenários positivos e negativos

---

## Tecnologias utilizadas

* Java 17
* RestAssured
* JUnit 5
* Maven
* Allure Report

---

## Testes implementados

### Cenários positivos

* GET /breeds/list/all
* GET /breeds/image/random
* GET /breed/{breed}/images

### Cenário negativo

* GET /breed/{breed}/images com raça inválida

---

## Como executar os testes

```bash
mvn clean test
```

---

## Relatório Allure

Gerar relatório:

```bash
mvn allure:serve
```

O relatório será aberto automaticamente no navegador com detalhes dos testes.

---

## Estrutura do projeto

```
src/test/java/api → testes automatizados
src/test/resources → configurações (Allure)
pom.xml → dependências e build
```

---

## Observações

* O projeto utiliza boas práticas de organização e reutilização de código
* Os relatórios Allure facilitam a análise de falhas e execução dos testes

---

## Autor

Renata Graciano Lobato Bicalho Melo
