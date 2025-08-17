# Foro Hub - API REST

Foro Hub es una API REST desarrollada en **Java 17 + Spring Boot** que permite gestionar un foro de discusión, con funcionalidades para crear, listar y administrar **tópicos**. El proyecto está pensado como una práctica de arquitectura limpia, seguridad con JWT y persistencia con **Spring Data JPA + MySQL**.

---

## 🚀 Tecnologías utilizadas

* **Java 17**
* **Spring Boot 3.x**
* **Spring Web** (REST Controllers)
* **Spring Data JPA** (persistencia)
* **Spring Security + JWT** (autenticación y autorización)
* **Hibernate** (ORM)
* **MySQL** (base de datos principal)
* **Maven** (gestor de dependencias)

---

## 📌 Funcionalidades principales

* Autenticación de usuarios con **JWT**
* Creación, actualización y eliminación de tópicos
* Listado de tópicos con **paginación y ordenamiento**
* Asociación de tópicos con **usuario** 
* Validaciones con **Bean Validation**

---

## 📖 Endpoints principales

### 👤 Usuarios

* `POST /usuarios` → Registrar un nuevo usuario.

### 🔑 Autenticación

* `POST /login` → Recibe usuario y contraseña, devuelve JWT válido.

### 📝 Tópicos

* `POST /topicos` → Crear un nuevo tópico
* `GET /topicos` → Listar tópicos (paginados y ordenados por fecha de creación)
* `GET /topicos/{id}` → Detalle de un tópico
* `PUT /topicos/{id}` → Actualizar un tópico
* `DELETE /topicos/{id}` → Eliminar un tópico

---

## 🔐 Seguridad

* Los endpoints están protegidos con **JWT**.
* Debes autenticarte en `/login` para obtener un token.
* En cada request, incluye el header:

  ```http
  Authorization: Bearer <tu_token>
  ```
  
---

## 👨‍💻 Autor

Proyecto desarrollado por **Pilar Morán** como parte de la práctica de desarrollo de APIs REST con Spring Boot, Alura Cursos.

---

## ⚙️ Clonar el Repositorio

   ```bash
   git clone https://github.com/pilar-moran/foro-hub.git
 

