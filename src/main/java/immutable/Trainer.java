package immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trainer {

    private final String name;

    private final List<String> skills;

    public Trainer(String name, List<String> skills) {
        this.name = name;
        this.skills = Collections.unmodifiableList(new ArrayList<>(skills));
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }
}
