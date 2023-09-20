package ky2lab2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MovingBalls extends JPanel implements Runnable {

    private static final long serialVersionUID = 1L;
    private ArrayList<Ball> balls = new ArrayList<Ball>();
    private Thread animator;
    private boolean running = false;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int NUM_BALLS = 10;
    private static final int BALL_RADIUS = 50;
    private static final int DELAY = 10;

    public MovingBalls() {
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initBalls();
    }

    private void initBalls() {
        Random rand = new Random();
        for (int i = 0; i < NUM_BALLS; i++) {
            int x = rand.nextInt(WIDTH - 2 * BALL_RADIUS);
            int y = rand.nextInt(HEIGHT - 2 * BALL_RADIUS);
            int dx = rand.nextInt(10) - 5;
            int dy = rand.nextInt(10) - 5;
            balls.add(new Ball(x, y, dx, dy, BALL_RADIUS, randColor()));
        }
    }

    private Color randColor() {
        Random rand = new Random();
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    @Override
    public void addNotify() {
        super.addNotify();
        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
            ball.draw(g);
        }
    }

    private void move() {
        for (Ball ball : balls) {
            ball.move();
            ball.bounce(WIDTH, HEIGHT);
        }
    }

    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();
        running = true;
        while (running) {
            move();
            repaint();
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;
            if (sleep < 0) {
                sleep = 2;
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
            beforeTime = System.currentTimeMillis();
        }
    }

    public void stop() {
        running = false;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Balls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new MovingBalls());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private class Ball {

        private Point position;
        private Point velocity;
        private int radius;
        private Color color;

        public Ball(int x, int y, int dx, int dy, int radius, Color color) {
            position = new Point(x, y);
            velocity = new Point(dx, dy);
            this.radius = radius;
            this.color = color;
        }

        public void bounce(int width, int height) {
			// TODO Auto-generated method stub
			
		}

		public void move() {
            position.translate(velocity.x, velocity.y);
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(position.x - radius, position.y - radius, radius * 2, radius * 2);
        }
}}