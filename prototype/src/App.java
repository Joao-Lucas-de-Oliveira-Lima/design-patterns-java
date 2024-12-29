import model.Pawn;

public class App {
    public static void main(String[] args) throws Exception {
        // Pawn created empty and then set
        Pawn pawn = new Pawn();
        pawn.setAlive(true);
        pawn.setColor("White");
        pawn.setCurrentPosition("A2");
        pawn.setPointValue(1);
        pawn.setPromotion(false);
        pawn.setFirstMoveBonus(true);

        // Pawn cloned using the prototype pattern
        Pawn pawnClone = (Pawn) pawn.clone("A3");

        System.out.println(pawnClone.toString());
        
    }
}
