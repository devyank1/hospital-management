<h1 align="center">
Hospital API
</h1>

## 📚 Project
API made for a hospital, with Services and HTTP methods.

## 🔍 Operation Flows

1. **Find (GET Method):** Return a List or specific class called.
2. **Create (POST Method):** Create a info on database.
3. **Modify (PUT Method):** Modify a info setted in the persistence.
4. **Delete (DELETE Method):** Picks a info and delete.

## 👨‍💻 Endpoints

<details>
<summary><b>Medic</b></summary>
<img src="\api-medical\src\main\java\com\hospital\api_medical\img\img1.png" alt="">
</details>

<details>
<summary><b>Patient</b></summary>
<img src="\api-medical\src\main\java\com\hospital\api_medical\img\img2.png" alt="">
</details>

<details>
<summary><b>Schedule</b></summary>
<img src="\api-medical\src\main\java\com\hospital\api_medical\img\img3.png" alt="">
</details>

<details>
<summary><b>Medic Disponibility</b></summary>
<img src="" alt="">
</details>


```mermaid
classDiagram
    class Patient {
        Long id
        String name
        String email
        String number
        Date birth_date
        String cpf
    }

    class Medic {
        Long id
        String name
        String specialty
        String crm
        String number
        String email
    }

   class MedicDisponibility {
        Long id
        LocalDate data
        List~String~ avaliableHours
        Long id_medic
    }

    class Scheduling {
        Long id
        LocalDateTime dateHour
        String status
        Long id_patient
        Long id_medic
    }

    Pacient "1" --> "0..*" Scheduling : "possui"
    Medic "1" --> "0..*" Scheduling : "realiza"
    Medic "1" --> "0..*" MedicDisponibility : "tem"
```

## 💻 Technology

- Language: Java
- Framework: Spring Framework
- Database: PostgreSQL
- Maven
- Junit5
- Mockito
