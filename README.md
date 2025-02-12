# 📘 Aplicație Web pentru Gestionarea Planurilor de Învățământ

## 📌 Descriere

Această aplicație web permite gestionarea eficientă a planurilor de învățământ, oferind suport pentru importarea și administrarea fișierelor Excel. Platforma este destinată administratorilor, profesorilor și studenților, permițând vizualizarea și actualizarea informațiilor academice într-un mod intuitiv.

## 🛠️ Tehnologii Utilizate

- **Backend:** Java, Spring Boot, Apache POI, MySQL
- **Frontend:** Thymeleaf, Bootstrap 5
- **Alte Tehnologii:** Hibernate, Spring Security

## 🚀 Funcționalități Principale

- 📂 Import automat de planuri educaționale din fișiere Excel
- 🏫 Administrarea disciplinelor și asignarea profesorilor
- 🔑 Autentificare și gestionare permisiuni

## 📥 Instalare și Configurare

### 1️⃣ Cerințe

- **Java 17+**
- **MySQL 8+**
- **Maven**

### 2️⃣ Instalare și rulare

1. **Clonează repository-ul:**

   ```sh
   git clone https://github.com/utilizator/proiect.git
   cd proiect
   ```

2. **Configurează baza de date MySQL:**

   - Creează baza de date `planuri_invatamant`
   - Editează `application.properties` cu datele corecte

3. **Rulează backend-ul (Spring Boot):**

   ```sh
   mvn spring-boot:run
   ```

## 📡 Ghid Rapid API-uri

### 🔹 Autentificare

- `POST /api/auth/login` - Login utilizator
- `POST /api/auth/signup` - Înregistrare utilizator nou
- `GET /api/auth/logout` - Logout utilizator

### 🔹 Administrare Planuri

- `POST /api/plans/inserare` - Import planuri de învățământ din Excel
- `GET /api/planInvatamant-read` - Listă planuri existente
- `GET /api/planInvatamant-read/{id}` - Detalii plan specific
- `DELETE /api/planInvatamant-delete/{id}` - Șterge un plan

### 🔹 Administrare Discipline

- `GET /api/discipline-read` - Listă discipline
- `POST /api/discipline-create` - Adaugă o disciplină nouă
- `GET /api/discipline-read/{id}` - Detalii disciplină
- `DELETE /api/discipline-delete/{id}` - Șterge disciplină

## 🤝 Contribuție

Dacă vrei să contribui:

1. **Forkuiește proiectul** 🍴
2. **Creează un branch nou:** `feature/noua-functionalitate` 🚀
3. **Fă un Pull Request** 📥

## 📝 Licență

Acest proiect este licențiat sub ****.

## 👨‍💻 Autor

**Daniel-Ionuț Mîrza** - [GitHub](https://github.com/Daniel051101/Planuri) 

