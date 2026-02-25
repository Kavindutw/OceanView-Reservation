<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.oceanviewreservation.model.RoomType" %>
<!DOCTYPE html>
<html>
<head>
  <title>Add Reservation</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-4">
  <h3>Add New Reservation</h3>
  <a href="<%=request.getContextPath()%>/dashboard">← Back</a>

  <%
    List<String> errors = (List<String>) request.getAttribute("errors");
    if (errors != null && !errors.isEmpty()) {
  %>
  <div class="alert alert-danger mt-3">
    <ul class="mb-0">
      <% for (String e : errors) { %><li><%= e %></li><% } %>
    </ul>
  </div>
  <% } %>

  <form class="card p-3 mt-3" method="post" action="<%=request.getContextPath()%>/reservation/add">
    <div class="row g-3">
      <div class="col-md-4">
        <label class="form-label">Reservation No</label>
        <input class="form-control" name="reservationNo" required maxlength="30">
      </div>
      <div class="col-md-8">
        <label class="form-label">Guest Name</label>
        <input class="form-control" name="guestName" required maxlength="100">
      </div>

      <div class="col-md-8">
        <label class="form-label">Address</label>
        <input class="form-control" name="address" required maxlength="255">
      </div>
      <div class="col-md-4">
        <label class="form-label">Contact Number</label>
        <input class="form-control" name="contactNumber" required maxlength="30">
      </div>

      <div class="col-md-4">
        <label class="form-label">Room Type</label>
        <select class="form-select" name="roomTypeCode" required>
          <option value="">-- Select --</option>
          <%
            List<RoomType> roomTypes = (List<RoomType>) request.getAttribute("roomTypes");
            if (roomTypes != null) {
              for (RoomType rt : roomTypes) {
          %>
          <option value="<%= rt.getCode() %>"><%= rt.getName() %> (LKR <%= rt.getRatePerNight() %>/night)</option>
          <% } } %>
        </select>
      </div>

      <div class="col-md-4">
        <label class="form-label">Check-in Date</label>
        <input type="date" class="form-control" name="checkIn" required>
      </div>
      <div class="col-md-4">
        <label class="form-label">Check-out Date</label>
        <input type="date" class="form-control" name="checkOut" required>
      </div>

      <div class="col-12">
        <button class="btn btn-success">Save Reservation</button>
      </div>
    </div>
  </form>
</div>
</body>
</html>
