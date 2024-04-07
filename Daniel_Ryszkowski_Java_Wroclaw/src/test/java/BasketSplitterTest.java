import org.daniel.ryszkowski.java.ocadoApi.BasketSplitter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class BasketSplitterTest {

    private BasketSplitter basketSplitter;


    @BeforeEach
    void setUp() {
        basketSplitter = new BasketSplitter("testConfig.json");
    }

    @Test
    void splitShouldReturnCorrectGrouping() {
        List<String> items = Arrays.asList("item1", "item2", "item3");
        Map<String, List<String>> result = basketSplitter.split(items);

        // Assert the result
        assertEquals(2, result.size());
        assertTrue(result.get("deliveryMethod1").contains("item1"));
        assertTrue(result.get("deliveryMethod3").contains("item3"));
        assertNull(result.get("deliveryMethod2"));
    }

    @Test
    void splitShouldHandleEmptyItemList() {
        List<String> items = new ArrayList<>();
        Map<String, List<String>> result = basketSplitter.split(items);

        // Assert the result
        assertTrue(result.isEmpty());
    }

    @Test
    void splitShouldThrowExceptionForNullConfig() {
        BasketSplitter basketSplitterWithNullConfig = new BasketSplitter(null);
        List<String> items = Arrays.asList("item1", "item2", "item3");

        // Assert that an exception is thrown
        assertThrows(IllegalArgumentException.class, () -> basketSplitterWithNullConfig.split(items));
    }

    @Test
    void splitShouldReturnCorrectGroupingWhenItemsHaveMultipleDeliveryMethods() {
        List<String> items = Arrays.asList("item1", "item2", "item3", "item4");
        Map<String, List<String>> result = basketSplitter.split(items);

        // Assert the result
        assertEquals(2, result.size());
        assertTrue(result.get("deliveryMethod1").containsAll(Arrays.asList("item1", "item4")));
        assertNull(result.get("deliveryMethod2"));
    }

    @Test
    void splitShouldReturnSingleGroupWhenAllItemsHaveSameDeliveryMethod() {
        List<String> items = Arrays.asList("item1", "item2", "item3", "item4");
        Map<String, List<String>> result = basketSplitter.split(items);

        // Assert the result
        assertEquals(2, result.size());
        assertFalse(result.get("deliveryMethod1").containsAll(Arrays.asList("item1", "item2", "item3", "item4")));
    }

    @Test
    void splitShouldHandleSingleItem() {
        List<String> items = Collections.singletonList("item1");
        Map<String, List<String>> result = basketSplitter.split(items);

        // Assert the result
        assertEquals(1, result.size());
        assertTrue(result.get("deliveryMethod1").contains("item1"));
    }
}
