![](https://upload.wikimedia.org/wikipedia/commons/8/8d/Jumbo_Logo.svg)
# Jumbo stores locator App:

## Prerequisites:
	* JDK 8
	* Maven 3
	* Git (client)
	* IDE (I used IntelliJ IDEA)

>#### Notes:
>>The WebApp is published on Azure and can be accessed through the following url: [Published App](https://storelocator.azurewebsites.net/)

## Usage:
1. The user must click on the button `Find stores...` and allow the site to access its location
2. The App will use the user coordinates as Input to execute the algorithm from a REST service to obtain a JSON response with the result of the operation.
3. In the page will be displayed the following information:
    * The user coordinates
    * A map with its location and the 5 closest stores locations with their names as labels
    * A list denoting the stores names and the distance to them in kilometers or meters.
	
## How to run the App locally?:
1. Create a local directory to hold the application (i.e `mkdir jumbo-achievement`)
2. Change to that directory (i.e `cd jumbo-achievement`)
3. Download the source code from github with the following url: https://github.com/michaelrodas/jumbo-achievement.git
	(i.e `git clone https://github.com/michaelrodas/jumbo-achievement.git`)
4. Change to the directory of the complete project (i.e `cd StoresLocator`)
5. Launch the app by typing:  `mvn clean spring-boot:run`
6. Test the app locally using a web browser by visiting: `http://localhost:8080` 
7. To run all unit test use the command: `mvn clean test` 

## How to review the code and run the app from an IDE?:
1. Open _IntelliJ IDEA_
2. Select Import project, select the second option, select Maven and then click on next
3. On the next window select the project _StoresLocator_
4. Set the JDK as 1.8, click next and then click on Finish on next window
5. To run the app, open class _StoresLocatorApplication_, right click on it and select Run...
	Or create a Maven run configuration putting the command `clean spring-boot:run` on it
6. Test the App on [localhost](http://localhost:8080)
7. Api Documentation on [Swagger UI](http://localhost:8080/swagger-ui.html)

### Code/Project Structure:
* `Backend`:
    * `core`: contains the classes with the logic, Location calculates distant to a point and StoreLocatorImpl is the service which finds the stores -it uses java streams and lambda expressions-
    * `dao`: contains the class StoreProvider to load the app's source database, in this case the JSON file.
    * `dto`: contains classes to transfer data in memory like Entities and POJOs
    * `rest/controllers`: contains the class StoreController which is a REST service used to invoke StoreLocator service to get the closest stores list
			It is a GET type request method, its path is `/stores/{latitude}/{longitude}`
	* `util`: Utilitarian classes for additional calculations		
  * `Tests`: All classes have unit tests using JUnit and Mockito
* `Frontend` (Located in the folder _resources/public_):
    * `assets/css`: contains the file styles.css which includes html configurations for index page
    * `assets/js`: contains the class logic.component.js which has the logic to invoke the app's Backend and show the result
    * `index.html` loads the scripts and shows the result of the application