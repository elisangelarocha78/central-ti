# 🛠️ Central TI

Sistema web desenvolvido em **Java com Spring Boot** para organizar o atendimento da equipe de TI por meio de um único número de WhatsApp.

O projeto permitirá que vários técnicos utilizem o mesmo canal de atendimento, mantendo a identificação do responsável por cada conversa e o histórico dos atendimentos.

---

## 🎯 Objetivo

Atualmente, quatro pessoas utilizam o mesmo número de WhatsApp para atender os usuários e precisam informar manualmente seus nomes durante as conversas.

O **Central TI** pretende organizar esse processo, permitindo que:

* 👤 cada técnico acesse o sistema com seu próprio usuário;
* 📥 mensagens recebidas sejam direcionadas para uma fila de atendimento;
* 🙋 um técnico assuma o atendimento;
* 🪪 o sistema identifique automaticamente o técnico responsável;
* 💬 uma mensagem de apresentação seja enviada ao cliente;
* 📝 as conversas e os atendimentos sejam registrados;
* ✅ o atendimento seja finalizado e armazenado no histórico.

---

## 🚀 Tecnologias

* ☕ Java 21
* 🍃 Spring Boot 3
* 🌐 Spring MVC
* 🗄️ Spring Data JPA
* 🧩 Thymeleaf
* 📦 Maven
* 🛢️ SQL Server 2022
* 🔐 BCrypt / Spring Security Crypto
* 🖥️ HTML
* 🎨 CSS
* 📱 API do WhatsApp para integração futura
* 🌿 Git / GitHub

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

### 👥 Usuários

* ✅ Estrutura inicial do projeto Spring Boot
* ✅ Configuração da conexão com o SQL Server
* ✅ Criação da entidade `Usuario`
* ✅ Criação do `UsuarioRepository`
* ✅ Criação do `UsuarioService`
* ✅ Criação do `UsuarioController`
* ✅ Cadastro de usuários
* ✅ Listagem de usuários
* ✅ Campo para ativar ou desativar usuários
* ✅ Tela de cadastro de usuários
* ✅ Tela de listagem de usuários
* ✅ Exibição amigável dos perfis
* ✅ Exibição da situação ativa ou inativa do usuário

### 👤 Perfis

Perfis controlados por enum:

* 👑 `ADMIN`
* 🧑‍💻 `TECNICO`

### 🔍 Validações

* ✅ Nome obrigatório
* ✅ Limite de tamanho do nome
* ✅ E-mail obrigatório
* ✅ Validação do formato do e-mail
* ✅ Limite de tamanho do e-mail
* ✅ Senha obrigatória
* ✅ Senha com no mínimo 6 caracteres
* ✅ Perfil obrigatório
* ✅ Exibição de mensagens de erro no formulário
* ✅ Destaque visual dos campos inválidos
* ✅ Bloqueio do salvamento quando existem dados inválidos

### 📧 Controle de e-mails

* ✅ Bloqueio de e-mails duplicados
* ✅ Verificação de e-mail já cadastrado
* ✅ Normalização dos e-mails antes do cadastro
* ✅ Conversão automática do e-mail para letras minúsculas
* ✅ Remoção de espaços extras com `trim()`
* ✅ Mensagem amigável para e-mail já cadastrado

Exemplo:

```text
ADMIN@CENTRALTI.COM
        ↓
admin@centralti.com
```

### 🔐 Segurança das senhas

* ✅ Integração com `spring-security-crypto`
* ✅ Configuração do `BCryptPasswordEncoder`
* ✅ Criptografia da senha antes do armazenamento
* ✅ Senhas não são mais armazenadas em texto puro

Exemplo:

```text
Senha informada:
123456

        ↓ BCrypt

Senha armazenada:
$2a$10$...
```

---

## 🚧 Funcionalidades em desenvolvimento

* ✏️ Edição de usuários
* 🗑️ Exclusão de usuários
* 🔄 Melhorias na ativação e desativação de usuários
* 📢 Mensagens de sucesso
* 🔑 Login
* 🔒 Controle de acesso
* 🎧 Módulo de atendimento
* 📱 Integração com WhatsApp

---

## 🗺️ Próximas etapas

### 👥 Módulo de usuários

Próxima etapa imediata:

* ✏️ Implementar edição de usuários

Depois:

* 🔐 Permitir alteração segura de senha
* 🗑️ Implementar exclusão de usuários
* 🔄 Melhorar ativação e desativação
* 📢 Adicionar mensagens de sucesso
* 🧪 Criar testes para o módulo de usuários

---

### 🔒 Segurança

Após concluir o módulo de usuários:

* 🔑 Implementar login com Spring Security
* 👤 Identificar o usuário autenticado
* 🛡️ Separar permissões de administrador e técnico
* ⛔ Impedir o acesso de usuários inativos
* 🔐 Proteger as páginas do sistema
* 🚪 Implementar logout

---

### 🎧 Atendimento

* 👥 Criar cadastro de contatos
* 📋 Criar entidade de atendimento
* 💬 Criar entidade de mensagens
* 📥 Criar fila de novos atendimentos
* 🙋 Permitir que um técnico assuma um atendimento
* 🧑‍💻 Registrar o técnico responsável
* 🕐 Registrar data e horário de início
* 🕓 Registrar data e horário de finalização
* ✅ Permitir finalizar atendimento
* 📚 Armazenar o histórico dos atendimentos

Fluxo inicial:

```text
Novo atendimento
       ↓
Fila
       ↓
Técnico assume
       ↓
Atendimento em andamento
       ↓
Finalização
       ↓
Histórico
```

---

### 📱 WhatsApp

A automação será desenvolvida no próprio **Spring Boot**.

Etapas previstas:

* 🔌 Configurar integração com a API do WhatsApp
* 🌐 Criar webhook para recebimento de mensagens
* 📥 Receber mensagens no Spring Boot
* 📤 Enviar mensagens pelo Spring Boot
* 🤖 Criar atendimentos automaticamente
* 👋 Enviar automaticamente a apresentação do técnico
* 🖥️ Permitir respostas pelo painel do Central TI
* 💾 Registrar mensagens enviadas e recebidas
* 🔗 Relacionar cada conversa ao técnico responsável
* ✅ Finalizar atendimentos pelo painel

Exemplo de apresentação automática:

```text
Olá! Meu nome é Elisangela e ficarei responsável pelo seu atendimento.
Como posso ajudar?
```

---

### 🌍 Produção

Quando o sistema estiver funcional:

* 🖥️ Preparar ambiente de produção
* 🔒 Configurar HTTPS
* 🛢️ Configurar banco de dados de produção
* 🔑 Proteger credenciais e tokens
* 💾 Implementar backup
* 📝 Configurar logs
* 📊 Configurar monitoramento
* 📱 Conectar o número oficial de atendimento

---

## 🔗 Endereços disponíveis atualmente

### Listagem de usuários

```text
http://localhost:8080/usuarios
```

### Cadastro de usuário

```text
http://localhost:8080/usuarios/novo
```

---

## 🗄️ Banco de dados

O projeto utiliza **SQL Server 2022**.

A configuração local fica em:

```text
src/main/resources/application-local.properties
```

> ⚠️ Credenciais, senhas, tokens e outras informações sensíveis não devem ser enviadas ao repositório público.

A tabela utilizada atualmente é:

```text
usuarios
```

Campos principais:

```text
id
nome
email
senha
status
ativo
data_cadastro
```

O campo `status` no banco é representado no Java pela propriedade:

```java
PerfilUsuario perfil
```

com os valores:

```text
ADMIN
TECNICO
```

---

## 🔐 Senhas

As senhas de novos usuários são processadas pelo **BCrypt** antes de serem salvas.

O sistema não armazena a senha original no banco.

Exemplo:

```text
123456
```

é transformado em um hash semelhante a:

```text
$2a$10$Sr...
```

O hash BCrypt não é descriptografado.

No futuro, durante o login, o sistema verificará se a senha informada corresponde ao hash armazenado.

---

## ▶️ Executando o projeto

### 📋 Requisitos

* ☕ Java 21
* 🛢️ SQL Server 2022
* 📦 Maven ou Maven Wrapper
* 💻 IntelliJ IDEA ou outra IDE compatível
* 🌿 Git

### 💻 Pelo IntelliJ IDEA

Execute a classe:

```text
CentralTiApplication
```

> ⚠️ Não execute `CentralTiApplicationTests` quando quiser acessar o sistema pelo navegador.

Quando a aplicação estiver iniciada corretamente, o console deverá indicar que o Tomcat está ativo na porta `8080`.

---

### ⌨️ Pelo terminal

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

No Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

Depois acesse:

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
    │                   ├── config
    │                   │   └── SecurityConfig.java
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

### 👑 Administrador

O perfil `ADMIN` será responsável por:

* 👤 cadastrar usuários;
* ✏️ editar usuários;
* 🗑️ excluir ou desativar usuários;
* ⚙️ acessar configurações administrativas;
* 📊 acompanhar atendimentos.

### 🧑‍💻 Técnico

O perfil `TECNICO` será responsável por:

* 📥 acessar a fila de atendimento;
* 🙋 assumir atendimentos;
* 💬 responder clientes;
* 📋 visualizar seus atendimentos;
* ✅ finalizar atendimentos;
* 📚 consultar o histórico permitido.

---

## 📌 Status do projeto

🚧 **Projeto em desenvolvimento e utilizado inicialmente para estudo.**

Atualmente estão funcionando:

```text
✅ Cadastro de usuários
✅ Listagem de usuários
✅ Perfis ADMIN e TECNICO
✅ Validação dos dados
✅ Mensagens de erro
✅ Bloqueio de e-mails duplicados
✅ Normalização dos e-mails
✅ Criptografia das senhas com BCrypt
```

### ⏭️ Próxima etapa

**Etapa 1.5 — Implementar edição de usuários.**

A edição deverá permitir alterar:

* nome;
* e-mail;
* perfil;
* situação ativo/inativo;
* senha, somente quando uma nova senha for informada.

Também será necessário garantir que uma senha já criptografada **não seja criptografada novamente** quando o usuário for editado sem alterar a senha.

---

## ℹ️ Observação

A automação será desenvolvida no próprio **Spring Boot**.

A API do WhatsApp será utilizada como meio de comunicação para receber e enviar mensagens.

A lógica de criação da fila, identificação do técnico, abertura do atendimento, envio da apresentação, registro das mensagens e finalização será controlada pela aplicação **Central TI**.
