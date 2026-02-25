<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>OceanView - Login</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5" style="max-width: 480px;">
  <div class="card shadow-sm">
    <div class="card-body">
      <h4 class="mb-3">Ocean View Resort - Login</h4>

      <% String error = (String) request.getAttribute("error"); %>
      <% if (error != null) { %>
      <div class="alert alert-danger"><%= error %></div>
      <% } %>

      <form method="post" action="<%= request.getContextPath() %>/login">
        <div class="mb-3">
          <label class="form-label">Username</label>
          <input class="form-control" name="username" required>
        </div>
        <div class="mb-3">
          <label class="form-label">Password</label>
          <input type="password" class="form-control" name="password" required>
        </div>
        <button class="btn btn-primary w-100">Login</button>
      </form>
      <p class="text-muted mt-3 mb-0">Default admin: <b>admin</b> / <b>admin123</b></p>
    </div>
  </div>
</div>
</body>
</html>
