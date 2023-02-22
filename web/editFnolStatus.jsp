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
        <title>Edit FNOL Status</title>
        <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">

        <!-- Favicons -->
        <link rel="apple-touch-icon" href="/docs/5.3/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
        <link rel="manifest" href="/docs/5.3/assets/img/favicons/manifest.json">
        <link rel="mask-icon" href="/docs/5.3/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon.ico">
        <meta name="theme-color" content="#712cf9">

<!--
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/menu_css.css" rel="stylesheet">
        <link href="css/product.css" rel="stylesheet">
        <link href="css/sign-in.css" rel="stylesheet">-->
        <style>
            #textboxes1{
                display:flex;
            }
             #mainform{
               
                padding: 10px;
            }
            #textboxes{
                display:flex;
                justify-content: space-evenly;
                justify-content: space-around;
                width: 1000px;
                padding: 20px;
            }
            #submitbuttons{
                display:flex;
                justify-content: space-evenly;

            }
        </style>
    </head>


    <script>
        async function addInsuranceData() {
            document.getElementById("my-textareanew").style.display = "block";
            const res = await fetch('https://retoolapi.dev/OUN6Rg/data');
            r = await res.json();

            console.log(r);
            r.forEach((obj, i) => {
                document.getElementById("my-textareanew").value += "Email: " + obj.email + "\r\n";
                document.getElementById("my-textareanew").value += "First Name: " + obj.firstName + "\r\n";
                document.getElementById("my-textareanew").value += "Last Name: " + obj.lastName + "\r\n";
                document.getElementById("my-textareanew").value += "Credit Score: " + obj.creditScore + "\r\n";
                document.getElementById("my-textareanew").value += "Date: " + obj.Date + "\r\n";
                document.getElementById("my-textareanew").value += "^^^^^^^^^^^^^^^^^^^^^^^^^\r\n";
            });
        }
    </script>
    <script>
        async function addDMVData() {
            document.getElementById("my-textarea").style.display = "block";
            const res = await fetch('https://retoolapi.dev/Zzci51/data');
            r = await res.json();

            console.log(r);
            r.forEach((obj, i) => {
                document.getElementById("my-textarea").value += "Email: " + obj.emailAddress + "\r\n";
                document.getElementById("my-textarea").value += "Driver Name: " + obj.driverName + "\r\n";
                document.getElementById("my-textarea").value += "Accident Date: " + obj.accidentDate + "\r\n";
                document.getElementById("my-textarea").value += "Driver License: " + obj.driverLicense + "\r\n";
                document.getElementById("my-textarea").value += "^^^^^^^^^^^^^^^^^^^^^^^^^^^\r\n";
            });
        }
    </script>
    <body class="text-center">

        <jsp:include page="fnolDetailsUnderwriter.jsp"></jsp:include>
            <main class="form-signin w-50" id="mainform">


                <!--                <form >
                
                                    <div class="form-floating">
                                        <input type="text" class="form-control" id="floatingInput" placeholder="fnol_id" name="fnol_id" value=${Underwriter.getFnol_id()} readonly>
                                    <label for="floatingInput">FNOL Id</label>
                                </div>
                                <div class="form-floating">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="user_id" name="user_id" value=${Underwriter.getUser_id()} readonly>
                                    <label for="floatingInput">User Id</label>
                                </div>
                                <div class="form-floating">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="driverName" name="driverName" value=${Underwriter.getDriverName()} readonly>
                                    <label for="floatingInput">Driver Name</label>
                                </div>
                
                                <div class="form-floating">
                                    <input type="text" class="form-control" id="floatingInput" placeholder="accident_type" name="accident_type" value=${Underwriter.getAccident_type()} readonly>
                                    <label for="floatingInput">Accident Details</label>
                                </div>
                
                
                                                <div class="form-floating">
                                                    
                                                    <select name="fnol_status"  class="form-select" id="fnol_status" required>
                                
                                                        <option value="PENDING">PENDING</option>  
                                                        <option value="APPROVED">APPROVED</option> 
                                                        <option value="REJECTED">REJECTED</option> 
                                                    </select>
                                                    <label for="floatingInput">Status</label>
                                
                                                </div>
                                <div display="flex">  <button class="w-40 btn btn-lg btn-primary" onclick="addInsuranceData()">Insurance Master</button>
                                    <button class="w-40 btn btn-lg btn-primary" onclick="addDMVData()">DMV Data</button>
                                </div>
                
                                                <div display="flex">
                                                    <button value="APPROVE" class="w-100 btn btn-lg btn-primary" name="fnol_status" id="fnol_status" type="submit">Approve</button>
                                                    <button value="REJECTED" class="w-100 btn btn-lg btn-primary" name="fnol_status" id="fnol_status" type="submit">Reject</button>
                                                </div>
                
                
                            </form>-->

            <c:set var="user" value="${User}"></c:set>


                <div display="flex" id="textboxes">
                    <textarea id="id" name="name" rows="4" cols="60">
                FNOL Id: ${Underwriter.getFnol_id()}
                User Id: ${Underwriter.getUser_id()}
                Driver Name: ${Underwriter.getDriverName()}
                Accident Details: ${Underwriter.getAccident_type()}
                
                </textarea>
                <div display="flex" id="textboxes1">  <textarea id="my-textarea" name="name" rows="4" cols="50" ></textarea>
                    <textarea id="my-textareanew" name="name2" rows="5" cols="40" ></textarea></div></div>

            <div display="flex">  <button class="w-40 btn btn-lg btn-primary" onclick="addInsuranceData()">Insurance Master</button>
                <button class="w-40 btn btn-lg btn-primary" onclick="addDMVData()">DMV Data</button>
            </div>




            <!--            <div display="flex">
                            <button value="APPROVE" class="w-50 btn btn-lg btn-primary" name="fnol_status" id="fnol_status" type="submit">Approve</button>
                            <button value="REJECTED" class="w-50 btn btn-lg btn-primary" name="fnol_status" id="fnol_status" type="submit">Reject</button>
                        </div>-->
        </main>

        <!--        <div display="flex">
                    <button value="APPROVE" class="w-100 btn btn-lg btn-primary" name="fnol_status" id="fnol_status" type="submit">Approve</button>
                    <button value="REJECTED" class="w-100 btn btn-lg btn-primary" name="fnol_status" id="fnol_status" type="submit">Reject</button>
                </div>-->
        <div display="flex" id="submitbuttons">
            <form action="Approve" method="post">
                <button class="btn btn-lg btn-primary" type="submit">Approve</button>
            </form>
            <form action="Reject" method="post">
                <button class="btn btn-lg btn-primary" type="submit">Reject</button>
            </form>
        </div>
    </body>
</html>