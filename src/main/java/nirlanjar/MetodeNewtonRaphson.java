package nirlanjar;

public class MetodeNewtonRaphson {
    final double EPSILON1 = 0.000001; // Toleransi galat akar hampiran
    final double EPSILON2 = 0.000000001; // Toleransi nilai yang hampir 0
    final int NMAX = 30; // Jumlah maksimum iterasi

    public static void main(String[] args) {
        MetodeNewtonRaphson newtonRaphson = new MetodeNewtonRaphson();
        newtonRaphson.newtonRaphson(1.5); // tebakan awal x0 Soal 2a
//        newtonRaphson.newtonRaphson(3.5); // tebakan awal x0 Soal 2b

    }

    // Fungsi f(x)
    static double fungsi(double x) {
        return Math.exp(x) + Math.pow(2, -x) + 2 * Math.cos(x) - 6; // Soal 2a
//        return Math.pow(x - 2, 2) - Math.log(x); // Soal 2b
    }

    // Turunan dari fungsi f(x)
    static double turunanFungsi(double x) {
        return Math.exp(x) - Math.pow(2, -x) * Math.log(2) - 2 * Math.sin(x); // Soal 2a
//        return 2 * (x - 2) - 1 / x; // Soal 2b
    }

    void newtonRaphson(double x) {
        double xSebelumnya;
        boolean berhenti = false;
        int i = 0;

        do {
            if (Math.abs(turunanFungsi(x)) < EPSILON2) {
                berhenti = true;
                break; // Menghindari pembagian bilangan yang mendekati 0
            } else {
                xSebelumnya = x;
                x = x - fungsi(x) / turunanFungsi(x);
                i++;

                // Output
                double selisihX = Math.abs(x - xSebelumnya);
                System.out.printf("Iterasi %d: x0 = %.5f || x1 = %.5f || selisih X = %.5f\n", i, xSebelumnya, x, selisihX);
            }
        } while (!(Math.abs(x - xSebelumnya) < EPSILON1) && i < NMAX);

        if (berhenti) {
            System.out.println("Pembagian dengan bilangan yang mendekati 0");
        } else if (i >= NMAX) {
            System.out.println("Divergen");
        } else {
            // x adalah hampiran akar persamaan
            System.out.printf("Hampiran akar x = %.6f\n", x);
        }
    }
}
