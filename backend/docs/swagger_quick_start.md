# Swagger Quick Start

## 🚀 Khởi động nhanh

### 1. Chạy ứng dụng
```bash
cd ..
mvnw spring-boot:run
```

### 2. Truy cập Swagger UI
```
http://localhost:8080/swagger-ui.html
```

---

## 📋 URLs quan trọng

| Mục đích | URL |
|----------|-----|
| **Swagger UI** | http://localhost:8080/swagger-ui.html |
| **API Docs JSON** | http://localhost:8080/api-docs |

---

## 🔑 Test API với JWT Token

### Bước 1: Login để lấy token
```
POST /api/auth/login
```

### Bước 2: Authorize trong Swagger
1. Click nút **"Authorize"** (🔓).
2. Paste JWT token.
3. Click **"Authorize"**.

---

## 📝 Các files đã thay đổi

- [pom.xml](../pom.xml)
- [application.properties](../src/main/resources/application.properties)
- [SecurityConfig.java](../src/main/java/com/eyewear/backend/config/SecurityConfig.java)
- [OpenApiConfig.java](../src/main/java/com/eyewear/backend/config/OpenApiConfig.java)
- [AuthController.java](../src/main/java/com/eyewear/backend/controller/AuthController.java)
