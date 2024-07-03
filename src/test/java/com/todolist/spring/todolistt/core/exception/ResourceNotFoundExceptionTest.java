package com.todolist.spring.todolistt.core.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResourceNotFoundExceptionTest {

    @Test
    public void testResourceNotFoundExceptionMessage() {
        // Define the expected message
        String expectedMessage = "Resource not found";

        // Use assertThrows to check that the exception is thrown with the correct message
        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> { throw new ResourceNotFoundException(expectedMessage); }
        );

        // Verify the message of the exception
        assertEquals(expectedMessage, exception.getMessage());
    }
}
