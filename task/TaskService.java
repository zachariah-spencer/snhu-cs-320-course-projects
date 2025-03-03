package task;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
	private final Map<String, Task> tasks;
	
	public TaskService() {
		tasks = new HashMap<>();
	}
	
	public Task getTask(String taskId) {
		return tasks.get(taskId);
	}
	
	public boolean addTask(Task task) {
		if(tasks.putIfAbsent(task.getTaskId(), task) == null) {
			return true;
		}
		
		return false;
	}
	
	public void deleteTask(String taskId) {
		tasks.remove(taskId);
	}
	
	public void updateTaskName(String name, String taskId) {
		tasks.get(taskId).setTaskName(name);
	}
	
	public void updateTaskDescription(String description, String taskId) {
		tasks.get(taskId).setTaskDescription(description);
	}
}
