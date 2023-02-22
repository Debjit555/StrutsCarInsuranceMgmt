<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--        <link href="css/header.css" rel="stylesheet">-->
      
        <title>FNOL Claim Details</title>
        
    </head>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <!<!-- I want to check my session before showing any content to the user -->


<jsp:include page="menu.jsp"></jsp:include>
        <div id="example">
            <script>
                init({
                    title: 'Large data',
                    desc: 'Use `virtualScroll` to enable the virtual scroll to play with large data sets (10000 rows).',
                    links: ['bootstrap-table.min.css'],
                    scripts: ['bootstrap-table.min.js']
                });
            </script>



            <div class="bootstrap-table bootstrap5">
                <div class="fixed-table-toolbar"><div class="bs-bars float-left">

                    </div><div class="columns columns-right btn-group float-right"><div class="keep-open btn-group" title="Columns">
                            <div class="dropdown-menu dropdown-menu-right" style=""><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="id" value="0" checked="checked"> <span>ID</span></label><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="name" value="1" checked="checked"> <span>Item Name</span></label><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="price" value="2" checked="checked"> <span>Item Price</span></label></div></div></div></div>

                <div class="fixed-table-container fixed-height" style="height: 542px; padding-bottom: 50.5px;">

                    <div class="fixed-table-body">
                        <table id="table" data-height="400" data-virtual-scroll="true" class="table table-bordered table-hover" style="margin-top: -9.5px;">
                            <table id="example" class="table table-striped border">
                                <thead>
                                    <tr class="backgroud_color">
                                        <th>
                                            FNOL Id
                                        </th>
                                        <th>
                                            User Id
                                        </th>
                                        <th>
                                            Driver Name
                                        </th>
                                        <th>
                                            Accident Details
                                        </th>
                                        
                                        <th>
                                            Claim Status
                                        </th>
                                        <th>
                                            Action
                                        </th>
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${officerList}" var="user">
                                    <tr>
                                        <td>
                                            ${user.getFnol_id()}
                                        </td>
                                        <th scope="row">
                                            ${user.getUser_id()}                    </th>
                                        <th scope="row">
                                            ${user.getDriverName()}                    </th>
                                        <td>
                                            ${user.getAccident_type()}                    </td>
                                        
                                        
                                        <td>
                                            <c:if test="${user.getClaim_status()==0}">
                                                <c:out value="${'PENDING'}"/>  
                                            </c:if>  
                                            <c:if test="${user.getClaim_status()==1}">
                                                <c:out value="${'APPROVED'}"/>  
                                            </c:if>                   
                                        </td>
                                        
                                        
                                         <td>   <!-- <form action="Edit" method="Post">
                                                <button class="w-100 btn btn-lg btn-primary" type="submit">Edit</button>
                                            </form> -->
                                            
                                          <a href=EditClaimStatus?fnol_id=${user.getFnol_id()}>
                                                Edit</a>                    
                                       </td>
                                    </tr>

                                </c:forEach>
                            </tbody>
                        </table>

                    <div class="fixed-table-footer" style="display: none;"></div>
                </div>
                <div class="fixed-table-pagination" style="display: none;"></div>
            </div>
<!--            <div class="clearfix"></div>

            <script>
                var $table = $('#table')
                var total = 0

                function getData(number, isAppend) {
                    if (!isAppend) {
                        total = 0
                    }
                    var data = []
                    for (var i = total; i < total + number; i++) {
                        data.push({
                            'id': i,
                            'name': 'Item ' + i,
                            'price': '$' + i
                        })
                    }
                    if (isAppend) {
                        total += number
                    } else {
                        total = number
                    }
                    $('#total').text(total)
                    return data
                }

                function mounted() {
                    $table.bootstrapTable({data: getData(20)})

                    $('#load').click(function () {
                        $table.bootstrapTable('load', getData(10000))
                    })

                    $('#append').click(function () {
                        $table.bootstrapTable('append', getData(10000, true))
                    })
                }
            </script>
        </div>-->

</html>
