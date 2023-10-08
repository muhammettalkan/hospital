
# Hospital-Report App

### Purpose of App
The aim of the application is to be able to track the reports written
by labors to patients and to sort and display them according to various criteria.

### Technology Stack
- Java
- Spring Boot (Data JPA, Web, Validation, MySQL Driver)
- MySQL

## How to run the application
1. Clone the repository
2. Create a database schema named `hospital` with MySQL or configure it yourself in `application.yml` also configure the username and password
3. Make sure you have Maven and Java (Java 8 or higher version, preferably Java 17) installed
4. Run the application with `mvn spring-boot:run` command
5. Open `http://localhost:8080` in your browser or use Postman to test the endpoints
6. You can find the endpoints below

## Endpoints
### Patient Endpoints
- `POST /create` - Create a new patient

### Labor Endpoints
- `POST /create` - Create a new labor

### Report Endpoints
- `POST /create` - Create a new report
- `GET /findByPatient/{firstName}/{lastName}` - Find reports by patient's first and last name
- `GET /findByLabor/{firstName}/{lastName}` - Find reports by labor's first and last name
- `GET /find-patient?nationalId={nationalId}` - Find reports by patient's national id
- `GET /find-all-by-order?orderBy={orderBy}` - Find all reports and order them by given parameter (asc or desc)
- `GET /find-all` - Find all
- `PUT /update/{id}` - Update a report by id (Also requires a UpdateRequest body)
- `DELETE /delete/{id}` - Delete a report by id