<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Changing user password</h6>
    </div>
    <div class="card-body" style="padding-left: 400px; padding-right: 400px; padding-bottom: 10px; padding-text-outline: 10px;">
        <c:if test="${not empty incorrectPass}"><p style="color: #ca2819">${incorrectPass}</p></c:if>

        <form class="row g-3" method="post" action="/user/chpa">
            <div class="col-4">
                <br/>
                <label for="inputOldPass" class="form-label">Old password</label>
                <input type="password" class="form-control" id="inputOldPass" name="oldPass" value="${oldPass}">
            </div>
            <div class="col-8"></div>
            <div class="col-4">
                <br/>
                <label for="inputPassword" class="form-label">New password</label>
                <input type="password" class="form-control" id="inputPassword" name="newPass" value="${newPass}">
            </div>
            <div class="col-8"></div>
            <div class="col-4">
                <br/>
                <input type="password" class="form-control" id="inputRepeatPassword" name="repPass" value="${repPass}">
            </div>
            <div class="col-12">
                <br/>
                <button type="submit" class="btn btn-primary">Save</button>
            </div>
        </form>

    </div>
</div>
<%@ include file="footer.jsp" %>