# 📌 Aplicação Java Spring com MySQL no Docker

Este projeto é uma API desenvolvida em **Java Spring Boot**, utilizando **MySQL** como banco de dados e rodando o banco via **Docker Compose**.
API para o app :
- [app_wk](https://github.com/Vlad-Taguerran/wk_teste_app.git)

## 🛠️ Requisitos
Antes de iniciar o projeto, certifique-se de ter os seguintes requisitos instalados:

- [Java 21+](https://adoptium.net/)
- [Maven](https://maven.apache.org/download.cgi)
- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)

## 🚀 Configuração e Execução

### 1️⃣ **Clonar o repositório**
```sh
  git clone https://github.com/seu-usuario/seu-repositorio.git
  cd seu-repositorio
```

### 2️⃣ **Subir o banco de dados com Docker Compose**
Antes de rodar a aplicação, é necessário iniciar o banco de dados no Docker:
```sh
  docker-compose up -d
```
Isso irá iniciar um container MySQL em **modo daemon (-d)**.

### 3️⃣ **Configurar o banco de dados**
A configuração do banco está definida no arquivo `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/wk?useSSL=false&serverTimezone=UTC
spring.datasource.username=wk
spring.datasource.password=wk
spring.jpa.hibernate.ddl-auto=update
```
Caso tenha alterado usuário ou senha no `docker-compose.yml`, modifique aqui também.

### 4️⃣ **Compilar e rodar a aplicação**
Agora podemos rodar a aplicação Java:
```sh
  mvn spring-boot:run
```
A API estará disponível em **http://localhost:8080**.

## 🐳 **Docker Compose - Configuração do Banco**
O banco de dados é gerenciado por um serviço no `docker-compose.yml`:

```yaml
version: "3.8"

services:
  db:
    image: mysql:8.0
    container_name: database_wk
    environment:
      MYSQL_ROOT_PASSWORD: wk
      MYSQL_DATABASE: wk
      MYSQL_USER: wk
      MYSQL_PASSWORD: wk
    ports:
      - "3306:3306"
    expose:
      - 3306
```
Isso garante que os dados do banco persistam mesmo após reiniciar o container.

## 🛠️ **Parar o banco de dados**
Se precisar parar o banco de dados rodando no Docker, use:
```sh
  docker-compose down
```



## 📌 **Conclusão**
Agora sua aplicação Spring Boot está configurada para rodar com um banco MySQL no Docker. Você pode desenvolver sua API sem se preocupar com instalações locais do banco!

---
🔗 **Dúvidas ou sugestões?** Fique à vontade para contribuir com o projeto! 🚀

