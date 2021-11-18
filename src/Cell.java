import com.sun.org.apache.xpath.internal.operations.Bool;

public class Cell {
    boolean Alive;

    public Cell(){
        if (Math.random() > 0.5){
            Alive=false;
        }else{
            Alive=true;
        }
    }
    public Cell(Boolean Alive){
        this.Alive = Alive;
    }

    public boolean isAlive() {
        return Alive;
    }

    public void setAlive(Boolean state) {
        Alive=state;
    }

    public void changeAlive() {
        if (Alive){
            Alive=false;
        } else {
            Alive=true;
        }
    }
}
