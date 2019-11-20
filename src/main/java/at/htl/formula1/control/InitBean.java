package at.htl.formula1.control;

import at.htl.formula1.boundary.ResultsRestClient;
import at.htl.formula1.entity.Race;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
@Transactional
public class InitBean {

    private static final String TEAM_FILE_NAME = "teams.csv";
    private static final String RACES_FILE_NAME = "races.csv";


    @PersistenceContext
    EntityManager em;

    @Inject
    ResultsRestClient client;


    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {

        readTeamsAndDriversFromFile(TEAM_FILE_NAME);
        readRacesFromFile(RACES_FILE_NAME);
        //client.readResultsFromEndpoint();

    }

    /**
     * Einlesen der Datei "races.csv" und Speichern der Objekte in der Tabelle F1_RACE
     *
     * @param racesFileName
     */
    private void readRacesFromFile(String racesFileName) {


            BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/"+racesFileName),StandardCharsets.UTF_8));


        try {

            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {

                String [] row = line.split(";");

                Race r = new Race(Long.parseLong(row[0]), row[1],
                        LocalDate.parse(row[2], DateTimeFormatter.ofPattern("dd.MM.yyyy")));


                em.persist(r);



            }}
        catch (IOException e) {
            e.printStackTrace();
        }




    }

    /**
     * Einlesen der Datei "teams.csv".
     * Das String-Array jeder einzelnen Zeile wird der Methode persistTeamAndDrivers(...)
     * übergeben
     *
     * @param teamFileName
     */
    private void readTeamsAndDriversFromFile(String teamFileName) {




/*
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("../../ersources/teams.csv")));
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {

                String [] row = line.split(";");

              /*  List<Race> races = this.em.createNamedQuery("Race.getById",Race.class)
                        .setParameter("RACE",row[0])
                        .getResultList();

             Race race;

             //   race = new Race(row[0]);
                //this.em.persist(race);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



*/


    }

    /**
     * Es wird überprüft ob es das übergebene Team schon in der Tabelle F1_TEAM gibt.
     * Falls nicht, wird das Team in der Tabelle gespeichert.
     * Wenn es das Team schon gibt, dann liest man das Team aus der Tabelle und
     * erstellt ein Objekt (der Klasse Team).
     * Dieses Objekt wird verwendet, um die Fahrer mit Ihrem jeweiligen Team
     * in der Tabelle F!_DRIVER zu speichern.
     *
     * @param line String-Array mit den einzelnen Werten der csv-Datei
     */

    private void persistTeamAndDrivers(String[] line) {






    }


}
