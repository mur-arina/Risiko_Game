// erzeugen Angreifer und Verteidiger
public class Player {
	private String role;
    private int stones;

    public Player(String role, int stones) {
        this.role = role;
        this.stones = stones;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStones() {
        return this.stones;
    }

    public void setStones(int stones) {
        this.stones = stones;
    }

}
