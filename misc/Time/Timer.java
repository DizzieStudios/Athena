package Time;

public class Timer {
    private int milliseconds;
    private int seconds;
    private int minutes;
    public Timer(){
        milliseconds = 0;
        seconds = 0;
        minutes = 0;
        exe();
    }
    public void exe(){
        sleep();
        ++milliseconds;
        if ( milliseconds > 999){
            ++seconds;
            milliseconds = 0;
        }
        if ( seconds > 59){
            ++minutes;
            seconds = 0;
        }
    }

    public int getMilliseconds() {
        return milliseconds;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    private void sleep(){
        try {
            Thread.sleep(1);
        }catch (Exception e){

        }
    }
}
