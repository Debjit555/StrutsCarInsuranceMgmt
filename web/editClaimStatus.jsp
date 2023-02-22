<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.108.0">
        <title>Edit Claim Status</title>
        <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">

        <!-- Favicons -->
        <link rel="apple-touch-icon" href="/docs/5.3/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
        <link rel="manifest" href="/docs/5.3/assets/img/favicons/manifest.json">
        <link rel="mask-icon" href="/docs/5.3/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon.ico">
        <meta name="theme-color" content="#712cf9">


        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/menu_css.css" rel="stylesheet">
        <link href="css/product.css" rel="stylesheet">
        <link href="css/sign-in.css" rel="stylesheet">

    </head>
    <body class="text-center">
        <jsp:include page="menu.jsp"></jsp:include>
            <main class="form-signin w-100 m-auto">

            <c:set var="user" value="${User}"></c:set>
                <form action="SaveClaimStatus" method="post">
                    <h1 class="h3 mb-3 fw-normal">Please Update Claim Status </h1>
                    <div class="form-floating">
                        <input type="text" class="form-control" id="floatingInput" placeholder="fnol_id" name="fnol_id" value=${Officer.getFnol_id()} readonly>
                    <label for="floatingInput">FNOL Id</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="user_id" name="user_id" value=${Officer.getUser_id()} readonly>
                    <label for="floatingInput">User Id</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="driverName" name="driverName" value=${Officer.getDriverName()} readonly>
                    <label for="floatingInput">Driver Name</label>
                </div>

                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="accident_type" name="accident_type" value=${Officer.getAccident_type()} readonly>
                    <label for="floatingInput">Accident Details</label>
                </div>

                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="fnol_status" name="fnol_status" value=${Officer.getFnol_status()} readonly>
                    <label for="floatingInput">Underwriter Status</label>
                </div>


                <div class="form-floating">

                    <select name="claim_status"  class="form-select" id="claim_status" required>

                        <option value=0>PENDING</option>  
                        <option value=1>APPROVED</option> 
                    </select>
                    <label for="floatingInput">Status</label>

                </div>



                <button class="w-100 btn btn-lg btn-primary" type="submit">Save</button>

                <p class="mt-5 mb-3 text-muted">&copy; 2023-2024 </p>
            </form>
        </main>

    </body>
</html>