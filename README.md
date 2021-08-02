TODO-LIST PROJECT

Tech Stack used in this project :

1.OpenJdk 11

2.Spring boot

3.PostgreSql

API Endpoints Summary :

1. /user-register : If user does not have an account he/she can create by providing few details i.e.

 	1. Email
 	
 	2. First Name
 	 
 	3. Last Name
 	
 	4. Password
2. /authenticate : If the user is registered or already exists he/she can enter their username and password. If the credentials are correct JWT token will be generated using it user will be able to access further routes.

3. /create-task : If the user is logged in he/she can create a task by providing few details i.e.

	1. Title/Name of Task
	
	2. Due Date
	 
	3. Priority
4. /edit-task : If the user is logged in and there are already tasks present in the database, they can modify any column or detail of task.

5. /delete-task/{id} : User can delete any task.

6. /get-task/{id} : User can view any task using its id.

7. /tasks-list : If the user if logged in he/she will be able to view only their task.

8. /tasks : If it is required you can fetch all the tasks present in the database.