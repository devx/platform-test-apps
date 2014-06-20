 Services Check Demo Application
=================================

This is a sample application to test the various components of a application stack.  There
are two parts to this application. The first is to create a REST service, and the
second part is to create a front end that consumes the REST API described below.
This applications are not ment for production, they are simply a demo/test.

This is not ment as a monitoring application, but more as a prove that all
components are working.

The second part is to create a website that is writen in angular.js and have it
consume the REST services made available by the application.

#### Application Available for:
Languages
  * [ ] Java
  * [ ] Python
  * [ ] PHP
  * [ ] Ruby
  * [ ] Node.js



#### Supported Checks
|  Web Servers  | Application Servers  | Data Store |
|--------------:|:--------------------:|----------:|
|  Apache | Tomcat  |  MySQL   |
|  Nginx  |         |  MongoDB |
|         |         |  Redis   |
|         |         |  Memcache|



## REST API



### Methods

The REST API will have the following methods.

| Resource URI | HTTP Method | Description |
|--------------|:------------:|------------:|
|/service/checks | GET        | Asks for all the checks available |
|/service/checks/{check ID} | GET | Ask for information about the check |
|/service/checks/{check ID} | PUT | Updates a specific Check  |
|/service/checks/{check ID} | DELETE | Request the deletion of a specific check |
|/service/checks/{check ID}/status | GET |Ask for the status of a specific check |
|/service/checks/{check ID}/execute | GET |Execute the check for the specified service |
|/service/checks/ | POST | Add a new check  |




### HTTP Status codes
It should also support the following HTTP status codes

| Resource URI | HTTP Method | HTTP Status Codes |
|--------------|:------------:|------------:|
|/service/checks | GET        | 200 (OK, Success) |
|/service/checks/{check ID} | GET | 200 (OK); 404 (Not Found) if Order Resource not found |
|/service/checks/{check ID} | PUT | 201 (Created); 406 (Not Acceptable) if there is a problem with the format of the incoming data on the new payment details; 404 (Not Found) if Order Resource not found |
|/service/checks/{check ID} | DELETE | 200 (OK); 404 (Not Found) if Order Resource not found |
|/service/checks/{check ID}/status | GET | 200 (OK); 404 (Not Found) if Order Resource not found |
|/service/checks/{check ID}/execute | GET | 200 (OK); 404 (Not Found) if Order Resource not found |
|/service/checks/add   | POST | 201 (Created) if the Order resource is successfully created, in addition to a Location header that contains the link to the newly created Order resource; 406 (Not Acceptable) if the format of the incoming data for the new resource is not valid|
