# Web Scraper: Java, Spring Framework & Jsoup

A RESTful API which fetches data from multiple web addresses (URLs) by parsing specific elements from their HTML structure. Implemented concurrency to speed up the process. Used Swagger for documentation of API.

## Features

**Note:** It is not a violation of Wikipedia's site to scrape their data as long as the [Terms of Use](https://foundation.wikimedia.org/wiki/Terms_of_Use/en#12._Termination) are not violated. [Wikipedia's Licence](https://en.wikipedia.org/wiki/Wikipedia:Text_of_Creative_Commons_Attribution-ShareAlike_3.0_Unported_License) allows for free & legal usage of the data.

**Completed**

It scrapes data about movies from Wikipedia. Currently, it targets the URLs within this URL: https://en.wikipedia.org/wiki/Lists_of_American_films; it fetches data of movies by year. 

* It fetches the following data for each movie:

  * Title
  * Director
  * Genre

* It returns data as a 'Set of Strings' in JSON.

**In Progress**

* Integrate a PostgreSQL database.
* In addition, fetch for each movie: cast, year, country and notes. 
* Publish public API.
* Define requirements for a **front-end**.
  * Research and evaluate best technology options to develop a dashboard.

## Tech stack

### Back-End

* REST API
* Java 8 
  * Stream API: used class Collectors for fast/simpler manipulation of the data (map-reduce paradigm).
  * Concurrency: 
* Spring Framework
* Jsoup (Java Library) for fetching URLs and extracting and manipulating data.

## Run Program


## Testing & Documentation of API

**Completed**

* This is a collection of the requests tested on the API: https://documenter.getpostman.com/view/16169448/UV5Rmfa7

* Documentation of API in Swagger: 
  
  > Swagger Documentation
  
  ![Swagger Documentation](web-scraper-swagger-pic1.JPG)
  
**In Progress**

* Implement Monte Carlo testing for concurrency.

## Demo Pictures

> Demo 1
  
![Demo1](web-scraper-swagger-pic2.JPG)

> Demo 2
  
![Demo2](web-scraper-swagger-pic3.JPG)

> Demo 3
  
![Demo3](web-scraper-swagger-pic4.JPG)

> Demo 4
  
![Demo4](DBwithAllColumnsSeeded.JPG)

> Demo 5
  
![Demo5](DBwithAllColumnsSeeded2.JPG)

> Demo 6
  
![Demo6](DBwithAllColumnsSeeded4.JPG)


