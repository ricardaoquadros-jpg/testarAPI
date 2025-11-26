# 📱 Aplicativo TestarAPI – Android (Java/Kotlin)

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Volley](https://img.shields.io/badge/Volley-FFCA28?style=for-the-badge&logo=android&logoColor=black)
![MySQL](https://img.shields.io/badge/MySQL-00758F?style=for-the-badge&logo=mysql&logoColor=white)
![ChatGPT 5.1](https://img.shields.io/badge/ChatGPT_5.1-00A67D?style=for-the-badge&logo=openai&logoColor=white)
![Gemini 3 Pro](https://img.shields.io/badge/Gemini_3_Pro-AUTO?style=for-the-badge&logo=google&logoColor=white)

Este repositório contém o aplicativo **TestarAPI**, desenvolvido no **Android Studio** utilizando **Java** e partes em **Kotlin**, criado para consumir uma API REST desenvolvida no projeto abaixo:

👉 **API Backend (PHP + MySQL):**  
https://github.com/ricardaoquadros-jpg/cadastro43TI

O objetivo do app é permitir testes reais de requisições HTTP (GET, POST, UPDATE, DELETE) usando **Android + Volley**, consumindo dados do backend feito em Visual Code.

O desenvolvimento foi assistido e refinado com **ChatGPT 5.1** e **Gemini 3 Pro**, permitindo implementação mais rápida, organização de fluxo e correção de bugs.

---

## 🚀 Funcionalidades do Aplicativo

- 📡 Consumo da API via **Volley**
- 🔍 Busca de contatos por nome  
- 📋 Listagem dos registros retornados pela API  
- ➕ Inserção de novos dados (via endpoint)  
- ✏️ Atualização de entradas  
- 🗑 Exclusão de registros  
- 📱 Interface simples e funcional em XML  
- 🌐 Conexão direta com banco MySQL através da API PHP  

---

## 🛠 Tecnologias Utilizadas

### **Android / Mobile**
- Java  
- Kotlin  
- Android Studio  
- XML Layouts  
- Volley HTTP Client  

### **Backend (API Associada)**
> Repositório relacionado: https://github.com/ricardaoquadros-jpg/cadastro43TI  
- PHP  
- MySQL  
- PDO  
- Rotas REST (GET / POST / PUT / DELETE)  

### **Ferramentas que auxiliaram o desenvolvimento**
- ChatGPT 5.1 (auxílio em código, refatoração e arquitetura)  
- Gemini 3 Pro (refinamento de fluxos e correções)  
- Git & GitHub  

## 🧩 Arquitetura do Sistema

```mermaid
flowchart TB

    %% --- CAMADAS ---

    subgraph APP["📱 Aplicativo Android (Java/Kotlin)"]
        A1["MainActivity.java\n• Lê campos\n• Envia requisições\n• Atualiza UI"]
        A2["Volley HTTP Client\nGET / POST / PUT / DELETE"]
        A3["ListView + Adapter\nExibe contatos retornados da API"]
    end

    subgraph API["🖥 Backend PHP (cadastro43TI)"]
        B1["read.php\n🔎 Busca contatos"]
        B2["create.php\n➕ Inserção"]
        B3["update.php\n✏️ Atualização"]
        B4["delete.php\n🗑 Remoção"]
        B5["ContatosDAO.class.php\nAcesso ao banco (PDO)"]
        B6["Conexao.class.php\nConexão MySQL"]
    end

    subgraph DB["🗄 Banco de Dados MySQL"]
        C1["Tabela: contatos\n(id, nome, telefone, email)"]
    end


    %% --- FLUXO DE REQUISIÇÕES ---

    A1 --> A2

    %% GET
    A2 -- GET /read.php?nome= --> B1
    B1 --> B5 --> B6 --> C1
    C1 --> B1 --> A3

    %% POST
    A2 -- POST /create.php --> B2
    B2 --> B5 --> B6 --> C1

    %% PUT
    A2 -- PUT /update.php --> B3
    B3 --> B5 --> B6 --> C1

    %% DELETE
    A2 -- DELETE /delete.php?id= --> B4
    B4 --> B5 --> B6 --> C1
```
---

## 📁 Estrutura do Projeto (Resumo)

testarAPI/

├─ app/src/main/java/com/example/testarapi/

│ ├─ MainActivity.java

│ ├─ models/

│ ├─ adapters/

│ └─ utils/

├─ res/

│ ├─ layout/

│ │ ├─ activity_main.xml

│ │ └─ item_lista.xml

│ ├─ values/

│ └─ drawable/

├─ AndroidManifest.xml

├─ build.gradle

└─ README.md|


---

## 🔗 Conexão com a API

O aplicativo se conecta diretamente ao backend hospedado em servidor local (XAMPP) ou rede interna, consumindo endpoints como:

GET /view/read.php?nome=

POST /view/create.php

PUT /view/update.php

DELETE /view/delete.php?id=


Toda estrutura está disponível no repositório:  
➡ https://github.com/ricardaoquadros-jpg/cadastro43TI


## 🧑‍💻 Autor

**Ricardo Quadros**  
- Estudante de Engenharia da Computação na UERGS  
- Técnico em Informática na Dr. Solon Tavares 
- Estagiário de Tecnologia e Informação – Prefeitura de Guaíba  
- Guaíba, RS – Brasil

---

## 📫 Contato

- GitHub: https://github.com/ricardaoquadros-jpg  
- Email: ricardaoquadros@gmail.com
- Linkedin: https://www.linkedin.com/in/ricardopquadros/
