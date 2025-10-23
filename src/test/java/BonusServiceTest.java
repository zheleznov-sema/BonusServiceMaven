import org.example.BonusService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 400;
        boolean registered = false;
        long expected = 4;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldCalculateForNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldCalculateForNotRegisteredAndOnLimitValue() {
        BonusService service = new BonusService();

        long amount = 500;
        boolean registered = false;
        long expected = 5;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldCalculateForRegisteredAndLimitZero() {
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }

}
