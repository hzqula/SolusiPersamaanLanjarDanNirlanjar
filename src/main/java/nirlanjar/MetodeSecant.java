package nirlanjar;

public class MetodeSecant {
    final double EPSILON1 = 0.00001; // Toleransi galat akar hampiran
    final double EPSILON2 = 0.000000001; // Toleransi nilai yang hampir 0
    final int NMAX = 30; // Jumlah maksimum iterasi

    public static void main(String[] args) {
        MetodeSecant secant = new MetodeSecant();
        secant.secant(1, 2); // Tebakan awal x0 dan x1 Soal 3a
//        secant.secant(1, 0.7); // Tebakan awal x0 dan x1 Soal 3b


    }

    // Fungsi f(x)
    static double fungsi(double x) {
//        return x + Math.log(x) - 2; // Soal 3a
//        return Math.exp(-x) - Math.tan(x); // Soal 3b
        return x * Math.cos(x) - 2 * Math.pow(x, 3) + 3 * x - 1; // Soal 1b


    }


    void secant(double x0, double x1) {
        double xSebelumnya;
        boolean berhenti = false;
        int i = 0;

        do {
            if (Math.abs(fungsi(x1) - fungsi(x0)) < EPSILON2) {
                berhenti = true;
                break; // menghindari pembagian bilangan yang mendekati nol
            } else {
                xSebelumnya = x1;
                x1 = x1 - (fungsi(x1) * (x1 - x0) / (fungsi(x1) - fungsi(x0)));
                x0 = xSebelumnya;
                i++;

                // Output
                double selisihX = Math.abs(x1 - xSebelumnya);
                System.out.printf("Iterasi %d: x0 = %.5f || x1 = %.5f || selisih X = %.5f\n", i, x0, x1, selisihX);
            }
        } while (!(Math.abs(x1 - xSebelumnya) < EPSILON1) && i < NMAX);

        if (berhenti) {
            System.out.println("Pembagian dengan bilangan yang mendekati 0");
        } else if (i >= NMAX) {
            System.out.println("Divergen");
        } else {
            // x adalah hampiran akar persamaan
            System.out.printf("Hampiran akar x = %.5f\n", x1);
        }
    }
}
