package Tools;

public class StringComp
{
    String[] input;
    public StringComp( String[] input ){
        this.input = input;
    }

    public String[] sort(){
        if ( input.length == 1 ){
            return input;
        }
        String[] re = new String[input.length];
        int[][] vaa = new int[input.length][];
        for ( int i = 0 ; i < input.length ; i++ ){
            vaa[i] = ( new Alphabet(input[i]) ).getValueArray();
        }
        int[] fvaa = new int[input.length];
        for ( int i = 0 ; i < input.length ; i++ ){
            fvaa[i] = vaa[i][0];
        }
        int[] sfvaa = NumberTools.compareIndices(fvaa);
        for ( int j = 0 ; j < input.length ; j++ ){
            for ( int i = 0 ; i < input.length-1 ; i++ ){
                f:
                if ( vaa[sfvaa[i]][0] == vaa[ sfvaa[i+1] ][0] ){
                    int[] t = new int[2];
                    t[0] = vaa[ sfvaa[i] ].length;
                    t[1] = vaa[ sfvaa[i+1] ].length;
                    t = NumberTools.comp(t);
                    for ( int k = 0 ; k < t[0]-1 ; k++ ){
                        if( vaa[ sfvaa[i] ][k] == vaa[ sfvaa[i+1] ][k] ){
                            if (  vaa[ sfvaa[i] ][k+1] > vaa[ sfvaa[i+1] ][k+1] ){
                                int temp = sfvaa[i];
                                sfvaa[i] = sfvaa[i+1];
                                sfvaa[i+1] = temp;
                                break f;
                            }
                        }
                    }
                    if ( vaa [ sfvaa[i] ].length > vaa[ sfvaa[i+1] ].length ){
                        int temp = sfvaa[i];
                        sfvaa[i] = sfvaa[i+1];
                        sfvaa[i+1] = temp;
                    }
                }
            }
        }
        for ( int i = 0 ; i < input.length ; i++ ){
            re[i] = input[sfvaa[i]];
        }
        return re;
    }

    public int[] getIndices(){
        int[][] vaa = new int[input.length][];
        int[] fvaa = new int[input.length];
        for ( int i = 0 ; i < input.length ; i++ ){
            vaa[i] = ( new Alphabet(input[i]) ).getValueArray();
            fvaa[i] = vaa[i][0];
        }
        int[] sfvaa = NumberTools.compareIndices(fvaa);
        for ( int j = 0 ; j < input.length ; j++ ){
            for ( int i = 0 ; i < input.length-1 ; i++ ){
                f:
                if ( vaa[sfvaa[i]][0] == vaa[ sfvaa[i+1] ][0] ){
                    int[] t = new int[2];
                    t[0] = vaa[ sfvaa[i] ].length;
                    t[1] = vaa[ sfvaa[i+1] ].length;
                    t = NumberTools.comp(t);
                    for ( int k = 0 ; k < t[0]-1 ; k++ ){
                        if( vaa[ sfvaa[i] ][k] == vaa[ sfvaa[i+1] ][k] ){
                            if (  vaa[ sfvaa[i] ][k+1] > vaa[ sfvaa[i+1] ][k+1] ){
                                int temp = sfvaa[i];
                                sfvaa[i] = sfvaa[i+1];
                                sfvaa[i+1] = temp;
                                break f;
                            }
                        }
                    }
                    if ( vaa [ sfvaa[i] ].length > vaa[ sfvaa[i+1] ].length ){
                        int temp = sfvaa[i];
                        sfvaa[i] = sfvaa[i+1];
                        sfvaa[i+1] = temp;
                    }
                }
            }
        }
        return sfvaa;
    }
}
