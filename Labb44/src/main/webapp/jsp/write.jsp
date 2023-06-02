<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Запись</title>
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap" rel="stylesheet" type="text/css">
  <style>
    .container {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    h4 {
      font-size: 35px;
      font-family: 'Montserrat';
    }


    .form-group {
      margin-bottom: 15px;
    }

    label {
      font-weight: bold;
    }

    .form-control {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
      transition: border-color 0.3s;
    }

    .form-control:focus {
      outline: none;
      border-color: #6c757d;
    }

    .btn {
      display: inline-block;
      padding: 20px 40px;
      background-color: limegreen;
      color: #fff;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      transition: background-color 0.3s;
      font-size: 20px;
      font-family: 'Montserrat'

    }

    .btn:hover {
      background-color: green;
    }
    .btn-read {
      text-decoration: none;
    }

  </style>

</head>

<body>
<div class="container">
  <div class="row justify-content-center align-items-center vh-100">
    <form class="col-lg-4 col-md-6 col-sm-8 col-10 p-5 shadow rounded text-center">
      <h4 class="mb-4 font-weight-bold">Добавить автомобиль в список</h4>
      <div class="form-group">
        <input class="form-control mt-2 rounded" id="name" type="text" placeholder="Название">
      </div>
      <div class="form-group">
        <input class="form-control mt-2 rounded" id="body" type="text" placeholder="Тип кузова">
      </div>
      <div class="form-group">
        <input class="form-control mt-2 rounded" id="transmission" type="text" placeholder="КПП">
      </div>
      <div class="form-group">
        <input class="form-control mt-2 rounded" id="year" type="number" placeholder="Год выпуска">
      </div>
      <div class="form-group">
        <input class="form-control mt-2 rounded" id="mileage" type="number" placeholder="Пробег">
      </div>
      <button class="btn btn-info mt-2 rounded" onclick="getData()">Добавить</button>
      <a class="btn btn-read" href="/Labb44/read">Читать</a>
    </form>
  </div>
</div>

<script src="js/writer.js"></script>
</body>
</html>
