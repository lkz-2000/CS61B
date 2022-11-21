import synthesizer.GuitarString;

public class GuitarHero {
    private static final double[] a=new double[37];


    public static void main(String[] args) {
        synthesizer.GuitarString[] b=new GuitarString[37];
        for(int i=0;i<37;i++){
            a[i]=440*Math.pow(2,(i-24.0)/12);
            b[i]=new synthesizer.GuitarString(a[i]);

        }
        /* create two guitar strings, for concert A and C */
        String keyboard ="q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (keyboard.indexOf(key)!=-1) {
                    b[keyboard.indexOf(key)].pluck();
                }
            }

            /* compute the superposition of samples */

            double sample1= b[0].sample();
            for(int i=1;i<37;i++){
                sample1=sample1+b[i].sample();
            }
            /* play the sample on standard audio */
            StdAudio.play(sample1);

            /* advance the simulation of each guitar string by one step */
            for(int i=0;i<37;i++){
                b[i].tic();
            }
        }
    }
}
