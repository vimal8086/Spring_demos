<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register User</title>
       
    </head>
    <body>
        <div class="container">
            <div class="regbox box">
                <img class="avatar" src="img/collaboration.png">
                <h1>Register Account</h1>
	<form action="RegisterServlet" method="post">
                   <p>Username</p><input type="text" placeholder="Username" name="name" required>
                  
                   <p>Password</p><input type="password" placeholder="Password" name="password" required>
                   <input type="submit" value="Register">
                   
                  
                </form>
</div>
</div>
</body>
</html>
