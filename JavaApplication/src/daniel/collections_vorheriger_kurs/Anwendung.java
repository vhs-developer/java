package daniel.collections_vorheriger_kurs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anwendung {

	public static void main(String[] args) {
		List<Mitarbeiter> mitarbeiterListe = new ArrayList<>();
		mitarbeiterListe.add(new Mitarbeiter("Anna", "Bielefeld", 6500));
		mitarbeiterListe.add(new Mitarbeiter("Peter", "Paderborn", 7499));
		mitarbeiterListe.add(new Mitarbeiter("Mary", "Bielefeld", 4500));

		// Alle Mitarbeiter aus Bielefeld mit Gehalt mindestens 5000:
		Stream<Mitarbeiter> stream = mitarbeiterListe.stream().filter(
				m -> m.getGehalt() >= 5000 && m.getOrt() == "Bielefeld");
		
		stream.forEach(m -> System.out.println(m));

		// Alle Mitarbeiter aus Bielefeld mit Gehalt mindestens 5000:
		mitarbeiterListe.stream()
		.filter(m -> m.getGehalt() >= 5000 && m.getOrt() == "Bielefeld")
		.forEach(m -> System.out.println(m));

		// Alle Vornamen von Mitarbeitern aus Bielefeld mit Gehalt mindestens 5000:
		mitarbeiterListe.stream()
		.filter(m -> m.getGehalt() >= 5000 && m.getOrt() == "Bielefeld")
		.map(m -> m.getVorname())
		.forEach(v -> System.out.println(v));

		// Maximal drei Vornamen von Mitarbeitern aus Bielefeld mit Gehalt mindestens 5000:
		mitarbeiterListe.stream()
		.filter(m -> m.getGehalt() >= 5000 && m.getOrt() == "Bielefeld")
		.map(m -> m.getVorname())
		.limit(3)
		.forEach(v -> System.out.println(v));

		// Vornamen der (höchstens) 3 bestbezahltesten Mitarbeiter aus Bielefeld mit Gehalt mindestens 5000:
		mitarbeiterListe.stream()
		.filter(m -> m.getGehalt() >= 5000 && m.getOrt() == "Bielefeld")
//		.sorted((m1, m2) -> Double.compare(m1.getGehalt(), m2.getGehalt()))
//		.sorted(Comparator.comparingDouble(m -> m.getGehalt()))
//		.sorted(Comparator.comparingDouble(Mitarbeiter::getGehalt))
		.sorted(Comparator.comparing(Mitarbeiter::getGehalt))
		.map(m -> m.getVorname())
		.limit(3)
		.forEach(v -> System.out.println(v));

		// Aus der nach Vorname sortierten Liste der Mitarbeiter aus Bielefeld mit Gehalt mindestens 5000 die vordersten (maximal) 3 Vornamen ausgeben:
		mitarbeiterListe.stream()
		.filter(m -> m.getGehalt() >= 5000 && m.getOrt() == "Bielefeld")
		.map(m -> m.getVorname())
		.sorted()
		.limit(3)
		.forEach(v -> System.out.println(v));
		
		// Mitarbeiter nach Gehalt, dann nach Ort sortieren:
		mitarbeiterListe.stream()
		.sorted(Comparator.comparing(Mitarbeiter::getGehalt)
				.thenComparing(Mitarbeiter::getOrt))
		.forEach(v -> System.out.println(v));
		
		// Durchschnittsgehalt aller Paderborner Mitarbeiter:
		double durchschnitt = mitarbeiterListe.stream()
		.filter(m -> m.getOrt() == "Paderborn")
		.mapToDouble(Mitarbeiter::getGehalt)
		.average().orElse(0); // orElse: 0 zurückgeben, falls der Stream "leer" ist (dann kann ja kein Durchschnitt berechnet werden)
		
		System.out.println("Durchschnittsgehalt: " + durchschnitt);

		// Durchschnittsgehalt aller Gütersloher Mitarbeiter (gibt's keine!):
		OptionalDouble d = mitarbeiterListe.stream()
		.filter(m -> m.getOrt() == "Gütersloh")
		.mapToDouble(Mitarbeiter::getGehalt)
		.average();
		
		if (d.isPresent()) {
			System.out.println("Durchschnittsgehalt: " + d.getAsDouble());
		} else {
			System.out.println("Die Abfrage hat keine Ergebnisse geliefert. Ein Durchschnitt konnte daher nicht berechnet werden.");
		}

		// Median des Gehalts aller Paderborner Mitarbeiter:
		List<Double> paderbornerMitarbeiter = mitarbeiterListe.stream()
		.filter(m -> m.getOrt() == "Paderborn")
		.map(Mitarbeiter::getGehalt)
		.sorted()
		.collect(Collectors.toCollection(ArrayList<Double>::new));
		
		System.out.println("Median: "
     		+ paderbornerMitarbeiter.get(paderbornerMitarbeiter.size() / 2));

		// Gruppieren mittels groupBy:
		// z.B. Gruppieren nach Ort
		Map<String, List<Mitarbeiter>> gruppiert = mitarbeiterListe.stream()
		.collect(Collectors.groupingBy(Mitarbeiter::getOrt));
		
		for (String ort : gruppiert.keySet()) {
			System.out.println("Mitarbeiter aus " + ort + ":");
			System.out.println("------------------------");

			durchschnitt = gruppiert.get(ort).stream()
					.mapToDouble(Mitarbeiter::getGehalt)
					.average().orElse(0); // orElse: 0 zurückgeben, falls der Stream "leer" ist (dann kann ja kein Durchschnitt berechnet werden)

			System.out.println("Durchschnittsgehalt: " + durchschnitt);
			System.out.println();
			gruppiert.get(ort).forEach(System.out::println);
			System.out.println();
		}
	}	
}

