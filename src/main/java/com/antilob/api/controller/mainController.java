package com.antilob.api.controller;

import com.antilob.engine.database.IRace;
import com.antilob.engine.database.entity.*;
import com.antilob.engine.service.RaceService;
import com.antilob.system.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import  com.antilob.engine.service.IDataService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:9001")
public class mainController {


    @Autowired
    ApplicationProperties applicationProperties;

    @Autowired
    private IDataService dataService;

    @Autowired
    private RaceService raceService;


/*    public mainController(IDataService dataService) {
        this.dataService = dataService;
    }*/


    @GetMapping("/memberList")
    public List<Member> memberList() {
        List<Member> list = dataService.getMemberList();
        return list;

    }

    @RequestMapping("/eventList")
    public List<Event> eventList() {
        List<Event> list = dataService.getEventList();
        return list;

    }
    @RequestMapping("/lastResultList")
    public List<LastResult> lastResultList() {
        List<LastResult> list = dataService.getLastResultList();
        return list;
    }

    @RequestMapping("/raceList")
    public List<IRace> raceList() {
        List<IRace> list = raceService.getRaceList();
        return list;
    }

    @GetMapping("/raceListOfDate")
    public List<IRace> raceListOfDate(@RequestParam("date") String dateString) {
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        try {
            date = formatter.parse(dateString);
        }
        catch (ParseException e) {
            System.out.println("Invalid date String building Id of Race");
        }
        List<IRace> list = raceService.listRaceOfWeek(date);
        return list;
    }

    @GetMapping("/closedRaceList")
    public List<Race> getResults() {
        List<Race> list = raceService.getRaceFinished();
        return list;
    }

    @RequestMapping("/challengeList")
    public List<Challenge> challengeList() {
        List<Challenge> list = dataService.getChallengeList();
        return list;
    }
    @RequestMapping("/resultList")
    public List<Result> ResultList() {
        List<Result> list = dataService.getResultList();
        return list;
    }

    @GetMapping("/race/{id}")
    public Race getRace(@PathVariable("id") String number) {
        Integer id = Integer.parseInt(number);
        Race race = raceService.getRace(id.longValue());
        return race;
    }

    @RequestMapping("/raceResults/{id}")
    public List<Result> ResultListOfRace(@PathVariable("id") String number) {
        Integer id = Integer.parseInt(number);
        List<Result> list = dataService.getResultsOfRace(id);
        return list;
    }


    @RequestMapping("/raceResultsAll/{id}")
    public List<Result> ResultListAll(@PathVariable("id") String number) {
        Integer id = Integer.parseInt(number);
        List<Result> list = dataService.getResultsOfRaceAll(id);
        return list;
    }

    @RequestMapping("/nbrParticipantsAll/{id}")
    public String NbrParticipantsAll(@PathVariable("id") String number) {
        Integer id = Integer.parseInt(number);
        Integer n = dataService.getResultsOfRaceAll(id).size();
        return "{ \"nbrParticipantsAll\":" + n +"}";
    }

    @RequestMapping("/challengeclub")
    public List<ChallengeClub> challengeClub() {
        List<ChallengeClub> list = dataService.getChallengeClubList();
        return list;
    }

    @RequestMapping("/memberResults/{id}")
    public List<Result> memberResultsList(@PathVariable("id") String number) {
        Integer id = Integer.parseInt(number);
        List<Result> list = dataService.getResultsOfMember(id);
        return list;
    }

    @RequestMapping("/member/{id}")
    public Member getMember(@PathVariable("id") String number) {
        Integer id = Integer.parseInt(number);
        Member member = dataService.getMember(id.longValue());
        return member;
    }

    @PostMapping("/race")
    public void AddRace(@RequestBody String jsonRace) {
        try {
            raceService.AddRace(jsonRace);
        }
        catch (Exception e) {
            System.out.println("Error creating new Race");
        }
    }

    @RequestMapping("system/ApplicationProperties")
    @ResponseBody
    public String memberResults() {
        applicationProperties.logApplicationProperties();
        return "Consult the log please";
    }


}
