<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <th>First name</th>
                    <th>Last name</th>
                    <th>E-mail</th>
                    <th>Phone</th>
                    <th>Zip code</th>
                    <th>City</th>
                    <th>Street</th>
                    <th>Street number</th>
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
                    <td>${user.last_name}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                    <td>${user.code}</td>
                    <td>${user.zipCode}</td>
                    <td>${user.street}</td>
                    <td>${user.streetNumber}</td>
                </tr>
                </c:forEach>
                </tbody>
                </c:if>
            </table>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>