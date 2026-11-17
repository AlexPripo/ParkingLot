<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Edit Car">
    <h1>Edit Car</h1>
    <form method="POST" action="${pageContext.request.contextPath}/EditCar" class="needs-validation" novalidate>
        <div class="col-12">
            <label for="license_plate" class="form-label">License Plate</label>
            <input type="text" name="license_plate" class="form-control" placeholder="" value="${car.licensePlate}"required>
            <div class="invalid-feedback">License Plate is required.</div>
        </div>

        <div class="col-12">
            <label for="parking_spot" class="form-label">Parking Spot</label>
            <input type="text" name="parking_spot" class="form-control" placeholder="" value="${car.parkingSpot}" required>
            <div class="invalid-feedback">Parking Spot is required.</div>
        </div>

        <div class="col-12">
            <label for="owner_id" class="form-label">Owner</label>
            <select name="owner_id" class="form-control" required>
                <c:forEach var="user" items="${users}" varStatus="status">
                    <option value="${user.id}" ${car.ownerName eq user.username ? 'selected' : ''}>${user.username}</option>
                </c:forEach>
                <option value="">Choose...</option>
            </select>
            <div class="invalid-feedback">Please select an owner.</div>
        </div>

        <input type="hidden" name="car_id" value="${car.id}" />
        <button class="w-100 btn btn-primary btn-lg" type="submit">Save</button>
    </form>
</t:pageTemplate>
