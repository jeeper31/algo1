import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 1/13/2017.
 */
public class Percolation_UT {

    @Test
    public void shouldPercolate(){
        Percolation percolation = new Percolation(8);

        percolation.open(0, 2);
        percolation.open(0, 3);
        percolation.open(0, 4);

        percolation.open(1, 0);
        percolation.open(1, 3);
        percolation.open(1, 4);
        percolation.open(1, 5);
        percolation.open(1, 6);
        percolation.open(1, 7);

        percolation.open(2, 0);
        percolation.open(2, 1);
        percolation.open(2, 2);
        percolation.open(2, 5);
        percolation.open(2, 6);

        percolation.open(3, 2);
        percolation.open(3, 3);
        percolation.open(3, 5);
        percolation.open(3, 6);
        percolation.open(3, 7);

        percolation.open(4, 1);
        percolation.open(4, 2);
        percolation.open(4, 3);
        percolation.open(4, 5);
        percolation.open(4, 6);

        percolation.open(5, 1);
        percolation.open(5, 6);
        percolation.open(5, 7);

        percolation.open(6, 0);
        percolation.open(6, 2);
        percolation.open(6, 4);
        percolation.open(6, 5);
        percolation.open(6, 6);
        percolation.open(6, 7);

        percolation.open(7, 0);
        percolation.open(7, 1);
        percolation.open(7, 2);
        percolation.open(7, 3);
        percolation.open(7, 5);

        assertTrue(percolation.percolates());
    }

    @Test
    public void shouldNotPercolate() {
        Percolation percolation = new Percolation(8);

        percolation.open(0, 2);
        percolation.open(0, 3);
        percolation.open(0, 5);

        percolation.open(1, 0);
        percolation.open(1, 1);
        percolation.open(1, 2);
        percolation.open(1, 3);
        percolation.open(1, 4);

        percolation.open(2, 0);
        percolation.open(2, 1);
        percolation.open(2, 4);
        percolation.open(2, 5);

        percolation.open(3, 2);
        percolation.open(3, 3);
        percolation.open(3, 4);
        percolation.open(3, 5);
        percolation.open(3, 6);

        percolation.open(4, 0);
        percolation.open(4, 6);
        percolation.open(4, 7);

        percolation.open(5, 1);
        percolation.open(5, 3);
        percolation.open(5, 4);
        percolation.open(5, 5);

        percolation.open(6, 1);
        percolation.open(6, 2);
        percolation.open(6, 4);
        percolation.open(6, 5);
        percolation.open(6, 7);

        percolation.open(7, 0);
        percolation.open(7, 2);
        percolation.open(7, 6);

       assertFalse(percolation.percolates());
    }
}
