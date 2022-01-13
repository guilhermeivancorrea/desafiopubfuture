# Desafio PubFuture
 Implementação de uma API de controle das finanças pessoais
 
 ## Descrição
 API desenvolvida em java para manipular os dados entre as tabelas do banco de dados e qualquer outra aplicação.
 ### Funcionalidade
 * Adicionar/Editar/Excluir (Receita,despesa,conta)
 * Listar todas as contas, receitas e despesas
 * Filtrar receitas e despesas por Periodo e tipo
 * Selecionar conta, receita e despesa por ID
 * Retornar soma total de contas, de receitas e de despesas
 * Tranferir valor entre contas
 * O saldo da conta é atualizado diretamento no banco de dados ao adicionar, editar e excluir uma receita ou despesa (triggers)
 
 ## Requisitos 
 * JDK11
 * MYSQL Server 8.0.27
 
 ## Ferramentas 
 * Eclipse IDE 
 * Mysql Workbench 8.0
 * Postman
 
 ## Tecnologias
 ![java](https://github.com/guilhermeivancorrea/desafiopubfuture/blob/main/documenta%C3%A7%C3%A3o/java.png)
 ![mysql](https://github.com/guilhermeivancorrea/desafiopubfuture/blob/main/documenta%C3%A7%C3%A3o/mysql.png)
 ![spring](https://github.com/guilhermeivancorrea/desafiopubfuture/blob/main/documenta%C3%A7%C3%A3o/spring.png)
 ![gradle](https://github.com/guilhermeivancorrea/desafiopubfuture/blob/main/documenta%C3%A7%C3%A3o/gradle.png)
 
 ## Utilização
 Clonar o Repositório utilizando o git
 ```
 gh repo clone guilhermeivancorrea/desafiopubfuture
 ```
 o repositório deve permanecer com o nome "desafiopubfuture"
 
 importe o banco de dados utilizando o workbanch, o dump está na pasta "banco de dados mysql"
 
 importe o projeto para o eclipse utilizando o gladle
 
 altere usuario e senha no arquivo "application.properties" na pasta "resources"
 
 clicando com o botão direito no projeto, Gradle/Refresh Gradle
 
 start a aplicação diretamente na classe "desafiopubfutureApplication.java"
 
 importe a coleção no Postman, arquivo na pasta Postman
 
 utilize o postman para testar a requisições.
 
 ## Autor
 Guilherme Ivan Correa
 guilherme1603@gmail.com
 
 
 
 
