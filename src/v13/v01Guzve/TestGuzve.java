package v13.v01Guzve;

import java.util.*;

public class TestGuzve
{
	// Read a person from the keyboard
	static public Osoba procitajOsobu() throws NekorektanUnosException 
	{
		FormatizovaniUlaz ulaz = new FormatizovaniUlaz();
		// Read in the first name and remove blanks front and back
		System.out.println("\nUnesi ime ili ! za kraj: ");
		String firstName = ulaz.citajString().trim(); // Read and trim a string
		if (firstName.charAt(0) == '!') // Check for ! entered
			return null; // If so, we are done...
		// Read in the surname, also trimming blanks
		System.out.println("Unesi prezime: ");
		String surname = ulaz.citajString().trim(); // Read and trim a string
		return new Osoba(firstName, surname);
	}

	public static void main(String[] args) throws NekorektanUnosException 
	{
		Osoba osoba; // A person object
		Guzva filmskaEkipa = new Guzva();
		// Populate the crowd
		for (;;)
		{ // Indefinite loop
			osoba = procitajOsobu(); // Read in a film star
			if (osoba == null) // If null obtained...
				break; // We are done...
			filmskaEkipa.dodaj(osoba); // Otherwise, add to the cast
		}
		int broj = filmskaEkipa.velicina();
		System.out.println(
			"Dodata "
				+ broj
				+ ( broj == 2 || broj == 3 || broj == 4 ? " osobe " : " osoba " )
				+ " u filmsku ekipu.\n");
		// Show who is in the cast using an iterator
		Iterator pristup = filmskaEkipa.iterator(); // Obtain an iterator
		while (pristup.hasNext()) // Output all elements
			System.out.println(pristup.next());
	}

}
