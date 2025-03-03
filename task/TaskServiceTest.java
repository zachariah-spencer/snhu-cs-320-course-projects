package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.Task;
import task.TaskService;

class TaskServiceTest {
	private TaskService taskService;
	
	
	@BeforeEach
	public void setupTaskServiceTests() {
		taskService = new TaskService();
	}
	
	@Test
	void taskServiceTestConstructor() {
		assertNotNull(taskService);
	}
	
	@Test
	void taskServiceTestGetTask() {
		taskService.addTask(new Task("id", "name", "desc"));
		assertFalse(taskService.addTask(new Task("id", "name", "desc")));
		
	}

	@Test
	void taskServiceTestAddTask() {
		
		Task task = new Task("id", "name", "desc");
		
		taskService.addTask(task);
		assertNotNull(taskService.getTask(task.getTaskId()));
		
	}
	
	@Test
	void taskServiceTestDeleteContact() {
		Task task = new Task("id", "name", "desc");
		
		taskService.addTask(task);
		
		taskService.deleteTask(task.getTaskId());
		assertNull(taskService.getTask(task.getTaskId()));
	}
	
	@Test
	void taskServiceTestUpdateTaskName() {
		Task task = new Task("id", "name", "desc");
		
		taskService.addTask(task);
		
		taskService.updateTaskName("newname", task.getTaskId());
		
		
		
		assertTrue(taskService.getTask(task.getTaskId()).getTaskName().equals("newname"));
	}
	
	@Test
	void taskServiceTestUpdateTaskDescription() {
		Task task = new Task("id", "name", "desc");
		
		taskService.addTask(task);
		
		taskService.updateTaskDescription("newdesc", task.getTaskId());
		assertTrue(taskService.getTask(task.getTaskId()).getTaskDescription().equals("newdesc"));
	}
	
}
