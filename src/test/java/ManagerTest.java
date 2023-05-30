import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    @Test
    public void addTest() {
        ManagerF manager = new ManagerF();
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        String[] actual = manager.findAll();
        String[] expected = {"Film 1", "Film 2"};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void addZeroTest() {
        ManagerF manager = new ManagerF();
        String[] actual = manager.findAll();
        String[] expected = {};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void addOverLimitTest() {
        ManagerF manager = new ManagerF(5);
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        manager.addFilm("Film 3");
        manager.addFilm("Film 4");
        manager.addFilm("Film 5");
        manager.addFilm("Film 6");
        String[] actual = manager.findLast();
        String[] expected = {"Film 6", "Film 5", "Film 4", "Film 3", "Film 2"};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void addOnLimitTest() {
        ManagerF manager = new ManagerF(3);
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        manager.addFilm("Film 3");
        String[] actual = manager.findLast();
        String[] expected = {"Film 3", "Film 2", "Film 1"};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void addWithoutLimitTest() {
        ManagerF manager = new ManagerF();
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        manager.addFilm("Film 3");
        manager.addFilm("Film 4");
        manager.addFilm("Film 5");
        manager.addFilm("Film 6");
        String[] actual = manager.findLast();
        String[] expected = {"Film 6", "Film 5", "Film 4", "Film 3", "Film 2"};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void addZeroLimitTest() {
        ManagerF manager = new ManagerF(3);
        String[] actual = manager.findLast();
        String[] expected = {};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void addUnderLimitTest() {
        ManagerF manager = new ManagerF(3);
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        String[] actual = manager.findLast();
        String[] expected = {"Film 2", "Film 1"};
        Assertions.assertArrayEquals(actual, expected);
    }
}
