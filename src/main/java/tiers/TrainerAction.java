package tiers;

public class TrainerAction {

    private TrainerDao trainerDao;

    public TrainerAction(TrainerDao trainerDao) {
        this.trainerDao = trainerDao;
    }

    public boolean saveTrainer(String name) {
        if (name == null || name.trim().length() == 0) {
            return false;
        }
        String modifiedName = name.trim();

        trainerDao.insertTrainer(modifiedName);

        return true;
    }
}
