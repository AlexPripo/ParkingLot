<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Cars">
    <h1>Cars</h1>
    <form method="POST" action="${pageContext.request.contextPath}/Cars">
        <a href="${pageContext.request.contextPath}/AddCar" class="btn btn-primary btn-lg">Add Car</a>
        <button type="submit" class="btn btn-danger">Delete Cars</button>
        <table class="container text-center">
            <thead>
                <tr class="row">
                    <th scope="col" class="col">License Plate</th>
                    <th scope="col" class="col">Parking Spot</th>
                    <th scope="col" class="col" colspan="2">Owner</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="car" items="${cars}">
                    <tr class="row">
                        <td class="col">
                            <input type="checkbox" name="car_ids" value="${car.id}" />
                        </td>
                        <td class="col">${car.licensePlate}</td>
                        <td class="col">${car.parkingSpot}</td>
                        <td class="col">${car.ownerName}</td>
                        <td class="col">
                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditCar?id=${car.id}">Edit Car</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </form>

    <h5>Free parking spots: ${numberOfFreeParkingSpots}</h5>
</t:pageTemplate>