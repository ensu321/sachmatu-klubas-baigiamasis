# Baigiamasis darbas šachmatų klubas
This is a simple Java application that performs CRUD (Create, Read, Update, Delete) operations on a database. The application is built using Java and the Spring framework.
The aim of the system is to allow chess club administrator to register new players to the club and manage the players data view, delete and edit. 
Tech stack'as
*  Front-end:
    * HTML
    * CSS
    * JavaScript
* Back-end:
  * Spring / Spring Boot
  * Java 17
* Database:
  * MySQL

Funkciniai reikalavimai
* Žaidėjų registravimo forma:
    * Formos laukai:
        * Vardas
        * Pavardė
        * El. Paštas
        * Asmens kodas
        * Data nuo kurios pradėjo žaisti šachmatais
        * Užregistruotų žaidėjų sąrašo peržiūra
    * Sąraše atvaizduojami laukai:
        * Vardas
        * Pavardė
        * El. Paštas
        * Lytis (Jei nesigauna – praleisti, asmens kodas negali būti atvaizduojamas)
        * Amžius (Jei nesigauna – praleisti, asmens kodas negali būti atvaizduojamas)
        * Šachmatų žaidimo patirtis metais ir mėnesiais (Pvz: “1 m. 3 mėn.”) (Jei 
        nesigauna - rodyti datą nuo kurios pradėjo žaisti)
        * Administravimo mygtukai
* Užregistruotų žaidėjų redagavimas (galimybė pakeisti esamus duomenis)
* Užresigstruotų žaidėjų trinimas
* Programa turi veikti tiek su XXa., tiek su XXIa. gimusių lietuvių asmens kodais 
* Visi duomenys turi būti saugomi duomenų bazėje
* Duomenų bazėje privalo būti sudėti reikiami “Primary Key” ir “Foreign Key” raktai
* Bent minimalus dizainas (tam puikiai tiktų bet kuris CSS framework’as)

## Installation

    1. Clone the repository:
    git clone https://github.com/ensu321/sachmatu-klubas-baigiamasis/

    2. Open the project in your IDE of choice (e.g. Eclipse, IntelliJ IDEA).

    3. Build the project using Maven
    mvn clean install

    4.java -jar target/Sachmatu-klubas-0.0.1-SNAPSHOT.jar

## Configuration

    The application uses a MySQL database. You can configure the database connection in the application.properties file. 
    sachmatuKlubas/src/main/resources/application.properties



## API Reference

The application provides RESTful API endpoints for performing CRUD operations on a database. The following endpoints are available:
#### Get all items

```http
  GET http://localhost:8080/player
```


#### Get item

```http
  GET http://localhost:8080/player/:id
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `number` | get player by id |

#### Add player

```http
  POST http://localhost:8080/player
```

#### Delete player by id

```http
  DELETE http://localhost:8080/player/:id
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `number` | delete player by id |

You can use a tool like Postman to test the endpoints. Postman collection have been added with examples, check Appendix.

## Appendix

API postman request collection JSON file named: sachmatu-klubas-baigiamasis-requests.postman_collection. 
Relative path: sachmatuKlubas/sachmatu-klubas-baigiamasis-requests.postman_collection.json

## Authors

- [@ensu321](https://github.com/ensu321/sachmatu-klubas-baigiamasis/)
