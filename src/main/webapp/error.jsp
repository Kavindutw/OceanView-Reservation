<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html><head>
  <title>Error</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
  <div class="alert alert-danger">
    <h4>Something went wrong.</h4>
    <p>Please try again or contact the administrator.</p>
  </div>
  <a href="<%=request.getContextPath()%>/dashboard">Back to Dashboard</a>
</div>
</body></html>
