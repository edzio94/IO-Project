

/**
 * Created by lukasz on 1/30/17.
 */
public class ValidationExtra {
    private String username;
    private String email;

    public ValidationExtra() {
    }

    public ValidationExtra(String username) {
        this.username = username;

    }

    public ValidationExtra(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public boolean valid() {
        return username.length()>=5;
    }
    public boolean valide() {
        return email.matches("^.*@.*/..*");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
