import java.util.Vector;
public class JailSpace extends BoardSpace {

  public Vector<Player> jailedPlayers;

  JailSpace(String name, String description) {
    super(name, description);
  }
}