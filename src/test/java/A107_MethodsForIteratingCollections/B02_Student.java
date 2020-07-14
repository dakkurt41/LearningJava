package A107_MethodsForIteratingCollections;

public class B02_Student implements Comparable<B02_Student> {

    private String name;
    private int score;

    public B02_Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "B02_Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(B02_Student o) {
        return 0;
    }
}
