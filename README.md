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

# ✅ Funcionalidades concluídas

## 👥 Usuários

* ✅ Estrutura inicial do projeto Spring Boot
* ✅ Configuração da conexão com o SQL Server
* ✅ Criação da entidade `Usuario`
* ✅ Criação do `UsuarioRepository`
* ✅ Criação do `UsuarioService`
* ✅ Criação do `UsuarioController`
* ✅ Cadastro de usuários
* ✅ Listagem de usuários
* ✅ Tela de cadastro de usuários
* ✅ Tela de listagem de usuários
* ✅ Campo ativo/inativo
* ✅ Exibição amigável dos perfis
* ✅ Exibição da situação ativa ou inativa do usuário
* ✅ Edição de usuários
* ✅ Botão de edição na listagem
* ✅ Formulário específico para edição
* ✅ Preservação do ID durante a edição
* ✅ Preservação da data original de cadastro

---

## 👤 Perfis de usuário

Os perfis são controlados através do enum `PerfilUsuario`.

Perfis disponíveis:

* 👑 `ADMIN`
* 🧑‍💻 `TECNICO`

O banco continua utilizando a coluna:

```text
status
```

Enquanto no Java ela é representada por:

```java
PerfilUsuario perfil
```

---

## 🔍 Validações

O cadastro possui validações no backend utilizando **Jakarta Validation**.

Atualmente estão implementadas:

* ✅ Nome obrigatório
* ✅ Limite de tamanho do nome
* ✅ E-mail obrigatório
* ✅ Validação do formato do e-mail
* ✅ Limite de tamanho do e-mail
* ✅ Senha obrigatória no cadastro
* ✅ Senha com no mínimo 6 caracteres
* ✅ Perfil obrigatório
* ✅ Exibição de mensagens de erro no formulário
* ✅ Destaque visual dos campos inválidos
* ✅ Bloqueio do salvamento quando existem dados inválidos

Exemplo:

```text
Nome:
[vazio]

Resultado:
O nome é obrigatório
```

---

## 📧 Controle de e-mails

O sistema possui proteção contra duplicidade de e-mails.

Funcionalidades implementadas:

* ✅ Verificação de e-mail já cadastrado
* ✅ Bloqueio de e-mails duplicados
* ✅ Normalização dos e-mails
* ✅ Conversão automática para letras minúsculas
* ✅ Remoção de espaços extras com `trim()`
* ✅ Mensagem amigável para e-mail já cadastrado
* ✅ Bloqueio de duplicidade durante a edição
* ✅ Permite manter o próprio e-mail durante a edição

Exemplo:

```text
ADMIN@CENTRALTI.COM
        ↓
admin@centralti.com
```

Caso o e-mail pertença a outro usuário:

```text
Já existe outro usuário cadastrado com este e-mail
```

---

## 🔐 Segurança das senhas

As senhas são protegidas utilizando **BCrypt**.

Funcionalidades concluídas:

* ✅ Integração com `spring-security-crypto`
* ✅ Configuração de `PasswordEncoder`
* ✅ Uso do `BCryptPasswordEncoder`
* ✅ Criptografia da senha antes de salvar
* ✅ Senhas não são mais armazenadas em texto puro
* ✅ Nova senha é criptografada durante a edição
* ✅ Senha atual é preservada quando o campo de nova senha fica vazio
* ✅ Hash BCrypt não é enviado para o formulário de edição
* ✅ Evita criptografar novamente uma senha já criptografada

Exemplo:

```text
Senha informada:

123456

        ↓

BCrypt

        ↓

$2a$10$...
```

O BCrypt utiliza salt automaticamente, portanto duas senhas iguais podem gerar hashes diferentes.

---

# ✏️ Edição de usuários

A edição de usuários está funcionando.

A tela permite alterar:

* ✅ Nome
* ✅ E-mail
* ✅ Perfil
* ✅ Situação ativo/inativo
* ✅ Senha opcional

A edição utiliza:

```text
UsuarioEdicaoDTO
```

Isso permite separar as regras do cadastro das regras de edição.

---

## 🔐 Alteração de senha durante a edição

No formulário de edição existe o campo:

```text
Nova senha
```

Se ele for deixado vazio:

```text
Nova senha: [vazio]
        ↓
Senha atual é preservada
```

Se uma nova senha for informada:

```text
Nova senha: 654321
        ↓
BCrypt
        ↓
Novo hash é armazenado
```

O sistema nunca exibe o hash atual no formulário.

---

## 🧪 Testes realizados na edição

Foram testados com sucesso:

* ✅ Alteração do nome
* ✅ Alteração do perfil
* ✅ Alteração do status ativo/inativo
* ✅ Manutenção da senha atual
* ✅ Alteração para uma nova senha
* ✅ Geração de novo hash BCrypt
* ✅ Preservação do hash quando a senha não é alterada
* ✅ Bloqueio de e-mail pertencente a outro usuário
* ✅ Preservação do e-mail original quando ocorre erro
* ✅ Preservação do mesmo ID do usuário

---

# 🚧 Funcionalidades em desenvolvimento

* 🗑️ Exclusão de usuários
* 🔄 Melhorias na ativação e desativação de usuários
* 📢 Mensagens de sucesso
* 🧪 Testes automatizados
* 🔑 Login
* 🔒 Controle de acesso
* 🎧 Módulo de atendimento
* 📱 Integração com WhatsApp

---

# 🗺️ Próximas etapas

## 👥 Módulo de usuários

### ⏭️ Próxima etapa imediata

**Etapa 1.6 — desativação e exclusão de usuários**

Planejado:

* 🗑️ Implementar exclusão de usuário
* ⚠️ Adicionar confirmação antes da exclusão
* 🔄 Melhorar controle ativo/inativo
* 🛡️ Evitar exclusão indevida de usuários importantes
* 📢 Adicionar mensagens de sucesso
* 🧪 Criar testes do módulo

Como futuramente os usuários estarão relacionados aos atendimentos, a preferência será por **desativar usuários em vez de excluí-los fisicamente** quando já existirem registros vinculados.

---

# 🔒 Segurança

Depois de concluir o módulo de usuários:

* 🔑 Implementar login com Spring Security
* 👤 Identificar o usuário autenticado
* 🛡️ Separar permissões entre `ADMIN` e `TECNICO`
* ⛔ Impedir login de usuários inativos
* 🔐 Proteger páginas administrativas
* 🚪 Implementar logout
* 🔄 Gerenciar sessão

Fluxo planejado:

```text
Usuário informa e-mail e senha
            ↓
Spring Security
            ↓
Busca usuário no SQL Server
            ↓
BCrypt compara a senha
            ↓
Usuário autenticado
```

---

# 🎧 Atendimento

Depois da autenticação será criado o módulo de atendimento.

Funcionalidades planejadas:

* 👥 Cadastro de contatos
* 📋 Entidade de atendimento
* 💬 Entidade de mensagens
* 📥 Fila de novos atendimentos
* 🙋 Técnico assume atendimento
* 🧑‍💻 Registro do técnico responsável
* 🕐 Registro da data e hora de início
* 🕓 Registro da data e hora de finalização
* ✅ Finalização do atendimento
* 📚 Histórico de atendimentos

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

# 📱 Integração com WhatsApp

A automação será desenvolvida dentro do próprio **Spring Boot**.

A API do WhatsApp será responsável apenas pela comunicação entre o WhatsApp e o Central TI.

Etapas previstas:

* 🔌 Configurar integração com a API do WhatsApp
* 🌐 Criar webhook
* 📥 Receber mensagens no Spring Boot
* 📤 Enviar mensagens pelo Spring Boot
* 🤖 Criar atendimento automaticamente
* 📥 Adicionar novo atendimento à fila
* 🙋 Permitir que um técnico assuma a conversa
* 👋 Enviar automaticamente a apresentação do técnico
* 🖥️ Permitir respostas através do painel
* 💾 Registrar mensagens enviadas
* 💾 Registrar mensagens recebidas
* 🔗 Relacionar cada conversa ao técnico responsável
* ✅ Finalizar atendimento pelo painel

Exemplo:

```text
Cliente:
Olá, preciso de ajuda com meu computador.

        ↓

Central TI cria atendimento

        ↓

Técnico assume

        ↓

Sistema envia:

Olá! Meu nome é Elisangela e ficarei responsável pelo seu atendimento.
Como posso ajudar?
```

---

# 🌍 Produção

Quando o sistema estiver funcional:

* 🖥️ Preparar servidor de produção
* 🔒 Configurar HTTPS
* 🛢️ Configurar banco de dados de produção
* 🔑 Proteger credenciais
* 🔑 Proteger tokens da API
* 💾 Implementar backup
* 📝 Configurar logs
* 📊 Configurar monitoramento
* 📱 Conectar o número oficial do WhatsApp

---

# 🔗 Endereços disponíveis atualmente

## 👥 Listagem de usuários

```text
http://localhost:8080/usuarios
```

## ➕ Cadastro de usuário

```text
http://localhost:8080/usuarios/novo
```

## ✏️ Edição de usuário

```text
http://localhost:8080/usuarios/editar/{id}
```

Exemplo:

```text
http://localhost:8080/usuarios/editar/15
```

---

# 🗄️ Banco de dados

O projeto utiliza:

**SQL Server 2022**

Configuração local:

```text
src/main/resources/application-local.properties
```

> ⚠️ Credenciais, senhas, tokens e outras informações sensíveis não devem ser enviadas ao repositório público.

Tabela atualmente utilizada:

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

---

# 🔐 Senhas no banco

Novos usuários possuem senhas armazenadas como hash BCrypt.

Exemplo:

```text
Senha:

123456
```

No banco:

```text
$2a$10$...
```

O hash BCrypt:

* não é descriptografado;
* não revela a senha original;
* utiliza salt automaticamente;
* será utilizado futuramente pelo Spring Security para autenticação.

---

# ▶️ Executando o projeto

## 📋 Requisitos

* ☕ Java 21
* 🛢️ SQL Server 2022
* 📦 Maven ou Maven Wrapper
* 💻 IntelliJ IDEA ou outra IDE compatível
* 🌿 Git

---

## 💻 Pelo IntelliJ IDEA

Execute:

```text
CentralTiApplication
```

> ⚠️ Não execute `CentralTiApplicationTests` quando quiser utilizar o sistema pelo navegador.

Quando iniciado corretamente, o console deverá indicar que o Tomcat está ativo na porta:

```text
8080
```

Depois acesse:

```text
http://localhost:8080/usuarios
```

---

## ⌨️ Pelo terminal

Linux ou macOS:

```bash
./mvnw spring-boot:run
```

Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

---

# 📁 Estrutura principal do projeto

```text
src
└── main
    ├── java
    │   └── br
    │       └── com
    │           └── samoa
    │               └── central_ti
    │
    │                   ├── config
    │                   │   └── SecurityConfig.java
    │                   │
    │                   ├── controller
    │                   │   ├── DashboardController.java
    │                   │   ├── LoginController.java
    │                   │   └── UsuarioController.java
    │                   │
    │                   ├── dto
    │                   │   ├── LoginDTO.java
    │                   │   └── UsuarioEdicaoDTO.java
    │                   │
    │                   ├── entity
    │                   │   ├── StatusAtendimento.java
    │                   │   └── Usuario.java
    │                   │
    │                   ├── enums
    │                   │   ├── PerfilUsuario.java
    │                   │   └── StatusTecnico.java
    │                   │
    │                   ├── repository
    │                   │   ├── StatusAtendimentoRepository.java
    │                   │   └── UsuarioRepository.java
    │                   │
    │                   ├── service
    │                   │   └── UsuarioService.java
    │                   │
    │                   └── CentralTiApplication.java
    │
    └── resources
        ├── templates
        │   ├── dashboard
        │   ├── fragments
        │   ├── login
        │   └── usuario
        │       ├── editar.html
        │       ├── listar.html
        │       └── novo.html
        │
        ├── application.properties
        └── application-local.properties
```

---

# 👤 Perfis de usuário

## 👑 Administrador

O perfil `ADMIN` será responsável por:

* 👤 cadastrar usuários;
* ✏️ editar usuários;
* 🗑️ excluir ou desativar usuários;
* 🔄 ativar usuários;
* ⚙️ acessar configurações administrativas;
* 📊 acompanhar atendimentos.

---

## 🧑‍💻 Técnico

O perfil `TECNICO` será responsável por:

* 📥 acessar a fila de atendimento;
* 🙋 assumir atendimentos;
* 💬 responder clientes;
* 📋 visualizar seus atendimentos;
* ✅ finalizar atendimentos;
* 📚 consultar o histórico permitido.

---

# 📌 Status do projeto

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
✅ Edição de usuários
✅ Alteração de nome
✅ Alteração de e-mail
✅ Alteração de perfil
✅ Ativação/desativação pela edição
✅ Alteração segura de senha
✅ Preservação da senha quando não alterada
```

---

## ⏭️ Próxima etapa

**Etapa 1.6 — desativação e exclusão de usuários.**

Nesta etapa serão implementados:

* controle mais claro de ativação e desativação;
* botão de exclusão;
* confirmação antes da exclusão;
* proteção contra exclusões indevidas;
* preparação para manter histórico de usuários ligados aos atendimentos.

Depois disso, o próximo grande módulo será:

```text
🔑 Login
        ↓
🔒 Spring Security
        ↓
👤 Identificação do técnico
        ↓
🎧 Atendimento
        ↓
📱 WhatsApp
```

---

# ℹ️ Observação

A automação será desenvolvida no próprio **Spring Boot**.

A API do WhatsApp será utilizada como meio de comunicação para receber e enviar mensagens.

A lógica de:

* criação da fila;
* identificação do técnico;
* abertura do atendimento;
* envio da apresentação;
* registro das mensagens;
* controle do responsável;
* finalização do atendimento;

será controlada pela aplicação **Central TI**.
