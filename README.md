<div align = "center">
  <h1> Doctor Application </h1>
 </div>

## Framework and Language
* Java 
* SpringBoot

## Dependencies
  * SpringWeb
  * Lombok
  * Swagger
  * JPA
  * My SQL Server
  * Validation
    
## Database Used 
  * Sql

    
## Data flow
  **The project has four main packages which are following** 
* Controller - Controller package has all the api and Crud operations.
* Services - Service class has all the business logic and it will return the result of that method which is called by controller class . 
* Repository - Respository has all the datasource in it i uses SQL Database
#### Model - Model has two entity class Doctor and Patient
* Doctor - Doctor class has doctorId , Name , Email , Phone Number , City ( City is of enum type which has Delhi , Noida , Faridabad) , Speciality ( Speciality is of enum type which has four values  ORTHOPEDIC, GYNECOLOGY, DERMATOLOGY, ENT_SPECIALIST ).
> The flow of data is from controller has all the api and logics of that api has in service class and
service class is using the repository class which has all the data it keeps data source.The api called by user call the controller method
return the logic which is written in service class so service class object is called and service class use data source of repo class.

## Datastructure 
* ArrayList

## Project Summary 
This is Doctor application which is used to suggest doctor to patients based on their symptoms and location.Following operation can be performed :
* Doctor can be registred
* Doctor can be deleted
* Patient can be registred
* Patient can be deleted
* It suggest doctor to patient.
