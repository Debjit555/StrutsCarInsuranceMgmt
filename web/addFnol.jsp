<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.108.0">
        <title>Add FNOL</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">




        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--        <link href="css/header.css" rel="stylesheet">-->
        <!--        <link rel="stylesheet" href="css/all.min.css">
                <link rel="stylesheet" href="css/reset-min.css">
                <link rel="stylesheet" href="css/algolia-min.css">
                <link rel="stylesheet" href="css/header.css">
                <link rel="stylesheet" href="css/docs.min.css">
                <link rel="stylesheet" href="css/index.css">-->

        <!-- Favicons -->
        <link rel="apple-touch-icon" href="/docs/5.3/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
        <link rel="manifest" href="/docs/5.3/assets/img/favicons/manifest.json">
        <link rel="mask-icon" href="/docs/5.3/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon.ico">
        <meta name="theme-color" content="#712cf9">





        <!-- Custom styles for this template -->
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link href="css/menu_css.css" rel="stylesheet" >
        <link href="css/product.css" rel="stylesheet" >
        <!--        <link href="css/signin.css" rel="stylesheet">-->

    </head>
    <body class="text-center">
        <div id="body">
            <jsp:include page="menu.jsp"></jsp:include>

                <main class="form-signin w-50 m-auto">
                  

                    <form action="AddFNOL" method="post" id="myForm">


                        <h1 class="h3 mb-3 fw-normal">Please add FNOL details</h1>
                        
                       <div class="form-floating">
                       <input type="text" class="form-control" id="floatingInput" placeholder="user id" name="user_id" value=${Loggedin.getUser_id()} readonly>
                    <label for="floatingInput">User Id</label>
                </div>

                        <div class="form-floating">
                            <input type="text" class="form-control" id="floatingInput" placeholder="driver name" name="driverName" required>
                            <label for="floatingInput">Driver Name</label>
                        </div>
                        <div class="form-floating">
                            <input type="text" class="form-control" id="floatingInput" placeholder="accident_type" name="accident_type" required>
                            <label for="floatingInput">Type of Accident</label>
                        </div>

                       


                    <button class="w-100 btn btn-lg btn-primary" type="submit" id="submitBtn">Submit</button>

                </form>
            </main>

        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        

        <div id="responseDiv" ></div>


    </body>
</html>
