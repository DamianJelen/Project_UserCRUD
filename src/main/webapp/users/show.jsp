<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Show user</h6>
    </div>
    <div class="card-body" style="padding-left: 400px; padding-right: 400px; padding-bottom: 10px; padding-text-outline: 10px;">

        <div class="row g-3">
            <div class="col-md-12">
                <label><strong>First name & last name</strong></label>
                <c:if test="${not empty user.first_name}"><p>${user.first_name}</p></c:if>
                <c:if test="${not empty user.last_name}"><p>${user.last_name}</p></c:if>
            </div>

            <c:if test="${not empty user.zipCode || not empty user.city || not empty user.street || not empty user.streetNumber}">
            <div class="col-md-12">
                <label><strong>Address</strong></label>
                <p>Zip code: ${user.zipCode}&emsp;City: ${user.city}</p>
                <p>Street: ${user.street} ${user.streetNumber}</p>
            </div>
            </c:if>

            <c:if test="${not empty user.phone || not empty user.email}">
            <div class="col-md-12">
                <label><strong>Contact</strong></label>
                <p>Phone: ${user.phone}</p>
                <p>E-mail: ${user.email}</p>
            </div>
            </c:if>

            <div class="col-md-12">
                <br/>
                <a href="/user/list"><button type="submit" class="btn btn-primary">Back</button></a>
            </div>
        </div>

    </div>
</div>
<%@ include file="footer.jsp" %>