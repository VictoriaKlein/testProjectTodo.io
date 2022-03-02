const searchInput = document.querySelector(".search-todo-input");
const addTodoForm = document.querySelector(".add-todo-form");
const todoListUl = document.querySelector(".todo-list");
const todoLitItem = document.querySelectorAll(".todo-lit-item");

addTodoForm.addEventListener("submit", (event) => {
  event.preventDefault();
  const value = addTodoForm.addTodoField.value;
  addTodo(value);
 addTodoForm.addTodoField.value = "";
  countTodo();
});
 
function addTodo(value) {
  if (/\S/.test(value)) {
    todoListUl.innerHTML += `<li class="todo-lit-item">
 <span class="todo-status"></span class="todo-status">${value}<div class="todo-close-button">
 <img class="todo-close-button-icon"
   src="data:image/png;base64,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"
   alt=""
 />
</div></li>`;
  }
}

searchInput.addEventListener("keyup", (e) => {
  e.preventDefault();
  searchTodo(e.target.value);
});

function searchTodo(value) {
  Array.from(todoListUl.children).forEach((item) => {
    if (item.innerText.includes(value)) {
      item.style.display = "";
    } else {
      item.style.display = "none";
    }
  });
}
let todoListFunction = todoListUl.addEventListener;
todoListUl.addEventListener("click", (e) => {
  if (e.target.className.includes("status")) {
    e.target.parentNode.classList.toggle("checked");
  } else if (e.target.className.includes("close-button")) {
    e.target.parentNode.parentNode.remove();
  }
  countTodo();
});
const todoListCounter = document.querySelector(".todo-list-footer-counter");
const buttonContainer = document.querySelector(".todo-list-footer");
buttonContainer.addEventListener("click", (e) => {
  if (e.target.className.includes("all")) {
    showAll();
  } else if (e.target.className.includes("active")) {
    showActive();
  } else if (e.target.className.includes("completed")) {
    showCompleted();
  }
});
function showAll() {
  Array.from(todoListUl.children).forEach((item) => {
    if (item.className.includes("invisible" || "checked")) {
      item.classList.remove("invisible");
    }
  });
}
function showActive() {
  Array.from(todoListUl.children).forEach((item) => {
    if (item.className.includes("checked")) {
      item.classList.add("invisible");
    } else {
      item.classList.remove("invisible");
    }
  });
}
function showCompleted() {
  Array.from(todoListUl.children).forEach((item) => {
    if (item.className.includes("checked")) {
      item.classList.remove("invisible");
    } else {
      item.classList.add("invisible");
    }
  });
}
function countTodo() {
  var i = Array.from(todoListUl.children).length;
  Array.from(todoListUl.children).forEach((child) => {
    console.log(i);
    if (child.className.includes("checked")) {
      i--;
    }
    todoListCounter.innerHTML = `<div class="todo-list-footer-counter">${i} item${
      i !== 1 ? "s" : ""
    } left<div>`;
  });
}