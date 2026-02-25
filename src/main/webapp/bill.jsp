<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.oceanviewreservation.model.Reservation" %>
<!DOCTYPE html>
<html>
<head>
  <title>Bill</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script>
    function printBill() { window.print(); }
  </script>
</head>
<body class="bg-light">
<div class="container mt-4">
  <h3>Calculate & Print Bill</h3>
  <a href="<%=request.getContextPath()%>/dashboard">← Back</a>

  <form class="card p-3 mt-3" method="post" action="<%=request.getContextPath()%>/bill">
    <div class="row g-2 align-items-end">
      <div class="col-md-6">
        <label class="form-label">Reservation No</label>
        <input class="form-control" name="reservationNo" required value="<%= request.getParameter("reservationNo") != null ? request.getParameter("reservationNo") : "" %>">
      </div>
      <div class="col-md-3">
        <button class="btn btn-success w-100">Calculate</button>
      </div>
    </div>
  </form>

  <% String error = (String) request.getAttribute("error"); %>
  <% if (error != null) { %>
  <div class="alert alert-danger mt-3"><%= error %></div>
  <% } %>

  <%
    Reservation r = (Reservation) request.getAttribute("reservation");
    Object nights = request.getAttribute("nights");
    Object total = request.getAttribute("total");
    if (r != null) {
  %>
  <div class="card mt-3">
    <div class="card-body">
      <h5>Bill - Reservation <%= r.getReservationNo() %></h5>
      <p class="mb-1"><b>Guest:</b> <%= r.getGuestName() %></p>
      <p class="mb-1"><b>Room Type:</b> <%= r.getRoomTypeCode() %></p>
      <p class="mb-1"><b>Check-in:</b> <%= r.getCheckIn() %></p>
      <p class="mb-1"><b>Check-out:</b> <%= r.getCheckOut() %></p>
      <p class="mb-1"><b>Nights:</b> <%= nights %></p>
      <hr>
      <h4>Total: LKR <%= total %></h4>
      <button class="btn btn-primary mt-2" onclick="printBill()">Print</button>
    </div>
  </div>
  <% } %>
</div>
</body>
</html>
