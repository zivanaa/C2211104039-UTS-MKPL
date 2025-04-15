package lib;

public class TaxFunction {

	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus
	 * dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan
	 * bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan)
	 * dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena
	 * pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah
	 * sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya
	 * ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */

	private static final int BULAN_MAKSIMUM_KERJA = 12;
	private static final int ANAK_MAKSIMUM_UNTUK_POTONGAN = 3;
	private static final double TARIF_PAJAK = 0.05;
	private static final int PENGHASILAN_TIDAK_KENA_PAJAK_DASAR = 54000000;
	private static final int PENGHASILAN_TIDAK_KENA_PAJAK_PASANGAN = 4500000;
	private static final int PENGHASILAN_TIDAK_KENA_PAJAK_ANAK = 1500000;

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible,
			boolean isMarried, int numberOfChildren) {

		int tax = 0;

		if (numberOfMonthWorking > BULAN_MAKSIMUM_KERJA) {
			System.err.println("Bulan kerja melebihi 12 bulan dalam setahun");
		}

		int anakUntukPotongan = Math.min(numberOfChildren, ANAK_MAKSIMUM_UNTUK_POTONGAN);

		int totalPendapatan = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
		int penghasilanTidakKenaPajak = PENGHASILAN_TIDAK_KENA_PAJAK_DASAR;

		if (isMarried) {
			penghasilanTidakKenaPajak += PENGHASILAN_TIDAK_KENA_PAJAK_PASANGAN
					+ (anakUntukPotongan * PENGHASILAN_TIDAK_KENA_PAJAK_ANAK);
		}

		tax = (int) Math.round(TARIF_PAJAK * (totalPendapatan - deductible - penghasilanTidakKenaPajak));

		return Math.max(tax, 0);
	}

}
