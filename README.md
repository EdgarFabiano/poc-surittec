# poc-surittec

###Dependências
- Java 8
- Maven
- Node.js
- Angular CLI

###Para executar a aplicação

Executar o jar o H2 Database engine que está na raíz do projeto
```
$ java -jar h2-1.4.197.jar
```

Em outro terminal, executar a aplicação backend na raíz do projeto
```
$ mvn clean package
$ java -jar target\poc-edgar-0.0.1-SNAPSHOT.jar
```

Em outro terminal, executar a aplicação frontend na raíz do projeto
```
$ cd angularclient
$ npm install
$ npm run start
```

A aplicação estará disponível em
http://localhost:4200/

###Usuários pré cadastrados
```
Usuário: admin

Senha: 123456
```

```
Usuário: comum

Senha: 123456
```
