<%--
  Created by IntelliJ IDEA.
  User: zelen
  Date: 18.06.2022
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Добавление книги</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-light bg-light">
    <form class="form-inline">
        <button onclick="window.location.href = '/books';" class="btn btn-outline-success" type="button">Список книг</button>
    </form>
</nav>

<div class="container">
    <form method="get" action="/insert-book">
        <div class="row">
            <div class="col-sm">
                <div class="form-group">
                    <label for="title">Название книги</label>
                    <input type="text" class="form-control" id="title" name="title" value="" placeholder="Введите название">
                </div>
                <div class="form-group">
                    <label for="author">Автор книги</label>
                    <input type="text" class="form-control" id="author" name="author" value="" placeholder="Укажите автора">
                </div>
                <div class="form-group">
                    <label for="quantity">Количество</label>
                    <input type="number" class="form-control" id="quantity" name="quantity" value="" placeholder="Укажите количество">
                </div>
                <button type="submit" class="btn btn-primary">Отправить</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
