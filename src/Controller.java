import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class Controller implements Runnable{
    private Thread thread;
    private boolean running = false;
    private boolean pause = false;
    private int fps = 60;
    private double deltaT;

    private View view;
    private Model model;

    public Controller() {
        int width = 900;
        int height = 900;
        int cellWidth = 450;
        int cellHeight = 450;
        view = new View(width, height);
        model = new Model(cellWidth, cellHeight);
        view.setCellSize(model.getCellTable());

        JFrame frame = new JFrame("My Nuts");
        frame.setSize(1200,800);
        frame.add(view);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.addKeyListener(new KL());
        frame.setVisible(true);
    }


    @Override
    public void run() {
        deltaT = 1000.0 / fps;
        long lastTime = System.currentTimeMillis();
        view.draw(model.getCellTable());

        while (running) {
            long now = System.currentTimeMillis();
            if (now - lastTime > deltaT) {
                if (!pause) {
                    model.update(model.getCellTable());
                }
                view.draw(model.getCellTable());

                lastTime = now;
            }
        }
        stop();
    }

    public static void main(String[] args) {
        Controller c = new Controller();
        c.start();
    }
    public synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private class KL implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
                ArrayList<Integer> x = new ArrayList<Integer>();
                ArrayList<Integer> y = new ArrayList<Integer>();

                for (int ww = 0; ww<model.getCellTable().length; ww++) {
                    for (int hh = 0; hh<model.getCellTable()[0].length; hh++) {
                        if (Math.random()>0 && (!model.getCellTable()[ww][hh].isAlive() && model.checkAround(ww,hh,model.getCellTable())==1)) {
                            x.add(ww);
                            y.add(hh);
                        }
                    }
                }

                for (int i = 0; i<y.size(); i++) {
                    model.getCellTable()[x.get(i)][y.get(i)].setAlive(true);
                }

                model.update(model.getCellTable());

            }
            if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') { }
            if (e.getKeyChar() == 'r' || e.getKeyChar() == 'R') {
                for (int ww = 0; ww<model.getCellTable().length; ww++) {
                    for (int hh = 0; hh<model.getCellTable()[0].length; hh++) {
                        if (Math.random()>0.40) {
                            model.getCellTable()[ww][hh].setAlive(true);
                        } else {
                            model.getCellTable()[ww][hh].setAlive(false);
                        }
                    }
                }
            } //Randomize CellTable 50/50 Alive And Dead.
            if (e.getKeyChar() == 'f' || e.getKeyChar() == 'F') {
                ArrayList<Integer> x = new ArrayList<Integer>();
                ArrayList<Integer> y = new ArrayList<Integer>();

                for (int ww = 0; ww<model.getCellTable().length; ww++) {
                    for (int hh = 0; hh<model.getCellTable()[0].length; hh++) {
                        if (Math.random()>0 && (!model.getCellTable()[ww][hh].isAlive() && model.checkAround(ww,hh,model.getCellTable())>0)) {
                            x.add(ww);
                            y.add(hh);
                        }
                    }
                }

                for (int i = 0; i<y.size(); i++) {
                    model.getCellTable()[x.get(i)][y.get(i)].setAlive(true);
                }

            } //Turns 100% Of Dead Cells Around Alive Cells, Alive Again.
            if (e.getKeyChar() == 'g' || e.getKeyChar() == 'G') {
                ArrayList<Integer> x = new ArrayList<Integer>();
                ArrayList<Integer> y = new ArrayList<Integer>();

                for (int ww = 0; ww<model.getCellTable().length; ww++) {
                    for (int hh = 0; hh<model.getCellTable()[0].length; hh++) {
                        if (Math.random()>0 && (!model.getCellTable()[ww][hh].isAlive() && model.checkAround(ww,hh,model.getCellTable())==1)) {
                            x.add(ww);
                            y.add(hh);
                        }
                    }
                }

                for (int i = 0; i<y.size(); i++) {
                    model.getCellTable()[x.get(i)][y.get(i)].setAlive(true);
                }

            } //Turns 10% Of Dead Cells Around Alive Cells, Alive Again.
            if (e.getKeyChar() == 'c' || e.getKeyChar() == 'C') {
                for (int ww = 0; ww<model.getCellTable().length; ww++) {
                    for (int hh = 0; hh<model.getCellTable()[0].length; hh++) {
                            model.getCellTable()[ww][hh].setAlive(false);
                    }
                }
            } //Clear CellTable Of Alive Cells.
            if (e.getKeyChar() == 'p' || e.getKeyChar() == 'P') {
                if (pause) {
                    pause=false;
                } else {
                    pause = true;
                }
            } //Pause Button.
            if (e.getKeyChar() == 'q' || e.getKeyChar() == 'Q') {
                model.update(model.getCellTable());
            } //Manual Update.
        }
        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
