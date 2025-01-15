# Forecast

## Funcionalidades

- **Obter Todos os Funcionários**: Recupera uma lista de todos os funcionários.
- **Obter Funcionário por ID**: Recupera os detalhes de um funcionário específico pelo seu ID.
- **Adicionar Novo Funcionário**: Adiciona um novo funcionário ao sistema.
- **Atualizar Funcionário**: Atualiza os detalhes de um funcionário existente.
- **Excluir Funcionário**: Remove um funcionário do sistema.

# Arquitetura Clean no Projeto

Este projeto segue os princípios da Arquitetura Clean, que visa separar as responsabilidades e criar um código flexível,
de fácil manutenção e testável. A arquitetura é dividida em várias camadas, cada uma com responsabilidades específicas.

## Estrutura do Projeto

### Camada de Domínio

- **Pasta**: `domain`
- **Responsabilidades**: Contém a lógica de negócios principal e os modelos de domínio. Esta camada é independente de
  qualquer outra camada e não depende de bibliotecas ou frameworks externos.
- **Principais Componentes**:
  - `model`: Contém os modelos de domínio.
  - `exceptions`: Contém exceções personalizadas específicas do domínio.
  - `port`: Contém interfaces que definem os contratos para os serviços e repositórios.

### Camada de Aplicação

- **Pasta**: `application`
- **Responsabilidades**: Contém a lógica de negócios específica da aplicação e os casos de uso. Esta camada orquestra o
  fluxo de dados entre o domínio e as camadas externas.
- **Principais Componentes**:
  - `service`: Contém a implementação dos casos de uso.
  - `usecase`: Contém as interfaces para os casos de uso.

### Camada de Adapters

- **Pasta**: `adapters`
- **Responsabilidades**: Contém o código que adapta a aplicação ao mundo externo. Isso inclui controladores web,
  endpoints de API e outros mecanismos de entrada/saída.
- **Principais Componentes**:
  - `in/web/api`: Contém os controladores web e endpoints de API.

### Camada de Infraestrutura

- **Pasta**: `forecast/src/main/java/dti/digital/infrastructure`
- **Responsabilidades**: Contém os detalhes de implementação para os sistemas externos, como bancos de dados, sistemas
  de mensagens e outros serviços de terceiros.
- **Principais Componentes**:
  - `service/telemetry`: Contém a implementação dos serviços de telemetria.
  - `persistence/adapter`: Contém a implementação dos adaptadores de persistência.
  - `persistence/repository`: Contém as interfaces de repositório e suas implementações.
  - `entrypoint/controller`: Contém os controladores de tratamento de exceções.

## Resumo

Ao organizar o projeto nessas camadas, garantimos uma clara separação de responsabilidades, tornando o código mais fácil
de manter, testar e estender. Cada camada tem um papel e responsabilidade específicos, contribuindo para a robustez e
flexibilidade geral da aplicação.

## Começando

### Acesso ao Swagger

Acesse a interface do Swagger em: `http://localhost:8080/swagger-ui`

Para começar com o projeto, siga estes passos:

### Inicialização da Aplicação

1. Clone o repositório:
   ```bash
   git clone 

2. Configure o banco de dados e as credenciais no `.env`.
3. Compile o projeto e inicie o servidor com os seguintes comandos:
   ```bash
   mvn clean install
   mvn mn:run

## Tecnologias Utilizadas

### Banco de Dados

- **SQL Server**: Utilizado como banco de dados relacional.
- **JPA/Hibernate**: Para gerenciamento de persistência e acesso a dados.

### Documentação

- **OpenAPI**: Definição da API para garantir padronização e integridade.
- **Swagger-UI**: Disponibiliza uma interface interativa para explorar e testar os endpoints da API.

### Testes

- **JUnit**: Para criação de testes unitários garantindo a qualidade do código.
- **Mockito**: Para mock de dependências nos testes.

### Linguagens e Frameworks

- **Java 21**
- **Micronaut Framework**
- **Maven**
- **MapStruct**
- **Lombok**

## Licença

Este projeto é licenciado sob a [MIT License](LICENSE).