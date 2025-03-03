package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import task.Task;

class TaskTest {

	private Task task;
	
	@BeforeEach
	public void setupTaskTests() {
		// Create test objects
		task = new Task("0000", "name", "desc");
	}
	
	@Test
	void taskTestConstructor() {
		assertNotNull(task.getTaskId());
		assertNotNull(task.getTaskName());
		assertNotNull(task.getTaskDescription());
	}
	
	@Test
	void taskTestSettersAndGetters() {
		task.setTaskName("newname");
		task.setTaskDescription("newdesc");
		
		assertTrue(task.getTaskName().equals("newname"));
		assertTrue(task.getTaskDescription().equals("newdesc"));
	}
	
	
	
	@Test
	public void testNullId() {
		assertThrows(IllegalArgumentException.class, () -> {new Task(null, "name", "desc");});
		// assertDoesNotThrow(IllegalArgumentException.class, () -> {new Task("id", "name", "desc");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"0", "longerthan10characters"})
	void testIdValidation(String testValue) {
		assertThrows(IllegalArgumentException.class, () -> {new Task(testValue, "name", "desc");});
	}
	
	@Test
	public void testNullName() {
		assertThrows(IllegalArgumentException.class, () -> {new Task("id", null, "desc");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"0", "thisnameisgoingtoexceed20characters"})
	void testNameValidation(String testValue) {
		assertThrows(IllegalArgumentException.class, () -> {new Task("id", testValue, "desc");});
	}


	@Test
	public void testNullDesc() {
		assertThrows(IllegalArgumentException.class, () -> {new Task("id", "name", null);});
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"0", "thisdescriptionisverylongandardousandthereforewillbeexceedingthefiftycharacterlimitofthisstring"})
	void testDescValidation(String testValue) {
		assertThrows(IllegalArgumentException.class, () -> {new Task("id", "name", testValue);});
	}	
	
}
