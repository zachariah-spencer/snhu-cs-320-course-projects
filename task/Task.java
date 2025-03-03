package task;

public class Task {
	private String taskId;
	private String name;
	private String description;
	
	public Task(String taskId, String name, String description) {
		setTaskId(taskId);
		setTaskName(name);
		setTaskDescription(description);
	}
	
	// getters
	public String getTaskId() {
		return taskId;
	}
	
	public String getTaskName() {
		return name;
	}
	
	public String getTaskDescription() {
		return description;
	}
	
	// setters
	public void setTaskId(String taskId) {
		if(taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Invalid task id.");
		}
		
		this.taskId = taskId;
	}
	
	public void setTaskName(String name) {
		if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid task name.");
		}
		
		this.name = name;
	}
	
	public void setTaskDescription(String description) {
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid task description.");
		}
		
		this.description = description;
	}
	
}
