package com.todolist.spring.todolistt.core.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResourceNotFoundExceptionTest {

    @Test
    public void testResourceNotFoundExceptionMessage() {
        String expectedMessage = "Resource not found";

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> { throw new ResourceNotFoundException(expectedMessage); }
        );

        assertEquals(expectedMessage, exception.getMessage());
    }
}
