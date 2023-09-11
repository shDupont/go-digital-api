# GoDigital Code API

<!--Tecnologias Utilizadas e suas versões-->

[![Java Version][java-badge]][java-doc] [![PostgreSQL Version][postgresql-badge]][postgresql-doc] [![Spring-boot Version][spring-badge]][spring-doc] [![Docker Compose Version][docker-compose-badge]][docker-compose-doc]


> Status: :factory: Under development

## Indíce :bookmark_tabs:

:cd: [Descrição](#descrição-clipboard) 

:cd: [Funcionalidades](#funcionalidades-gear)    

:cd: [Front-end](#front-end-art) 

:cd: [Instalação](#instalação-floppy_disk)

:cd: [Contribuir](#contribuir-gift) 

## Descrição :clipboard:

<p style="text-align:justify">
GoDigital Code API é a parte backend de um sistema de gestão empresarial para administração de uma corretora de seguros. O gestor pode manter o registro de todos seus funcionários, clientes e contratos firmados em um banco de dados PostgreSQL protegido por um sistema de autenticação do Keycloak.
</p>

*([Acessar repositório do front-end][front-end-repo])*

## Funcionalidades :gear:

- O docker divide a aplicação em dois containers:
    - PostgreSQL - `https://localhost:994/`
    - Keycloak - `https://localhost:8890/`

<br>

- O Keycloak autentica as credenciais do gestor

<br>

- O sistema em Java:
    - Se conecta ao servidor PostgreSQL
    - Efetua instruções no banco para manter os registros
    - Gerencia requisições de rest API feitas pela rota `http://localhost:8080/api/v1`

<br>

- Rest API endpoints ativos:
    - `/employess`
    - `/customers`
    - `/contracts`

## Front-end :art:

*Você pode [acessar o repositório front-end do sistema][front-end-repo] para mais detalhes*

## Instalação :floppy_disk:

<!--Indique o passo a passo para se instalar o projeto, como também os pré-requisitos para isso-->

### Pré-requisitos

- [Docker Compose][docker-download]
- [Java][java-download]
- [Maven][maven-download]
- [PostgreSQL][postgreSQL-download]

### Iniciando o projeto 
> Os comandos listados a seguir foram feitos pelo terminal do Windows

1. **Clone** o projeto no seu computador:

```
git clone https://github.com/shDupont/go-digital-api
```

2. Acesse a pasta raiz do projeto pelo terminal e instale todas as dependências e compile o projeto com o **Maven**:
```
mvn package
```

3. Ainda na pasta raiz, inicialize o **Docker**:
```
docker-compose up
```

### Configurando o Keycloak

1. Espere o docker concluir os procedimentos então, acesse painel de controle do **Keycloak** pelo navgador:
```
https://localhost:8890/
```
![Screenshot da interface do Keycloak no navegador. Tela inicial do "Admin Console"][admin-console-img]

2. Clique em "Acessar painel de controle", e insira as credências padrão para acesso (`{username: "admin", password: "admin"}`)

<br>

3. Clique na opção "Clients" no menu lateral esquerdo, e depois clique em "Import Client"

![Screenshot da interface do Keycloak no navegador, acessando o realm "master" > "Clients". A imagem dá destaque à localização da opção "Import client", ao lado do botão "Create client"][client-import-img]


4. Importe o cliente selecionando o arquivo `users-auth.json` no repositório do projeto

![Screenshot da pasta do projeto com destaque para o arquivo "users-auth.json"][users-auth-file-img]

### Subindo a API

1. Acesse a pasta raiz do projeto e **inicialize** a API:
```
mvn spring-boot:run
```

2. Verifique se a API está funcionando por um dos [endpoints da aplicação](#funcionalidades-gear)
> *- **Atenção**: Como o banco de dados está **vazio**, o primeiro acesso a qualquer um dos endpoints mostrara um array vazio (colchetes)*

![Screenshot da tela do navegador acessando o endereço "http://localhost:8080/api/v1/employees". A tela do site esta vazia e preta, apenas com um par de colchetes no canto superior esquerdo.][empty-endpoint-img]

3. Siga toda a lista de passos para **[instalação do GoDigital Code Painel][front-end-repo]**

## Contribuir :gift:

Se você tem alguma ideia, sugestão, ou viu algum erro, você pode [abrir uma issue][issues] e contar para gente.

<!-- Links utilizados no documento -->

<!-- Badges -->
[spring-badge]: https://img.shields.io/badge/Spring--Boot-2.5.5-green?style=for-the-badge&logo=spring

[java-badge]: https://img.shields.io/badge/Java-17-red?style=for-the-badge&logo=openjdk

[postgresql-badge]: https://img.shields.io/badge/PostgreSQL-15-cyan?style=for-the-badge&logo=postgresql&logoColor=cyan

[docker-compose-badge]: https://img.shields.io/badge/Docker_Compose-2.19.1-blue?style=for-the-badge&logo=docker

<!-- Documentations -->
[postgresql-doc]: https://www.postgresql.org/docs/15/index.html

[java-doc]: https://docs.oracle.com/en/java/javase/17/

[spring-doc]: https://docs.spring.io/spring-boot/docs/2.5.5/reference/html/

[docker-compose-doc]: https://docs.docker.com/

[status-badge]: https://img.shields.io/static/v1?label=status&message=em%20projeto&color=success&style=for-the-badge

<!-- Downloads -->
[docker-download]: https://docs.docker.com/compose/install/
[java-download]: https://www.java.com/pt-BR/download/ie_manual.jsp?locale=pt_BR
[maven-download]: https://maven.apache.org/download.cgi
[postgreSQL-download]: https://www.postgresql.org/download/

[front-end-repo]: https://github.com/gpado/painel

<!-- Imagens -->
[admin-console-img]: https://github.com/GustavoHerreroNunes/go-digital-api/blob/main/readme-assets/admin-console.jpg

[client-import-img]: https://github.com/GustavoHerreroNunes/go-digital-api/blob/main/readme-assets/import_client.png

[users-auth-file-img]: https://github.com/GustavoHerreroNunes/go-digital-api/blob/main/readme-assets/arquivo_users-auth.png

[empty-endpoint-img]: https://github.com/GustavoHerreroNunes/go-digital-api/blob/main/readme-assets/endpoint-array_vazio.png

<!-- Others -->
[issues]: https://github.com/shDupont/go-digital-api/issues