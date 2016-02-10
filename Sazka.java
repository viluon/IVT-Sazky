
public class Sazka
{
	public Hrac sazejici;
	public Ruleta ruleta;
	public int tipovaneCislo;
	public int pocetZetonu;

	public Sazka( int tC, int pZ, Hrac S, Ruleta R )
	{
		this.tipovaneCislo = tC;
		this.pocetZetonu = pZ;
		this.sazejici = S;
		this.ruleta = R;

	}
}
