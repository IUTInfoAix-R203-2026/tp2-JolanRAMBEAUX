package fr.univ_amu.iut.exercice4;

/**
 * Exercice 4 - Robot sur grille infinie.
 *
 * <p>Un robot a une {@link Position} et une {@link Orientation}. Il peut :
 *
 * <ul>
 *   <li>tourner à droite / à gauche (sens horaire / antihoraire)
 *   <li>avancer d'une case dans sa direction courante
 * </ul>
 *
 * <p>Les rotations ne modifient <b>pas</b> la position, et l'avancée ne modifie <b>pas</b>
 * l'orientation. La grille est infinie dans les deux dimensions.
 */
public class Robot {

  private Position position;
  private Orientation orientation;

  public Robot(Position position, Orientation orientation) {
    this.position = position;
    this.orientation = orientation;
  }

  public Position getPosition() {
    return position;
  }

  public Orientation getOrientation() {
    return orientation;
  }

  /** Fait pivoter le robot d'un quart de tour vers sa droite (sens horaire). */
  public void tournerADroite() {
    // TODO exercice 4 : implémenter la rotation horaire.
    // Astuce : profitez de l'ordre NORD → EST → SUD → OUEST → NORD
    // (les valeurs de l'enum sont déjà dans le sens horaire).
    switch (getOrientation()) {
      case NORD:
        this.orientation = Orientation.EST;
        break;
      case EST:
        this.orientation = Orientation.SUD;
        break;
      case SUD:
        this.orientation = Orientation.OUEST;
        break;
      case OUEST:
        this.orientation = Orientation.NORD;
        break;
    }
  }

  /** Fait pivoter le robot d'un quart de tour vers sa gauche (sens antihoraire). */
  public void tournerAGauche() {
    // TODO exercice 4 : implémenter la rotation antihoraire.
    switch (orientation) {
      case NORD:
        this.orientation = Orientation.OUEST;
        break;
      case EST:
        this.orientation = Orientation.NORD;
        break;
      case SUD:
        this.orientation = Orientation.EST;
        break;
      case OUEST:
        this.orientation = Orientation.SUD;
        break;
    }
  }

  /** Avance le robot d'une case dans la direction de son orientation courante. */
  public void avancer() {
    // TODO exercice 4 : implémenter le déplacement d'une case.
    // NORD → y+1, EST → x+1, SUD → y-1, OUEST → x-1
    switch (orientation) {
      case NORD:
        this.position = new Position(this.position.x(), this.position.y() + 1);
        break;
      case EST:
        this.position = new Position(this.position.x() + 1, this.position.y());
        break;
      case SUD:
        this.position = new Position(this.position.x(), this.position.y() - 1);
        break;
      case OUEST:
        this.position = new Position(this.position.x() - 1, this.position.y());
        break;
    }
  }
}
