<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.oceanviewreservation.model.Reservation" %>
<!DOCTYPE html>
<html>
<head>
  <title>Bill</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- ADD THIS -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
  <script>
    function printBill() {
      const printContent = document.getElementById("billArea").innerHTML;
      const originalContent = document.body.innerHTML;

      document.body.innerHTML = printContent;
      window.print();
      document.body.innerHTML = originalContent;
    }
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
  <div id="billArea" class="card mt-4">
    <div class="card-body">

      <h3 class="text-center">Ocean View Resort</h3>
      <p class="text-center">Galle, Sri Lanka</p>
      <hr>

      <h5>Reservation Number: <%= r.getReservationNo() %></h5>

      <table class="table table-bordered mt-3">

        <tr>
          <th>Guest Name</th>
          <td><%= r.getGuestName() %></td>
        </tr>

        <tr>
          <th>Room Type</th>
          <td><%= r.getRoomTypeCode() %></td>
        </tr>

        <tr>
          <th>Check-in Date</th>
          <td><%= r.getCheckIn() %></td>
        </tr>

        <tr>
          <th>Check-out Date</th>
          <td><%= r.getCheckOut() %></td>
        </tr>

        <tr>
          <th>Total Nights</th>
          <td><%= nights %></td>
        </tr>

      </table>

      <h4 class="text-end">Total Amount: LKR <%= total %></h4>

      <hr>

      <p class="text-center">Thank you for staying with Ocean View Resort!</p>

    </div>
  </div>

  <button class="btn btn-primary mt-3" onclick="printBill()">Print Bill</button>
    </div>
  </div>
  <% } %>
</div>
</body>
</html>
