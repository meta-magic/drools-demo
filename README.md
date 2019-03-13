# Drools Demo

This demo focus on 3 key points
- Dynamically loading Drools [Rule file](https://github.com/meta-magic/drools-demo/blob/master/DB/droolsrule.txt) from DB in KSession
- Dynamically creating model which are defined in Drools File using [Declare](https://access.redhat.com/documentation/en-us/red_hat_jboss_bpm_suite/6.2/html/development_guide/sect-type_declaration)
- Get the runtime model defined in DRL and map the Incoming JSON structure to the Model

## Prerequisite before you start application
- Run [create](https://github.com/meta-magic/drools-demo/blob/master/DB/create-script.sql) and [load data](https://github.com/meta-magic/drools-demo/blob/master/DB/data.csv) before your proceed.

## Steps to run
- Start spring-boot application
  - mvn spring-boot:run
- Start angular application
  - ng serve


Open http://localhost:4200/ in browser, enter the required data and discount getting changed based on TYPE selection.

<img width="1673" alt="Screen Shot 2019-03-13 at 7 44 07 PM" src="https://user-images.githubusercontent.com/23295769/54285915-dc1a5600-45c8-11e9-9abe-1bb66f65de51.png">

<img width="1677" alt="Screen Shot 2019-03-13 at 7 44 16 PM" src="https://user-images.githubusercontent.com/23295769/54285932-e76d8180-45c8-11e9-84dd-3ecbb71c0a85.png">

<img width="1672" alt="Screen Shot 2019-03-13 at 7 45 56 PM" src="https://user-images.githubusercontent.com/23295769/54285940-e9cfdb80-45c8-11e9-9974-e77194d7e89e.png">


Thanks
Ketan

Enjoy!
