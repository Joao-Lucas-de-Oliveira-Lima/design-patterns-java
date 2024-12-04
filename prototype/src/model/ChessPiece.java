package model;

public abstract class ChessPiece {
    private String color;
    private String currentPosition;
    private Integer pointValue;
    private Boolean alive;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Integer getPointValue() {
        return pointValue;
    }

    public void setPointValue(Integer pointValue) {
        this.pointValue = pointValue;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    protected ChessPiece(){}

    protected ChessPiece(ChessPiece target){
        if(target != null){
            this.color = target.color;
            this.currentPosition = target.currentPosition;
            this.pointValue = target.pointValue;
            this.alive = target.alive;
        }
    }

    public abstract ChessPiece clone(String currentPosition);

    public String toString(){
        return "Color: " + this.color + "\n" +
               "Current Position: " + this.currentPosition + "\n" +
               "Point Value: " + this.pointValue + "\n" +
               "Alive: " + this.alive + "\n";
    }
}
