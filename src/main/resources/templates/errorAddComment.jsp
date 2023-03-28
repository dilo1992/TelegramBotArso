<%--
  Created by IntelliJ IDEA.
  User: dmitrylobov
  Date: 18.12.22
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!--    Google fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@1,100;1,300;1,400;1,500&display=swap"
          rel="stylesheet">
    <!--    Google Fonts-->
    <!-- Font Awesome   -->
    <script src="https://kit.fontawesome.com/743632d36e.js" crossorigin="anonymous"></script>
    <!--  Font awesome  -->
    <link rel="stylesheet" href="style.css">
    <title>Title</title>
</head>

<body>
<nav class="navbar navbar-expand-lg fixed-top navbar-light" style="background-color: lightskyblue">
    <div class="container-fluid">
        <img src="https://images.deal.by/281173257_w640_h640_betonomeshalka-mixer-truck.jpg" alt="" width="30"
             height="24" class="d-inline-block align-text-top"/>
        <a class="navbar-brand" href="http://localhost:8081/"> ARSO-BETON </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8081/Prod">Продукция</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="name">
    <div class="container-xxl">
        <h1 style="margin-top: 5rem;" class="text-center card-img">Написать отзыв</h1>
    </div>
</div>

<p>Проверьте заполнение данных и их корректность</p>

<form action="/AddComment" method="post">
    <div class="input-group mb-3">
        <label class="input-group-text" for="floatingName">Введите имя</label>
        <input type="text" name="newName" class="form-control" id="floatingName" placeholder="Представьтесь, пожалуйста"
               required>
    </div>

    <div class="input-group mb-3">
        <label class="input-group-text" for="inputGroupSelect01">Выберите тип оцениваемого продукта</label>
        <select class="form-select" type="text" name="newTypeOfProduct" id="inputGroupSelect01">
            <option selected value="null">Выберите из списка...</option>
            <option value="M100">Бетон М100</option>
            <option value="F150">Бетон М150</option>
            <option value="M200">Бетон М200</option>
            <option value="M250">Бетон М250</option>
            <option value="M300">Бетон М300</option>
            <option value="M350">Бетон М350</option>
            <option value="M400">Бетон М400</option>
            <option value="M450">Бетон М450</option>
            <option value="M500">Бетон М500</option>
            <option value="F200">Плита F200</option>
            <option value="F250">Плита F250</option>
        </select>
    </div>


    <div class="mb-3">
        <label for="exampleFormControlTextarea1" class="form-label">Место для отзыва</label>
        <textarea class="form-control" type="text" name="newFeedback" id="exampleFormControlTextarea1"
                  rows="3"></textarea>
    </div>


    <div class="input-group mb-3">
        <label class="input-group-text" for="inputGroupSelect01">Оцените нашу работу и продукцию</label>
        <select class="form-select" type="text" name="newRating" id="inputGroupSelect02">
            <option selected value="0">Выберите оценку из списка...</option>
            <option value="1">Ужасно</option>
            <option value="2">Плохо</option>
            <option value="3">Удовлетворительно</option>
            <option value="4">Хорошо</option>
            <option value="5">Отлично</option>
        </select>
    </div>

    <button type="submit" class="btn btn-success">Confirm</button>
    <button type="reset" class="btn btn-primary">Clear</button>
</form>
<br>

<footer>
    <section class="footer">
        <div class="container-xxl">
            <div class="row">
                <div class="col-md-4 col-6">
                    <ul class="list-unstyled">
                        <h4>График работы</h4>
                        <li>Понедельник-пятница</li>
                        <li>08:00 - 18:00</li>
                    </ul>
                </div>

                <div class="col-md-4 col-6">
                    <ul class="list-unstyled">
                        <h4>Контакты</h4>
                        <li><a href="tel:+375299999999">+375 29 999 99 99</a></li>
                        <li><a href="tel:+375333333333">+375 33 333 33 33</a></li>
                        <li><a href="tel:+375444444444">+375 44 444 44 44</a></li>
                    </ul>
                </div>

                <div class="col-md-4 col-6">
                    <h4>Мы в глобальной сети</h4>
                    <div class="footer-icons">
                        <a href="https://www.facebook.com/"><i class="fab fa-facebook"></i></a>
                        <a href="https://www.youtube.com/"><i class="fab fa-youtube"></i></a>
                        <a href="https://www.instagram.com/"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>

            </div>
        </div>
    </section>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="static/myJs_HW25.js"></script>
</body>
</html>

