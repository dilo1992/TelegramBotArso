<%--
  Created by IntelliJ IDEA.
  User: dmitrylobov
  Date: 20.11.22
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="../templates/style.css">
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
        <h1 style="margin-top: 5rem;" class="text-center card-img">Продукция ARSO-BETON</h1>
    </div>
</div>

<div class="products">
    <div class="product1">
        <div class="container-xxl">
            <h1 style="margin-top: 5rem;" class="text-center card-img text-uppercase">Бетоны</h1>
        </div>

        <div class="row row-cols-1 row-cols-md-3 g-4" style="padding: 20px">
            <div M100 class="col">
                <div class="card h-100 w-100" style="padding-left: 10px">
                    <img src="https://www.arsobeton.by/wp-content/uploads/2022/09/kub-m100.jpg" class="card-img-top"
                         style="width: 200px; height: 170px; display: block; margin: auto" alt="...">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align: center">M-100 (C8/10)</h5>
                        <p class="card-text text-center">Бетон М100 применяется для ремонтно-строительных работ. Бетон
                            соответствует мировым требованиям и стандартам.
                            Для работы с ним не требуется использование специальной техники. Материал комфортен в
                            работе, отлично ложится. Бетон М100 обладает невысоким уровнем прочности, поэтому и сферы
                            использования его ограничены.</p>
                    </div>
                    <div class="price">
                        <p class="card-price" style="text-align: center"> Цена за 1 кубический метр: <b> 88р </b></p>
                    </div>

                    <section feedback>
                        <div class="row">
                            <div class="col-1">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-star-fill" viewBox="0 0 16 16">
                                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                </svg>
                            </div>
                            <div class="col-3">

                                <a href="/comments?typeOfProductForDisplayComment=M100"
                                   style="text-decoration: underline" title="нажмите для просмотра отзывов">
                                    <p>
                                        <c:if test="${sizeOfArrM100=='0'}">
                                            no rating
                                            <br/>
                                        </c:if>
                                        <c:if test="${sizeOfArrM100 gt '0'}">
                                            ${averageRatingM100}
                                        </c:if>
                                    </p>
                                </a>
                            </div>
                        </div>
                    </section>
                </div>
            </div>

            <div M150 class="col">
                <div class="card h-100">
                    <div class="card h-100 w-100" style="padding-left: 10px">
                        <img src="https://gomelgraal.by/image/cache/catalog/products/beton/m-150-800x800.jpg"
                             class="card-img-top"
                             style="width: 200px; height: 170px; display: block; margin: auto" alt="...">
                        <div class="card-body">
                            <h5 class="card-title" style="text-align: center">M-150 (C10/12,5)</h5>
                            <p class="card-text">Бетон этой марки не выделяется устойчивостью к нагрузкам,
                                поэтому применяется в местах, где они несущественны</p>
                        </div>
                        <div class="price">
                            <p class="card-price" style="text-align: center"> Цена за 1 кубический метр: <b> 90р </b>
                            </p>
                        </div>

                        <section feedback>
                            <div class="row">
                                <div class="col-1">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-star-fill" viewBox="0 0 16 16">
                                        <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                    </svg>
                                </div>
                                <div class="col-3">
                                    <a href="/comments?typeOfProductForDisplayComment=M150"
                                       style="text-decoration: underline" title="нажмите для просмотра отзывов">
                                        <p>
                                            <c:if test="${sizeOfArrM150=='0'}">
                                                no rating
                                                <br/>
                                            </c:if>
                                            <c:if test="${sizeOfArrM150 gt '0'}">
                                                ${averageRatingM150}
                                            </c:if>
                                        </p>
                                    </a>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            </div>

            <div M200 class="col">
                <div class="card h-100">
                    <div class="card h-100 w-100" style="padding-left: 10px">
                        <img src="https://gomelgraal.by/image/cache/catalog/products/beton/m-200-800x800.jpg"
                             class="card-img-top"
                             style="width: 200px; height: 170px; display: block; margin: auto" alt="...">
                        <div class="card-body">
                            <h5 class="card-title" style="text-align: center">M-200 (C12/15)</h5>
                            <p class="card-text">Нашел применение он практически во всех строительных сферах.
                                Может использоваться и для строительства зданий, монтажа опор, лестничных пролетов и
                                т.п. Также его применяют для бетонирования придорожных откосов, ограждений, заливки
                                цементных стяжек, для изготовления плит, блоков и т.п.</p>
                        </div>
                        <div class="price">
                            <p class="card-price" style="text-align: center"> Цена за 1 кубический метр:
                            <p style="text-align: center">на гравии:<b> 95р </b></p>
                            <p style="text-align: center">на щебне:<b> 120р </b></p>
                        </div>

                        <section feedback>
                            <div class="row">
                                <div class="col-1">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-star-fill" viewBox="0 0 16 16">
                                        <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                    </svg>
                                </div>
                                <div class="col-3">
                                    <a href="/comments?typeOfProductForDisplayComment=M200"
                                       style="text-decoration: underline" title="нажмите для просмотра отзывов">
                                        <p>
                                            <c:if test="${sizeOfArrM200=='0'}">
                                                no rating
                                                <br/>
                                            </c:if>
                                            <c:if test="${sizeOfArrM200 gt '0'}">
                                                ${averageRatingM200}
                                            </c:if>
                                        </p>
                                    </a>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            </div>

            <div M250 class="col">
                <div class="card h-100">
                    <img src="https://gomelgraal.by/image/cache/catalog/products/beton/m-250-800x800.jpg"
                         class="card-img-top"
                         style="; width: 200px; height: 170px; display: block; margin: auto" alt="...">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align: center">M-250 (C16/20)</h5>
                        <p class="card-text">Применяют эту смесь бетона для декора, при производстве ЖБИ,
                            мебели, дорожном строительстве. Бетон М250 подходит для зданий, которые эксплуатируются в
                            непростых условиях (неровный рельеф, подтапливание территории и т.п.).</p>
                    </div>
                    <div class="price">
                        <p class="card-price" style="text-align: center"> Цена за 1 кубический метр:
                        <p style="text-align: center">на гравии:<b> 100р </b></p>
                        <p style="text-align: center">на щебне:<b> 125р </b></p>
                    </div>

                    <section feedback>
                        <div class="row">
                            <div class="col-1">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-star-fill" viewBox="0 0 16 16">
                                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                </svg>
                            </div>
                            <div class="col-3">
                                <a href="/comments?typeOfProductForDisplayComment=M250"
                                   style="text-decoration: underline" title="нажмите для просмотра отзывов">
                                    <p>
                                        <c:if test="${sizeOfArrM250=='0'}">
                                            no rating
                                            <br/>
                                        </c:if>
                                        <c:if test="${sizeOfArrM250 gt '0'}">
                                            ${averageRatingM250}
                                        </c:if>
                                    </p>
                                </a>
                            </div>
                        </div>
                    </section>
                </div>
            </div>

            <div M300 class="col">
                <div class="card h-100">
                    <img src="https://gomelgraal.by/image/cache/catalog/products/beton/m-300-800x800.jpg"
                         class="card-img-top"
                         style="; width: 200px; height: 170px; display: block; margin: auto" alt="...">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align: center">M-300 (C18/22,5)</h5>
                        <p class="card-text">Областью использования бетонных смесей являются строительные сооружения,
                            которые при эксплуатации будут подвержены значительной нагрузке. Потому-то важнейшей
                            характеристикой бетона считается прочность, то есть способность противостоять загруженности.
                            Данный параметр залагается в наименовании марки бетона.</p>
                    </div>
                    <div class="price">
                        <p class="card-price" style="text-align: center"> Цена за 1 кубический метр:
                        <p style="text-align: center">на гравии:<b> 105р </b></p>
                        <p style="text-align: center">на щебне:<b> 130р </b></p>
                    </div>

                    <section feedback>
                        <div class="row">
                            <div class="col-1">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-star-fill" viewBox="0 0 16 16">
                                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                </svg>
                            </div>
                            <div class="col-3">
                                <a href="/comments?typeOfProductForDisplayComment=M300"
                                   style="text-decoration: underline" title="нажмите для просмотра отзывов">
                                    <p>
                                        <c:if test="${sizeOfArrM300=='0'}">
                                            no rating
                                            <br/>
                                        </c:if>
                                        <c:if test="${sizeOfArrM300 gt '0'}">
                                            ${averageRatingM300}
                                        </c:if>
                                    </p>
                                </a>
                            </div>
                        </div>
                    </section>
                </div>
            </div>

            <div M350 class="col">
                <div class="card h-100">
                    <img src="https://gomelgraal.by/image/cache/catalog/products/beton/m-350-800x800.jpg"
                         class="card-img-top"
                         style="; width: 200px; height: 170px; display: block; margin: auto" alt="...">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align: center">M-350 (C20/25)</h5>
                        <p class="card-text">Данная марка бетона принадлежит к стройматериалам, входящим в состав
                            среднего раздела. Для того, чтобы его изготовить, необходимо большее количество связывающего
                            компонента на 1м3, чем для материалов, относящихся к простым классам, именно это является причиной того,
                            что технические характеристики М350 многообразнее.</p>
                    </div>
                    <div class="price">
                        <p class="card-price" style="text-align: center"> Цена за 1 кубический метр:
                        <p style="text-align: center">на щебне:<b> 135р </b></p>
                    </div>

                    <section feedback>
                        <div class="row">
                            <div class="col-1">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-star-fill" viewBox="0 0 16 16">
                                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                </svg>
                            </div>
                            <div class="col-3">
                                <a href="/comments?typeOfProductForDisplayComment=M350"
                                   style="text-decoration: underline" title="нажмите для просмотра отзывов">
                                    <p>
                                        <c:if test="${sizeOfArrM350=='0'}">
                                            no rating
                                            <br/>
                                        </c:if>
                                        <c:if test="${sizeOfArrM350 gt '0'}">
                                            ${averageRatingM350}
                                        </c:if>
                                    </p>
                                </a>
                            </div>
                        </div>
                    </section>
                </div>
            </div>

            <div M400 class="col">
                <div class="card h-100">
                    <img src="https://gomelgraal.by/image/cache/catalog/products/beton/m-400-800x800.jpg"
                         class="card-img-top"
                         style="; width: 200px; height: 170px; display: block; margin: auto" alt="...">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align: center">M-400 (C25/30)</h5>
                        <p class="card-text"> Возведение сооружений, на которые возлагаются особые требования
                            в области общей надежности, а также строительство высотных зданий предполагает применение
                            стройматериалов, обладающих очень высокой ступенью прочности. К таким материалам относится
                            бетон М400. </p>
                    </div>
                    <div class="price">
                        <p class="card-price" style="text-align: center"> Цена за 1 кубический метр:
                        <p style="text-align: center">на щебне:<b> 140р </b></p>
                    </div>

                    <section feedback>
                        <div class="row">
                            <div class="col-1">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-star-fill" viewBox="0 0 16 16">
                                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                </svg>
                            </div>
                            <div class="col-3">
                                <a href="/comments?typeOfProductForDisplayComment=M400"
                                   style="text-decoration: underline" title="нажмите для просмотра отзывов">
                                    <p>
                                        <c:if test="${sizeOfArrM400=='0'}">
                                            no rating
                                            <br/>
                                        </c:if>
                                        <c:if test="${sizeOfArrM400 gt '0'}">
                                            ${averageRatingM400}
                                        </c:if>
                                    </p>
                                </a>
                            </div>
                        </div>
                    </section>
                </div>
            </div>

            <div M450 class="col">
                <div class="card h-100">
                    <img src="https://gomelgraal.by/image/cache/catalog/products/beton/m-450-800x800.jpg"
                         class="card-img-top"
                         style="; width: 200px; height: 170px; display: block; margin: auto" alt="...">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align: center">M-450 (C28/35)</h5>
                        <p class="card-text">Бетон М450 считается не очень востребованным материалом в
                            строительстве домов, потому что имеет высокую скорость схватывания и большую стоимость.
                            Обусловлено это тем, что в его состав входит огромное количество цемента, а также гранит.
                            Однако, благодаря этим дорогостоящим компонентам можно получить высококачественный и прочный
                            материал для возведения конструкций, требующих особой нагрузки.</p>
                    </div>
                    <div class="price">
                        <p class="card-price" style="text-align: center"> Цена за 1 кубический метр:
                        <p style="text-align: center">на щебне:<b> 145р </b></p>
                    </div>

                    <section feedback>
                        <div class="row">
                            <div class="col-1">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-star-fill" viewBox="0 0 16 16">
                                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                </svg>
                            </div>
                            <div class="col-3">
                                <a href="/comments?typeOfProductForDisplayComment=M450"
                                   style="text-decoration: underline" title="нажмите для просмотра отзывов">
                                    <p>
                                        <c:if test="${sizeOfArrM450=='0'}">
                                            no rating
                                            <br/>
                                        </c:if>
                                        <c:if test="${sizeOfArrM450 gt '0'}">
                                            ${averageRatingM450}
                                        </c:if>
                                    </p>
                                </a>
                            </div>
                        </div>
                    </section>
                </div>
            </div>

            <div M500 class="col">
                <div class="card h-100">
                    <img src="https://gomelgraal.by/image/cache/catalog/products/beton/m-500-800x800.jpg"
                         class="card-img-top"
                         style="; width: 200px; height: 170px; display: block; margin: auto" alt="...">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align: center">M-500 (C30/37)</h5>
                        <p class="card-text">Бетон М500 – популярный и надежный материал. Он не боится агрессивной среды
                            и других негативных факторов, способен выдерживать максимальные нагрузки.
                            Чаще всего бетон М500 используется для:
                        <li>Возведения фундамента для небоскребов и многоэтажек;</li>
                        <li>Строительства опор мостов, сложных конструкций;</li>
                        <li>Подземных сооружений, испытывающих воздействие грунтовых вод.</li>
                    </div>
                    <div class="price">
                        <p class="card-price" style="text-align: center"> Цена за 1 кубический метр:
                        <p style="text-align: center">на щебне:<b> 150р </b></p>
                    </div>

                    <section feedback>
                        <div class="row">
                            <div class="col-1">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-star-fill" viewBox="0 0 16 16">
                                    <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                </svg>
                            </div>
                            <div class="col-3">
                                <a href="/comments?typeOfProductForDisplayComment=M500"
                                   style="text-decoration: underline" title="нажмите для просмотра отзывов">
                                    <p>
                                        <c:if test="${sizeOfArrM500=='0'}">
                                            no rating
                                            <br/>
                                        </c:if>
                                        <c:if test="${sizeOfArrM500 gt '0'}">
                                            ${averageRatingM500}
                                        </c:if>
                                    </p>
                                </a>
                            </div>
                        </div>
                    </section>
                </div>
            </div>

        </div>
    </div>

    <div class="product2">
        <div class="container-xxl" style="padding: 20px">
            <h1 class="text-center card-img text-uppercase">ФБС плиты</h1>
            <p style="margin: auto; text-align: justify">Изготавливают дорожные плиты из бетона «тяжелых» марок (М300,
                М400), чтобы они могли выдерживать интенсивные нагрузки.
                Для усиления конструкции используется стальная арматура. За счет этого она обладает повышенной
                прочностью и надежностью.
                С целью улучшения сцепления с колесами дополнительно может придаваться рифление.</p>
            <p style="margin: auto; text-align: justify">Производство изделий максимально оптимизируется, чтобы в
                результате получить качественный продукт, соответствующий ГОСТ
                и изготовленный с соблюдением технологий, поэтому при приобретении плит вы можете быть уверены в их
                высоком качестве.</p>
            <p style="margin: auto; text-align: justify">Благодаря размерам плиты способны покрывать большие поверхности
                в очень быстрые сроки. При этом их без труда можно транспортировать
                грузовым транспортом. Монтаж также не занимает много времени и не вызывает сложностей.</p>
        </div>

        <div class="row row-cols-1 row-cols-md-2 g-2"
             style="padding-bottom: 50px; padding-left: 20px; padding-right: 20px">

            <div class="col">
                <div class="card h-100">
                    <img src="https://www.arsobeton.by/wp-content/uploads/2022/09/plita-dor-1.jpg"
                         class="card-img-top"
                         style="; width: 500px; height: 300px; display: block; margin: auto" alt="...">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align: center">2ПП30.15-30 F200 W4</h5>
                        <p class="card-text">
                        <li>Размеры (длина/ширина/высота): 3000x1500x170 мм</li>
                        <li>Масса, т: 1,68</li>
                        <div class="price">
                            <p class="card-price" style="text-align: center"> Цена: <b> 360р </b></p>
                        </div>

                        <section feedback>
                            <div class="row">
                                <div class="col-1">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-star-fill" viewBox="0 0 16 16">
                                        <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                    </svg>
                                </div>
                                <div class="col-3">
                                    <a href="/comments?typeOfProductForDisplayComment=F200"
                                       style="text-decoration: underline" title="нажмите для просмотра отзывов">
                                        <p>
                                            <c:if test="${sizeOfArrF200=='0'}">
                                                no rating
                                                <br/>
                                            </c:if>
                                            <c:if test="${sizeOfArrF200 gt '0'}">
                                                ${averageRatingF200}
                                            </c:if>
                                        </p>
                                    </a>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            </div>

            <div class="col">
                <div class="card h-100">
                    <img src="https://www.arsobeton.by/wp-content/uploads/2022/09/plita-dor-1.jpg"
                         class="card-img-top"
                         style="; width: 500px; height: 300px; display: block; margin: auto" alt="...">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align: center">2ПП30.18-30 F250 W4</h5>
                        <p class="card-text">
                        <li>Размеры (длина/ширина/высота): 3000x1750x170 мм</li>
                        <li>Масса, т: 2,16</li>
                        <div class="price">
                            <p class="card-price" style="text-align: center"> Цена: <b> 390р </b></p>
                        </div>

                        <section feedback>
                            <div class="row">
                                <div class="col-1">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-star-fill" viewBox="0 0 16 16">
                                        <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                                    </svg>
                                </div>
                                <div class="col-3">
                                    <a href="/comments?typeOfProductForDisplayComment=F250"
                                       style="text-decoration: underline" title="нажмите для просмотра отзывов">
                                        <p>
                                            <c:if test="${sizeOfArrF250=='0'}">
                                                no rating
                                                <br/>
                                            </c:if>
                                            <c:if test="${sizeOfArrF250 gt '0'}">
                                                ${averageRatingF250}
                                            </c:if>
                                        </p>
                                    </a>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            </div>


        </div>
    </div>
</div>


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