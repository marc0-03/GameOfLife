public class Cell {
    private boolean Alive;

    public Cell(){
        if (Math.random() > 0.5){
            Alive=false;
        }else{
            Alive=true;
        }
    }

    public boolean isAlive() {
        return Alive;
    }

    public void setAlive(Boolean state) {
        Alive=state;
    }

    public void changeAlive() {
        Alive=!Alive;
    }
}
