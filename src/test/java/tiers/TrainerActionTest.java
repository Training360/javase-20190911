package tiers;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrainerActionTest {

    private DummyTrainerDao trainerDao = new DummyTrainerDao();

    private TrainerAction trainerAction = new TrainerAction(trainerDao);

    @Test
    public void testSaveTrainer() {
        boolean result = trainerAction.saveTrainer("   John Doe   ");

        assertEquals(true, result);
        assertEquals("John Doe", trainerDao.getName());
    }

    @Test
    public void testSaveTrainerWithNull() {

        boolean result = trainerAction.saveTrainer(null);

        assertEquals(false, result);
        assertEquals("XXXXX", trainerDao.getName());
    }

    private static class DummyTrainerDao implements TrainerDao {
        private String name = "XXXXX";

        @Override
        public void insertTrainer(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}