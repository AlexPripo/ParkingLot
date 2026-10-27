<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Cars">
    <h1>Cars</h1>
    <table>
        <tbody>
            <tr>
                <th scope="col">License Plate</th>
                <th scope="col">Parking Spot</th>
                <th scope="col">Owner</th>
            </tr>
            <tr>
                <td>Car 1</td>
                <td>Spot 1</td>
                <td>User 1</td>
            </tr>
            <tr>
                <td>Car 2</td>
                <td>Spot 2</td>
                <td>User 2</td>
            </tr>
            <tr>
                <td>Car 3</td>
                <td>Spot 3</td>
                <td>User 3</td>
            </tr>
        </tbody>
    </table>

    <h5>Free parking spots: ${numberOfFreeParkingSpots}</h5>
</t:pageTemplate>