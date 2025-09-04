<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Survey Results - Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/survey.css" type="text/css"/>    
</head>

<body>
    <img src="images/murachlogo.jpg" alt="Murach" width="100">
    <h1>Cảm ơn bạn đã gửi thông tin!</h1>

    <h2>Thông tin bạn đã gửi:</h2>

    <% 
        murach.business.User userObj = null;
        if (request.getAttribute("user") != null) {
            userObj = (murach.business.User) request.getAttribute("user");
        }
    %>

    <label>Họ tên:</label>
    <span>${user.firstName} ${user.lastName}</span><br>
    
    <label>Email:</label>
    <span>${user.email}</span><br>
    
    <% if (userObj != null && userObj.getDateOfBirth() != null && !userObj.getDateOfBirth().isEmpty()) { %>
        <label>Ngày sinh:</label>
        <span>${user.dateOfBirth}</span><br>
    <% } %>
    
    <label>Bạn biết đến chúng tôi qua:</label>
    <span>${user.heardFrom}</span><br>
    
    <label>Muốn nhận thông tin cập nhật:</label>
    <span>${user.wantsUpdates}</span><br>

    <label>Đồng ý nhận email thông báo:</label>
    <span>${user.emailOK}</span><br>

    <% if (userObj != null && "Yes".equals(userObj.getWantsUpdates())) { %>
        <label>Liên hệ qua:</label>
        <span>${user.contactVia}</span><br>
    <% } %>    
    
    <p><a href="index.html">← Làm khảo sát lại</a></p>
    
</body>
</html>