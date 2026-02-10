# Arquitetura de Microsserviços com Spring Boot, Docker e Kubernetes

Este projeto tem como objetivo demonstrar, na prática, a evolução da arquitetura de sistemas de software, partindo de conceitos modernos como **microsserviços**, **Docker** e **Kubernetes**, aplicados ao ecossistema **Java com Spring Boot**.

## 📌 Visão Geral

Nos últimos anos, a arquitetura de software passou por diversas transformações — dos grandes sistemas monolíticos até arquiteturas distribuídas baseadas em microsserviços. Atualmente, no mundo Java, o **Spring Boot** se consolidou como o framework mais utilizado para o desenvolvimento desse tipo de solução, facilitando configurações, dependências e boas práticas.

Porém, desenvolver microsserviços vai além de escrever código. Para executar uma aplicação completa — tanto em ambiente local quanto em produção — é necessário:

- Subir múltiplos serviços de forma consistente  
- Garantir a comunicação entre eles  
- Padronizar ambientes  
- Automatizar o deploy  

É nesse contexto que entram **Docker** e **Kubernetes**.

## 🎯 Objetivo do Projeto

Este repositório acompanha o desenvolvimento completo do back-end de uma aplicação Java baseada em microsserviços, inspirado no conteúdo do livro de **Eduardo Zambom Santana**.

Ao longo do projeto, são abordados:

- Desenvolvimento de microsserviços com **Spring Boot**
- Comunicação entre serviços
- Criação de imagens Docker
- Execução da aplicação em um **cluster Kubernetes**

## 🧩 Arquitetura da Aplicação

A aplicação é composta inicialmente por **três microsserviços independentes**, cada um com sua responsabilidade bem definida:

- **User Service**  
  Responsável pelo gerenciamento de usuários

- **Product Service**  
  Responsável pelo gerenciamento de produtos

- **Purchase Service**  
  Responsável pelo gerenciamento de compras e pela comunicação com os outros serviços

Cada serviço é desenvolvido de forma independente, seguindo os princípios de baixo acoplamento e alta coesão.

## 🐳 Docker

Após o desenvolvimento dos microsserviços, cada aplicação é empacotada em uma **imagem Docker**, permitindo:

- Padronização do ambiente
- Facilidade de execução local
- Preparação para ambientes de produção

## ☸️ Kubernetes

Por fim, os microsserviços são executados em um **cluster Kubernetes**, possibilitando:

- Orquestração dos contêineres
- Escalabilidade
- Gerenciamento de serviços
- Comunicação entre pods

## 🛠️ Tecnologias Utilizadas

- Java
- Spring Boot
- Maven
- Docker
- Kubernetes
- REST APIs

## 🚀 Como Executar o Projeto

> As instruções detalhadas para build, execução com Docker e deploy no Kubernetes podem ser encontradas nas pastas específicas de cada microsserviço.

## 📚 Referência

Projeto baseado nos conceitos apresentados no livro:

**Arquitetura de Microsserviços com Spring Boot, Docker e Kubernetes**  
Autor: *Eduardo Zambom Santana*

---

## 👨‍💻 Autor

Desenvolvido por **Diego Assunção**  
Back-end Developer 🚀
