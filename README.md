README (only for part User, just now I develop user Profile)

# Service "Resources" Demo version

Resources is an open source service with a web interface and a WebAPI. It lets easily manage resources registered and located in the country, look up resources by type, properties or owners and manage ownership relations.

# Architecture

The application's backend is developed using Spring and JPA/Hibernate. 

View technology may vary for each framework. Here, JSP views are (re)used for most of current implementations. Thymeleaf is also planned to be used as alternative to JSPs.

URLs under /users, /roles etc. must be accessible to only logged users with right privileges. This requirement implemented using Spring Security

# Build and run
1. Check out the project source code from github.
  * Main developing project is https://github.com/softservedata/lv257.git 
  * This https://github.com/lyapandra/resourcesProject is my version of project for experiments
2. Import resources_MYSQL_DB.sql to newly created schema named mydatabase
3. IDE -> maven install
4. IDE -> Run maven build
5. Browse the following URL : localhost:8080/
6. You can register a new account or login using the following credentials : dbuser1 / 12345

PS If application don't run correctly at point 6, maybe database is filled uncorrect. In that way you should:
  * run src\main\resources\resources_MYSQL_DB_user_details.sql
  * check if user_account.id, user_details.id and user_details.id_user are equal and if users have permissions.

# My part of project Resources (now I develop user Profile):
UserProfile:
* DB.table is user_details (user_account is used for get user ID)
* Entity layer is UserDetails
* DAO layer is 
* DTO layer are UserProfile (for Profile.jsp), UserDetails. I use common GenericResourceDTO too.
* Service layer is userProfileService
* Controller layer are UserController (/profile) and MainController (/users and /account. When I begin to develope them I move them to UserController)
* View layer are:
  - [ ] /profile -> Profile.jsp (skeleton is partly ready. I need add some fields and upload image and pdf files), 
  - [ ] /users -> users.jsp (skeleton is partly ready.)
  - [ ] /account -> account.jsp (skeleton is partly ready.)

# Done
- [x] 1. Edit personal data of user: /profile
Get data from UserDetails Entity, put them to UserProfileDTO at UserController and display them at Profile.jsp 
- [x] 2. Take data from Profile.jsp, put them into UserProfileDTO at UserController
- [x] 3a. Save data from UserProfileDTO into UserDetails Entity (UserController @RequestMapping(value="/profile", method=RequestMethod.POST))

# Todo Profile.jsp
- [ ] 3b. Add other fields at Profile.jsp
- [ ] 3c. Add Exceptions handling
- [ ] 4. Create unit and integration tests (JUnit, TestNG) 