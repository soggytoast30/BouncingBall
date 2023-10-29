public class Umbrella {

    private Triangle canvas;
    private RectangleShape pole;
    private int size;
    private int x;
    private int y;
    private String color;
    private boolean isOpen;
    
    public Umbrella() {
        this.size = 100;
        this.x = 50;
        this.y = 0;
        color = "blue";
        isOpen = true;
        canvas = new Triangle();
        canvas.setXPosition(x);
        canvas.setYPosition(y);
        pole = new RectangleShape();
        changeColor(color);
        changeSize(size);
    }
    
    public Umbrella(int size, int x, int y) {
        this.size = size;
        this.x = x;
        this.y = y;
        color = "blue";
        isOpen = true;
        canvas = new Triangle();
        canvas.setXPosition(x);
        canvas.setYPosition(y);
        pole = new RectangleShape();
        changeColor(color);
        changeSize(size);
    }
       
    public void changeSize(int size) {
        this.size = size;
        canvas.changeSize(size/5, size);
        pole.changeSize(size/2, size/20);
        pole.setXPosition(x-size/40);
        pole.setYPosition(y+size/5);
        makeVisible();
    }        
    
    public void changeColor(String color) {
        this.color = color;
        canvas.changeColor(color);
        pole.changeColor(color);
    }
    
    public void moveHorizontal(int d) {
        x += d;
        canvas.setXPosition(x);
        pole.setXPosition(x-size/40);
        makeVisible();
    }
    
    public void moveVertical(int d) {
        y += d;
        canvas.setYPosition(y);
        pole.setYPosition(y+size/5);
        makeVisible();
    }
    
    public void slowMoveHorizontal(int speed, int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -speed;
            distance = -distance;
        }
        else 
        {
            delta = speed;
        }

        for(int i = 0; i < distance; i+=speed)
        {
            moveHorizontal(delta);
        }
    }
    
    public void slowMoveVertical(int speed, int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -speed;
            distance = -distance;
        }
        else 
        {
            delta = speed;
        }

        for(int i = 0; i < distance; i+=speed)
        {
            moveVertical(delta);
        }
    }
    
    public void makeVisible() {
        canvas.makeVisible();
        pole.makeVisible();
    }
    
    public void open()
    {
        if (!isOpen) {
            canvas.changeSize(size/5, size);
            isOpen = true;
        } 
    }
    
    public void close() 
    {
        if (isOpen) {
            canvas.changeSize(size/2+size/5, size/5);
            isOpen = false;
        } 
    }
    
}