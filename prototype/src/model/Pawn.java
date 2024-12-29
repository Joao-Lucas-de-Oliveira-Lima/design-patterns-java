package model;

public class Pawn extends ChessPiece{

    private Boolean promotion;
    private Boolean firstMoveBonus;

    public Pawn(){}

    protected Pawn(Pawn target){
        super(target);
        if(target != null){
            this.promotion = target.promotion;
            this.firstMoveBonus = target.firstMoveBonus;
        }
    }

    public Boolean getPromotion() {
        return promotion;
    }

    public void setPromotion(Boolean promotion) {
        this.promotion = promotion;
    }

    public Boolean getFirstMoveBonus() {
        return firstMoveBonus;
    }

    public void setFirstMoveBonus(Boolean firstMoveBonus) {
        this.firstMoveBonus = firstMoveBonus;
    }

    @Override
    public ChessPiece clone(String currentPosition){
        Pawn pawnClone = new Pawn(this);
        pawnClone.setCurrentPosition(currentPosition);
        return pawnClone;
    }

    public String toString(){
        return super.toString() +
               "Promotion: " + this.promotion + "\n" +
               "First Move Bonus: " + this.firstMoveBonus + "\n";
    }

}