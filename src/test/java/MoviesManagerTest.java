import static org.junit.jupiter.api.Assertions.*;

import movies.MoviesManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoviesManagerTest {
    @Test
    public void shouldGetAddedFilms() {
        MoviesManager manager = new MoviesManager();
        manager.add("First");
        manager.add("Second");
        manager.add("Third");

        String[] expected = {"First", "Second", "Third"};
        String[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotGetFilms() {
        MoviesManager manager = new MoviesManager();

        String[] expected = new String[0];
        String[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetOneFilm() {
        MoviesManager manager = new MoviesManager();
        manager.add("First");

        String[] expected = {"First"};
        String[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastCustomLimit() {
        MoviesManager manager = new MoviesManager(2);
        manager.add("First");
        manager.add("Second");
        manager.add("Third");

        String[] expected = {"Third", "Second"};
        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetLast10() {
        MoviesManager manager = new MoviesManager();
        manager.add("First");
        manager.add("Second");
        manager.add("Third");
        manager.add("Fourth");
        manager.add("Fifth");
        manager.add("Sixth");
        manager.add("Seventh");
        manager.add("Eighth");
        manager.add("Ninth");
        manager.add("Tenth");

        String[] expected = {"Tenth", "Ninth", "Eighth", "Seventh", "Sixth", "Fifth", "Fourth", "Third", "Second", "First"};
        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotGetLastOverDefault() {
        MoviesManager manager = new MoviesManager();
        manager.add("First");
        manager.add("Second");
        manager.add("Third");
        manager.add("Fourth");
        manager.add("Fifth");
        manager.add("Sixth");
        manager.add("Seventh");
        manager.add("Eighth");
        manager.add("Ninth");
        manager.add("Tenth");
        manager.add("Eleventh");

        String[] expected = {"Eleventh", "Tenth", "Ninth", "Eighth", "Seventh", "Sixth", "Fifth", "Fourth", "Third", "Second"};
        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldGetLastBelowLimit() {
        MoviesManager manager = new MoviesManager(10);
        manager.add("First");
        manager.add("Second");
        manager.add("Third");
        manager.add("Fourth");
        manager.add("Fifth");

        String[] expected = {"Fifth", "Fourth", "Third", "Second", "First"};
        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);


    }
}

