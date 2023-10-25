package solid.java.metal;

/**
 * This Enum contains the spaceships available in the game
 */
public enum SpaceShipType {

    FIRESHIP_A("resources/SpaceshipRed.png"),
    LIGHTSHIP_A("resources/SpaceshipYellow.png"),
    WATERSHIP_A("resources/SpaceshipBlue.png"),

    FIRESHIP_B("resources/SpaceshipRedDown.png"),
    LIGHTSHIP_B("resources/SpaceshipYellowDown.png"),
    WATERSHIP_B("resources/SpaceshipBlueDown.png");

    private final String pictureFile;

    SpaceShipType(String pictureFile) {
        this.pictureFile = pictureFile;
    }

    public String getPictureFile(){
        return this.pictureFile;
    }
}
