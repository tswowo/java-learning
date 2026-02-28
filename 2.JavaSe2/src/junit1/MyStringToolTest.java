package junit1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyStringToolTest {
    @Test
    void isEmpty() {
        MyStringTool tool = new MyStringTool();
        boolean result = tool.isEmpty("");
        System.out.println(result);
        assertTrue(result);
        assertFalse(tool.isEmpty(" "));
        assertFalse(tool.isEmpty("abc"));
        assertTrue(tool.isEmpty(null));
    }
    @Test
    void getLength() {
        MyStringTool tool = new MyStringTool();
        int result = tool.getLength("");
        System.out.println(result);
        assertEquals(0, result);
        assertEquals(3, tool.getLength("abc"));
        assertThrows(NullPointerException.class, () -> tool.getLength(null));
    }
}