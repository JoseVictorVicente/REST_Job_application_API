# REST Job Application API

Spring Boot REST API for job application forms. Clients submit and update candidate records. Admins list, view, and delete them.

## Tech stack

- Java 21
- Spring Boot 4.1.1
- Spring Web, Spring Data JPA, Spring Security
- H2 in-memory database

## Requirements

- JDK 21 or later
- Maven Wrapper is included (`mvnw` / `mvnw.cmd`)

## How to run

From the project root:

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

The API starts at `http://localhost:8080`.

H2 is in-memory. Data is lost when the application stops.

## Authentication

The API uses HTTP Basic Auth.

| Username | Password  | Role   | Access                         |
|----------|-----------|--------|--------------------------------|
| `admin`  | `admin123`| ADMIN  | `/admin/**`                    |
| `client` | `client123`| CLIENT | `/client/**`                   |

Unauthorized requests return `401`. A valid user calling the other role's endpoints returns `403`.

## Endpoints

### Client (`ROLE_CLIENT`)

| Method | URL                      | Description              |
|--------|--------------------------|--------------------------|
| POST   | `/client/candidate`      | Create a candidate       |
| PUT    | `/client/candidate/{id}` | Update an existing record|

### Admin (`ROLE_ADMIN`)

| Method | URL                      | Description           |
|--------|--------------------------|-----------------------|
| GET    | `/admin/candidate`       | List all candidates   |
| GET    | `/admin/candidate/{id}`  | Get one candidate     |
| DELETE | `/admin/candidate/{id}`  | Delete a candidate    |

### H2 console

Available at `http://localhost:8080/h2-console`.

- JDBC URL: `jdbc:h2:mem:candidatedb`
- User: `SA`
- Password: (empty)

## Example requests

Create a candidate (client):

```bash
curl -u client:client123 -H "Content-Type: application/json" -d @candidate.json http://localhost:8080/client/candidate
```

List all candidates (admin):

```bash
curl -u admin:admin123 http://localhost:8080/admin/candidate
```

Get one candidate (admin):

```bash
curl -u admin:admin123 http://localhost:8080/admin/candidate/1
```

### Sample JSON body

```json
{
  "objective_Position": "Systems Analyst",
  "name": "Maria Silva",
  "age": 28,
  "currentDate": "2026-09-09",
  "adress": "Rua das Flores, 100",
  "state": "SP",
  "cep": "01000-000",
  "telephone": "1133334444",
  "phone": "11999998888",
  "email": "maria@email.com",
  "birthDate": "1998-05-10",
  "sex": "F",
  "fatherName": "Jose Silva",
  "motherName": "Ana Silva",
  "maritalStatus": "Single",
  "sons": false,
  "daughters": false,
  "workedInTheCompany": false,
  "endDate": null,
  "otherActivities": "Basic English",
  "knowsPeopleThatWorkInTheCompany": false,
  "peopleYouKnowThatWorkInTheCompany": null,
  "signature": true,
  "background": [
    {
      "schoolOrCollege": "USP",
      "agency": "University",
      "startDate": "2017-02-01",
      "endDate": "2021-12-15",
      "graduated": true,
      "grade": "Bachelor"
    }
  ],
  "references": [
    {
      "name": "Carlos Souza",
      "relationship": "Former manager",
      "company": "Company X",
      "phone": "11988887777"
    }
  ],
  "priorJob": [
    {
      "lastCompany": "Company X",
      "phone": "1133332222",
      "startDate": "2022-01-10",
      "endDate": "2025-08-30",
      "reasonForLeaving": "Resignation",
      "adress": "Av. Paulista, 1000",
      "supervisor": "Carlos Souza",
      "position": "Developer",
      "startSalary": 4000.00,
      "endSalary": 6500.00,
      "responsabilities": "API development"
    }
  ]
}
```

A candidate record includes personal data plus lists of education (`background`), personal references (`references`), and previous jobs (`priorJob`).

## License

MIT License. See [LICENSE](LICENSE).
