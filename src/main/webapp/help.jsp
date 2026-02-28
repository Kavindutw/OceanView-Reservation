<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Help</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- ADD THIS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body class="bg-light">
<div class="container mt-4">
    <h3>Help - How to Use the System</h3>
    <a href="<%=request.getContextPath()%>/dashboard">← Back</a>

    <div class="card mt-3">
        <div class="card-body">
            <ol>
                <li><b>Login</b> using your staff username and password.</li>
                <li>Go to <b>Add New Reservation</b> and fill all fields (reservation number must be unique).</li>
                <li>Use <b>Display Reservation Details</b> to search by reservation number.</li>
                <li>Open <b>Calculate & Print Bill</b>, enter the reservation number, then print the bill.</li>
                <li>Use <b>Exit/Logout</b> to close the system safely.</li>
            </ol>
            <p class="text-muted mb-0">Tip: Always ensure check-out date is after check-in date to avoid errors.</p>
        </div>
    </div>
</div>
</body>
</html>
