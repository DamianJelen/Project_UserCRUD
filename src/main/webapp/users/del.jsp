<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Deleting user</h6>
    </div>
    <div class="card-body" style="padding-left: 400px; padding-right: 400px; padding-bottom: 10px; padding-text-outline: 10px;">

        <form class="row g-3" method="post" action="/user/del">
            <div class="col-12">
                <h5>Do you want delete user ${userEmail}?</h5>
                Enter the user's password to remove him.
            </div>
            <div class="col-6">
                <br/>
                <c:if test="${not empty incorrectPass}"><p style="color: #ca2819">${incorrectPass}</p></c:if>
                <input type="password" class="form-control" id="inputPassword" name="password">
            </div>
            <div class="col-4" style="visibility: hidden">
                <input type="number" name="userIdToDel" value="${userIdToD}" <%--style="visibility: hidden"--%>>
            </div>
            <div class="col-12">
                <br/>
                <a href="/user/list" itemref="cancelDel">
                <input type="button" id="cancelDel" class="btn btn-success" value="No"></a>
                <input id="acceptDel" type="submit" class="btn btn-danger" value="Yes">
            </div>
        </form>

    </div>
</div>
<%@ include file="footer.jsp" %>