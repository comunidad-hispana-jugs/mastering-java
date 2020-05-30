package org.medellinjug.mastering_java.avoid_checked_exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AvoidingCheckedExceptions {
    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        assertEquals(2, 1, "1 + 1 should equal 2");
    }
}
