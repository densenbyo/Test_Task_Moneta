package tasks;

/**
 * @author Mukan Atazhanov
 * @project TestTask
 * @created 15/02/2022 - 23:00
 */
public class Greeting {
    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
