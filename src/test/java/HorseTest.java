import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class HorseTest {

    @Test
    public void ThrowsIfNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 5, 5));
    }

    @Test
    public void HorseCannotBeNullMessage() {
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 5, 5));
        assertEquals(exc.getMessage(), "Name cannot be null.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void ifStringNameIsProbel(String string) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(string, 5, 5));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void StringNameCannotBeProbelMessage(String string) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse(string, 5, 5));
        assertEquals(exception.getMessage(), "Name cannot be blank.");
    }


    @Test
    public void ifSpeedIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Horse("hey", -5, 5));
    }

    @Test
    public void SpeedCannotBeNegativeMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse("hey", -5, 5));
        assertEquals(exception.getMessage(), "Speed cannot be negative.");
    }

    @Test
    public void ThrowsIfDistanceIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Horse("hey", 5, -5));
    }

    @Test
    public void DistanceCannotBeNegativeMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse("hey", 5, -5));
        assertEquals(exception.getMessage(), "Distance cannot be negative.");
    }

    @ParameterizedTest
    @ValueSource(strings = "string")
    public void NameParametrEqualsGetName(String string) {
        Horse horse = new Horse(string, 5, 5);
        assertEquals(horse.getName(), string);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10})
    public void SpeedParametrEqualsGetSpeed(int speed) {
        Horse horse = new Horse("name", speed, 5);
        assertEquals(horse.getSpeed(), speed);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10})
    public void DistanceParametrEqualsGetDistance(int distance) {
        Horse horse = new Horse("name", 5, distance);
        assertEquals(horse.getDistance(), distance);
    }

    @Test
    public void IfNoDistanceParametrReturnZeroGetDistance() {
        Horse horse = new Horse("name", 5);
        assertEquals(horse.getDistance(), 0);
    }

    @Test
    public void testGetRandomDoubleInMethodMove() {
        Horse horse = new Horse("name", 5, 5);
        try (MockedStatic<Horse> static_horse = Mockito.mockStatic(Horse.class)) {
            horse.move();
            static_horse.verify(() -> Horse.getRandomDouble(anyDouble(), anyDouble()));
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.2, 0.9})
    public void testGetRandomDoubleInMethodMove1(Double first, Double second) {
        Horse horse = new Horse("name", 5, 5);
        try (MockedStatic<Horse> static_horse = Mockito.mockStatic(Horse.class)) {
            horse.move();
            static_horse.verify(() -> Horse.getRandomDouble(first, second));
        }
    }
}




