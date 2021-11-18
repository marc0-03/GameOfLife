import java.util.ArrayList;
public class Model {
    private Cell[][] cellTable;

    public Model(int width, int height) {
        cellTable = new Cell[width][height];
        for (int w = 0; w<width; w++) {
            for (int h = 0; h<height; h++) {
                cellTable[w][h] = new Cell();
            }
        }
    }


    public void update(Cell[][] cellTable) {
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        int around;


        for (int w = 0; w< cellTable.length; w++) {
            for (int h = 0; h < cellTable[0].length; h++) {
                around = checkAround(w,h,cellTable);

                if (cellTable[w][h].isAlive()) {
                    if (around>=2 && around<=3) {
                    } else {
                        x.add(w);
                        y.add(h);
                    }
                } else {
                    if (around==3){
                        x.add(w);
                        y.add(h);
                    }
                }
            }
        }

        for (int i = 0; i<y.size(); i++) {
            cellTable[x.get(i)][y.get(i)].changeAlive();
        }



    }
    public int checkAround(int w, int h, Cell[][] cellTable) {
        int around = 0;
        int x;
        int y;

        for (x = -1; x<2; x++) {
            for (y = -1; y<2; y++) {
                    if ((w+x > cellTable.length-1 || w+x < 0) || (h+y > cellTable[0].length-1 || h+y < 0)) {

                    } else {
                        if (cellTable[w+x][h+y].isAlive() && !(x==0 && y==0)) {
                            around++;
                        }
                    }
            }
        }
        return around;
    }


    public Cell[][] getCellTable() {
        return cellTable;
    }
}
