import java.util.Vector;
public class JailSpace extends BoardSpace {

  public Vector<Player> jailedPlayers;

  JailSpace(String name) {
    super(name);
  }
}