
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
- `GET /patients` - Find all
- `GET /patients/national-id` - Find a patient by national id (Requires a national id as a parameter)
- `POST /patients/create` - Create a new patient
- `POST /patients/login` - Login a patient (Requires a LoginRequest body)

### Labor Endpoints
- `GET /labors` - Find all
- `POST /create` - Create a new labor
- `POST /login` - Login a labor (Requires a LoginRequest body)
- `GET /hospital-id` - Find a labor by hospital id (Requires a hospital id as a parameter)

### Report Endpoints
- `POST reports/create` - Create a new report (Requires a ReportDto body)
- `GET reports/find-by-patient-name/{firstName}/{lastName}` - Find reports by patient's first and last name
- `GET reports/find-by-labor-name/{firstName}/{lastName}` - Find reports by labor's first and last name
- `GET reports/find-patient?nationalId={nationalId}` - Find reports by patient's national id
- `GET reports/find-all-by-order?orderBy={orderBy}` - Find all reports and order them by given parameter (asc or desc)
- `GET reports/find-all` - Find all
- `PUT reports/update` - Update a report by id (Requires id as request param, also requires a UpdateRequest body)
- `DELETE reports/delete/{id}` - Delete a report by id (int)

### Custom Response Codes
- `200` - OK
- `1001` - Your hospital id must be 7 characters
- `1002` - Username or password is incorrect
- `1003` - National id must be 11 characters