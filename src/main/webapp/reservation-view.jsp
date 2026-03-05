<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.oceanviewreservation.model.Reservation" %>
<%@ page import="com.example.oceanviewreservation.model.RoomType" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Reservation</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- ADD THIS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body class="bg-light">
<div class="container mt-4">
    <h3>Display Reservation Details</h3>
    <a href="<%=request.getContextPath()%>/dashboard">← Back</a>

    <form class="card p-3 mt-3" method="get" action="<%=request.getContextPath()%>/reservation/view">
        <div class="row g-2 align-items-end">
            <div class="col-md-6">
                <label class="form-label">Reservation No</label>
                <input class="form-control" name="reservationNo" placeholder="e.g., R-1001" required>
            </div>
            <div class="col-md-3">
                <button class="btn btn-primary w-100">Search</button>
            </div>
        </div>
    </form>

    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
    <div class="alert alert-warning mt-3"><%= error %></div>
    <% } %>

    <%
        Reservation r = (Reservation) request.getAttribute("reservation");
        RoomType rt = (RoomType) request.getAttribute("roomType");
        Object nightsObj = request.getAttribute("nights");
        if (r != null) {
    %>
    <div class="card mt-3">
        <div class="card-body">
            <h5>Reservation: <%= r.getReservationNo() %></h5>
            <p class="mb-1"><b>Guest:</b> <%= r.getGuestName() %></p>
            <p class="mb-1"><b>Address:</b> <%= r.getAddress() %></p>
            <p class="mb-1"><b>Contact:</b> <%= r.getContactNumber() %></p>
            <p class="mb-1"><b>Room Type:</b> <%= r.getRoomTypeCode() %> <% if (rt != null) { %>(<%= rt.getName() %>)<% } %></p>
            <p class="mb-1"><b>Check-in:</b> <%= r.getCheckIn() %></p>
            <p class="mb-1"><b>Check-out:</b> <%= r.getCheckOut() %></p>
            <p class="mb-0"><b>Nights:</b> <%= nightsObj %></p>

            <div class="mt-3 d-flex gap-2">

                <!-- Bill Button -->
                <a class="btn btn-warning"
                   href="<%=request.getContextPath()%>/bill?reservationNo=<%= r.getReservationNo() %>">
                    Go to Bill
                </a>

                <!-- DELETE BUTTON -->
                <form method="post"
                      action="<%=request.getContextPath()%>/reservation/delete"
                      onsubmit="return confirm('Are you sure you want to delete this reservation?');">

                    <input type="hidden" name="reservationNo"
                           value="<%= r.getReservationNo() %>">

                    <button class="btn btn-danger">
                        Delete Reservation
                    </button>
                </form>

            </div>
        </div>
    </div>
    <% } %>
</div>
</body>
</html>
