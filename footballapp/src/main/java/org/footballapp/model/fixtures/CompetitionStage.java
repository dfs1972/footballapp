package org.footballapp.model.fixtures;

import java.util.List;

public class CompetitionStage {

    private String name;

    private List<String> rounds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRounds() {
        return rounds;
    }

    public void setRounds(List<String> rounds) {
        this.rounds = rounds;
    }
}