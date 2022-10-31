<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Editing user</h6>
    </div>
    <div class="card-body" style="padding-left: 400px; padding-right: 400px; padding-bottom: 10px; padding-text-outline: 10px;">

        <form class="row g-3" method="post" action="/user/upd">
            <div class="col-md-6">
                <input name="firstName" type="text" class="form-control" placeholder="First name" aria-label="First name" value="${user.first_name}">
            </div>
            <div class="col-md-6">
                <input name="lastName" type="text" class="form-control" placeholder="Last name" aria-label="Last name" value="${user.last_name}">
            </div>
            <div class="col-md-6">
                <br/>
                <input type="email" class="form-control" id="inputEmail4" placeholder="E-mail" name="email" value="${user.email}">
            </div>
            <div class="col-md-6">
                <br/>
                <input type="tel" class="form-control" id="inputPhone4" placeholder="Phone number XXX-XXX-XXX" name="phone" value="${user.phone}">
            </div>
            <div class="col-md-6">
                <br/>
                <label for="inputZipCode" class="form-label">Address</label>
                <input type="text" class="form-control" id="inputZipCode" placeholder="Zip code XX-XXX" name="zipCode" value="${user.zipCode}">
            </div>
            <div class="col-md-6">
                <br/>
                <label for="inputCity" class="form-label">&nbsp;</label>
                <input type="text" class="form-control" id="inputCity" placeholder="City" name="city" value="${user.city}">
            </div>
            <div class="col-md-6">
                <br/>
                <input type="text" class="form-control" id="inputStreet" placeholder="Street" name="street" value="${user.street}">
            </div>
            <div class="col-md-6">
                <br/>
                <input type="text" class="form-control" id="inputStreetNumber" placeholder="Street number" name="streetNumber" value="${user.streetNumber}">
            </div>
            <div class="col-12">
                <br/>
                <button type="submit" class="btn btn-primary">Update</button>
            </div>
        </form>

    </div>
</div>
<%@ include file="footer.jsp" %>