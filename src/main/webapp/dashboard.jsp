<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.oceanviewreservation.config.AppConfig" %>
<%@ page import="com.example.oceanviewreservation.model.User" %>
<%
    User user = (User) session.getAttribute(AppConfig.SESSION_USER);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- ADD THIS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<nav class="navbar navbar-dark bg-dark px-3">
    <span class="navbar-brand">OceanView Reservation System🏖️</span>
    <span class="text-white">Logged in: <%= user.getUsername() %> (<%= user.getRole() %>)</span>
</nav>

<div class="container mt-4">
    <div class="row g-3">
        <div class="col-md-4">
            <a class="btn btn-success w-100 p-3" href="<%= request.getContextPath() %>/reservation/add">Add New Reservation</a>
        </div>
        <div class="col-md-4">
            <a class="btn btn-primary w-100 p-3" href="<%= request.getContextPath() %>/reservation/view">Display Reservation Details</a>
        </div>
        <div class="col-md-4">
            <a class="btn btn-warning w-100 p-3" href="<%= request.getContextPath() %>/bill">Calculate & Print Bill</a>
        </div>
        <div class="col-md-6">
            <a class="btn btn-info w-100 p-3" href="<%= request.getContextPath() %>/help">Help</a>
        </div>
        <div class="col-md-6">
            <a class="btn btn-danger w-100 p-3" href="<%= request.getContextPath() %>/logout">Exit / Logout</a>
        </div>
    </div>
</div>
</body>
</html>
