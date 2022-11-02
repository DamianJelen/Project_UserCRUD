<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th style="vertical-align: middle">First name</th>
<%--                    <th>Last name</th>--%>
                    <th style="vertical-align: middle">E-mail</th>
<%--                    <th>Phone</th>--%>
<%--                    <th>Zip code</th>--%>
<%--                    <th>City</th>--%>
<%--                    <th>Street</th>--%>
<%--                    <th>Street number</th>--%>
                    <th style="vertical-align: middle" width="50px">Show</th>
                    <th style="vertical-align: middle" width="50px">Edit</th>
                    <th style="vertical-align: middle" width="50px">Delete</th>
                    <th style="vertical-align: middle" width="100px">Change user pass</th>
                </tr>
                </thead>
                <%--<tfoot>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>E-mail</th>
                    <th>Phone</th>
                    <th>Zip code</th>
                    <th>City</th>
                    <th>Street</th>
                    <th>Street number</th>
                </tr>
                </tfoot>--%>
                <c:if test="${not empty users}">
                <tbody>
                <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.first_name}</td>
<%--                    <td>${user.last_name}</td>--%>
                    <td>${user.email}</td>
<%--                    <td>${user.phone}</td>--%>
<%--                    <td>${user.zipCode}</td>--%>
<%--                    <td>${user.city}</td>--%>
<%--                    <td>${user.street}</td>--%>
<%--                    <td>${user.streetNumber}</td>--%>
                    <td colspan="3" align="center">
                        <div class="btn-group" role="group" aria-label="Basic example">
                            <a href="/user/show?userId=${user.id}"><button type="button" class="btn btn-success btn-circle">
                                <i class="fas fa-binoculars fa-sm text-white-50"></i>
                            </button></a>&emsp;
                            <a href="/user/upd?userId=${user.id}"><button type="button" class="btn btn-warning btn-circle">
                                <i class="fas fa-edit fa-sm text-white-50"></i>
                            </button></a>&emsp;
                            <a href="/user/del?userId=${user.id}"><button type="button" class="btn btn-danger btn-circle">
                                <i class="fas fa-trash fa-sm text-white-50"></i>
                            </button></a>
                        </div>
                    </td>
                    <td align="center">
                        <a href="/user/chpa?userId=${user.id}"><button type="button" class="btn btn-primary btn-circle">
                            <i class="fas fa-lock fa-sm text-white-50"></i>
                        </button></a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
                </c:if>
            </table>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>