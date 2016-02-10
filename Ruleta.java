
import java.util.*;

public class Ruleta
{
	public int dolniMez;
	public int horniMez;

	private int vyherniCislo;

	private boolean prijimaSazky = true;

	private Sazka[] evidenceSazek = new Sazka[ 256 ];
	private int pocetSazek = 0;	

	public Ruleta( int d, int h )
	{
		this.dolniMez = d;
		this.horniMez = h;

	}

	public void roztoc()
	{
		this.prijimaSazky = false;

		Random rnd = new Random();

		this.vyherniCislo = this.dolniMez + rnd.nextInt( this.horniMez - this.dolniMez );

		Hrac[] vyherci = new Hrac[ this.pocetSazek ];
		int[] vsazeno = new int[ this.pocetSazek ];
		int pocetVyhercu = 0;

		int soucetVsazenychZetonu = 0;
		int vsazenoOdVyhercu = 0;

		for ( int i = 0; i < this.pocetSazek; i++ )
		{
			if ( this.evidenceSazek[ i ].tipovaneCislo == this.vyherniCislo )
			{
				vyherci[ pocetVyhercu ] = this.evidenceSazek[ i ].sazejici;
				vsazeno[ pocetVyhercu ] = this.evidenceSazek[ i ].pocetZetonu;
				vsazenoOdVyhercu += this.evidenceSazek[ i ].pocetZetonu;
				pocetVyhercu++;
			}

			soucetVsazenychZetonu += this.evidenceSazek[ i ].pocetZetonu;
		}

		if ( soucetVsazenychZetonu != 0 )
		{
			for ( int i = 0; i < pocetVyhercu; i++ )
			{
				vyherci[ i ].pocetZetonu += ( vsazeno[ i ] / vsazenoOdVyhercu ) * soucetVsazenychZetonu;
			}
		}

		this.pocetSazek = 0;
		this.evidenceSazek = new Sazka[ 256 ];
	}

	public void registrujSazku( Sazka S )
	{
		if ( this.prijimaSazky )
		{
			this.evidenceSazek[ this.pocetSazek ] = S;
			this.pocetSazek++;
		}
	}
}
