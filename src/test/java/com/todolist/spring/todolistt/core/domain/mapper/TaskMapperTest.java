package com.todolist.spring.todolistt.core.domain.mapper;

import com.todolist.spring.todolistt.core.domain.dto.TaskDTO;
import com.todolist.spring.todolistt.core.domain.model.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskMapperTest {

    @Test
    public void testToEntity() {
        TaskDTO dto = new TaskDTO();
        dto.setId(1L);
        dto.setTitle("Sample Task");
        dto.setDescription("This is a sample task");
        dto.setCompleted(true);
        dto.setUserId(100L);

        Task task = TaskMapper.toEntity(dto);

        assertNotNull(task);
        assertEquals(1, task.getId());
        assertEquals("Sample Task", task.getTitle());
        assertEquals("This is a sample task", task.getDescription());
        assertTrue(task.getIscompleted());
        assertEquals(100, task.getUserId());
    }

    @Test
    public void testToDto() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Sample Task");
        task.setDescription("This is a sample task");
        task.setIscompleted(true);
        task.setUserId(100L);

        TaskDTO dto = TaskMapper.toDto(task);

        assertNotNull(dto);
        assertEquals(1, dto.getId());
        assertEquals("Sample Task", dto.getTitle());
        assertEquals("This is a sample task", dto.getDescription());
        assertTrue(dto.isCompleted());
        assertEquals(100, dto.getUserId());
    }
}
