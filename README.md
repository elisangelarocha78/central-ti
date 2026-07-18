# 🛠️ Central TI

Sistema web desenvolvido em **Java com Spring Boot** para organizar o atendimento da equipe de TI por meio de um único número de WhatsApp.

O projeto permitirá que vários técnicos utilizem o mesmo canal de atendimento, mantendo a identificação do responsável por cada conversa e o histórico dos atendimentos.

---

## 🎯 Objetivo

Atualmente, quatro pessoas utilizam o mesmo número de WhatsApp para atender os usuários e precisam informar manualmente seus nomes durante as conversas.

O **Central TI** pretende organizar esse processo, permitindo que:

- 👤 cada técnico acesse o sistema com seu próprio usuário;
- 📥 mensagens recebidas sejam direcionadas para uma fila de atendimento;
- 🙋 um técnico assuma o atendimento;
- 🪪 o sistema identifique automaticamente o técnico responsável;
- 💬 uma mensagem de apresentação seja enviada ao cliente;
- 📝 as conversas e os atendimentos sejam registrados;
- ✅ o atendimento seja finalizado e armazenado no histórico.

---

## 🚀 Tecnologias

- ☕ Java 21
- 🍃 Spring Boot 3
- 🌐 Spring MVC
- 🗄️ Spring Data JPA
- 🧩 Thymeleaf
- 📦 Maven
- 🛢️ SQL Server 2022
- 🖥️ HTML
- 🎨 CSS
- 📱 API do WhatsApp para integração futura

---

## 🔄 Fluxo planejado

```text
📱 Cliente envia uma mensagem pelo WhatsApp
                         ↓
🍃 Aplicação Spring Boot recebe a mensagem
                         ↓
📥 Atendimento é criado na fila
                         ↓
🙋 Técnico autenticado assume o atendimento
                         ↓
💬 Sistema envia a apresentação do técnico
                         ↓
🖥️ Conversa é realizada pelo painel
                         ↓
✅ Atendimento é finalizado e armazenado
```

---

## ✅ Funcionalidades concluídas

- ✅ Estrutura inicial do projeto Spring Boot
- ✅ Configuração da conexão com o SQL Server
- ✅ Criação da entidade `Usuario`
- ✅ Criação do `UsuarioRepository`
- ✅ Criação do `UsuarioService`
- ✅ Criação do `UsuarioController`
- ✅ Cadastro de usuários
- ✅ Listagem de usuários
- ✅ Campo para ativar ou desativar usuários
- ✅ Perfis controlados:
    - 👑 `ADMIN`
    - 🧑‍💻 `TECNICO`
- ✅ Tela de cadastro de usuários
- ✅ Tela de listagem de usuários
- ✅ Exibição amigável dos perfis
- ✅ Exibição da situação ativa ou inativa do usuário

---

## 🚧 Funcionalidades em desenvolvimento

- 🔍 Validação dos dados do usuário
- 📧 Bloqueio de e-mails duplicados
- 🔐 Criptografia de senhas
- ✏️ Edição de usuários
- 🗑️ Exclusão de usuários
- 📢 Mensagens de sucesso e erro

---

## 🗺️ Próximas etapas

### 👥 Módulo de usuários

- 🔍 Adicionar validações ao cadastro
- 📧 Impedir o cadastro de e-mails duplicados
- 🔐 Criptografar senhas com BCrypt
- ✏️ Implementar edição de usuários
- 🗑️ Implementar exclusão de usuários
- 🔄 Permitir ativação e desativação de usuários
- 📢 Melhorar mensagens de sucesso e erro

### 🔒 Segurança

- 🔑 Implementar login com Spring Security
- 👤 Identificar o usuário autenticado
- 🛡️ Separar permissões de administrador e técnico
- ⛔ Impedir o acesso de usuários inativos
- 🔐 Proteger as páginas do sistema

### 🎧 Atendimento

- 👥 Criar cadastro de contatos
- 📋 Criar entidade de atendimento
- 💬 Criar entidade de mensagens
- 📥 Criar fila de novos atendimentos
- 🙋 Permitir que um técnico assuma um atendimento
- 🧑‍💻 Registrar o técnico responsável
- 🕐 Registrar data e horário de início
- 🕓 Registrar data e horário de finalização
- 📚 Armazenar o histórico dos atendimentos

### 📱 WhatsApp

- 🔌 Configurar uma API de integração com o WhatsApp
- 🌐 Criar webhook para recebimento de mensagens
- 📥 Receber mensagens no Spring Boot
- 📤 Enviar mensagens pelo Spring Boot
- 🤖 Criar atendimentos automaticamente
- 👋 Enviar automaticamente a apresentação do técnico
- 🖥️ Permitir respostas pelo painel do sistema
- 💾 Registrar mensagens enviadas e recebidas
- 🔗 Relacionar cada conversa ao técnico responsável

### 🌍 Produção

- 🖥️ Preparar o ambiente de produção
- 🔒 Configurar HTTPS
- 🛢️ Configurar banco de dados de produção
- 🔑 Proteger credenciais e tokens
- 💾 Implementar backup
- 📝 Configurar logs
- 📊 Configurar monitoramento
- 📱 Conectar o número oficial de atendimento

---

## 🔗 Endereços disponíveis atualmente

Com a aplicação em execução, a listagem de usuários está disponível em:

```text
http://localhost:8080/usuarios
```

O formulário de cadastro está disponível em:

```text
http://localhost:8080/usuarios/novo
```

---

## 🗄️ Banco de dados

O projeto utiliza o **SQL Server**.

A configuração local do banco fica no arquivo:

```text
src/main/resources/application-local.properties
```

> ⚠️ Credenciais, senhas, tokens e outras informações sensíveis não devem ser enviadas ao repositório público.

---

## ▶️ Executando o projeto

### 📋 Requisitos

- ☕ Java 21
- 🛢️ SQL Server 2022
- 📦 Maven ou Maven Wrapper
- 💻 IntelliJ IDEA ou outra IDE compatível
- 🌿 Git

### 💻 Execução pelo IntelliJ IDEA

Execute a classe:

```text
CentralTiApplication
```

### ⌨️ Execução pelo terminal

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

No Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

Depois, acesse:

```text
http://localhost:8080/usuarios
```

---

## 📁 Estrutura principal do projeto

```text
src
└── main
    ├── java
    │   └── br
    │       └── com
    │           └── samoa
    │               └── central_ti
    │                   ├── controller
    │                   ├── dto
    │                   ├── entity
    │                   ├── enums
    │                   ├── repository
    │                   ├── service
    │                   └── CentralTiApplication.java
    │
    └── resources
        ├── templates
        │   ├── dashboard
        │   ├── fragments
        │   ├── login
        │   └── usuario
        ├── application.properties
        └── application-local.properties
```

---

## 👤 Perfis de usuário

O sistema possui inicialmente dois perfis.

### 👑 Administrador

O perfil `ADMIN` será responsável por:

- 👤 cadastrar usuários;
- ✏️ editar usuários;
- 🗑️ excluir usuários;
- 🔄 ativar ou desativar usuários;
- ⚙️ acessar configurações administrativas;
- 📊 acompanhar atendimentos.

### 🧑‍💻 Técnico

O perfil `TECNICO` será responsável por:

- 📥 acessar a fila de atendimento;
- 🙋 assumir atendimentos;
- 💬 responder clientes;
- 📋 visualizar seus atendimentos;
- ✅ finalizar atendimentos;
- 📚 consultar o histórico permitido.

---

## 📌 Status do projeto

🚧 **Projeto em desenvolvimento e utilizado inicialmente para estudo.**

A estrutura básica do cadastro e da listagem de usuários está funcionando.

A próxima etapa é implementar as validações do cadastro antes de iniciar o login e o módulo de atendimento.

---

## ℹ️ Observação

A automação será desenvolvida no próprio **Spring Boot**.

A API do WhatsApp será utilizada como meio de comunicação para receber e enviar mensagens.

A lógica de criação da fila, identificação do técnico, abertura do atendimento, envio da apresentação, registro das mensagens e finalização será controlada pela aplicação **Central TI**.