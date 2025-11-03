# PayNow
Uma API REST desenvolvida em Java Spring Boot que simula uma plataforma de pagamentos simplificada.
Com ela, é possível cadastrar usuários, consultar contas e realizar transferências seguras entre usuários.

🚀 Funcionalidades

Cadastro de usuários (comuns e lojistas)

Consulta de todos os usuários cadastrados

Transferências entre usuários

Validação de saldo antes da transação

Consulta a serviço externo de autorização

Envio de notificação simulada ao destinatário da transferência

## 🧩 Tipos de Usuário

A plataforma possui **dois tipos de usuários**, cada um com permissões específicas:

- **Usuário Comum (COMMON):**  
  Pode **enviar e receber dinheiro** livremente entre outros usuários e lojistas.

- **Lojista (MERCHANT):**  
  Pode **apenas receber dinheiro**.  
  Lojistas **não podem realizar transferências** para outros usuários.


CPF/CNPJ e e-mail devem ser únicos.

Lojistas não podem enviar dinheiro.

O usuário deve possuir saldo suficiente para transferir.

Antes de confirmar a transação, o sistema consulta o serviço externo de autorização:

GET https://util.devi.tools/api/v2/authorize


Após a transferência, uma notificação é enviada ao destinatário via serviço simulado:

POST https://util.devi.tools/api/v1/notify

🧰 Tecnologias Utilizadas

Java 17+

Spring Boot

Spring Data JPA (H2 Database)

Lombok

MapStruct

RestTemplate / WebClient

Maven

▶️ Como Executar o Projeto
# 1. Clonar o repositório
git clone https://github.com/seuusuario/picpay-simplificado.git

# 2. Entrar na pasta do projeto
cd picpay-simplificado

# 3. Rodar a aplicação
mvn spring-boot:run


O servidor será iniciado em:

http://localhost:8080

🧪 Testando os Endpoints
📍 Criar Usuário
curl --location 'localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{
  "firstName": "Pedro",
  "lastName": "Ferreira",
  "document": "12444248348",
  "email": "prdro@example.com",
  "password": "123456",
  "userType": "COMMON",
  "balance": 1000.00
}'

📍 Listar Usuários
curl --location 'localhost:8080/users'

📍 Fazer Transferência
curl --location 'localhost:8080/transactions' \
--header 'Content-Type: application/json' \
--data '{
  "senderId": 4,
  "receiverId": 1,
  "value": 100
}'

📬 Notificações e Autorização

Durante uma transferência:

O sistema consulta o serviço autorizador.
Se o mock retornar "message": "Autorizado", a transação prossegue.

Ao final, o sistema envia uma notificação simulada ao destinatário.

💾 Estrutura de Banco (H2)

Para acessar o console do H2:

http://localhost:8080/h2-console


Credenciais padrão:

JDBC URL: jdbc:h2:mem:testdb

User: sa

Password: (vazio)

🧠 Melhorias Futuras

Autenticação JWT

Validação de CPF/CNPJ real

Logs e auditoria de transações

Integração com banco real (PostgreSQL)

Melhorar técnicas de código limpo e arquitetura limpa
