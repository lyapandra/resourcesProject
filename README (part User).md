# Service "Resources" Demo version

Resources is an open source service with a web interface and a WebAPI. It lets easily manage resources registered and located in the country, look up resources by type, properties or owners and manage ownership relations.

# Architecture

The application's backend is developed using Spring and JPA/Hibernate. 

View technology may vary for each framework. Here, JSP views are (re)used for most of current implementations. Thymeleaf is also planned to be used as alternative to JSPs.

URLs under /users, /roles etc. must be accessible to only logged users with right privileges. This requirement implemented using Spring Security

# Build and run
1. Check out the project source code from github. 
Main developing project is https://github.com/softservedata/lv257.git 
This https://github.com/lyapandra/resourcesProject is experiment project
  
2. Import resources_MYSQL_DB.sql to newly created schema named mydatabase

3. Open a terminal and run the following command from root directory : mvn install
4. Choose a web framework to test and run it. For example : cd todolist-web-springmvc && mvn tomcat7:run
5. Browse the following URL : localhost:8080/
6. You can register a new account or login using the following credentials : dbuser1 / 12345
PS If application don't run correct maybe database is filld uncorrect. In that way you should:
* run src\main\resources\resources_MYSQL_DB_user_details.sql
* check if user_account.id, user_details.id and user_details.id_user are equal.


# Done
1. Edit personal data of user: /profile
Get data from UserDetails Entity, put them to UserProfileDTO at UserController and display them at Profile.jsp 
2. Take data from Profile.jsp, put them into UserProfileDTO at UserController

# Todo Profile.jsp
3. Save data from UserProfileDTO into UserDetails Entity (UserController @RequestMapping(value="/profile", method=RequestMethod.POST))
4. Use tests (JUnit, TestNG) 
