Jumbo stores locator App:

Prerequisites:
	*JDK 8
	*Maven 3
	*Git (client)
	*IDE (I used IntelliJ IDEA)

Notes:
The WebApp is published on Azure and can be accessed through the following url: https://storelocator.azurewebsites.net/

Usage:
The user must click on the button "Find stores..." and allow the site to access its location
The App will use the user coordenites as Input to execute the algorithm from a REST service to obtain a JSON response with the result of the operation.
In the page will be displayed the following information:
	*The user coordinates
	*A map with its location and the 5 closest stores locations with their names as labels
	*A list denoting the stores names and the distance to them in kilometers or meters.
	
How to run the App locally?:
1)Create a local directory to hold the application (i.e mkdir jumbo-achievement)
2)Chage to that directory (i.e cd jumbo-achievement)
3)Download the source code from github with the following url: https://github.com/michaelrodas/jumbo-achievement.git
	(i.e git clone https://github.com/michaelrodas/jumbo-achievement.git)
4)Change to the directory of the complete project (i.e cd StoresLocator)
5)Launch the app by typing:  mvn clean spring-boot:run
6)Test the app locally using a web browerser by visiting: http://localhost:8080  
7)To run all unit test use the command: mvn clean test 

How to review the code and run the app from an IDE?:
1)Open IntelliJ IDEA
2)Select Import project, select the second option, select Maven and then click on next
3)On the next window select the project "StoresLocator"
4)Set the JDK as 1.8,click next and then click on Finish on next window
5)To run the app, open class StoresLocatorApplication, right click on it and select Run...
	Or create a Maven run configuration putting the command  "clean spring-boot:run" on it
6)Test the App on http://localhost:8080

Code/Project Structure:
	*Backend:
		*core: contains the classes with the logic, Location calculates distante to a point and StoreLocatorImpl is the service which finds the stores -it uses java streams and lambda expressions-
		*dao: contains the class StoreDAO to load the app's source database, in this case the JSON file.
		*dto: contains classes to transfer data in memory like Entities and POJOs
		*rest/controllers: contains the class StoreController which is a REST service used to invoke StoreLocator service to get the closest stores list
			It is a GET type request method, its path is /stores/{latitude}/{longitude}
		*Tests: All classes have unit tests using JUnit and Mockito
	*Frontend:
		Located in folder resources/public
		*assets/css: contains the file styles.css which includes html configurations for index page
		*assets/js: contains the class logic.component.js which has the logic to invoke the app's Backend and show the result
		*index.html loads the scripts and shows the result of the application