<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/style.css">
    <title>Access</title>
</head>
<body>
    <form action="jsp" method="post">
        <div class="div_form">
            <div class="div_form_access">
                <h3>
                    АВТОРИЗАЦИЯ
                </h3>
                <div class="div_form_access_input">
                    <input class="access_input" type="text" name="user" placeholder="user">
                </div>
                <div class="div_form_access_input">
                    <input class="access_input" type="password" name="password" placeholder="password">
                </div>
                <div class="div_form_access_buttons">
                    <input type="submit" value="Вход"/>
                </div>
            </div>
        </div>
    </form>
</body>
</html>