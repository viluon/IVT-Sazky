
public class Hrac
{
	private static int kurz = 1;
	public String jmeno;
	public int hotovost;
	public int pocetZetonu;

	public Hrac( String j, int h )
	{
		this.jmeno = j;
		this.hotovost = h;
	}

	public void nakupZetonu( int m )
	{
		if ( this.hotovost < m * kurz )
		{
			return;
		}

		this.hotovost -= m * kurz;
		this.pocetZetonu += m;
	}

	public void prodejZetonu( int m )
	{
		if ( this.pocetZetonu < m )
		{
			return;
		}

		this.hotovost += m * kurz;
		this.pocetZetonu -= m;
	}

	public void vsad( int tC, int pZ, Ruleta R )
	{
		if ( pZ > this.pocetZetonu )
		{
			return;
		}
		if ( tC > R.horniMez || tC < R.dolniMez )
		{
			return;
		}

		this.pocetZetonu -= pZ;

		R.registrujSazku( new Sazka( tC, pZ, this, R ) );
	}
}