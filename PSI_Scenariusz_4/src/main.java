import java.util.Random;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double wspolczynnikUczenia = 0.1;
		double wspolczynnikZapominania = 1;
		double[][] all = new double[20][20];
		double[] dobreOdpowiedzi = new double[2];
		createWectors(all);
		perc[] percs = new perc[2];
		Random rand = new Random();
		int doRozwazenia = rand.nextInt(20);
		percs[0]=new perc(all[doRozwazenia]);
		percs[1]=new perc(all[doRozwazenia]);
		for(int z=0;z<1000;z++) {
			int[] odp = new int[2];
			percs[0].sum();
			percs[1].sum();
			if(percs[0].getSuma()>10) {
				odp[0]=1;
				if(doRozwazenia<10) {
					dobreOdpowiedzi[0]++;
				}
			}else {
				odp[0]=-1;
				if(doRozwazenia>9) {
					dobreOdpowiedzi[0]++;
				}
			}
			if(percs[1].getSuma()<10) {
				odp[1]=1;
				if(doRozwazenia>9) {
					dobreOdpowiedzi[1]++;
				}
			}else {
				odp[1]=-1;
				if(doRozwazenia<10) {
					dobreOdpowiedzi[1]++;
				}
			}
			//System.out.println(percs[0].getSuma());
			//System.out.println(percs[1].getSuma());
			//System.out.println("Dla wektora nr "+doRozwazenia+" perceptron 1 odpowiedzial: "+odp[0]+", a perceptron 2 odpowiedzial: "+odp[1]);
			for(int i=0;i<20;i++) {
				percs[0].setWeight(i, percs[0].getWeights()[i]+wspolczynnikUczenia*all[doRozwazenia][i]*odp[0]-wspolczynnikZapominania*percs[0].getWeights()[i]*all[doRozwazenia
				                                                                                                                                                    ][i]*odp[0]);
				percs[1].setWeight(i, percs[1].getWeights()[i]+wspolczynnikUczenia*all[doRozwazenia][i]*odp[1]-wspolczynnikZapominania*percs[1].getWeights()[i]*all[doRozwazenia][i]*odp[1]);
			}
			doRozwazenia = rand.nextInt(20);
			percs[0].setVector(all[doRozwazenia]);
			percs[1].setVector(all[doRozwazenia]);
		}
		for(int z=0;z<20;z++) {
			dobreOdpowiedzi[0]=dobreOdpowiedzi[1]=0;
			for(int i=0;i<100;i++) {
				doRozwazenia = rand.nextInt(20);
				percs[0].setVector(all[doRozwazenia]);
				percs[1].setVector(all[doRozwazenia]);
				int[] odp = new int[2];
				percs[0].sum();
				percs[1].sum();
				if(percs[0].getSuma()>10) {
					odp[0]=1;
					if(doRozwazenia<10) {
						dobreOdpowiedzi[0]++;
					}
				}else {
					odp[0]=-1;
					if(doRozwazenia>9) {
						dobreOdpowiedzi[0]++;
					}
				}
				if(percs[1].getSuma()<10) {
					odp[1]=1;
					if(doRozwazenia>9) {
						dobreOdpowiedzi[1]++;
					}
				}else {
					odp[1]=-1;
					if(doRozwazenia<10) {
						dobreOdpowiedzi[1]++;
					}
				}
			}
			double[] procenty = new double[2];
			procenty[0]=dobreOdpowiedzi[0]/100*100;
			procenty[1]=dobreOdpowiedzi[1]/100*100;
			System.out.println("Perceptron 1 mial: "+procenty[0]+"% dobrych odpowiedzi a perceptron 2 mial: "+procenty[1]+"% dobrych odpowiedzi");
		}
	}

	public static void createWectors(double[][] all) {
		double[] A={0,1,1,0,1,0,0,1,1,1,1,1,1,0,0,1,1,0,0,1};
		double[] B={1,1,1,0,1,0,0,1,1,1,1,0,1,0,0,1,1,1,1,0};
		double[] C={0,1,1,0,1,0,0,1,1,0,0,0,1,0,0,1,0,1,1,0};
		double[] D={1,1,1,0,1,0,0,1,1,0,0,1,1,0,0,1,1,1,1,0};
		double[] E={1,1,1,1,1,0,0,0,1,1,1,1,1,0,0,0,1,1,1,1};
		double[] F={1,1,1,1,1,0,0,0,1,1,1,0,1,0,0,0,1,0,0,0};
		double[] G={0,1,1,0,1,0,0,0,1,0,1,0,1,0,0,1,0,1,1,0};
		double[] H={1,0,0,1,1,0,0,1,1,1,1,1,1,0,0,1,1,0,0,1};
		double[] I={0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0};
		double[] J={0,1,1,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,1,0};
		double[] a={0,0,0,0,0,0,0,0,0,1,1,0,1,0,1,0,0,1,1,0};			
		double[] b={0,0,0,0,1,0,0,0,1,1,0,0,1,0,1,0,0,1,0,0};
		double[] c={0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0};
		double[] d={0,0,0,0,0,0,1,0,0,1,1,0,1,0,1,0,0,1,1,0};
		double[] e={0,0,0,0,0,1,0,0,1,0,1,0,1,0,0,0,0,1,1,0};
		double[] f={0,0,0,0,0,1,1,0,1,0,0,0,1,1,0,0,1,0,0,0};
		double[] g={0,0,0,0,0,1,0,0,1,0,1,0,0,0,1,0,0,1,0,0};
		double[] h={0,0,0,0,1,0,0,0,1,0,0,0,1,1,1,0,1,0,1,0};
		double[] i={0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0};
		double[] j={0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,1,0,0};
		all[0]=A;
		all[1]=B;
		all[2]=C;
		all[3]=D;
		all[4]=E;
		all[5]=F;
		all[6]=G;
		all[7]=H;
		all[8]=I;
		all[9]=J;
		all[10]=a;
		all[11]=b;
		all[12]=c;
		all[13]=d;
		all[14]=e;
		all[15]=f;
		all[16]=g;
		all[17]=h;
		all[18]=i;
		all[19]=j;
	}
}
