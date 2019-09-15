package tiers;

public class JpaTrainerDao implements TrainerDao {

    @Override
    public void insertTrainer(String name) {
        // SQL insert, JPA persist
        System.out.println("Insert trainer: " + name);
    }
}
