package A102_LearningJava11;

public enum ClothingSize {
    L("Large"),
    M("Medium"),
    S("Small");


    private String description;

    ClothingSize(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  description ;
    }
}
