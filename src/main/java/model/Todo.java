package model;

public class Todo {
	
private int id;
private String TodoDesc;
private boolean status;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTodoDesc() {
		return TodoDesc;
	}
	public void setTodoDesc(String todoDesc) {
		TodoDesc = todoDesc;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
