## Vulnerable application

### Description
Simple backend spring boot application for lab2 assignment for [Advanced Web Development](https://www.fer.unizg.hr/en/course/awd) course that demonstrates Sensitive data exposure and Cross-Site Scripting vulnerabilities.

### Usage
Build application jar with gradle bootJar task.
```kotlin
./gradlew bootJar
```

Run docker-compose to start application and database.
```bash
cd support/docker/vulnerable-application-be
docker-compose up
```

### Vulnerabilities
Both vulnerabilities can be toggled on and off with request parameter `vulnerable` set to `true` or `false`. Default value is `false`.
```kotlin
@RequestParam(required = false, defaultValue = "false") vulnerable: Boolean
```

#### Sensitive data exposure
Sensitive data exposure vulnerability is implemented by exposing whole DAO layer to the client. The DAO contains too much information and exposes everything to the client without any obfuscation.
Fix for this vulnerability is implemented so the client recieves only the data it needs with separate DTO, all sensitive data is obfuscated on DTO creation as well.
Additionally, sensitive data in db should always be encrypted, for easier implementation data is kept in plain text.
#### Cross-Site Scripting 
Cross-Site Scripting vulnerability is implemented by not sanitizing user input. User input is directly saved in db/returned in the response without any sanitization. Toggling vulnerability on and off enables/disables regex validation.

### Frontend repo
[link](https://github.com/Theanko1412/vulnerable-application-fe)