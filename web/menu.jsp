<%@page import="com.exavalu.models.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    
    
    <head>
        <title>Insurance Management</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta name="theme-color" content="#712cf9">

        <!-- Custom styles for this template -->
        <link href="css/header.css" rel="stylesheet">
        <!--<link href="css/carousel.css" rel="stylesheet">-->
        <style>
            #my-textarea{
                display:none;
            }
        </style>
        <style>
            #my-textareanew{
                display:none;
            }
        </style>
    </head>
    
    

    <script src="https://code.jquery.com/jquery-3.6.3.js" 
                        integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" 
                crossorigin="anonymous"></script>

    <script>
        function fetchEmployees(targetId, url)
                {
//            alert("'#"+selectedId.name+"'");
                        document.getElementById('nav_bar').style.display = 'none';
              $.ajax({

                                    url: url,

                                    success: function (responseText) {
//                        alert(responseText);
                                            $("#" + targetId).html(responseText);
                                    }
                            });
            
                }
    </script> 

<!--    <script>
        async function addDMVData() {
            document.getElementById("my-textarea").style.display="block";
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
    </script>-->
<!--    <script>
        async function addInsuranceData() {
            document.getElementById("my-textareanew").style.display="block";
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
    </script>-->


    <header class="p-3 text-bg-dark" id="nav_bar">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mx-auto" role="img" viewBox="0 0 24 24"><title>Product</title><circle cx="12" cy="12" r="10"/><path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"/></svg>
                </a>


                <c:set var="login_check" value="${Loggedin}"/>
                <c:set var="loginStatus_check" value="${LoggedinStatus}"/>
                <c:if test="${login_check!=null}">
                    <c:if test="${loginStatus_check=='User'}">

                        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                            <li><a href="addFnol.jsp" class="nav-link px-2 text-white" >Add FNOL </a></li>
                            <!--                        <li><a class="nav-link px-2 text-white" onclick="fetchEmployees('show','addemployee.jsp')" >Add </a></li>-->
                            <!--                        <li><a class="nav-link px-2 text-white" onclick="fetchEmployees('show','employeeDetails.jsp')">Show Employees</a></li>-->
                            <!--                        <li><a class="nav-link px-2 text-white" onclick="fetchEmployees('show','searchemployee.jsp')">Search </a></li>-->
                            <!--                         <li><a href="#" class="nav-link px-2 text-white">Sign Out</a></li>-->
                            <li><a href="fnolDetails.jsp" class="nav-link px-2 text-white" >See status </a></li>
                        </ul>

                        <c:set var="user" value="${User}"/>
                        <a class="nav-link px-2 text-white" href="#">
                            Welcome User: ${Loggedin.getFirstName()} ${Loggedin.getLastName()}</a>
                        </c:if>

                    <c:if test="${loginStatus_check=='Underwriter'}">

                        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                            <!--<li><a href="addFnol.jsp" class="nav-link px-2 text-white" >Add FNOL </a></li>-->
                            <!--                        <li><a class="nav-link px-2 text-white" onclick="fetchEmployees('show','addemployee.jsp')" >Add </a></li>-->
                            <!--                        <li><a class="nav-link px-2 text-white" onclick="fetchEmployees('show','employeeDetails.jsp')">Show Employees</a></li>-->
                            <!--                        <li><a class="nav-link px-2 text-white" onclick="fetchEmployees('show','searchemployee.jsp')">Search </a></li>-->
                            <li><a href="fnolDetailsUnderwriter.jsp" class="nav-link px-2 text-white" >See status </a></li>
<!--                            <li><a class="nav-link px-2 text-white" onclick="addInsuranceData()">Insurance Master</a></li>                         
                            <li><a class="nav-link px-2 text-white" onclick="addDMVData()">Fetch DMV API</a></li>-->
                        </ul>


                        <c:set var="user" value="${User}"/>
                        <a class="nav-link px-2 text-white" href="#">
                            Welcome Underwriter: ${Loggedin.getUnderwriterName()}</a>
                        </c:if>

                    <c:if test="${loginStatus_check=='Officer'}">

                        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                            <!--<li><a href="addFnol.jsp" class="nav-link px-2 text-white" >Add FNOL </a></li>-->
                            <!--                        <li><a class="nav-link px-2 text-white" onclick="fetchEmployees('show','addemployee.jsp')" >Add </a></li>-->
                            <!--                        <li><a class="nav-link px-2 text-white" onclick="fetchEmployees('show','employeeDetails.jsp')">Show Employees</a></li>-->
                            <!--                        <li><a class="nav-link px-2 text-white" onclick="fetchEmployees('show','searchemployee.jsp')">Search </a></li>-->
                            <!--                         <li><a href="#" class="nav-link px-2 text-white">Sign Out</a></li>-->
                            <li><a href="fnolDetailsOfficer.jsp" class="nav-link px-2 text-white" >See status </a></li>
                        </ul>


                        <c:set var="user" value="${User}"/>
                        <a class="nav-link px-2 text-white" href="#">
                            Welcome Officer: ${Loggedin.getOfficerName()}</a>
                        </c:if>

                </c:if>

                <c:if test="${login_check==null}">

                    <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                        <!--                        <li><a href="login.jsp" class="nav-link px-2 text-white">Add FNOL</a></li>-->
                        <!--                        <li><a href="login.jsp" class="nav-link px-2 text-white">Show Status</a></li>-->
<!--                        <li><a href="underwriterLogin.jsp" class="nav-link px-2 text-white">Underwriter Login </a></li>
                        <li><a href="officerLogin.jsp" class="nav-link px-2 text-white">Officer Login </a></li>-->

                        <!--                        <li><a href="login.jsp" class="nav-link px-2 text-white">Update</a></li>
                                                <li><a href="ApiFetch" class="nav-link px-2 text-white">API Call</a></li>-->


                    </ul>

                </c:if>


                <div class="text-end">
                    <% if (request.getSession().getAttribute("Loggedin") == null) {%>

                    <a href="login.jsp">
                        <button type="button" class="btn btn-outline-light me-2" >Login</button>
                    </a>
                    <!--                    <a href="PreSignUp">
                                            <button type="button" class="btn btn-warning">Sign-up</button>
                                        </a>-->
                    <%
                    } else {%>

                    <a href="Logout">
                        <button type="button" class="btn btn-outline-light me-2" >Log Out</button>
                    </a>
                    <%
                        }
                    %>


                </div>
            </div>
        </div>

    </header>
    <div name="show"  id="show" ></div>
<!--    <textarea id="my-textarea" name="name" rows="10" cols="50"></textarea>
    <textarea id="my-textareanew" name="name2" rows="10" cols="40"></textarea>-->