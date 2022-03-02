<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="./main.css" /> 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
        <script>
        $(document).on("click", "#add", function() {
        	var addTodoField = $('#addTodoField').val();
        	$.ajax({
        	    type: "POST",
        	    url: 'todo',
        	    cache: false,
        	    contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
        	    dataType: "json",
        	    data: {
        	        'addTodoField':addTodoField,
        	    },
        	    success: function (data) {
        	        alert(data.mensaje);
        	    }
        	});
        });
        </script>
  </head>
  <body class="Todo">
    <div class="wrapper">
      <h1>Todo</h1>
      <div class="container">
      <form action = "todo" method = "post" class="add-todo-form" id = "form">
      <input
          id = "addTodoField"
            name="addTodoField"
            type="text"
            class="add-todo-input"
            required
            placeholder="Add your todo"
          />
          <input type = "submit" id = "add" class= "add"/>
        </form> 
        <div class="todo-list-container" id = "result">
          <ul class="todo-list" id = "result"></ul>
        </div>
        <form class="search-todo-form">
          <input type="text" class="search-todo-input" placeholder="Find your todo" />
        </form>
        <footer class="todo-list-footer">
          <div class="todo-list-footer-counter"></div>
          <button class="todo-list-footer-button-all">All</button>
          <button class="todo-list-footer-button-active">Active</button>
          <button class="todo-list-footer-button-completed">Completed</button>
        </footer>
      </div>
    </div>
    <script src="./app.js"></script>
  </body>
</html>