# Hướng dẫn tích hợp Swagger vào Spring Boot Project

## Tổng quan
Swagger (OpenAPI) đã được tích hợp thành công vào project **Eyewear Sales Backend**. Bạn có thể sử dụng Swagger UI để xem tài liệu API và test các endpoints.

---

## Các bước đã thực hiện

### ✅ Bước 1: Thêm dependency SpringDoc OpenAPI
Đã thêm dependency `springdoc-openapi-starter-webmvc-ui` vào [pom.xml](../pom.xml).

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.8.4</version>
</dependency>
```

> [!NOTE]
> Với Spring Boot 3.x, chúng ta sử dụng **SpringDoc OpenAPI** thay vì Springfox.

---

### ✅ Bước 2: Cấu hình Swagger trong application.properties
Đã thêm các cấu hình sau vào [application.properties](../src/main/resources/application.properties):

```properties
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.enabled=true
springdoc.swagger-ui.operationsSorter=method
```

---

### ✅ Bước 3: Cấu hình Spring Security
Đã cập nhật [SecurityConfig.java](../src/main/java/com/eyewear/backend/config/SecurityConfig.java) để cho phép truy cập Swagger UI mà không cần authentication.

---

### ✅ Bước 4: Tạo OpenAPI Configuration
Đã tạo file [OpenApiConfig.java](../src/main/java/com/eyewear/backend/config/OpenApiConfig.java) để cấu hình JWT Bearer Authentication.

---

### ✅ Bước 5: Thêm Swagger Annotations vào Controller
Đã cập nhật [AuthController.java](../src/main/java/com/eyewear/backend/controller/AuthController.java) với các annotations `@Tag`, `@Operation`, `@ApiResponses`.

---

## Cách sử dụng Swagger UI

### 1. Khởi động ứng dụng
```bash
cd ..
mvnw spring-boot:run
```

### 2. Truy cập Swagger UI
Mở trình duyệt và truy cập:
```
http://localhost:8080/swagger-ui.html
```

### 3. Test API với Authentication
1. Login API `/api/auth/login` để lấy token.
2. Click nút **"Authorize"** (🔓) ở góc trên bên phải.
3. Paste token vào ô input.
4. Click **"Authorize"**.
5. Test các endpoints khác.
