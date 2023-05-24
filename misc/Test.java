
import Tools.Alphabet;
import Tools.NumberTools;
class Test {

    public static void main(String[] args) {
        int[] n = {5,2};
        int[] a = {2,5};
        System.out.print(n[0]+""+n[1]);
        n = NumberTools.swap(n,0,1);
        System.out.println(n[0]+""+n[1]);
        System.out.println((n[0]==a[0])&&(n[1]==a[1]));
    }
}
