package Time;

public class Timer {
    private int milliseconds;
    private int seconds;
    private int minutes;
    public Timer(){

    }

    private void sleep(){
        try {
            Thread.sleep(1);
        }catch (Exception e){

        }
    }
}
