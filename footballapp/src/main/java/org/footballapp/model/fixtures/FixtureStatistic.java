package org.footballapp.model.fixtures;

import java.math.BigDecimal;

public class FixtureStatistic {

    private long fixtureId;
    private int teamId;

    private Integer shotsOnGoal;
    private Integer shotsOffGoal;
    private Integer totalShots;
    private Integer blockedShots;
    private Integer shotsInsideBox;
    private Integer shotsOutsideBox;
    private Integer fouls;
    private Integer cornerKicks;
    private Integer offsides;
    private String ballPossession;
    private Integer yellowCards;
    private Integer redCards;
    private Integer goalkeeperSaves;
    private Integer totalPasses;
    private Integer accuratePasses;
    private String passPercentage;
    private BigDecimal expectedGoals;
    private BigDecimal goalsPrevented;

    public FixtureStatistic() {
    }

    public long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(long fixtureId) {
        this.fixtureId = fixtureId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Integer getShotsOnGoal() {
        return shotsOnGoal;
    }

    public void setShotsOnGoal(Integer shotsOnGoal) {
        this.shotsOnGoal = shotsOnGoal;
    }

    public Integer getShotsOffGoal() {
        return shotsOffGoal;
    }

    public void setShotsOffGoal(Integer shotsOffGoal) {
        this.shotsOffGoal = shotsOffGoal;
    }

    public Integer getTotalShots() {
        return totalShots;
    }

    public void setTotalShots(Integer totalShots) {
        this.totalShots = totalShots;
    }

    public Integer getBlockedShots() {
        return blockedShots;
    }

    public void setBlockedShots(Integer blockedShots) {
        this.blockedShots = blockedShots;
    }

    public Integer getShotsInsideBox() {
        return shotsInsideBox;
    }

    public void setShotsInsideBox(Integer shotsInsideBox) {
        this.shotsInsideBox = shotsInsideBox;
    }

    public Integer getShotsOutsideBox() {
        return shotsOutsideBox;
    }

    public void setShotsOutsideBox(Integer shotsOutsideBox) {
        this.shotsOutsideBox = shotsOutsideBox;
    }

    public Integer getFouls() {
        return fouls;
    }

    public void setFouls(Integer fouls) {
        this.fouls = fouls;
    }

    public Integer getCornerKicks() {
        return cornerKicks;
    }

    public void setCornerKicks(Integer cornerKicks) {
        this.cornerKicks = cornerKicks;
    }

    public Integer getOffsides() {
        return offsides;
    }

    public void setOffsides(Integer offsides) {
        this.offsides = offsides;
    }

    public String getBallPossession() {
        return ballPossession;
    }

    public void setBallPossession(String ballPossession) {
        this.ballPossession = ballPossession;
    }

    public Integer getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Integer yellowCards) {
        this.yellowCards = yellowCards;
    }

    public Integer getRedCards() {
        return redCards;
    }

    public void setRedCards(Integer redCards) {
        this.redCards = redCards;
    }

    public Integer getGoalkeeperSaves() {
        return goalkeeperSaves;
    }

    public void setGoalkeeperSaves(Integer goalkeeperSaves) {
        this.goalkeeperSaves = goalkeeperSaves;
    }

    public Integer getTotalPasses() {
        return totalPasses;
    }

    public void setTotalPasses(Integer totalPasses) {
        this.totalPasses = totalPasses;
    }

    public Integer getAccuratePasses() {
        return accuratePasses;
    }

    public void setAccuratePasses(Integer accuratePasses) {
        this.accuratePasses = accuratePasses;
    }

    public String getPassPercentage() {
        return passPercentage;
    }

    public void setPassPercentage(String passPercentage) {
        this.passPercentage = passPercentage;
    }

    public BigDecimal getExpectedGoals() {
        return expectedGoals;
    }

    public void setExpectedGoals(BigDecimal expectedGoals) {
        this.expectedGoals = expectedGoals;
    }

    public BigDecimal getGoalsPrevented() {
        return goalsPrevented;
    }

    public void setGoalsPrevented(BigDecimal goalsPrevented) {
        this.goalsPrevented = goalsPrevented;
    }

}