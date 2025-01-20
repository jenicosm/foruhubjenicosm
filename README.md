Aquí tienes un README para tu repositorio de Git:

---

# ForoHub API - Gestión de Tópicos

Este proyecto es una implementación de un controlador para gestionar los tópicos de ForoHub, una plataforma que organiza y administra foros temáticos. La API permite crear, listar, actualizar, ocultar y consultar detalles de tópicos, integrando prácticas modernas como DTOs, seguridad con `@SecurityRequirement` y paginación con Spring.

---

## 📂 Estructura del Proyecto

### **Controlador: `TopicoController`**

Este controlador se encuentra en el paquete `api.alura.forohub.controller` y expone los endpoints relacionados con los tópicos.

### Funcionalidades Principales:

1. **Crear un Tópico**  
   Endpoint: `POST /topicos`  
   - Recibe datos mediante una clase DTO (`DatosRegistroTopico`) validada con `@Valid`.  
   - Retorna un objeto `DatosRespuestaTopico` con la información del tópico creado.  
   - Genera una URL dinámica con `UriComponentsBuilder`.

2. **Listar Tópicos**  
   Endpoint: `GET /topicos`  
   - Implementa paginación con `@PageableDefault`.  
   - Filtra los tópicos activos (`status = true`).

3. **Actualizar un Tópico**  
   Endpoint: `PUT /topicos`  
   - Actualiza campos específicos de un tópico mediante el DTO `DatosActualizarTopico`.  
   - Utiliza transacciones con `@Transactional`.

4. **Ocultar un Tópico**  
   Endpoint: `DELETE /topicos/{id}`  
   - Cambia el estado de un tópico a oculto en lugar de eliminarlo físicamente.

5. **Consultar un Tópico**  
   Endpoint: `GET /topicos/{id}`  
   - Retorna los detalles de un tópico específico mediante su ID.

---

## 🔒 Autenticación

La autenticación en esta API utiliza un controlador adicional para manejar el inicio de sesión. 

### Proceso de Autenticación:
1. **Definición del Controller**  
   - Utiliza `@RestController` y `@RequestMapping` para mapear el endpoint de autenticación.
   
2. **Recepción de Credenciales**  
   - Una clase DTO (implementada como instancia `Record` en Java) es responsable de recibir y validar los datos del usuario (nombre y contraseña).

3. **Gestión de Autenticación**  
   - El método `AuthenticationManager`, definido en la clase `SecurityConfigurations`, valida las credenciales y genera el token correspondiente.

### Buenas Prácticas:
- Usa `@PostMapping`, `@RequestBody` y `@Valid` para manejar y validar las solicitudes de autenticación.

---

## 🚀 Tecnologías Utilizadas

- **Java 17**  
- **Spring Boot**  
  - Spring Data JPA  
  - Spring Validation  
  - Spring Security  
- **Jakarta EE**  
  - Validaciones con `@Valid`  
  - Transacciones con `@Transactional`  
- **Swagger/OpenAPI**  
  - Anotación `@SecurityRequirement` para documentar la autenticación.  
- **Herramientas de Paginación**  
  - `Pageable` y `@PageableDefault` para consultas eficientes.

---

## 📄 Endpoints Disponibles

| Método | Endpoint           | Descripción                      |
|--------|--------------------|----------------------------------|
| POST   | `/topicos`         | Crear un nuevo tópico           |
| GET    | `/topicos`         | Listar todos los tópicos activos |
| PUT    | `/topicos`         | Actualizar un tópico existente  |
| DELETE | `/topicos/{id}`    | Ocultar un tópico por ID        |
| GET    | `/topicos/{id}`    | Consultar detalles de un tópico |

---

## 🛠️ Configuración

1. Clona este repositorio:  
   ```bash
   git clone https://github.com/tu_usuario/forohub-api.git
   ```

2. Configura tu base de datos en el archivo `application.properties` o `application.yml`.

3. Inicia la aplicación:  
   ```bash
   mvn spring-boot:run
   ```

4. Accede a la documentación Swagger en:  
   ```
   http://localhost:8080/swagger-ui.html
   ```

---

¡Explora y contribuye! 🚀
