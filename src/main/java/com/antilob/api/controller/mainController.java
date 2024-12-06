package com.antilob.api.controller;

import com.antilob.engine.database.entity.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import  com.antilob.engine.service.IDataService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class mainController {
    private final IDataService dataService;

    public mainController(IDataService dataService) {
        this.dataService = dataService;
    }


    @RequestMapping("/memberList")
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
    public List<Race> raceList() {
        List<Race> list = dataService.getRaceList();
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

    @RequestMapping("/raceResults/{id}")
    public List<Result> ResultList(@PathVariable("id") String number) {
        Integer id = Integer.parseInt(number);
        List<Result> list = dataService.getResultsOfRace(id);
        return list;
    }

    @RequestMapping("/race/{id}")
    public Race getRace(@PathVariable("id") String number) {
        Integer id = Integer.parseInt(number);
        Race race = dataService.getRace(id.longValue());
        return race;
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



}
