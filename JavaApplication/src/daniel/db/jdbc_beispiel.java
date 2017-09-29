/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daniel.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class jdbc_beispiel {

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "root");

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", connectionProps);
        return conn;
    }

    public static void viewTable(Connection con) throws SQLException {

        Statement stmt = null;
        // Beispiel 1: SELECT-Abfrage formulieren um Liste der Programmiersprachen ermitteln
        String query = "SELECT * FROM mydb.programmiersprachen ORDER BY sprache;";

        try {
            // Abfrage über die Datenbankverbindung absetzen
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // Abfrageergebnis auswerten und z.B. ausgeben
            while (rs.next()) {
                String sprache = rs.getString("sprache");
                System.out.println(sprache);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    // Beispieldaten in die Datenbank einfügen:
    // INSERT-Statement
    public void personenEinfuegen(Connection con) {
        try {
            String einfuegenString = "INSERT INTO `mydb`.`personen` (`vorname`, `geburtsdatum`, `wohnort`, `partei`) VALUES (?, ?, ?, ?);";
            con.setAutoCommit(false);
            
            PreparedStatement ps = con.prepareStatement(einfuegenString);

            // Platzhalter ? binden:
            ps.setString(1, "Gabi");
            ps.setDate(2, new Date(2017, 9, 28));
            ps.setString(3, "Bielefeld");
            ps.setString(4, "1");
            
            // PreparedStatement ausführen: (INSERT)
            ps.executeUpdate();
            
            // Anweisung bestätigen:
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(jdbc_beispiel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        try {
            jdbc_beispiel j = new jdbc_beispiel();
            // Datenbankverbindung herstellen
            Connection c = j.getConnection();
            // Abfrage:
            j.viewTable(c);
            // INSERT-Anweisung ausführen:
            j.personenEinfuegen(c);
        } catch (SQLException ex) {
            Logger.getLogger(jdbc_beispiel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Person> beispielDatenErzeugen() {
        List<Person> personen = new ArrayList<Person>();

        Person person = new Person();
        person.vorname = "Frank";
        person.programmiersprachen = new String[]{"Python", "C", "C++", "PHP", "Pascal", "Basic"};
        person.geburtsdatum = new Date(1964, 14, 3);
        person.wohnort = "Wiedenbrück";
        person.partei = "3";
        personen.add(person);

        person = new Person();
        person.vorname = "Ahmad";
        person.programmiersprachen = new String[]{"Python", "C", "C++", "PHP", "Pascal", "Basic"};
        person.geburtsdatum = new Date(1961, 2, 10);
        person.wohnort = "Paderborn";
        person.partei = "4";
        personen.add(person);

        person = new Person();
        person.vorname = "Paul";
        person.programmiersprachen = new String[]{"C", "C++", "PHP", "Pascal", "Fortran", "Assembler"};
        person.geburtsdatum = new Date(1959, 2, 12);
        person.wohnort = "Brakel";
        person.partei = "2";
        personen.add(person);

        person = new Person();
        person.vorname = "Tom";
        person.programmiersprachen = new String[]{"Java", "Simula", "Python", "C", "C++", "PHP", "Pascal", "Basic"};
        person.geburtsdatum = new Date(1957, 3, 10);
        person.wohnort = "Paderborn";
        person.partei = "1";
        personen.add(person);

        person = new Person();
        person.vorname = "Wolfgang";
        person.programmiersprachen = new String[]{"Python", "C", "C#", "PHP", "Basic", "Assembler", "RexX"};
        person.geburtsdatum = new Date(1955, 6, 6);
        person.wohnort = "Delbrück";
        person.partei = "2";
        personen.add(person);

        person = new Person();
        person.vorname = "Bernhard";
        person.programmiersprachen = new String[]{"PHP", "Python", "C", "Pascal", "Assembler", "VHDL"};
        person.geburtsdatum = new Date(1958, 6, 2);
        person.wohnort = "Bad Driburg";
        person.partei = "2";
        personen.add(person);

        person = new Person();
        person.vorname = "Ralf";
        person.programmiersprachen = new String[]{"PHP", "Python", "C", "C++", "Java", "PL/1", "Cobol", "Assembler"};
        person.geburtsdatum = new Date(1960, 2, 3);
        person.wohnort = "Paderborn";
        person.partei = "1";
        personen.add(person);

        person = new Person();
        person.vorname = "Daniel";
        person.programmiersprachen = new String[]{"Java"};
        person.geburtsdatum = new Date(1983, 1, 2);
        person.wohnort = "Bielefeld";
        person.partei = "1";
        personen.add(person);

        return personen;
    }
}

class Person {
    String vorname;
    String[] programmiersprachen;
    Date geburtsdatum;
    String wohnort;
    String partei;
    
    public Integer getAlter() {
        return 2017 - geburtsdatum.getYear();
    }
}
